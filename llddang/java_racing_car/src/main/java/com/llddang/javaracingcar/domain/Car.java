package com.llddang.javaracingcar.domain;

public class Car {
  private String name;
  private StringBuilder movement = new StringBuilder("");

  public Car(String name){
    this.name = name;
  }

  public void MoveOneStep(){
    movement.append("-");
  }

  public String getMovement(){
    return movement.toString();
  }

  public String getName(){
    return name;
  }
}
