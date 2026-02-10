package task.ConsoleUI.Menu;

import task.Entities.Task;
import task.IO.InputReader;
import task.Service.TaskService;

import java.util.List;

public class DisplayMenu {
    private final TaskService taskService;
    private final InputReader input;

    public DisplayMenu(TaskService taskService, InputReader input) {
        this.taskService = taskService;
        this.input = input;
    }

    public void show() {
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
                    getAllOverdueTasks();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Ведіть номер з пунтку, або натисніть 0 для вихаду в меню");
            }
        }
    }

    public void getAllTask(){
        List<Task> allTasks = taskService.getAll();

        if (allTasks.isEmpty()) {
            System.out.println("Список порожній!");
        }

        System.out.println("Список завдань: ");

        for (Task task : allTasks) {
            System.out.println(task);
        }
    }

    public void getAllOverdueTasks(){
        List<Task> allOverdueTasks = taskService.getOverdueTasks();

        if(allOverdueTasks.isEmpty()){
            System.out.println("Не має протермінованих завдань: ");
        }

        System.out.println("Список протермінованих завданнь " + allOverdueTasks.size() + " :");

        for (Task allOverdueTask : allOverdueTasks) {
            System.out.println(allOverdueTask);
        }

    }
}
