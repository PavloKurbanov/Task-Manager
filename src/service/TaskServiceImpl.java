package service;

import entity.Priority;
import entity.Status;
import entity.Task;
import repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;

public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task add(Task task) {
        if (task == null || task.getTitle().isBlank()) {
            throw new IllegalArgumentException("Введіть коректні дані!");
        }
        if (task.getDeadline().isBefore(LocalDateTime.now())){
            throw new IllegalArgumentException("Дата дедлайну не може бути в минулому!");
        }
        return taskRepository.save(task);
    }

    @Override
    public Task update(int id) {
        Task task = taskRepository.getTaskById(id);

        if (task.getStatus() == Status.DONE) {
            throw new IllegalArgumentException("Не можливо оновити завершене завдання!");
        }

        switch (task.getStatus()) {
            case NEW -> task.setStatus(Status.IN_PROGRESS);
            case IN_PROGRESS -> task.setStatus(Status.DONE);
            default -> throw new IllegalStateException("Не можливо оновити статус " + task.getStatus().getStatusName());
        }

        return task;
    }

    @Override
    public Task findById(int id) {
        return taskRepository.getTaskById(id);
    }

    public Task findByTitle(String title) {
        return taskRepository.getTaskByTitle(title);
    }

    @Override
    public Task postponeTask(int id, long days) {
        Task task = taskRepository.getTaskById(id);
        task.setDeadline(task.getDeadline().plusDays(days));
        return task;
    }

    @Override
    public void delete(int id) {
        taskRepository.delete(id);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.getAll();
    }

    @Override
    public List<Task> getOverdueTasks() {
        return taskRepository.findOverdueTasks(LocalDateTime.now());
    }

    @Override
    public List<Task> getTasksByPriority(Priority priority) {
        return taskRepository.findByPriority(priority);
    }

    @Override
    public List<Task> getTasksByStatus(Status status) {
        return taskRepository.findByStatus(status);
    }
}
