package Entities;

public class Task {

    private int id;
    private final String title;
    private Status status;
    private final Priority priority;

    public Task(int id, String title, Priority priority) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.status = Status.NEW;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return String.format("ID: %-2d | Назва: %-5s | Пріоритет: %-5s | Статус: %-5s",
                id, title, priority.getPriority(), status.getStatusName());
    }
}
