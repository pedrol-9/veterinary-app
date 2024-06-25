package com.veterinary.veterinaryApp.utils;

import java.util.Random;

public class Utils {

    public static String fiveDigits() {
        Random random = new Random();
        int number = random.nextInt(100000000); // Genera un número entre 0 y 99999999
        return String.format("%08d", number);  // Completa con ceros a la izquierda si es necesario
    }

    public static long generateRandomLong() {
        Random random = new Random();
        return 1 + (long)(random.nextInt(3)); // Genera un número entre 0 y 2, luego suma 1
    }
}
