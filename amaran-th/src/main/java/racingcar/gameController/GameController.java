package racingcar.gameController;

import java.util.ArrayList;
import java.util.List;
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
    for (int i = 0; i < carNameList.length; i++) {
      carList.add(new Car(carNameList[i]));
    }
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
    for (int i = 0; i < carList.size(); i++) {
      if (carList.get(i).getPosition() == maxPosition) {
        winnerList.add(carList.get(i).getName());
      }
    }
  }

  public int getMaxPosition() {
    int max = 0, pos;
    for (int i = 0; i < carList.size(); i++) {
      pos = carList.get(i).getPosition();
      if (pos > max) {
        max = pos;
      }
    }
    return max;
  }
}
