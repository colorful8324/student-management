package exception;

import java.util.InputMismatchException;

public class DateOfBirthException extends RuntimeException {

    public DateOfBirthException(String message) {
        super(message);
    }

    public DateOfBirthException(String message, Throwable cause) {
        super(message, cause);
    }

    public DateOfBirthException(Throwable cause) {
        super(cause);
    }
}
