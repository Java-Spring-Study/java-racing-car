package racingcar.gameController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.Car;
import racingcar.tool.RacingTool;
import racingcar.tool.TextPrinter;
import racingcar.tool.TextScanner;

public class GameController {

  TextPrinter textPrinter = new TextPrinter();
  TextScanner textScanner = new TextScanner();
  RacingTool racingTool = new RacingTool();
  List<Car> carList = new ArrayList<Car>();
  List<String> winnerList = new ArrayList<String>();
  int roundN = 0;

  public void gameStart() {
    try {
      //초기설정
      textPrinter.printInit();
      setCarList(textScanner.scanCarName());
      textPrinter.printQuestion();
      setRoundN(textScanner.scanRoundN());
      //라운드 실행
      runRounds();
      //우승자 출력
      pickWinners();
      textPrinter.printWinner(winnerList);
    } catch (IllegalArgumentException e) {
      TextPrinter.printError(e);
    }
  }

  public void setRoundN(int roundN) {
    this.roundN = roundN;
  }

  public void setCarList(String[] carNameList) {
    Arrays.stream(carNameList).map((carName) -> carList.add(new Car(carName)))
        .collect(Collectors.toList());

  }

  public void runRounds() {
    for (int i = 0; i < roundN; i++) {
      runRound();
    }
  }

  public void runRound() {
    for (int i = 0; i < carList.size(); i++) {
      carList.get(i).behave(racingTool.isGoAhead());
    }
    textPrinter.printRound(carList);
  }

  public void pickWinners() {
    int maxPosition = getMaxPosition();
    winnerList = carList.stream().filter(car -> car.getPosition() == maxPosition)
        .map(car -> car.getName()).collect(Collectors.toList());
  }

  public int getMaxPosition() {
    return carList.stream().mapToInt(car -> car.getPosition()).max().getAsInt();
  }
}
