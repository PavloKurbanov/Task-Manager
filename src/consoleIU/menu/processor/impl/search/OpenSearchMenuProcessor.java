package consoleIU.menu.processor.impl.search;

import consoleIU.menu.processor.TaskProcessor;
import consoleIU.menu.SearchMenu;
import service.TaskService;
import io.InputReader;

public class OpenSearchMenuProcessor implements TaskProcessor {
    private SearchMenu searchMenu;

    public OpenSearchMenuProcessor(TaskService taskService, InputReader input){
        this.searchMenu = new SearchMenu(taskService, input);
    }

    @Override
    public String choice() {
        return "4";
    }

    @Override
    public void process() {
        searchMenu.show();
    }
}
