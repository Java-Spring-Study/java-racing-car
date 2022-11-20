package racingcar.tool;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingTool {

  public boolean isGoAhead() {  //전진할 지 여부를 반환하는 메서드
    int random = Randoms.pickNumberInRange(0, 9);
    return random >= 4;
  }

  public static void checkName(String[] names) throws IllegalArgumentException {
    for (int i = 0; i < names.length; i++) {
      if (names[i].length() > 5) {
        throw new IllegalArgumentException("이름은 다섯 글자를 넘길 수 없다.");
      }
    }
  }

  public static int checkRoundN(String input) throws IllegalArgumentException {
    if (!input.matches("^[0-9]+$")) {
      throw new IllegalArgumentException("시도 횟수는 숫자여야 한다.");
    }
    int roundN = Integer.parseInt(input);
    if (roundN <= 0) {
      throw new IllegalArgumentException("시도 횟수는 양수여야 한다.");
    }
    return roundN;

  }
}
