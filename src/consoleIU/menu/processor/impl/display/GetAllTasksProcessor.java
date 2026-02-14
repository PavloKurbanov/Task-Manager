package consoleIU.menu.processor.impl.display;

import consoleIU.menu.processor.TaskProcessor;
import service.TaskService;
import entity.Task;
import io.InputReader;

import java.util.List;

public class GetAllTasksProcessor implements TaskProcessor {
    private final TaskService taskService;

    public GetAllTasksProcessor(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public String choice() {
        return "1";
    }

    @Override
    public void process() {
        List<Task> allTasks = taskService.getAll();

        if (allTasks.isEmpty()) {
            System.out.println("Список порожній!");
        }

        System.out.println("Список завдань: ");

        for (Task task : allTasks) {
            System.out.println(task);
        }
    }
}
