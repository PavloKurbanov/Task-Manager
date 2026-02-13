package TaskProcessor;

public interface TaskProcessor {
    // Яку роботу виконуємо (додаємо, видаляємо...)
    void process();

    // На яку цифру реагуємо ("1", "2", "0"...)
    String choice();
}
