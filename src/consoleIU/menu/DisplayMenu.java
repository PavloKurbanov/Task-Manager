package consoleIU.menu;

import consoleIU.menu.processor.TaskProcessor;
import consoleIU.menu.builder.MapBuilderDisplayMenu;
import io.InputReader;
import service.TaskService;

import java.util.Map;

public class DisplayMenu {
    private final TaskService taskService;
    private final InputReader input;
    private final Map<String, TaskProcessor> displayMenu;

    public DisplayMenu(TaskService taskService, InputReader input) {
        this.taskService = taskService;
        this.input = input;
        MapBuilderDisplayMenu mapBuilderDisplayMenu = new MapBuilderDisplayMenu(taskService, input);
        this.displayMenu = mapBuilderDisplayMenu.displayMenu();
    }

    public void show() {
        while (true) {
            System.out.println("1) Список всіх завдань");
            System.out.println("2) Список всіх протермінованих завдань");
            System.out.println("0) Повернутись до меню");

            String choice = input.readString("Ваш вибір: ");

            if (choice.equals("0")) {
                return;
            } else {
                TaskProcessor processor = displayMenu.get(choice);
                if (processor != null) {
                    processor.process();
                } else {
                    System.out.println("Ведіть номер з пункту, або натисніть 0 для виходу в меню");
                }
            }
        }
    }
}
