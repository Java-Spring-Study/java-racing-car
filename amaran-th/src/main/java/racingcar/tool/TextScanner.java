package racingcar.tool;

import camp.nextstep.edu.missionutils.Console;

public class TextScanner {

  public String[] scanCarName() {
    String carNames = Console.readLine();
    String[] carNameList = carNames.split(",");
    try {
      RacingTool.checkName(carNameList);
      return carNameList;
    } catch (IllegalArgumentException e) {
      TextPrinter.printError(e);
      return scanCarName();
    }

  }

  public int scanRoundN() {
    String input = Console.readLine();
    try {
      int roundN = RacingTool.checkRoundN(input);
      return roundN;
    } catch (IllegalArgumentException e) {
      TextPrinter.printError(e);
      return scanRoundN();
    }
  }


}
