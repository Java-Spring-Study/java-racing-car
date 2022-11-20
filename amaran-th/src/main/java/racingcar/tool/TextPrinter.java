package racingcar.tool;

import java.util.List;
import racingcar.Car;

public class TextPrinter {

  public void printInit() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
  }

  public void printQuestion() {
    System.out.println("시도할 횟수는 몇회인가요?");
  }

  public void printRound(List<Car> cars) {
    for (int i = 0; i < cars.size(); i++) {
      System.out.print(cars.get(i).getName() + " : ");
      printPosition(cars.get(i).getPosition());
      System.out.println();
    }
    System.out.println();
  }

  public void printPosition(int pos) {
    for (int i = 0; i < pos; i++) {
      System.out.print("-");
    }
  }

  public void printWinner(List<String> winnerList) {
    System.out.println("최종 우승자 : " + String.join(", ", winnerList));
  }

  public static void printError(IllegalArgumentException e) {
    System.out.println("[ERROR] " + e.getMessage());

  }
}
