package consoleIU.menu.processor.impl.display;

import consoleIU.menu.DisplayMenu;
import consoleIU.menu.processor.TaskProcessor;
import consoleIU.menu.builder.MapBuilderDisplayMenu;
import service.TaskService;
import io.InputReader;

public class OpenDisplayMenuProcessor implements TaskProcessor {
    private final DisplayMenu displayMenu;

    public OpenDisplayMenuProcessor(TaskService taskService, InputReader input) {
        this.displayMenu = new DisplayMenu(taskService, input);
    }

    @Override
    public String choice() {
        return "5";
    }

    @Override
    public void process() {
        displayMenu.show();
    }
}
