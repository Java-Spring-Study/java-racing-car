package com.llddang.javaracingcar;

import com.llddang.javaracingcar.domain.Car;
import com.llddang.javaracingcar.util.GameValidator;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class GamePlay {

  final GameValidator gameValidator = new GameValidator();
  final static Scanner scanner = new Scanner(System.in);
  private List<Car> carList;
  private int tryCount;

  public GamePlay() {
    setCars();
    setTryCount();
  }

  private void setCars() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
    String carNames;
    String[] cars;

    do {
      carNames = scanner.next();
      cars = carNames.split(",");
    } while (gameValidator.isInvalidCarName(cars));

    carList = Arrays.stream(cars)
        .map(Car::new)
        .collect(Collectors.toList());
  }

  private void setTryCount() {
    System.out.println("시도할 회수는 몇 회인가요?");
    String tryCount;

    do {
      tryCount = scanner.next();
    } while (gameValidator.isInvalidTryCount(tryCount));

    this.tryCount = Integer.parseInt(tryCount);
  }

  public void startCarRacing() {
    System.out.println("\n실행결과");
    for (int i = 0; i < tryCount; i++) {
      startOneRound();
      printCarState();
    }
    printWinner();
  }

  private void startOneRound() {
    carList.forEach(car -> {
      if (isGo()) {
        car.MoveOneStep();
      }
    });
  }

  private boolean isGo() {
    int randomNumber = getRandomNumber();
    return randomNumber > 3;
  }

  private int getRandomNumber() {
    Random random = new Random();
    return random.nextInt(10);
  }

  private void printCarState() {
    carList.forEach(car -> System.out.println(car.getName() + " : " + car.getMovement()));
    System.out.println();
  }

  private void printWinner() {
    String winners = getWinner();
    System.out.println(winners + "가 최종 우승했습니다.");
  }

  private String getWinner() {
    AtomicInteger length = new AtomicInteger(-1);
    StringBuilder winners = new StringBuilder();
    carList.forEach(car -> {
      if (car.getMovement().length() == length.get()) {
        winners.append(", ");
        winners.append(car.getName());
      }
      if (car.getMovement().length() > length.get()) {
        length.set(car.getMovement().length());
        winners.setLength(0);
        winners.append(car.getName());
      }
    });

    return winners.toString();
  }


}
