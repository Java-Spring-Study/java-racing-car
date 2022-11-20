package com.taegeun;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<Car> carList = inputCarNameList(sc);

        System.out.println("시도할 횟수는 몇회인가요?");
        int playTimes = inputPlayTimes(sc);

        GamePlay game = new GamePlay();
        game.gameStart(playTimes, carList);
        game.printWinner(carList);

    }

    private static int inputPlayTimes(Scanner sc) {
        String playTimes;
        do {
            playTimes = sc.nextLine();
        }
        while (!GameValidator.playTimesValid(playTimes));

        return Integer.parseInt(playTimes);
    }

    private static List<Car> inputCarNameList(Scanner sc) {
        String inputCarName;

        do {
            inputCarName = sc.nextLine();
        } while (!GameValidator.carNameValid(inputCarName));


        return Arrays.stream(inputCarName.split(","))
                .map(name -> new Car(name))
                .collect(Collectors.toList());
    }
}