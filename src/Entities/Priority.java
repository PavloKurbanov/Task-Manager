package Entities;

public enum Priority {
    LOW("Низький"),
    MEDIUM("Середній"),
    HIGH("Високий");

    private final String priority;

    Priority(String priority) {
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }
}
