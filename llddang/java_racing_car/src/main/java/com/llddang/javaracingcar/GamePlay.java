package com.llddang.javaracingcar;

import com.llddang.javaracingcar.domain.Car;
import com.llddang.javaracingcar.util.GameValidator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class GamePlay {

  final static Scanner scanner = new Scanner(System.in);
  final static GameValidator gv = new GameValidator();
  private List<Car> carList;
  private int tryCount;

  public GamePlay(){
    getCars();
    getTryCount();
  }

  private void getCars() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
    String carNames = scanner.next();
    String[] cars = carNames.split(",");

    while (!gv.isValidCarName(cars)) {
      printErrorMessage();
      carNames = scanner.next();
      cars = carNames.split(",");
    }

    carList = Arrays.stream(cars).map(car -> new Car(car)).collect(Collectors.toList());
  }

  private void getTryCount() {
    System.out.println("시도할 회수는 몇 회인가요?");
    String tryCount = scanner.next();

    while (!gv.isValidTryCount(tryCount)) {
      printErrorMessage();
      tryCount = scanner.next();
    }

    this.tryCount = Integer.parseInt(tryCount);
  }

  private void printErrorMessage() {
    System.out.println("유효하지 않은 입력입니다. 재입력 입력하세요.");
  }

  public void startCarRacing(){
    System.out.println("\n실행결과");
    for(int i=0; i<tryCount; i++){
      startOneRound();
      printCarState();
    }
  }

  private void startOneRound() {
    carList.stream().forEach(car -> {
      if (isGo()) {
        car.MoveOneStep();
      }
    });
  }

  private boolean isGo() {
    int randomNumber = getRandomNumber();
    return randomNumber > 3 ? true : false;
  }

  private int getRandomNumber() {
    Random random = new Random();
    return random.nextInt() % 10;
  }

  private void printCarState() {
    carList.stream().forEach(car -> System.out.println(car.getName() + " : " + car.getMovement()));
    System.out.println("");
  }

  public void printWinner(){
    String winners = getWinner();
    System.out.println(winners + "가 최종 우승했습니다.");
  }

  private String getWinner(){
    final int[] length = {0};
    final String[] winners = {""};
    carList.stream().forEach(car -> {
      if(car.getMovement().length() == length[0]) {
        winners[0] += ", ";
        winners[0] += car.getName();
      }
      if(car.getMovement().length() > length[0]){
        length[0] = car.getMovement().length();
        winners[0] = car.getName();
      }
    });

    return winners[0];
  }



}
