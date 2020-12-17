package net.htlgkr.feinboeck18.hue11;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static java.time.temporal.ChronoUnit.*;

public class BetweenDatesHue {
    public static BetweenDatesHue instance = new BetweenDatesHue();
    public static Scanner scanner = new Scanner(System.in);
    public String dateFormat = "dd.MM.yyyy HH:mm:ss";

    public static void main(String[] args) {
        String[] dateParameters = {
                "Year(s): ",
                "Month(s): ",
                "Day(s): ",
                "Hour(s): ",
                "Minute(s): ",
                "Second(s): "
        };
        LocalDateTime now = LocalDateTime.now();
        //Teilaufgabe 1
        System.out.println("Enter a Date-Time " + instance.dateFormat);
        String dateLine = scanner.nextLine();
        LocalDateTime userInput = null;
        try {
            userInput = LocalDateTime.parse(dateLine, DateTimeFormatter.ofPattern(instance.dateFormat));
        } catch (Exception ignored) { }
        assert userInput!=null;

        int[] between = instance.getTimeBetween(now, userInput);
        for (int i = 0; i < between.length; i++)
            System.out.println(dateParameters[i] + between[i]);
        try {
            System.out.println("Sleeping 5 seconds that you can see the output");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //TEILAUFGABE 2
        System.out.println("\nPrinting Days between those Dates:");
        LocalDate nowAsLocalDate = now.toLocalDate();
        LocalDate userInputAsLocalDate = userInput.toLocalDate();

        if(nowAsLocalDate.isAfter(userInputAsLocalDate)) {
            LocalDate temp = nowAsLocalDate;
            nowAsLocalDate = userInputAsLocalDate;
            userInputAsLocalDate = temp;
        }

        for(LocalDate nextDay = nowAsLocalDate.plusDays(1); !nextDay.equals(userInputAsLocalDate); nextDay = nextDay.plusDays(1))
            System.out.println(nextDay);
    }

    private int[] getTimeBetween(LocalDateTime localDateTime, LocalDateTime otherLocalDateTime) {
        return localDateTime.isAfter(otherLocalDateTime) ? getTime(otherLocalDateTime, localDateTime) : getTime(localDateTime, otherLocalDateTime);
    }

    private int[] getTime(LocalDateTime localDateTime, LocalDateTime otherLocalDateTime) {
        return new int[]{
                (int) YEARS.between(localDateTime, otherLocalDateTime),
                (int) MONTHS.between(localDateTime, otherLocalDateTime),
                (int) DAYS.between(localDateTime, otherLocalDateTime),
                (int) HOURS.between(localDateTime, otherLocalDateTime),
                (int) MINUTES.between(localDateTime, otherLocalDateTime),
                (int) SECONDS.between(localDateTime, otherLocalDateTime)
        };
    }
}