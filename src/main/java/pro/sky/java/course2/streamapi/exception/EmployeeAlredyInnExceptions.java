package pro.sky.java.course2.streamapi.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeAlredyInnExceptions extends RuntimeException{
    public EmployeeAlredyInnExceptions() {
    }

    public EmployeeAlredyInnExceptions(String message) {
        super(message);
    }

    public EmployeeAlredyInnExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeAlredyInnExceptions(Throwable cause) {
        super(cause);
    }

    public EmployeeAlredyInnExceptions(String message,
                                       Throwable cause,
                                       boolean enableSuppression,
                                       boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
