package IO;

import DateTime.TimeFormatter;
import Entities.Priority;
import Entities.Status;
import Service.TaskService;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputReader {
    private final Scanner scanner;

    public InputReader() {
        scanner = new Scanner(System.in);
    }

    public String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int readInt(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Це не число! Спробуйте ще раз.");
            }
        }
    }

    public Priority readPriority() {
        Priority[] priorities = Priority.values();
        Priority priority = null;
        do {
            System.out.println("\nОберіть пріоритет: ");
            for (int i = 0; i < priorities.length; i++) {
                System.out.println((i + 1) + ". " + priorities[i].getPriority());
            }
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice >= 1 && choice <= priorities.length) {
                priority = priorities[choice - 1];
            }
        } while (priority == null);
        return priority;
    }

    public Status readStatus() {
        Status[] statuses = Status.values();
        Status status = null;

        do {
            System.out.println("\nОберіть статус");
            for (int i = 0; i < statuses.length; i++) {
                System.out.println((i + 1) + ". " + statuses[i].getStatusName());
            }
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice >= 1 && choice <= statuses.length) {
                status = statuses[choice - 1];
            }
        } while (status == null);
        return status;
    }

    public LocalDateTime readTime() {
        System.out.println("Введіть дату дедлайну через ' - ' ");
        LocalDateTime deadLine = null;
        while (deadLine == null) {
            try {
                deadLine = LocalDateTime.parse(scanner.nextLine(), TimeFormatter.FORMATTER);
            } catch (IllegalArgumentException | DateTimeParseException e) {
                System.err.println("ПОМИЛКА: " + e.getMessage());
            }
        }
        return deadLine;
    }

    public Long readLong(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                String string = scanner.nextLine();
                return Long.parseLong(string);
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Це не число! Спробуйте ще раз.");
            }
        }
    }
   /* public <T extends Enum<T>> T readEnum(Class<T> EnumClass, String lable) {
        T[] enums = EnumClass.getEnumConstants();

        while (true) {
            try {
                System.out.println("Оберіть " + lable + ":");

                for (int i = 0; i < enums.length; i++) {
                    System.out.println((i + 1) + ". " + enums[i]);
                }

                int choice = Integer.parseInt(scanner.nextLine());

                if (choice >= 1 && choice < -enums.length) {
                    return enums[choice - 1];
                }
            } catch (IllegalArgumentException e) {
            }
            System.out.println("⚠️ Невірний вибір. Спробуйте ще раз.");
        }
    }*/
}
