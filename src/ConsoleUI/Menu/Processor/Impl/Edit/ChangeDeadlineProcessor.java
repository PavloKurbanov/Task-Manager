package ConsoleUI.Menu.Processor.Impl.Edit;

import ConsoleUI.Menu.DisplayMenu;
import datetime.TimeFormatter;
import entity.Task;
import Service.TaskService;
import ConsoleUI.Menu.Processor.TaskProcessor;
import io.InputReader;


public class ChangeDeadlineProcessor implements TaskProcessor {
    private final TaskService taskService;
    private final InputReader input;
    private final DisplayMenu displayMenu;

    public ChangeDeadlineProcessor(TaskService taskService, InputReader input){
        this.taskService = taskService;
        this.input = input;
        this.displayMenu = new DisplayMenu(taskService, input);
    }

    @Override
    public String choice() {
        return "2";
    }

    @Override
    public void process() {
        displayMenu.getAllTask();
        int taskId = input.readInt("Введіть ID завдання: ");
        Long daysToAdd = input.readLong("Введіть кількість днів: ");
        try {

            Task task = taskService.postponeTask(taskId, daysToAdd);
            System.out.println("Дата дедлайну змінена на " + TimeFormatter.format(task.getDeadline()));
        } catch (IllegalArgumentException e) {
            System.err.println("Щось пішло не так!");
        }
    }
}
