package com.DateTime.java;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        //declare variables
        LocalDate LastFullMoon = LocalDate.of(2017, 9, 6);
        LocalDate NextFullMoon;
        double TimeBetweenMoons = 29.5;
        double DaysDifference;
        LocalDate today = LocalDate.now(); // to get current date / time

        // set date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");

        // display today's date formatted
        String textToday = today.format(formatter);
        System.out.println("Today's date is: " + textToday);

        //calculate days between last full moon and today
        DaysDifference = ChronoUnit.DAYS.between(LastFullMoon, today);

        //perform calculations to determine the date of the next full moon and present to user
        if (DaysDifference < TimeBetweenMoons) {
            NextFullMoon = LastFullMoon.plusDays(Math.round(TimeBetweenMoons));
            System.out.println("The next full moon will be: " + NextFullMoon);
        }
        else {
            //find out how many "moons" should have passed to figure out the date needed
            DaysDifference = DaysDifference / TimeBetweenMoons;
            //round up to nearest full number
            DaysDifference = Math.ceil(DaysDifference);
            DaysDifference = DaysDifference * TimeBetweenMoons;
            NextFullMoon = LastFullMoon.plusDays(Math.round(DaysDifference));
            //output date of next full moon
            System.out.println("The next full moon will be: " + NextFullMoon);
        }
    }
}