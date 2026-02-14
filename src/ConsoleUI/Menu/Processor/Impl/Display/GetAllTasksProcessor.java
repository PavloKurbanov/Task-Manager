package ConsoleUI.Menu.Processor.Impl.Display;

import ConsoleUI.Menu.Processor.TaskProcessor;
import Service.TaskService;
import entity.Task;
import io.InputReader;

import java.util.List;

public class GetAllTasksProcessor implements TaskProcessor {
    private final TaskService taskService;
    private final InputReader input;

    public GetAllTasksProcessor(TaskService taskService, InputReader input) {
        this.taskService = taskService;
        this.input = input;
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
