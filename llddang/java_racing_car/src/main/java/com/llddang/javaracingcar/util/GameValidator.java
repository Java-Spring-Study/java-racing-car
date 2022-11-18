package com.llddang.javaracingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.sql.rowset.Predicate;

public class GameValidator {
  private static final int MAXLENGTH = 5;
  public boolean isInvalidCarName(String[] cars) {
    return Arrays.stream(cars).allMatch(this::invalidateCarNameLength);
  }

  private boolean invalidateCarNameLength(String car){
    return car.length() > MAXLENGTH || car.length() == 0;
  }

  public boolean isInvalidTryCount(String tryCount) {
    try {
      Integer.parseInt(tryCount);
    } catch (Exception e) {
      return true;
    }
    return false;
  }
}
