package com.library.utils;

public class BillUtil {
    public static double calculateBill(int daysLate) {
        final double dailyFine = 2.5; // Günlük gecikme cezası
        return daysLate * dailyFine;
    }
}
