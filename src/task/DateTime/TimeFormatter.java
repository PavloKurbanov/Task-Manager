package DateTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class TimeFormatter {
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    private TimeFormatter() {
        throw new UnsupportedOperationException("Клас корисності");
    }

    public static String format(LocalDateTime date) {
        return (date == null) ? "N/A" : date.format(FORMATTER);
    }
}
