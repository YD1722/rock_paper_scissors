package com.imc.util;

public class ValidationHelper {
    public static boolean isPositiveNumber(String num) {
        return num.matches("\\d+");
    }
}
