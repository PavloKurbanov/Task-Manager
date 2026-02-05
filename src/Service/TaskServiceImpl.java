package Service;

import Entities.Priority;
import Entities.Status;
import Entities.Task;
import Repository.TaskRepository;

import java.util.List;

public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task add(Task task) {
        if(task != null){
            Task newTask = taskRepository.save(task);
            return newTask;
        }
        throw new IllegalArgumentException("Введіть коректні дані!");
    }

    @Override
    public Task update(int id) {
        Task task = taskRepository.getTask(id);
        if(task.getStatus() == Status.DONE){
            throw new IllegalArgumentException("Не можливо оновити завершене завдання!");
        }
        switch(task.getStatus()){
            case NEW -> task.setStatus(Status.IN_PROGRESS);
            case IN_PROGRESS -> task.setStatus(Status.DONE);
            default -> throw new IllegalStateException("Не можливо оновити статус " + task.getStatus().getStatusName());
        }
        return task;
    }

    @Override
    public Task findById(int id) {
        return taskRepository.getTask(id);
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
    public List<Task> getTasksByPriority(Priority priority) {
        return taskRepository.findByPriority(priority);
    }
}
