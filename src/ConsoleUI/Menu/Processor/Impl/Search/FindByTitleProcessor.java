package ConsoleUI.Menu.Processor.Impl.Search;

import Entities.Task;
import IO.InputReader;
import Service.TaskService;
import ConsoleUI.Menu.Processor.TaskProcessor;
import Exception.TasksNotFoundException;

public class FindByTitleProcessor implements TaskProcessor {
    private final TaskService  taskService;
    private final InputReader input;

    public FindByTitleProcessor(TaskService taskService, InputReader input) {
        this.taskService = taskService;
        this.input = input;
    }

    @Override
    public String choice() {
        return "2";
    }

    @Override
    public void process() {
        String readString = input.readString("Введінь назву завдання: ");
        try {
            Task byTitle = taskService.findByTitle(readString);
            if (byTitle != null) {
                System.out.println(byTitle);
            }
        } catch (TasksNotFoundException e) {
            System.err.println("ПОМИЛКА: " + e.getMessage());
        }
    }
}
