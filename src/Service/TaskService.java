package Service;

import Entities.Priority;
import Entities.Task;

import java.util.List;

public interface TaskService {
    Task add(Task task);

    Task update(int id);

    void delete(int id);

    Task findById(int id);

    List<Task> getAll();

    List<Task> getTasksByPriority(Priority priority);
}
