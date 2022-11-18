package com.hyuunnn.racingcar;

import static com.hyuunnn.racingcar.Util.MAX_LENGTH;

import java.util.Arrays;

public class Error {

  public static void validateLength(String[] strList) {
    if (Arrays.stream(strList)
        .anyMatch(str -> str.length() == 0 || str.length() > MAX_LENGTH)) {
      throw new IllegalStateException("[ERROR] 입력 가능 길이가 맞지 않습니다.");
    }
  }
}
