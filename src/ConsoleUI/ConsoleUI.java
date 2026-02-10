package ConsoleUI;

import ConsoleUI.Menu.EditMenu;
import ConsoleUI.Menu.SearchMenu;
import ConsoleUI.Menu.DisplayMenu;
import Entities.Priority;
import Entities.Task;
import IO.InputReader;
import Service.TaskService;
import Exception.TasksNotFoundException;
import java.time.LocalDateTime;


public class ConsoleUI {
    private final TaskService taskService;
    private final InputReader input;
    private final SearchMenu searchMenu;
    private final EditMenu editMenu;
    private final DisplayMenu displayMenu;

    public ConsoleUI(TaskService taskService) {
        this.taskService = taskService;
        this.input = new InputReader();
        this.searchMenu = new SearchMenu(taskService, input);
        this.editMenu = new EditMenu(taskService, input);
        this.displayMenu = new DisplayMenu(taskService, input);
    }

    public void start() {
        while (true) {
            System.out.println("\n---Менеджер завдань---");
            System.out.println("1) Додати завдання");
            System.out.println("2) Видалити завдання");
            System.out.println("3) Змінити завдання");
            System.out.println("4) Знайти завдання");
            System.out.println("5) Показати завдання");
            System.out.println("0) Вихід");

            String choice = input.readString("\nВаш вибір: ");

            switch (choice) {
                case "1":
                    addTask();
                    break;
                case "2":
                    deleteTask();
                    break;
                case "3":
                    editMenu.show();
                    break;
                case "4":
                    searchMenu.show();
                    break;
                case "5":
                    displayMenu.show();
                    break;
                case "0":
                    System.out.println("\nДякуємо! На все добре");
                    return;
                default:
                    System.out.println("Введіть номер з пункту!");
                    break;
            }
        }
    }

    private void addTask() {
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

    private void deleteTask() {
        displayMenu.getAllTask();
        int deleteId = input.readInt("Введіть ID завдання: ");
        try {
            taskService.delete(deleteId);
            System.out.println("Завдання з ID " + deleteId + " успішно видалено");
        } catch (TasksNotFoundException e) {
            System.err.println("ПОМИЛКА: " + e.getMessage());
        }
    }
}
