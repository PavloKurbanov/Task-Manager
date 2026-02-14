package ConsoleUI.Menu.Processor.Impl.Search;

import ConsoleUI.Menu.Processor.TaskProcessor;
import ConsoleUI.Menu.SearchMenu;
import Service.TaskService;
import io.InputReader;

public class OpenSearchMenuProcessor implements TaskProcessor {
    private final TaskService taskService;
    private final InputReader input;
    private SearchMenu searchMenu;

    public OpenSearchMenuProcessor(TaskService taskService, InputReader input){
        this.taskService = taskService;
        this.input = input;
    }

    @Override
    public String choice() {
        return "4";
    }

    @Override
    public void process() {
        searchMenu = new SearchMenu(taskService, input);
        searchMenu.show();
    }
}
