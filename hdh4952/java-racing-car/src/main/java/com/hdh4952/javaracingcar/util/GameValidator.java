package com.hdh4952.javaracingcar.util;

public class GameValidator {

  public boolean isInvalidName(String name) {
    return 1 <= name.length() && name.length() <= 5;
  }
}
