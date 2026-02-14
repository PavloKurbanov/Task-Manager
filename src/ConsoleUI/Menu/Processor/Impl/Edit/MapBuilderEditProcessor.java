package ConsoleUI.Menu.Processor.Impl.Edit;

import ConsoleUI.Menu.Processor.TaskProcessor;
import Service.TaskService;
import IO.InputReader;

public class MapBuilderEditProcessor implements TaskProcessor {
    private final TaskService taskService;
    private final InputReader input;
    private final MapBuilderEditMenu mapBuilderEditMenu;

    public MapBuilderEditProcessor(TaskService taskService, InputReader input){
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
