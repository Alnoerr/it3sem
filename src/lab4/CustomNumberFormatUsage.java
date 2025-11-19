package lab4;

public class CustomNumberFormatUsage {
    public static void main(String[] args) {
        String s = "s";
        parseInt(s);
    }

    public static int parseInt(String s) throws CustomNumberFormatException {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new CustomNumberFormatException("CustomNumberFormatException occurred for string " + s);
        }
    }
}
