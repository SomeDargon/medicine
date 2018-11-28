package com.medicine;


import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ChineseMedicineApplicationTests {

        public static void main(String[] args) {
            Dog dog = new Dog("A");
            System.out.println(dog.getObjectAddress()); // Dog@4554617c
            func(dog);
            System.out.println(dog.getObjectAddress()); // Dog@4554617c
            System.out.println(dog.getName());          // A
        }

        private static void func(Dog dog) {
            System.out.println(dog.getObjectAddress()); // Dog@4554617c
            dog = new Dog("B");
            System.out.println(dog.getObjectAddress()); // Dog@74a14482
            System.out.println(dog.getName());          // B
        }
}
class Dog {
    String name;

    Dog(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    String getObjectAddress() {
        return super.toString();
    }
}