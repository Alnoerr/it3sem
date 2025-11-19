package lab4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class CustomNumberFormatHandler {
    public static void logException(CustomNumberFormatException e) {
        try {
            Files.write(
                    Paths.get("src/lab4/logs/error.txt"),
                    (e.message + "\n").getBytes(),
                    StandardOpenOption.APPEND
            );
        } catch (IOException ex) {
            System.out.println("IOException occured: " + ex);
        }
    }
}
