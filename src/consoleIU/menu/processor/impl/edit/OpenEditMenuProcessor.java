package consoleIU.menu.processor.impl.edit;

import consoleIU.menu.EditMenu;
import consoleIU.menu.processor.TaskProcessor;
import consoleIU.menu.builder.MapBuilderEditMenu;
import service.TaskService;
import io.InputReader;

public class OpenEditMenuProcessor implements TaskProcessor {
    private final EditMenu editMenu;

    public OpenEditMenuProcessor(TaskService taskService, InputReader input){
        this.editMenu = new EditMenu(taskService, input);
    }

    @Override
    public String choice() {
        return "3";
    }

    @Override
    public void process() {
        editMenu.show();
    }
}
