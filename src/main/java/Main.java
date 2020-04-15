import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // BASIC DATE AND TIME
        LocalDate dateNow = LocalDate.now();
        System.out.println("Current date: " + dateNow);

        LocalTime timeNow = LocalTime.now();
        System.out.println("Current time: " + timeNow);

        LocalDate two_days_ago = dateNow.minusDays(2);
        System.out.println("Two days ago: " + two_days_ago);

        Period period = Period.between(two_days_ago, dateNow);
        System.out.println("Difference in days: " + period.getDays());

        LocalDate two_weeks_ago = dateNow.minusWeeks(2);
        System.out.println("Two weeks ago: " + two_weeks_ago);

        LocalDateTime now = LocalDateTime.now();
        System.out.println("Current date and time: " + now);

        // TIME PASSED
        Thread.sleep(1000);

        LocalDateTime later = LocalDateTime.now();
        Duration duration = Duration.between(now, later);
        System.out.println("Passed since the first date time: " + duration.toSeconds());

        long nanoSeconds = ChronoUnit.NANOS.between(now, later);
        System.out.println("Total nanoseconds passed: " + nanoSeconds);

        // TIME AND DATE FROM SPECIFIC INPUT
        LocalDateTime dateTimeInSpecific = LocalDateTime.of(2020, 4, 15, 12, 0);
        System.out.println("Date in specific: " + dateTimeInSpecific);

        LocalDateTime dateTimeInSpecificV2 = LocalDateTime.of(2020, Month.APRIL, 15, 12, 0);
        System.out.println("Date in specific: " + dateTimeInSpecificV2);

        // PARSING
        LocalDateTime parsedFromString = LocalDateTime.parse("2020-04-15T12:00");
        LocalDateTime twoDaysAfterParsed = parsedFromString.plusDays(2);
        System.out.println("Parsed from string plus 2 days: " + twoDaysAfterParsed);

        LocalDate myBirthDate = LocalDate.of(1986, 1, 1);
        DayOfWeek whichDay = myBirthDate.getDayOfWeek(); // GETTING WEEK DAY OF SOME WEEK
        System.out.println("My birtday was on a " + whichDay);

        LocalDateTime parsedFromDifferentFormat = LocalDateTime.parse("2020-04-15T12:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println(parsedFromDifferentFormat);

        LocalDateTime parsedFromDifferentFormatV2 = LocalDateTime.parse("Wed, 15 Apr 2020 12:05:01 GMT", DateTimeFormatter.RFC_1123_DATE_TIME);
        System.out.println(parsedFromDifferentFormatV2);

        LocalDateTime parsedFromDifferentFormatV3 = LocalDateTime.parse("2020__04__15--12-00-02", DateTimeFormatter.ofPattern("yyyy__MM__dd--HH-mm-ss"));
        System.out.println(parsedFromDifferentFormatV3);

        // COMPARISONS
        var startPlus1seconds = LocalDateTime.now().plusSeconds(1);
        do {
            System.out.println("1 second NOT PASSED!");
            Thread.sleep(100);
        } while (LocalDateTime.now().isBefore(startPlus1seconds));
        System.out.println("1 second PASSED!");
    }

}
