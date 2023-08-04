package exception;

import java.util.InputMismatchException;

public class HeightException extends RuntimeException {
    public HeightException(String message) {
        super(message);
    }

    public HeightException(String message, Throwable cause) {
        super(message, cause);
    }

    public HeightException(Throwable cause) {
        super(cause);
    }
}
