package java_racing_car.java_racing_car;

import java.util.Scanner;


public class User {

  private String carNames;
  private String[] carList;
  private String tryNumber;
  public static Scanner sc = new Scanner(System.in);

  User() {
    this.carNames = carNames;
    this.carList = carList;
    this.tryNumber = tryNumber;
  }

  public static void closeScanner() {
    sc.close();
  }

  public void userInputCarName() {
    carNames = sc.nextLine();
  }

  public void userInputTryNumber() {
    tryNumber = sc.nextLine();
  }

  public String getCarName() {
    return carNames;
  }

  public String getTryNumber() {
    return tryNumber;
  }

  public String[] getCarNameList() {
    return carList;
  }

  public void saveCarList(String[] array) {
    this.carList = array;
  }
}
