package ConsoleUI.Menu;

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
    private final MapBuilderEditMenu mapBuilderEditMenu;

    public MapBuilder(TaskService taskService, InputReader input) {
        this.taskService = taskService;
        this.input = input;
        this.mapBuilderEditMenu = new MapBuilderEditMenu(taskService, input);
    }

    public Map<String, TaskProcessor> buildMenu() {
        Map<String, TaskProcessor> map = new HashMap<>();


        TaskProcessor add = new AddProcessor(taskService, input);
        TaskProcessor delete = new DeleteProcessor(taskService, input);
        map.put(add.choice(), add);
        map.put(delete.choice(), delete);

        Map<String, TaskProcessor> editMenu = mapBuilderEditMenu.buildEditMenu();
        map.putAll(editMenu);

        return map;
    }
}
