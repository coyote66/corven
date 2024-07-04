package com.corven.test.corventest.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Utils {

    //yyyy-mm-yy
    public static boolean getAge(String dob1) {
        LocalDate dob = LocalDate.parse(dob1);
        LocalDate today = LocalDate.now();
        boolean isValidAge = false;
        if (dob.isAfter(today)) {
            System.out.println("Future date not allowed");
        } else {
            int age = (int) ChronoUnit.YEARS.between(dob, today);

            if (age < 18) {
                System.out.println(age);
                System.out.println("Underage");
            } else {
                System.out.println(age);
                System.out.println("> 18 years");
                isValidAge = true;

            }
        }

        return isValidAge;
    }
}
