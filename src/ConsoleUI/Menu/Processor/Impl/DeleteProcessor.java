package ConsoleUI.Menu.Processor.Impl;

import ConsoleUI.Menu.DisplayMenu;
import ConsoleUI.Menu.Processor.Impl.Display.GetAllTasksProcessor;
import Service.TaskService;
import io.InputReader;
import exception.TasksNotFoundException;
import ConsoleUI.Menu.Processor.TaskProcessor;

public class DeleteProcessor implements TaskProcessor {
    private final TaskService taskService;
    private final InputReader input;
    private final GetAllTasksProcessor  getAllTasksProcessor;

    public DeleteProcessor(TaskService taskService, InputReader input){
        this.taskService = taskService;
        this.input = input;
        this.getAllTasksProcessor = new GetAllTasksProcessor(taskService, input);
    }

    @Override
    public void process() {
       getAllTasksProcessor.process();
        int deleteId = input.readInt("Введіть ID завдання: ");
        try {
            taskService.delete(deleteId);
            System.out.println("Завдання з ID " + deleteId + " успішно видалено");
        } catch (TasksNotFoundException e) {
            System.err.println("ПОМИЛКА: " + e.getMessage());
        }
    }

    @Override
    public String choice() {
        return "2";
    }
}
