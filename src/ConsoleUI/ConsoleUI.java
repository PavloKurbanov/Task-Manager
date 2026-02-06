package ConsoleUI;

import DataTime.TimeFormatter;
import Entities.Priority;
import Entities.Task;
import InputRead.InputRead;
import Service.TaskService;
import Exception.TasksNotFoundException;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private TaskService taskService;
    private InputRead input;

    public ConsoleUI(TaskService taskService) {
        this.taskService = taskService;
        this.input = new InputRead();
    }

    public void start() {
        while (true) {
            System.out.println("---Менеджер завдань---");
            System.out.println("1) Додати завдання");
            System.out.println("2) Видалити завдання");
            System.out.println("3) Змінити статус завдання");
            System.out.println("4) Знайти завдання по ID");
            System.out.println("5) Знайти завдання по пріоритету");
            System.out.println("6) Показати всі завдання");
            System.out.println("0) Вихід");

            String choice = input.readString("Ваш вибір: ");

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
                    findTaskById();
                    break;
                case "5":
                    getTaskByPriority();
                    break;
                case "6":
                    getAllTask();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Введіть номер з пункту!");
                    break;
            }
        }
    }

    private void addTask() {
        String name = input.readString("Введіть назву завдання: ");
        Priority priority = input.readPriority();
        LocalDateTime deadLine = input.readTime();
        taskService.add(new Task(0, name, priority, deadLine));
        System.out.println("Завдання " + name + " успішно додано!");
    }

    private void deleteTask() {
        getAllTask();
        int deleteId = input.readInt("Введіть ID завдання: ");
        try {
            taskService.delete(deleteId);
            System.out.println("Завдання з ID " + deleteId + " успішно видалено");
        } catch (TasksNotFoundException e) {
            System.err.println("ПОМИЛКА: " + e.getMessage());
        }
    }

    private void findTaskById() {
        int id = input.readInt("Введіть ID завдання: ");
        try{
            Task byId = taskService.findById(id);
            if(byId != null){
                System.out.println(byId);
            }
        } catch (TasksNotFoundException e) {
            System.err.println("ПОМИЛКА: " + e.getMessage());
        }
    }

    private void updateTask() {
        getAllTask();
        int updateId = input.readInt("Введіть ID завдання: ");
        try {
            Task update = taskService.update(updateId);
            System.out.println("Завдання змінило статус на " + update.getStatus().getStatusName());
        } catch (TasksNotFoundException e) {
            System.err.println("ПОМИЛКА: " + e.getMessage());
        }
    }

    private void getAllTask() {
        System.out.println("Список завдань: ");

        List<Task> allTasks = taskService.getAll();

        if (allTasks.isEmpty()) {
            System.out.println("Список порожній!");
        }

        for (Task task : allTasks) {
            System.out.println(task);
        }
    }

    private void getTaskByPriority() {
        Priority priority = input.readPriority();

        List<Task> tasksByPriority = taskService.getTasksByPriority(priority);

        if (tasksByPriority.isEmpty()) {
            System.out.println("Не має задач з пріоритетом " + priority.getPriority());
        } else {
            if (tasksByPriority.size() % 2 == 0) {
                System.out.println("Знайдено " + tasksByPriority.size() + " задачі з пріоритетом " + priority.getPriority());
            } else {
                System.out.println("Знайдено " + tasksByPriority.size() + " задач з пріоритетом " + priority.getPriority());
            }
            tasksByPriority.forEach(task -> System.out.println(task));
        }
    }

}
