package ConsoleUI.Menu;

import Entities.Task;
import InputRead.InputRead;
import Service.TaskService;

import java.util.List;

public class ShowTaskMenu {
    private final TaskService taskService;
    private final InputRead input;

    public ShowTaskMenu(TaskService taskService, InputRead input) {
        this.taskService = taskService;
        this.input = input;
    }

    public void showTask() {
        while (true) {
            System.out.println("1) Список всіх завдань");
            System.out.println("2) Список всіх протермінованих завдань");
            System.out.println("0) Повернутись до меню");

            String choice = input.readString("Ваш вибір: ");

            switch (choice){
                case "1":
                    getAllTask();
                    break;
                case "2":
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Ведіть номер з пунтку, або натисніть 0 для вихаду в меню");
            }
        }
    }

    public void getAllTask(){
        System.out.println("Список завдань: ");

        List<Task> allTasks = taskService.getAll();

        if (allTasks.isEmpty()) {
            System.out.println("Список порожній!");
        }

        for (Task task : allTasks) {
            System.out.println(task);
        }
    }
}
