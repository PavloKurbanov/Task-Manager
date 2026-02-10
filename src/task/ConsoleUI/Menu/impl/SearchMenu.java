package task.ConsoleUI.Menu;

import task.Entities.Priority;
import task.Entities.Status;
import task.Entities.Task;
import task.IO.InputReader;
import task.Service.TaskService;
import task.Exception.TasksNotFoundException;

import java.util.List;

public class SearchMenu {
    private final TaskService taskService;
    private final InputReader input;

    public SearchMenu(TaskService taskService, InputReader inputRead) {
        this.taskService = taskService;
        this.input = inputRead;
    }

    public void show() {
        while (true) {
            System.out.println("\n1) Знайти по ID");
            System.out.println("2) Знайти по назві");
            System.out.println("3) Знайти по пріоритету");
            System.out.println("4) Знайти по статусу");
            System.out.println("0) Повернутись до меню");

            String choice = input.readString("\nВаш вибір: ");

            switch (choice) {
                case "1":
                    findById();
                    break;
                case "2":
                    findByTitle();
                    break;
                case "3":
                    findByPriority();
                    break;
                case "4":
                    findByStatus();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Ведіть номер з пунтку, або натисніть 0 для вихаду в меню");
            }
        }
    }

    private void findById() {
        int inputId = input.readInt("Введіть ID завдання: ");
        try {
            Task byId = taskService.findById(inputId);
            if (byId != null) {
                System.out.println(byId);
            }
        } catch (TasksNotFoundException e) {
            System.err.println("ПОМИЛКА: " + e.getMessage());
        }
    }

    private void findByTitle() {
        String readString = input.readString("Введінь назву завдання");
        try {
            Task byTitle = taskService.findByTitle(readString);
            if (byTitle != null) {
                System.out.println(byTitle);
            }
        } catch (TasksNotFoundException e) {
            System.err.println("ПОМИЛКА: " + e.getMessage());
        }
    }

    private void findByPriority(){
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
            tasksByPriority.forEach(System.out::println);
        }
    }

    private void findByStatus(){
        Status status = input.readStatus();

        List<Task> tasksByStatus = taskService.getTasksByStatus(status);

        if(tasksByStatus.isEmpty()){
            System.out.println("Не має завдань з статусом [" + status.getStatusName() + "]");
        }
        tasksByStatus.forEach(System.out::println);
    }
}