package ConsoleUI.Menu.Processor.Impl.Edit;

import ConsoleUI.Menu.EditMenu;
import ConsoleUI.Menu.Processor.TaskProcessor;
import ConsoleUI.Menu.builder.MapBuilderEditMenu;
import Service.TaskService;
import io.InputReader;

public class OpenEditMenuProcessor implements TaskProcessor {
    private final TaskService taskService;
    private final InputReader input;
    private final MapBuilderEditMenu mapBuilderEditMenu;

    public OpenEditMenuProcessor(TaskService taskService, InputReader input){
        this.taskService = taskService;
        this.input = input;
        this.mapBuilderEditMenu = new MapBuilderEditMenu(taskService, input);
    }

    @Override
    public String choice() {
        return "3";
    }

    @Override
    public void process() {
        EditMenu editMenu= new EditMenu(taskService, input);
        editMenu.show();
    }
}
