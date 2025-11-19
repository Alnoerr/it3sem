package lab4;

public class CustomNumberFormatException extends NumberFormatException {
    String message;

    public CustomNumberFormatException() {
        super();
        message = "CustomNumberFormatException occured";
        CustomNumberFormatHandler.logException(this);
    }

    public CustomNumberFormatException(String s) {
        super(s);
        message = s;
        CustomNumberFormatHandler.logException(this);
    }
}
