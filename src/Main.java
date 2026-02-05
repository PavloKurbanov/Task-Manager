import ConsoleUI.ConsoleUI;
import Repository.InMemoryRepositoryImpl;
import Repository.TaskRepository;
import Service.TaskService;
import Service.TaskServiceImpl;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TaskRepository repository = new InMemoryRepositoryImpl();
        TaskService service = new TaskServiceImpl(repository);
        ConsoleUI consoleUI = new ConsoleUI(service);
        consoleUI.start();
    }
}