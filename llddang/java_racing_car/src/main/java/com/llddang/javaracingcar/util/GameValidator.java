package com.llddang.javaracingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GameValidator {
  public boolean isValidCarName(String[] cars){
     return Arrays.stream(cars).allMatch(car -> car.length() <= 5 && car.length() != 0);
  }

  public boolean isValidTryCount(String tryCount){
    List<Character> validCount = new ArrayList<>();
    for(int i=0; i<10; i++){
      validCount.add((char)('0' + i));
    }
    List<Character> tryCountChar = stringToCharList(tryCount);

    return tryCountChar.stream().allMatch(ch -> validCount.stream().anyMatch(Predicate.isEqual(ch)));
  }

  private static List<Character> stringToCharList(String data) {
    return data.chars()
        .mapToObj(e -> (char) e)
        .collect(Collectors.toList());
  }
}
