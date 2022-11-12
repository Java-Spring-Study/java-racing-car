package com.llddang.javaracingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GameValidator {

  public static boolean isInvalidCarName(String[] cars) {
    return Arrays.stream(cars)
        .anyMatch(car -> car.length() > 5 || car.length() == 0);
  }

  public static boolean isInvalidTryCount(String tryCount) {
    try {
      Integer.parseInt(tryCount);
    } catch (Exception e) {
      return true;
    }
    return false;
  }
}
