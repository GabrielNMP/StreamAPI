package pro.sky.java.course2.streamapi.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoudExceptions extends RuntimeException{
    public EmployeeNotFoudExceptions() {
    }

    public EmployeeNotFoudExceptions(String message) {
        super(message);
    }

    public EmployeeNotFoudExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeNotFoudExceptions(Throwable cause) {
        super(cause);
    }

    public EmployeeNotFoudExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
