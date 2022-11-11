package com.llddang.javaracingcar.domain;

public class Car {
  private String name;
  private String movement = "";

  public Car(String name){
    this.name = name;
  }

  public void MoveOneStep(){
    movement += "-";
  }

  public String getMovement(){
    return movement;
  }

  public String getName(){
    return name;
  }
}
