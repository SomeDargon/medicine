package com.medicine;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class ChineseMedicineApplicationTests {
    public static void main(String[] args) {
        LocalDate l = LocalDate.now();
        System.out.println(l.getDayOfYear()+":"+l.getDayOfMonth());
        System.out.println(l);
        LocalDateTime localDateTime = LocalDateTime.now();

    }
}
