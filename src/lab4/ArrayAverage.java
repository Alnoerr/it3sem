package lab4;

import java.util.Scanner;

public class ArrayAverage {
    public static float average(String[] list) {
        float sum = 0;
        for (int i = 0; i < list.length; i++) {
            sum += Float.parseFloat(list[i]);
        }
        return sum / list.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] list = scanner.nextLine().split(" ");
        try {
            float average = average(list);
            System.out.println(average);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error occurred: Index out of bounds");
        } catch (IllegalArgumentException e) {
            System.out.println("Error occurred: Illegal argument");
        }
    }
}
