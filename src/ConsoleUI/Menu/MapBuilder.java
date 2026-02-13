package ConsoleUI.Menu;

import Service.TaskService;
import IO.InputReader;
import TaskProcessor.TaskProcessor;
import TaskProcessor.TaskProcessorImpl.AddProcessor;
import TaskProcessor.TaskProcessorImpl.DeleteProcessor;

import java.util.HashMap;
import java.util.Map;

public class MapBuilder {
    private final TaskService taskService;
    private final InputReader input;

    public MapBuilder(TaskService taskService, InputReader input){
        this.taskService = taskService;
        this.input = input;
    }

    public Map<String, TaskProcessor> buildMenu(){
        Map<String, TaskProcessor> map = new HashMap<>();

        TaskProcessor add = new AddProcessor(taskService, input);
        TaskProcessor delete = new DeleteProcessor(taskService, input);
        map.put(add.choice(), add);
        map.put(delete.choice(), delete);

        return map;
    }
}
