package com.exercises.third.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PrintUtils {

    public static void ioException(Exception e) {
        System.out.println("I/O Exception: " + e.getMessage());
    }

}
