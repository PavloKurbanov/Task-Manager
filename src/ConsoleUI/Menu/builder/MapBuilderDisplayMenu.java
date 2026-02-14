package ConsoleUI.Menu.builder;

import ConsoleUI.Menu.Processor.Impl.Display.GetAllOverdueTasksProcessor;
import ConsoleUI.Menu.Processor.Impl.Display.GetAllTasksProcessor;
import ConsoleUI.Menu.Processor.TaskProcessor;
import Service.TaskService;
import io.InputReader;

import java.util.HashMap;
import java.util.Map;

public class MapBuilderDisplayMenu {
    private final TaskService taskService;
    private final InputReader input;

    public MapBuilderDisplayMenu(TaskService taskService, InputReader input) {
        this.taskService = taskService;
        this.input = input;
    }

    public Map<String, TaskProcessor> displayMenu() {
        Map<String, TaskProcessor> displayMenu = new HashMap<>();

        TaskProcessor getAll = new GetAllTasksProcessor(taskService, input);
        TaskProcessor getAllOverdue = new GetAllOverdueTasksProcessor(taskService, input);

        displayMenu.put(getAll.choice(), getAll);
        displayMenu.put(getAllOverdue.choice(), getAllOverdue);

        return displayMenu;
    }
}
