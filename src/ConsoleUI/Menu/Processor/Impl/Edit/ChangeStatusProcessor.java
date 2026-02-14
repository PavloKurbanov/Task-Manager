package ConsoleUI.Menu.Processor.Impl.Edit;

import ConsoleUI.Menu.DisplayMenu;
import ConsoleUI.Menu.Processor.Impl.Display.GetAllTasksProcessor;
import entity.Task;
import Service.TaskService;
import ConsoleUI.Menu.Processor.TaskProcessor;
import io.InputReader;

public class ChangeStatusProcessor implements TaskProcessor {
    private final TaskService taskService;
    private final InputReader input;
    private final GetAllTasksProcessor getAllTasksProcessor;

    public ChangeStatusProcessor(TaskService taskService, InputReader input){
        this.taskService = taskService;
        this.input = input;
        this.getAllTasksProcessor = new GetAllTasksProcessor(taskService, input);
    }

    @Override
    public void process() {
        getAllTasksProcessor.process();
        int updateId = input.readInt("Введіть ID завдання: ");
        try {
            Task update = taskService.update(updateId);
            System.out.println("Завдання змінило статус на [" + update.getStatus().getStatusName() + "]");
        } catch (IllegalArgumentException e) {
            System.err.println("ПОМИЛКА: " + e.getMessage());
        }
    }

    @Override
    public String choice() {
        return "1";
    }
}
