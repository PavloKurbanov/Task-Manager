package ConsoleUI.Menu.Processor.Impl.Search;

import ConsoleUI.Menu.Processor.TaskProcessor;
import Service.TaskService;
import IO.InputReader;

public class MapBuilderSearchProcessor implements TaskProcessor {
    private final TaskService taskService;
    private final InputReader input;

    public MapBuilderSearchProcessor(TaskService taskService, InputReader input){
        this.taskService = taskService;
        this.input = input;
    }

    @Override
    public String choice() {
        return "4";
    }

    @Override
    public void process() {
        SearchMenu searchMenu = new SearchMenu(taskService, input);
        searchMenu.show();
    }
}
