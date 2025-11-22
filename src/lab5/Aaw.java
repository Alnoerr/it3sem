package lab5;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Aaw {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        Pattern pattern = Pattern.compile("([a-z][A-Z])");
        String result = text.replaceAll(pattern.pattern(), "!$1!");
        System.out.println(result);
    }
}
