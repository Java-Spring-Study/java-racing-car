package java_racing_car.java_racing_car;

import static java_racing_car.java_racing_car.RacingGame.GameMessage.FINAL_WINNER;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

  private final User user;
  private final GameController gameController;
  private final Random random = new Random();
  List<String> winnerList = new ArrayList<>();

  RacingGame(User user, GameController gameController) {
    this.user = user;
    this.gameController = gameController;
    this.winnerList = winnerList;
  }

  public void gamePlay() {
    int tryNumber = Integer.parseInt(user.getTryNumber());
    for (int i = 0; i < tryNumber; i++) {
      racingCar();
      printNowScore();
    }
  }

  private void racingCar() {
    for (Car car : gameController.getCarList()) {
      if (isNumberGreaterThanFour(generateRandomNumber())) {
        car.plusScore();
      }
    }
  }

  private int generateRandomNumber() {
    int randomNumber = random.nextInt(10);
    return randomNumber;
  }

  private boolean isNumberGreaterThanFour(int randomNumber) {
    if (randomNumber >= 4) {
      return true;
    }
    return false;
  }

  private void printNowScore() {
    for (Car car : gameController.getCarList()) {
      System.out.printf("%s : %s\n", car.getCarName(), "-".repeat(car.getScore()));
    }
    System.out.println("\n");
  }

  public void gameResult() {
    generateWinnerList(getHighestScore());
    printWinner();
  }

  public int getHighestScore() {
    int max = 0;
    for (Car car : gameController.getCarList()) {
      if (max <= car.getScore()) {
        max = car.getScore();
      }
    }
    return max;
  }

  public void generateWinnerList(int highestScore) {
    for (Car car : gameController.getCarList()) {
      if (car.getScore() == highestScore) {
        winnerList.add(car.getCarName());
      }
    }
  }

  private void printWinner() {
    System.out.printf("%s : ", FINAL_WINNER.getMessage());
    System.out.println(String.join(",", winnerList));
  }

  enum GameMessage {
    FINAL_WINNER("최종 우승자");
    private String message;

    GameMessage(String message) {
      this.message = message;
    }

    public String getMessage() {
      return this.message;
    }
  }
}
