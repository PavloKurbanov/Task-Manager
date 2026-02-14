package ConsoleUI;

import ConsoleUI.Menu.builder.MapBuilder;
import io.InputReader;
import Service.TaskService;
import ConsoleUI.Menu.Processor.TaskProcessor;

import java.util.Map;


public class ConsoleUI {
    private final InputReader input;
    private final Map<String, TaskProcessor> menuMap;

    public ConsoleUI(TaskService taskService) {
        this.input = new InputReader();
        MapBuilder builder = new MapBuilder(taskService, input);
        this.menuMap = builder.buildMenu();
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

            if(choice.equals("0")){
                System.out.println("Дякуємо! На все добре");
                return;
            }

            TaskProcessor processor = menuMap.get(choice);

            if(processor != null){
                processor.process();
            } else {
                System.out.println("Введіть номер з пункту!");
            }
        }
    }
}
