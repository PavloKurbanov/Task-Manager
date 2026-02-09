package ConsoleUI.Menu;

import DateTime.TimeFormatter;
import Entities.Task;
import InputRead.InputRead;
import Service.TaskService;

public class EditMenu {
    private final TaskService taskService;
    private final InputRead input;
    private final ShowTaskMenu showTaskMenu;

    public EditMenu(TaskService taskService, InputRead input) {
        this.taskService = taskService;
        this.input = input;
        this.showTaskMenu = new ShowTaskMenu(taskService, input);
    }

    public void showChangeInTasks() {
        while (true) {
            System.out.println("1) Змінити статус завдання");
            System.out.println("2) Змінити дату делайну завдання на один день");
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
        showTaskMenu.getAllTask();
        int updateId = input.readInt("Введіть ID завдання: ");
        try {
            Task update = taskService.update(updateId);
            System.out.println("Завдання змінило статус на [" + update.getStatus().getStatusName() + "]");
        } catch (IllegalArgumentException e) {
            System.err.println("ПОМИЛКА: " + e.getMessage());
        }
    }

    private void changeDeadline(){
        showTaskMenu.getAllTask();
        int deadlineId = input.readInt("Введіть ID завдання: ");
        try {
            Task task = taskService.postponeTask(deadlineId);
            System.out.println("Дата дедлайну змінена на " + TimeFormatter.format(task.getDeadline()));
        } catch (IllegalArgumentException e) {
            System.err.println("Щось пішло не так!");
        }
    }
}
