package ConsoleUI.Menu.Processor.Impl;

import entity.Priority;
import entity.Task;
import Service.TaskService;
import io.InputReader;
import ConsoleUI.Menu.Processor.TaskProcessor;

import java.time.LocalDateTime;

public class AddProcessor implements TaskProcessor {
    private final TaskService taskService;
    private final InputReader input;

    public AddProcessor(TaskService taskService, InputReader input){
        this.taskService = taskService;
        this.input = input;
    }

    @Override
    public void process() {
        try {
            String name = input.readString("Введіть назву завдання: ");
            Priority priority = input.readPriority();
            LocalDateTime deadLine = input.readTime();
            taskService.add(new Task(0, name, priority, deadLine));
            System.out.println("Завдання " + name + " успішно додано!");
        } catch (IllegalArgumentException e) {
            System.err.println("ПОМИЛКА: " + e.getMessage());
        }
    }

    @Override
    public String choice() {
        return "1";
    }
}
