package TaskProcessor.TaskProcessorImpl;

import ConsoleUI.Menu.DisplayMenu;
import DateTime.TimeFormatter;
import Entities.Task;
import Service.TaskService;
import TaskProcessor.TaskProcessor;
import IO.InputReader;


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
