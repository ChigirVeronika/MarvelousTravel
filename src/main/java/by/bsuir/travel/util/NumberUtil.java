package by.bsuir.travel.util;

import java.util.Random;

public class NumberUtil {
    public static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
