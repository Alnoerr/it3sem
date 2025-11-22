package lab5;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Doxxer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        Pattern pattern = Pattern.compile("((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)\\.?\\b){4}");
        Matcher matcher = pattern.matcher(text);
        if (matcher.matches()) {
            System.out.println("IPv4 адресс корректный!");
        } else {
            System.out.println("IPv4 адресс некорректный :(");
        }
    }
}
