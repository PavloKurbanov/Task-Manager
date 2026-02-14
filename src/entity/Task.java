package entity;

import datetime.TimeFormatter;

import java.time.LocalDateTime;

public class Task {
    private int id;
    private final String title;
    private Status status;
    private final Priority priority;
    private final LocalDateTime dateTime;
    private LocalDateTime deadline;

    public Task(int id, String title, Priority priority, LocalDateTime deadline) {
        if (title == null || title.isBlank()){
            throw new IllegalArgumentException("Введіть назву завдання!");
        }
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

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return String.format("ID: %-2d | Назва: %-5s | Пріоритет: %-5s | Статус:  %-5s | Дата створення: %-10s | Дедлайн: %-10s ",
                id, title, priority.getPriority(), status.getStatusName(), TimeFormatter.format(dateTime), TimeFormatter.format(deadline));
    }
}
