package lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    static void main() {
        String filePath = "sample.txt";
        File file = new File(filePath);
        Scanner scanner;

        try{
            scanner = new Scanner(file);
        } catch(FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Map<String, Integer> wordMap = new HashMap<>();

        while (scanner.hasNext()) {
            wordMap.merge(scanner.next(), 1, Integer::sum);
        }

        List<Map.Entry<String, Integer>> topWords = new ArrayList<>(wordMap.entrySet());

        topWords.sort(
                (o1, o2) -> Integer.compare(
                        o2.getValue(),
                        o1.getValue()
                )
        );

        for (Map.Entry<String, Integer> item : topWords.subList(0, Math.min(10, topWords.size()))) {
            System.out.printf("%s: %d\n", item.getKey(), item.getValue());
        }
    }
}
