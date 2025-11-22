package lab5;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        Pattern pattern = Pattern.compile("(?=.*[A-Z])(?=.*\\d)[A-Za-z0-9]{8,16}");
        Matcher matcher = pattern.matcher(text);
        if (matcher.matches()) {
            System.out.println("Пароль корректный!");
        } else {
            System.out.println("Пароль некорректный :(");
        }
    }
}

