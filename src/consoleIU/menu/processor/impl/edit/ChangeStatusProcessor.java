package consoleIU.menu.processor.impl.edit;

import consoleIU.menu.processor.impl.display.GetAllTasksProcessor;
import entity.Task;
import service.TaskService;
import consoleIU.menu.processor.TaskProcessor;
import io.InputReader;

public class ChangeStatusProcessor implements TaskProcessor {
    private final TaskService taskService;
    private final InputReader input;
    private final GetAllTasksProcessor getAllTasksProcessor;

    public ChangeStatusProcessor(TaskService taskService, InputReader input){
        this.taskService = taskService;
        this.input = input;
        this.getAllTasksProcessor = new GetAllTasksProcessor(taskService);
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
