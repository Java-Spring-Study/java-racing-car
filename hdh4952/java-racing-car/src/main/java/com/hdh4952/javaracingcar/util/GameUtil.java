package com.hdh4952.javaracingcar.util;

import com.hdh4952.javaracingcar.domain.Car;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GameUtil {

  private final Scanner sc = new Scanner(System.in);
  private final GameValidator gameValidator = new GameValidator();
  private ArrayList<String> carNames = new ArrayList<>();
  private int moveCount;

  public boolean initNames() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String inputNames = sc.next();
    String[] names = inputNames.split(",");
    for (String name : names) {
      if (!gameValidator.isInvalidName(name)) {
        return false;
      }
    }
    carNames = new ArrayList<>(Arrays.asList(names));
    return true;
  }

  public boolean initMoveCount() {
    try {
      System.out.println("시도할 회수는 몇회인가요?");
      moveCount = sc.nextInt();
      return true;
    } catch (InputMismatchException e) {
      return false;
    }
  }

  public List<String> getCarNames() {
    return carNames;
  }

  public int getMoveCount() {
    return moveCount;
  }

  public boolean isMove() {
    int cmp = (int) ((Math.random() * 10000) % 9);
    return cmp >= 4;
  }

  public void printResult(Car[] cars) {
    for (Car car : cars) {
      System.out.print(car.getName() + " : ");
      for (int i = 0; i < car.getMoveCount(); i++) {
        System.out.print("-");
      }
      System.out.println();
    }
    System.out.println();
  }
}
