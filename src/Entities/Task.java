package Entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {

    private int id;
    private final String title;
    private Status status;
    private final Priority priority;
    private final LocalDateTime dateTime;
    private final LocalDateTime deadline;

    public Task(int id, String title, Priority priority, LocalDateTime deadline) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.deadline = deadline;
        this.status = Status.NEW;
        this.dateTime = LocalDateTime.now();
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formattedDate = dtf.format(dateTime);
        String formattedDeadline = dtf.format(deadline);

        return String.format("ID: %-2d | Назва: %-5s | Пріоритет: %-5s | Статус: %-5s | Дата створення: %s | Дедлайн: %s ",
                id, title, priority.getPriority(), status.getStatusName(), formattedDate, formattedDeadline);
    }
}
