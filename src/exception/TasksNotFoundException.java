package exception;

public class TasksNotFoundException extends RuntimeException {
    public TasksNotFoundException(String message) {
        super(message);
    }

    public TasksNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
