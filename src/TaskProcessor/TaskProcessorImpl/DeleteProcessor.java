package TaskProcessor.TaskProcessorImpl;

import ConsoleUI.Menu.DisplayMenu;
import Service.TaskService;
import IO.InputReader;
import Exception.TasksNotFoundException;
import TaskProcessor.TaskProcessor;

public class DeleteProcessor implements TaskProcessor {
    private final TaskService taskService;
    private final InputReader input;
    private final DisplayMenu displayMenu;

    public DeleteProcessor(TaskService taskService, InputReader input){
        this.taskService = taskService;
        this.input = input;
        this.displayMenu = new DisplayMenu(taskService, input);
    }

    @Override
    public void process() {
        displayMenu.getAllTask();
        int deleteId = input.readInt("Введіть ID завдання: ");
        try {
            taskService.delete(deleteId);
            System.out.println("Завдання з ID " + deleteId + " успішно видалено");
        } catch (TasksNotFoundException e) {
            System.err.println("ПОМИЛКА: " + e.getMessage());
        }
    }

    @Override
    public String choice() {
        return "2";
    }
}
