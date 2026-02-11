package Entities;

public enum Status {
    NEW("Новий"),
    IN_PROGRESS("В процесі"),
    DONE("Виконано");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatusName() {
        return status;
    }
}
