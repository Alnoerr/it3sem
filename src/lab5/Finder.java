package lab5;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите букву с которой должно начинаться слово: ");
        String letter = input.nextLine();
        System.out.print("Введите текст: ");
        String text = input.nextLine();
        Pattern pattern = Pattern.compile("\\b" + letter + "\\w*");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
