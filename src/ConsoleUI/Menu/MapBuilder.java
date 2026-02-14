package ConsoleUI.Menu;

import ConsoleUI.Menu.Processor.Impl.Edit.MapBuilderEditProcessor;
import ConsoleUI.Menu.Processor.Impl.Search.MapBuilderSearchProcessor;
import Service.TaskService;
import IO.InputReader;
import ConsoleUI.Menu.Processor.TaskProcessor;
import ConsoleUI.Menu.Processor.Impl.AddProcessor;
import ConsoleUI.Menu.Processor.Impl.DeleteProcessor;

import java.util.HashMap;
import java.util.Map;

public class MapBuilder {
    private final TaskService taskService;
    private final InputReader input;

    public MapBuilder(TaskService taskService, InputReader input) {
        this.taskService = taskService;
        this.input = input;
    }

    public Map<String, TaskProcessor> buildMenu() {
        Map<String, TaskProcessor> map = new HashMap<>();


        TaskProcessor add = new AddProcessor(taskService, input);
        TaskProcessor delete = new DeleteProcessor(taskService, input);
        TaskProcessor edit = new MapBuilderEditProcessor(taskService, input);
        TaskProcessor search = new MapBuilderSearchProcessor(taskService, input);
        map.put(add.choice(), add);
        map.put(delete.choice(), delete);
        map.put(edit.choice(), edit);
        map.put(search.choice(), search);

        return map;
    }
}
