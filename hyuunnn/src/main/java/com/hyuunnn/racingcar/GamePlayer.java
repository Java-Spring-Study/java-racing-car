package com.hyuunnn.racingcar;

import static com.hyuunnn.racingcar.Util.SEPARATOR;
import static com.hyuunnn.racingcar.Util.PROGRESS_BAR;
import static com.hyuunnn.racingcar.Util.RANDOM_MIN_NUMBER;
import static com.hyuunnn.racingcar.Util.SCANNER;
import static com.hyuunnn.racingcar.Util.randomize;
import static com.hyuunnn.racingcar.Error.validateLength;

import com.hyuunnn.racingcar.Util.InputType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GamePlayer {

  private List<Car> carList;
  private int count = 0;

  private void input() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    while (inputCarNames() == InputType.INVALID)
      ;

    System.out.println("시도할 회수는 몇회인가요?");
    while (inputCount() == InputType.INVALID)
      ;
  }

  private InputType inputCarNames() {
    try {
      String strInputNames = SCANNER.nextLine();
      String[] strCarList = strInputNames.split(SEPARATOR);

      validateLength(strCarList);
      carList = initializeCarList(strCarList);

    } catch (Exception e) {
      System.out.println(e.getMessage());
      return InputType.INVALID;
    }
    return InputType.VALID;
  }


  private List<Car> initializeCarList(String[] strList) {
    return Arrays.stream(strList)
        .map(Car::new)
        .toList();
  }

  private InputType inputCount() {
    try {
      String strInputCount = SCANNER.nextLine();
      count = Integer.parseInt(strInputCount);

    } catch (NumberFormatException e) {
      System.out.println("[ERROR] 입력 값이 유효하지 않습니다.");
      return InputType.INVALID;
    }
    return InputType.VALID;
  }

  private void printResult() {
    System.out.println("실행 결과");

    for (int i = 0; i < count; i++) {
      addMoveCount();
      printStatus();
    }
  }

  private void addMoveCount() {
    carList.stream()
        .filter(e -> randomize() >= RANDOM_MIN_NUMBER)
        .forEach(Car::addPosition);
  }

  private void printStatus() {
    carList.forEach(car ->
        System.out.printf("%s : %s\n", car.getName(),
            PROGRESS_BAR.repeat(car.getPosition())));
    System.out.print("\n");
  }

  private void printWinner() {
    int maxPosition = carList.stream()
        .map(Car::getPosition)
        .reduce(Integer::max)
        .orElse(-1);

    System.out.print("최종 우승자: ");
    System.out.printf(carList.stream()
        .filter(car -> maxPosition == car.getPosition())
        .map(Car::getName)
        .collect(Collectors.joining(String.format("%s ", SEPARATOR))));
  }

  public void run() {
    input();
    printResult();
    printWinner();
    SCANNER.close();
  }
}
