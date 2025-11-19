package lab4;

public class ArrayAverage {
    public static float average(int[] list) {
        float sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum / list.length;
    }

    public static void main(String[] args) {
        int[] list = { 1, 3, 4, 5 };
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
