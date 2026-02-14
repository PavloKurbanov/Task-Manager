package ConsoleUI.Menu;

import ConsoleUI.Menu.builder.MapBuilderSearch;
import ConsoleUI.Menu.Processor.TaskProcessor;
import io.InputReader;
import Service.TaskService;

import java.util.Map;

public class SearchMenu {
    private final TaskService taskService;
    private final InputReader input;
    private final Map<String, TaskProcessor> mapBuilderSearch;


    public SearchMenu(TaskService taskService, InputReader inputRead) {
        this.taskService = taskService;
        this.input = inputRead;
        MapBuilderSearch mapBuilderSearch = new MapBuilderSearch(taskService, input);
        this.mapBuilderSearch = mapBuilderSearch.buildSearchMenu();
    }

    public void show() {
        while (true) {
            System.out.println("\n1) Знайти по ID");
            System.out.println("2) Знайти по назві");
            System.out.println("3) Знайти по пріоритету");
            System.out.println("4) Знайти по статусу");
            System.out.println("0) Повернутись до меню");

            String choice = input.readString("\nВаш вибір: ");
            if (choice.equals("0")) {
                return;
            } else {
                TaskProcessor processor = mapBuilderSearch.get(choice);
                if(processor != null){
                    processor.process();
                } else {
                    System.out.println("Ведіть номер з пунтку, або натисніть 0 для вихаду в меню");
                }
            }
        }
    }

}