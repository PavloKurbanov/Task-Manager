package consoleIU.menu.builder;

import consoleIU.menu.processor.impl.display.OpenDisplayMenuProcessor;
import consoleIU.menu.processor.impl.edit.OpenEditMenuProcessor;
import consoleIU.menu.processor.impl.search.OpenSearchMenuProcessor;
import service.TaskService;
import io.InputReader;
import consoleIU.menu.processor.TaskProcessor;
import consoleIU.menu.processor.impl.AddProcessor;
import consoleIU.menu.processor.impl.DeleteProcessor;

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
        TaskProcessor edit = new OpenEditMenuProcessor(taskService, input);
        TaskProcessor search = new OpenSearchMenuProcessor(taskService, input);
        TaskProcessor display = new OpenDisplayMenuProcessor(taskService, input);

        map.put(add.choice(), add);
        map.put(delete.choice(), delete);
        map.put(edit.choice(), edit);
        map.put(search.choice(), search);
        map.put(display.choice(), display);

        return map;
    }
}
