package Repository;

import entity.Priority;
import entity.Status;
import entity.Task;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository {
    Task save(Task task);

    Task getTaskById(int id);

    Task getTaskByTitle(String title);

    List<Task> findByPriority(Priority priority);

    List<Task> findByStatus(Status status);

    void delete(int id);

    List<Task> getAll();

    List<Task> findOverdueTasks(LocalDateTime localDateTime);
}
