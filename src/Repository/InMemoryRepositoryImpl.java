package Repository;

import entity.Priority;
import entity.Status;
import entity.Task;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import exception.TasksNotFoundException;

public class InMemoryRepositoryImpl implements TaskRepository {

    List<Task> tasks;
    private int id = 1;

    public InMemoryRepositoryImpl() {
        tasks = new ArrayList<>();
    }

    @Override
    public Task save(Task task) {
        if(task.getId() == 0){
            task.setId(id++);
            tasks.add(task);
        } else {
            delete(task.getId());
            tasks.add(task);
        }
        return task;
    }

    @Override
    public Task getTaskByTitle(String title) {
        for (Task task : tasks) {
            if(task.getTitle().equals(title)){
                return task;
            }
        }
        throw new TasksNotFoundException("Не знайдено завдання з назвою: " + title);
    }

    @Override
    public Task getTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        throw new TasksNotFoundException("Не знайдено завдання з ID: " + id);
    }

    @Override
    public List<Task> findByStatus(Status status) {
        List<Task> statusTasks = new ArrayList<>();
        for (Task task : tasks) {
            if(task.getStatus() == status){
                statusTasks.add(task);
            }
        }
        return statusTasks;
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
        Task task = getTaskById(id);
        tasks.remove(task);
    }

    @Override
    public List<Task> findOverdueTasks(LocalDateTime localDateTime) {
        List<Task> overdueTasks = new ArrayList<>();
        for (Task task : tasks) {
            if(task.getDeadline().isBefore(localDateTime)){
                overdueTasks.add(task);
            }
        }
        return overdueTasks;
    }

    @Override
    public List<Task> getAll() {
        return new ArrayList<>(tasks);
    }
}
