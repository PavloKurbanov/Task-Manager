package consoleIU.menu.processor.impl.display;

import consoleIU.menu.processor.TaskProcessor;
import service.TaskService;
import entity.Task;
import io.InputReader;

import java.util.List;

public class GetAllOverdueTasksProcessor implements TaskProcessor {
    private final TaskService taskService;
    private final InputReader inputReader;

    public GetAllOverdueTasksProcessor(TaskService taskService, InputReader inputReader) {
        this.taskService = taskService;
        this.inputReader = inputReader;
    }

    @Override
    public String choice() {
        return "2";
    }

    @Override
    public void process() {
        List<Task> allOverdueTasks = taskService.getOverdueTasks();

        if(allOverdueTasks.isEmpty()){
            System.out.println("Не має протермінованих завдань: ");
        }

        System.out.println("Список протермінованих завданнь " + allOverdueTasks.size() + " :");

        for (Task allOverdueTask : allOverdueTasks) {
            System.out.println(allOverdueTask);
        }
    }
}
