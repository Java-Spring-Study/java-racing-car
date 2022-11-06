package java_racing_car.java_racing_car;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Scanner;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

  private void setSystemInput(String input) {
    ByteArrayInputStream systemInput = new ByteArrayInputStream(input.getBytes());
    User.sc = new Scanner(systemInput);
    System.setIn(systemInput);
  }

  @Test
  @DisplayName("자동차 리스트 테스트")
  public void CarListTest() {
    User user = new User();
    GameController gameController = new GameController(user);

    setSystemInput("pobi,woni,jun");

    user.userInputCarName();
    gameController.generateList();

    Assertions.assertThat(gameController.carList.size()).isEqualTo(3);
    Assertions.assertThat(gameController.carList.containsAll(List.of("pobi", "woni", "jun")));
  }

  @Test
  @DisplayName("자동차 점수 테스트")
  public void CarScoreTest() {
    User user = new User();
    GameController gameController = new GameController(user);

    setSystemInput("pobi,woni,jun");
    user.userInputCarName();
    gameController.generateList();

    gameController.carList.get(0).plusScore();
    gameController.carList.get(0).plusScore();
    gameController.carList.get(0).plusScore();

    Assertions.assertThat(gameController.carList.get(0).getScore()).isEqualTo(3);
    Assertions.assertThat(gameController.carList.get(1).getScore()).isEqualTo(0);
    Assertions.assertThat(gameController.carList.get(2).getScore()).isEqualTo(0);
  }
}
