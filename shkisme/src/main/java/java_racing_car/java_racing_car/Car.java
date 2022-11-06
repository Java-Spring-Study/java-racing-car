package java_racing_car.java_racing_car;

public class Car {

  private final String name;
  private int score = 0;

  Car(String name) {
    this.name = name;
  }

  public void plusScore() {
    this.score++;
  }

  public String getCarName() {
    return this.name;
  }

  public int getScore() {
    return this.score;
  }
}
