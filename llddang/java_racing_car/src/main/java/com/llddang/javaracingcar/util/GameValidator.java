package com.llddang.javaracingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.sql.rowset.Predicate;

public class GameValidator {

  private static final int MAXLENGTH = 5;

  public boolean isInvalidCarName(String[] cars) {
    boolean invalidCarName = Arrays.stream(cars).allMatch(this::invalidateCarNameLength);
    if (invalidCarName) {
      printErrorMessage();
    }
    return invalidCarName;
  }

  private boolean invalidateCarNameLength(String car) {
    return car.length() > MAXLENGTH || car.length() == 0;
  }

  public boolean isInvalidTryCount(String tryCount) {
    try {
      Integer.parseInt(tryCount);
    } catch (Exception e) {
      printErrorMessage();
      return true;
    }
    return false;
  }

  private void printErrorMessage() {
    System.out.println("유효하지 않은 입력입니다. 재입력 입력하세요.");
  }

}
