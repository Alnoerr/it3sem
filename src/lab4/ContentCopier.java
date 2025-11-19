package lab4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ContentCopier {
    public static void main(String[] args) {
        try(
            FileInputStream file = new FileInputStream("sample.txt")
        ) {
            Path file2 = Paths.get("sample2.txt");
            Files.write(file2, file.readAllBytes());
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (AccessDeniedException e) {
            System.out.println("Access denied to file " + e.getFile());
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e);
        }
    }
}
