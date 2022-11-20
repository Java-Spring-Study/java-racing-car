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
        int winnerPosition = -1;
        for (Car car : carList) {
            if (car.getCarPosition() >= winnerPosition) {
                winnerPosition = car.getCarPosition();
            }
        }

        List<String> winners = new ArrayList<>();
        for (Car car : carList) {
            if (car.getCarPosition() == winnerPosition) {
                winners.add(car.getCarName());
            }
        }
        System.out.print(winners.stream().collect(Collectors.joining(", ")));
        System.out.println("가 최종 우승했습니다.");
    }
}
