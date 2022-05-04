package MyExceptions;

public class InvalidPriceException extends Exception{
    public InvalidPriceException() {
        super("Invalid price");
    }
    public InvalidPriceException(String name) {
        super(name);
    }
}
