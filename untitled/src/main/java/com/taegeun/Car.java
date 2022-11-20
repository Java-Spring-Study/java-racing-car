package com.taegeun;

public class Car {
    private String carName;
    private int carPosition;

    Car(String carName) {
        this.carName = carName;
        this.carPosition = 0;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getCarPosition() {
        return carPosition;
    }

    public void setCarPosition(int carPosition) {
        this.carPosition = carPosition;
    }

    public void addCarMove(int carMove) {
        this.carPosition += carMove;
    }

    public void printPosition() {
        System.out.println(this.carName + " : " + "-".repeat(carPosition));
    }
}
