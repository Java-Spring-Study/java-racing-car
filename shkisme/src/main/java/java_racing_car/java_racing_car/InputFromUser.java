package java_racing_car.java_racing_car;

import static java_racing_car.java_racing_car.Error.ERROR;

public class InputFromUser {

  private final User user;
  private final GameController gameController;

  InputFromUser(User user, GameController gameController) {
    this.user = user;
    this.gameController = gameController;
  }

  public void inputFromUser() {
    do {
      gameController.askCarNames();
      user.userInputCarName();
    } while (gameController.isCarNameError() == ERROR);
    do {
      gameController.askTryNumber();
      user.userInputTryNumber();
    } while (gameController.isTryNumberError() == ERROR);
    user.closeScanner();
  }
}
