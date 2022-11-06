package java_racing_car.java_racing_car;

import static java_racing_car.java_racing_car.Error.ERROR;
import static java_racing_car.java_racing_car.Error.NO_ERROR;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest {

  private void setSystemInput(String input) {
    ByteArrayInputStream systemInput = new ByteArrayInputStream(input.getBytes());
    User.sc = new Scanner(systemInput);
    System.setIn(systemInput);
  }

  @Test
  @DisplayName("정상적인 자동차 이름 입력 테스트")
  public void InputCarName() {
    User user = new User();
    GameController gameController = new GameController(user);

    setSystemInput("pobi,won,jun");

    user.userInputCarName();
    gameController.generateList();

    Assertions.assertThat(user.getCarNameList().length).isEqualTo(3);
    Assertions.assertThat(user.getCarNameList()[0]).isEqualTo("pobi");
    Assertions.assertThat(user.getCarNameList()[1]).isEqualTo("won");
    Assertions.assertThat(user.getCarNameList()[2]).isEqualTo("jun");
    Assertions.assertThat(gameController.isCarNameError()).isEqualTo(NO_ERROR);
  }

  @Test
  @DisplayName("5글자 이상의 이름이 입력되었을 때")
  public void InputCarNameGreaterThanFive() {
    User user = new User();
    GameController gameController = new GameController(user);

    setSystemInput("pobi,won,junnooo");
    user.userInputCarName();

    Assertions.assertThat(gameController.isCarNameError()).isEqualTo(ERROR);
  }

  @Test
  @DisplayName("0글자 이름이 입력되었을 때")
  public void InputCarNameIsZero() {
    User user = new User();
    GameController gameController = new GameController(user);

    setSystemInput(",won,junnooo");
    user.userInputCarName();

    Assertions.assertThat(gameController.isCarNameError()).isEqualTo(ERROR);
  }

  @Test
  @DisplayName("연속된 콤마가 입력되었을 때")
  public void ContinuousComma() {
    User user = new User();
    GameController gameController = new GameController(user);

    setSystemInput("pobi,,won,junnooo");
    user.userInputCarName();

    Assertions.assertThat(gameController.isCarNameError()).isEqualTo(ERROR);
  }

  @Test
  @DisplayName("정상적인 시도 횟수 입력 테스트")
  public void InputTryNumber() {
    User user = new User();
    GameController gameController = new GameController(user);

    setSystemInput("5");
    user.userInputTryNumber();
    Assertions.assertThat(gameController.isTryNumberError()).isEqualTo(NO_ERROR);
    Assertions.assertThat(user.getTryNumber()).isEqualTo("5");
  }

  @Test
  @DisplayName("0이 시도횟수로 입력되었을 때")
  public void ZeroTryNumber() {
    User user = new User();
    GameController gameController = new GameController(user);

    setSystemInput("0");
    user.userInputTryNumber();
    Assertions.assertThat(gameController.isTryNumberError()).isEqualTo(ERROR);
  }

  @Test
  @DisplayName("음수가 시도횟수로 입력되었을 때")
  public void NegativeTryNumber() {
    User user = new User();
    GameController gameController = new GameController(user);

    setSystemInput("-2");
    user.userInputTryNumber();
    Assertions.assertThat(gameController.isTryNumberError()).isEqualTo(ERROR);
  }

  @Test
  @DisplayName("문자열이 시도횟수로 입력되었을 때")
  public void InputStringTryNumber() {
    User user = new User();
    GameController gameController = new GameController(user);

    setSystemInput("hello");
    user.userInputTryNumber();
    Assertions.assertThat(gameController.isTryNumberError()).isEqualTo(ERROR);
  }
}
