package Repository;

import Entities.Priority;
import Entities.Task;

import java.util.List;

public interface TaskRepository {
    Task save(Task task);

    Task getTask(int id);

    List<Task> findByPriority(Priority priority);

    void delete(int id);

    List<Task> getAll();
}
