package ConsoleUI.Menu.Processor.Impl.Search;

import entity.Priority;
import entity.Task;
import io.InputReader;
import Service.TaskService;
import ConsoleUI.Menu.Processor.TaskProcessor;

import java.util.List;

public class FindByPriorityProcessor implements TaskProcessor {
    private final TaskService  taskService;
    private final InputReader input;

    public FindByPriorityProcessor(TaskService taskService, InputReader input) {
        this.taskService = taskService;
        this.input = input;
    }

    @Override
    public void process() {
        Priority priority = input.readPriority();

        List<Task> tasksByPriority = taskService.getTasksByPriority(priority);

        if (tasksByPriority.isEmpty()) {
            System.out.println("Не має задач з пріоритетом " + priority.getPriority());
        } else {
            if (tasksByPriority.size() % 2 == 0) {
                System.out.println("Знайдено " + tasksByPriority.size() + " задачі з пріоритетом " + priority.getPriority());
            } else {
                System.out.println("Знайдено " + tasksByPriority.size() + " задач з пріоритетом " + priority.getPriority());
            }
            tasksByPriority.forEach(System.out::println);
        }
    }

    @Override
    public String choice() {
        return "3";
    }
}
