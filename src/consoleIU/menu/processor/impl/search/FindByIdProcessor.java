package consoleIU.menu.processor.impl.search;

import entity.Task;
import io.InputReader;
import service.TaskService;
import consoleIU.menu.processor.TaskProcessor;
import exception.TasksNotFoundException;

public class FindByIdProcessor implements TaskProcessor {
    private final TaskService taskService;
    private final InputReader input;

    public FindByIdProcessor(TaskService taskService, InputReader inputReader) {
        this.taskService = taskService;
        this.input = inputReader;
    }
    @Override
    public String choice() {
        return "1";
    }

    @Override
    public void process() {
        int inputId = input.readInt("Введіть ID завдання: ");
        try {
            Task byId = taskService.findById(inputId);
            if (byId != null) {
                System.out.println(byId);
            }
        } catch (TasksNotFoundException e) {
            System.err.println("ПОМИЛКА: " + e.getMessage());
        }
    }
}
