package Repository;

import Entities.Priority;
import Entities.Task;

import java.util.List;

public interface TaskRepository {
    Task save(Task task);

    Task getTaskById(int id);

    Task getTaskByTitle(String title);

    List<Task> findByPriority(Priority priority);

    void delete(int id);

    List<Task> getAll();
}
