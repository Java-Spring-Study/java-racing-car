package com.taegeun;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GamePlay {
    public void gameStart(int playTimes, List<Car> carList) {
        System.out.println("\n실행결과");
        for (int i = 0; i < playTimes; i++) {
            carList.stream().forEach(car -> {
                car.addCarMove(GameUtil.moveCar());
                car.printPosition();
            });
            System.out.println();
            System.out.println();
        }
    }

    public void printWinner(List<Car> carList) {
        int winnerPosition = carList.stream()
                .map(Car::getCarPosition)
                .reduce(Integer::max)
                .orElse(-1);

        System.out.print(carList.stream()
                .filter(car -> car.getCarPosition() == winnerPosition)
                .map(car -> car.getCarName())
                .collect(Collectors.joining(", ")));

        System.out.println("가 최종 우승했습니다.");
    }
}
