package Exception;

public class TaskListIsEmptyException extends RuntimeException {
    public TaskListIsEmptyException(String message) {
        super(message);
    }

    public TaskListIsEmptyException(String message, Throwable cause) {
        super(message, cause);
    }
}
