package consoleIU.menu.builder;

import consoleIU.menu.processor.impl.edit.ChangeDeadlineProcessor;
import consoleIU.menu.processor.impl.edit.ChangeStatusProcessor;
import consoleIU.menu.processor.TaskProcessor;
import io.InputReader;
import service.TaskService;

import java.util.HashMap;
import java.util.Map;

public class MapBuilderEditMenu {
    private final TaskService taskService;
    private final InputReader input;

    public MapBuilderEditMenu(TaskService taskService, InputReader input) {
        this.taskService = taskService;
        this.input = input;
    }

    public Map<String, TaskProcessor> buildEditMenu() {
        Map<String, TaskProcessor> map = new HashMap<>();

        TaskProcessor changeStatus = new ChangeStatusProcessor(taskService, input);
        TaskProcessor changeDeadline = new ChangeDeadlineProcessor(taskService, input);

        map.put(changeStatus.choice(), changeStatus);
        map.put(changeDeadline.choice(), changeDeadline);

        return map;
    }
}
