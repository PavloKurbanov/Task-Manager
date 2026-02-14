package ConsoleUI.Menu.Processor.Impl.Display;

import ConsoleUI.Menu.DisplayMenu;
import ConsoleUI.Menu.Processor.TaskProcessor;
import ConsoleUI.Menu.builder.MapBuilderDisplayMenu;
import Service.TaskService;
import io.InputReader;

public class OpenDisplayMenuProcessor implements TaskProcessor {
    private final TaskService taskService;
    private final InputReader input;
    private final MapBuilderDisplayMenu mapBuilderDisplayMenu;

    public OpenDisplayMenuProcessor(TaskService taskService, InputReader input) {
        this.taskService = taskService;
        this.input = input;
        this.mapBuilderDisplayMenu = new MapBuilderDisplayMenu(taskService, input);
    }

    @Override
    public String choice() {
        return "5";
    }

    @Override
    public void process() {
        DisplayMenu displayMenu = new DisplayMenu(taskService, input);
        displayMenu.show();
    }
}
