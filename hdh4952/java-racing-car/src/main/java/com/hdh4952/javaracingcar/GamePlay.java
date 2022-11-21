package com.hdh4952.javaracingcar;

import com.hdh4952.javaracingcar.domain.Car;
import com.hdh4952.javaracingcar.util.GameUtil;
import java.util.ArrayList;
import java.util.List;

public class GamePlay {

  public void play() {
    GameUtil util = new GameUtil();
    while (!util.initNames()) {
      System.out.println("유효하지 않은 입력입니다. 재입력하세요.");
    }

    while (!util.initMoveCount()) {
      System.out.println("유효하지 않은 입력입니다. 재입력하세요.");
    }

    List<String> carNames = util.getCarNames();
    int carCount = carNames.size();
    Car[] cars = new Car[carCount];

    for (int i = 0; i < carCount; i++) {
      cars[i] = new Car(carNames.get(i));
    }

    for (int i = 0; i < util.getMoveCount(); i++) {
      for (int j = 0; j < carCount; j++) {
        if (util.isMove()) {
          cars[j].move();
        }
      }
      util.printResult(cars);
    }

    int maxMove = 0;
    for (Car car : cars) {
      if (maxMove < car.getMoveCount()) {
        maxMove = car.getMoveCount();
      }
    }

    ArrayList<String> winners = new ArrayList<>();
    for (Car car : cars) {
      if (maxMove == car.getMoveCount()) {
        winners.add(car.getName());
      }
    }
    boolean isPrintName = false;
    for (String winner : winners) {
      if (isPrintName) {
        System.out.print(", " + winner);
      } else {
        System.out.print(winner);
      }
      isPrintName = true;
    }
    System.out.println("가 최종 우승했습니다.");
  }
}
