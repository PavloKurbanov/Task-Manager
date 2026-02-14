package consoleIU.menu.processor.impl.search;

import entity.Status;
import entity.Task;
import io.InputReader;
import service.TaskService;
import consoleIU.menu.processor.TaskProcessor;

import java.util.List;

public class FindByStatusProcessor implements TaskProcessor {
    private final TaskService taskService;
    private final InputReader input;

    public FindByStatusProcessor(TaskService taskService, InputReader input) {
        this.taskService = taskService;
        this.input = input;
    }

    @Override
    public void process() {
        Status status = input.readStatus();

        List<Task> tasksByStatus = taskService.getTasksByStatus(status);

        if (tasksByStatus.isEmpty()) {
            System.out.println("Не має завдань з статусом [" + status.getStatusName() + "]");
        }
        tasksByStatus.forEach(System.out::println);
    }

    @Override
    public String choice() {
        return "4";
    }
}
