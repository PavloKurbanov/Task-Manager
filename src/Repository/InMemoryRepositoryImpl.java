package Repository;

import Entities.Priority;
import Entities.Status;
import Entities.Task;

import java.util.ArrayList;
import java.util.List;
import Exception.TasksNotFoundException;

import Exception.TaskListIsEmptyException;

public class InMemoryRepositoryImpl implements TaskRepository {

    List<Task> tasks;
    private int id = 1;

    public InMemoryRepositoryImpl() {
        tasks = new ArrayList<>();
    }

    @Override
    public Task save(Task task) {
        task.setId(id++);
        tasks.add(task);
        return task;
    }

    @Override
    public Task getTask(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        throw new TasksNotFoundException("Не знайдено завдання з ID: " + id);
    }

    @Override
    public List<Task> findByPriority(Priority priority) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getPriority() == priority) {
                result.add(task);
            }
        }
        return result;
    }

    @Override
    public void delete(int id) {
        Task task = getTask(id);
        tasks.remove(task);
    }

    @Override
    public List<Task> getAll() {
        return new ArrayList<>(tasks);
    }
}
