package java_racing_car.java_racing_car;

import static java_racing_car.java_racing_car.Error.ERROR;
import static java_racing_car.java_racing_car.Error.NO_ERROR;
import static java_racing_car.java_racing_car.GameController.GameControllerMessage.*;

import java.util.ArrayList;
import java.util.List;

public class GameController {

  private final User user;

  ArrayList<Car> carList = new ArrayList<Car>();

  GameController(User user) {
    this.user = user;
  }

  public void askCarNames() {
    System.out.println(INPUT_CAR_NAME.getGameContollerMessage());
  }

  public void askTryNumber() {
    System.out.println(INPUT_TRY_NUMBER.getGameContollerMessage());
  }

  public Error isCarNameError() {
    String[] array = user.getCarName().split(",");
    for (String str : array) {
      if (str.length() > 5 || str.length() == 0) {
        printCarNameError();
        return ERROR;
      }
    }
    return NO_ERROR;
  }

  public Error isTryNumberError() {
    try {
      int number = Integer.parseInt(user.getTryNumber());
      if (number <= 0) {
        printTryNumberError();
        return ERROR;
      }
      return NO_ERROR;
    } catch (IllegalArgumentException error) {
      printTryNumberError();
      return ERROR;
    }
  }

  public void printCarNameError() {
    System.out.println(CAR_NAME_ERROR.getGameContollerMessage());
  }

  public void printTryNumberError() {
    System.out.println(TRY_NUMBER_ERROR.getGameContollerMessage());
  }

  public void generateList() {
    generateCarNameList();
    generateCarList();
  }

  private void generateCarNameList() {
    String[] array = user.getCarName().split(",");
    user.saveCarList(array);
  }

  private void generateCarList() {
    for (String str : user.getCarNameList()) {
      Car car = new Car(str);
      carList.add(car);
    }
  }


  public ArrayList<Car> getCarList() {
    return carList;
  }

  enum GameControllerMessage {
    INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_TRY_NUMBER("시도할 회수는 몇회인가요?"),
    CAR_NAME_ERROR("[ERROR] 자동차의 이름의 길이는 0 이상, 5 이하여야 한다."),
    TRY_NUMBER_ERROR("[ERROR] 시도 횟수는 0보다 큰 정수여야 한다.");
    private String message;

    GameControllerMessage(String message) {
      this.message = message;
    }

    public String getGameContollerMessage() {
      return this.message;
    }
  }

}
