package com.hdh4952.javaracingcar.domain;

public class Car {

  final private String name;
  private int moveCount;

  public Car(String name) {
    this.name = name;
    moveCount = 0;
  }

  public String getName() {
    return name;
  }

  public int getMoveCount() {
    return moveCount;
  }

  public void move() {
    moveCount++;
  }
}
