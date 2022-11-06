package java_racing_car.java_racing_car;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnerTest {

  private void setSystemInput(String input) {
    ByteArrayInputStream systemInput = new ByteArrayInputStream(input.getBytes());
    User.sc = new Scanner(systemInput);
    System.setIn(systemInput);
  }

  @Test
  @DisplayName("우승자 테스트(우승자가 한명일 때)")
  public void OneWinnerTest() {
    User user = new User();
    GameController gameController = new GameController(user);
    RacingGame racingGame = new RacingGame(user, gameController);

    setSystemInput("pobi,woni,jun");
    user.userInputCarName();
    gameController.generateList();

    gameController.carList.get(0).plusScore();

    racingGame.generateWinnerList(racingGame.getHighestScore());

    Assertions.assertThat(racingGame.winnerList.size()).isEqualTo(1);
    Assertions.assertThat(racingGame.winnerList.get(0)).isEqualTo("pobi");
  }

  @Test
  @DisplayName("우승자가 두 명 이상일 때 테스트")
  public void ManyWinnerTest() {
    User user = new User();
    GameController gameController = new GameController(user);
    RacingGame racingGame = new RacingGame(user, gameController);

    setSystemInput("pobi,woni,jun");
    user.userInputCarName();
    gameController.generateList();

    gameController.carList.get(0).plusScore();
    gameController.carList.get(1).plusScore();

    racingGame.generateWinnerList(racingGame.getHighestScore());

    Assertions.assertThat(racingGame.winnerList.size()).isEqualTo(2);
    Assertions.assertThat(racingGame.winnerList.get(0)).isEqualTo("pobi");
    Assertions.assertThat(racingGame.winnerList.get(1)).isEqualTo("woni");
  }
}
