package ConsoleUI;

import Entities.Priority;
import Entities.Status;
import Entities.Task;
import Service.TaskService;
import Exception.TasksNotFoundException;
import Exception.TaskListIsEmptyException;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private TaskService taskService;
    private Scanner scanner;

    public ConsoleUI(TaskService taskService) {
        this.taskService = taskService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("---Менеджер завдань---");
            System.out.println("1) Додати завдання");
            System.out.println("2) Видалити завдання");
            System.out.println("3) Змінити статус завдання");
            System.out.println("4) Знайти завдання");
            System.out.println("5) Знайти завдання по пріоритету");
            System.out.println("6) Показати всі завдання");
            System.out.println("0) Вихід");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addTask();
                    break;
                case "2":
                    deleteTask();
                    break;
                case "3":
                    updateTask();
                    break;
                case "4":
                    getAllTask();
                    break;
                case "5":
                    getTaskByPriority();
                    break;
                case "6":
                    getAllTask();
                default:
                    System.out.println("Введіть номер з пункту!");
                    break;
            }
        }
    }

    private void addTask() {
        String name = readString("Введіть назву завдання: ");
        Priority priority = getPriority();
        try {
            taskService.add(new Task(0, name, priority));
            System.out.println("Завдання " + name + " успішно додано!");
        } catch (IllegalArgumentException e) {
            System.err.println("ПОМИЛКА: " + e.getMessage());
        }
    }

    private void deleteTask() {
        getAllTask();
        int deleteId = readInt("Введіть ID завдання: ");
        try {
            taskService.delete(deleteId);
            System.out.println("Завдання з ID " + deleteId + " успішно видалено");
        } catch (TasksNotFoundException e) {
            System.err.println("ПОМИЛКА: " + e.getMessage());
        }
    }

    private void updateTask() {
        getAllTask();
        int updateId = readInt("Введіть ID завдання: ");
        try {
            Task update = taskService.update(updateId);
            System.out.println("Завдання змінило статус на " + update.getStatus().getStatusName());
        } catch (TasksNotFoundException e) {
            System.err.println("ПОМИЛКА: " + e.getMessage());
        }
    }

    private void getAllTask() {
        try {
            System.out.println("Список всіх завдань: ");
            List<Task> allTask = taskService.getAll();
            for (Task task : allTask) {
                System.out.println(task);
            }
        } catch (TaskListIsEmptyException e) {
            System.err.println("ПОМИЛКА: " + e.getMessage());
        }
    }

    private void getTaskByPriority() {
        Priority priority = getPriority();
        try {
            System.out.println("Список завдань з пріоритетом " + priority.getPriority());
            List<Task> tasksByPriority = taskService.getTasksByPriority(priority);
            tasksByPriority.forEach(task -> System.out.println(task));
        } catch (TaskListIsEmptyException e) {
            System.err.println("ПОМИЛКА: " + e.getMessage());
        }
    }

    private Priority getPriority() {
        Priority[] priorities = Priority.values();
        Priority priority = null;
        do {
            System.out.println("Оберіть пріоритет: ");
            for (int i = 0; i < priorities.length; i++) {
                System.out.println((i + 1) + ". " + priorities[i].getPriority());
            }
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice >= 1 && choice <= priorities.length) {
                priority = priorities[choice - 1];
            }
        } while (priority == null);
        return priority;
    }

    private String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int readInt(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Це не число! Спробуйте ще раз.");
            }
        }
    }
}
