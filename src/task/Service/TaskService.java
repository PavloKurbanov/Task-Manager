package Service;

import Entities.Priority;
import Entities.Status;
import Entities.Task;

import java.sql.Statement;
import java.util.List;

public interface TaskService {
    Task add(Task task);

    Task update(int id);

    void delete(int id);

    Task findById(int id);

    Task findByTitle(String title);

    List<Task> getAll();

    List<Task> getTasksByPriority(Priority priority);

    List<Task> getTasksByStatus(Status status);

    Task postponeTask(int id, long days);

    List<Task> getOverdueTasks();
}
