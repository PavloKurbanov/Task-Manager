package TaskProcessor.TaskProcessorImpl;

import ConsoleUI.Menu.DisplayMenu;
import Entities.Task;
import Service.TaskService;
import TaskProcessor.TaskProcessor;
import IO.InputReader;

public class ChangeStatusProcessor implements TaskProcessor {
    private final TaskService taskService;
    private final InputReader input;
    private final DisplayMenu displayMenu;

    public ChangeStatusProcessor(TaskService taskService, InputReader input){
        this.taskService = taskService;
        this.input = input;
        this.displayMenu = new DisplayMenu(taskService, input);
    }

    @Override
    public void process() {
        displayMenu.getAllTask();
        int updateId = input.readInt("Введіть ID завдання: ");
        try {
            Task update = taskService.update(updateId);
            System.out.println("Завдання змінило статус на [" + update.getStatus().getStatusName() + "]");
        } catch (IllegalArgumentException e) {
            System.err.println("ПОМИЛКА: " + e.getMessage());
        }
    }

    @Override
    public String choice() {
        return "1";
    }
}
