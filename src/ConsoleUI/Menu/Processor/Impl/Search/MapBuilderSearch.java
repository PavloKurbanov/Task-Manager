package ConsoleUI.Menu.Processor.Impl.Search;

import ConsoleUI.Menu.Processor.TaskProcessor;
import Service.TaskService;
import IO.InputReader;

import java.util.HashMap;
import java.util.Map;

public class MapBuilderSearch {
    private final TaskService taskService;
    private final InputReader input;

    public MapBuilderSearch(TaskService taskService, InputReader input){
        this.taskService = taskService;
        this.input = input;
    }

    public Map<String, TaskProcessor> buildSearchMenu(){
        Map<String, TaskProcessor> searchMenu = new HashMap<>();

        TaskProcessor findById = new FindByIdProcessor(taskService, input);
        TaskProcessor findByPriority = new FindByPriorityProcessor(taskService, input);
        TaskProcessor findByTitle = new FindByTitleProcessor(taskService, input);
        TaskProcessor findByStatus = new FindByStatusProcessor(taskService, input);

        searchMenu.put(findById.choice(), findById);
        searchMenu.put(findByTitle.choice(), findByTitle);
        searchMenu.put(findByPriority.choice(), findByPriority);
        searchMenu.put(findByStatus.choice(), findByStatus);

        return searchMenu;
    }
}
