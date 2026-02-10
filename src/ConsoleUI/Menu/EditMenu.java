package ConsoleUI.Menu;

import DateTime.TimeFormatter;
import Entities.Task;
import IO.InputReader;
import Service.TaskService;

public class EditMenu {
    private final TaskService taskService;
    private final InputReader input;
    private final DisplayMenu displayMenu;

    public EditMenu(TaskService taskService, InputReader input) {
        this.taskService = taskService;
        this.input = input;
        this.displayMenu = new DisplayMenu(taskService, input);
    }

    public void show() {
        while (true) {
            System.out.println("1) Змінити статус завдання");
            System.out.println("2) Змінити дату делайну завдання");
            System.out.println("0) Повернутись в меню");

            String choice = input.readString("Ваш вибір: ");
            switch (choice) {
                case "1":
                    changeStatus();
                    break;
                case "2":
                    changeDeadline();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("ВВведіть номер з пунтку, або натисніть 0 для вихаду в меню");
            }
        }
    }

    private void changeStatus(){
        displayMenu.getAllTask();
        int updateId = input.readInt("Введіть ID завдання: ");
        try {
            Task update = taskService.update(updateId);
            System.out.println("Завдання змінило статус на [" + update.getStatus().getStatusName() + "]");
        } catch (IllegalArgumentException e) {
            System.err.println("ПОМИЛКА: " + e.getMessage());
        }
    }

    private void changeDeadline(){
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
