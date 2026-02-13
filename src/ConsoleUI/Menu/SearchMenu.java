package ConsoleUI.Menu;

import Entities.Priority;
import Entities.Status;
import Entities.Task;
import IO.InputReader;
import Service.TaskService;
import Exception.TasksNotFoundException;

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

    }

    private void findByTitle() {

    }

    private void findByPriority(){

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