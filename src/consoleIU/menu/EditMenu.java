package consoleIU.menu;

import consoleIU.menu.builder.MapBuilderEditMenu;
import consoleIU.menu.processor.TaskProcessor;
import io.InputReader;
import service.TaskService;

import java.util.Map;

public class EditMenu {
    private final InputReader input;
    private final DisplayMenu displayMenu;
    private final Map<String, TaskProcessor> mapBuilderEditMenu;

    public EditMenu(TaskService taskService, InputReader input) {
        this.input = input;
        this.displayMenu = new DisplayMenu(taskService, input);
        MapBuilderEditMenu mapBuilderEditMenu = new MapBuilderEditMenu(taskService, input);
        this.mapBuilderEditMenu = mapBuilderEditMenu.buildEditMenu();
    }

    public void show() {
        while (true) {
            System.out.println("1) Змінити статус завдання");
            System.out.println("2) Змінити дату делайну завдання");
            System.out.println("0) Повернутись в меню");

            String choice = input.readString("Ваш вибір: ");

            if(choice.equals("0")) {
                return;
            } else {
                TaskProcessor processor = mapBuilderEditMenu.get(choice);
                if(processor != null) {
                    processor.process();
                } else {
                    System.out.println("Введіть пункт з меню!");
                }
            }
        }
    }
}
