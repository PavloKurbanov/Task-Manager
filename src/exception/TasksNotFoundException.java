package exception;

public class TasksNotFoundException extends RuntimeException {
    public TasksNotFoundException(String message) {
        super(message);
    }
}
