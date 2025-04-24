package adapter;

public class Main {
    public static void main(String[] args) {
        NewDateInterface date = new CalendarToNewDateAdapter();

        date.setYear(2025);
        date.setMonth(4);
        date.setDay(24);

        System.out.println("Initial date: " + date);

        // Advance the date
        date.advanceDays(10);
        System.out.println("After advancing 10 days: " + date);

        date.advanceDays(30);
        System.out.println("After advancing 30 more days: " + date);
    }
}

