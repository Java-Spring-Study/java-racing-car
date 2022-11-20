package com.taegeun;

import java.util.Random;

public class GameUtil {
    public static int moveCar() {
        Random random = new Random();

        if (random.nextInt(10) >= 4){
            return 1;
        }
        return 0;
    }
}
