package java_racing_car.java_racing_car;

public class Main {

  public static void main(String[] args) {
    User user = new User();
    GameController gameController = new GameController(user);
    InputFromUser input = new InputFromUser(user, gameController);
    input.inputFromUser();
    gameController.generateList();
    RacingGame racingGame = new RacingGame(user, gameController);
    racingGame.gamePlay();
    racingGame.gameResult();
  }
}
