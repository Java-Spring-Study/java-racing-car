package com.taegeun;

import java.util.Arrays;
import java.util.stream.Stream;

public class GameValidator {
    public static boolean carNameValid(String inputCarName){

        boolean validCount = Arrays.stream(inputCarName.split(","))
                .allMatch(name -> (0 < name.length() && name.length()<=5));

        if (!validCount){
            System.out.println("유효하지 않은 입력입니다. 재입력 입력하세요.");
            return false;
        }
        return true;
    }

    public static boolean playTimesValid(String playTimes) {
        try {
            Integer.parseInt(playTimes);
        } catch (NumberFormatException e) {
            System.out.println("유효하지 않은 입력입니다. 재입력 입력하세요.");
            return false;
        }
        return true;
    }
}
