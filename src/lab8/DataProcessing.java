package lab8;

import java.io.IOException;
import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class DataProcessing {
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface DataProcessor {}

    static class DataManager {
        private List<String> data = new ArrayList<>();
        private final List<Object> processors = new ArrayList<>();
        private final ExecutorService executor = Executors.newSingleThreadExecutor();

        public void registerDataProcessor(Object processor) {
            processors.add(processor);
        }

        public void loadData(String source) {
            System.out.println("Загрузка из " + source);
            try {
                this.data = Files.readAllLines(Paths.get("file.txt"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void processData() {
            Future<List<String>> future = executor.submit(() -> {
                List<String> result = new ArrayList<>(data);

                for (Object proc : processors) {
                    for (Method m : proc.getClass().getDeclaredMethods()) {
                        if (m.isAnnotationPresent(DataProcessor.class)) {
                            result = (List<String>) m.invoke(proc, result);
                        }
                    }
                }
                return result;
            });

            try {
                this.data = future.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        public void saveData(String destination) {
            System.out.println("Сохранение в " + destination + ": " + data);
            try {
                Files.write(Paths.get(destination), data);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            executor.shutdown();
        }
    }

    static class FilterJob {
        @DataProcessor
        public List<String> filter(List<String> input) {
            return input.parallelStream()
                    .filter(s -> s.length() > 3)
                    .collect(Collectors.toList());
        }
    }

    static class TransformJob {
        @DataProcessor
        public List<String> makeUpper(List<String> input) {
            return input.parallelStream()
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());
        }
    }

    static void main() {
        DataManager manager = new DataManager();

        manager.registerDataProcessor(new FilterJob());
        manager.registerDataProcessor(new TransformJob());

        manager.loadData("file.txt");
        manager.processData();
        manager.saveData("file_output.txt");
    }
}
