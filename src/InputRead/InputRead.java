package InputRead;

import DataTime.TimeFormatter;
import Entities.Priority;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

public class InputRead {
    private Scanner scanner = new Scanner(System.in);
    public InputRead() {
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
            System.out.println("Виберіть пріоритет: ");
            for (int i = 0; i < priorities.length; i++) {
                System.out.println((i + 1) + ". " + priorities[i].getPriority());
            }
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice >= 1 && choice <= priorities.length) {
               priority =  priorities[choice - 1];
            }
        } while (priority == null);
        return priority;
    }

    public LocalDateTime readTime() {
        System.out.println("Введіть дату дедлайну через ' - ' ");
        LocalDateTime deadLine = null;
        while (deadLine == null) {
            try {
                deadLine = LocalDateTime.parse(scanner.nextLine(), TimeFormatter.FORMATTER);
            } catch (IllegalArgumentException e) {
                System.err.println("ПОМИЛКА: " + e.getMessage());
            } catch (DateTimeParseException e) {
                System.err.println("ПОМИЛКА: " + e.getMessage());
            }
        }
        return  deadLine;
    }
}
