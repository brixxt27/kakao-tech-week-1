package org.example.controller;

import org.example.domain.Charmander;
import org.example.domain.Squirtle;
import org.example.domain.User;

import java.util.Objects;
import java.util.Scanner;

public class Controller {
    final private Scanner scanner = new Scanner(System.in);
    final private User user = new User();
    final private Squirtle squirtle = new Squirtle("Squirtle", 0);
    final private Charmander charmander = new Charmander(null, 100);

    public void run() {
        while (true) {
            try {
                printMain(
                        squirtle.getName(), squirtle.getLevel(), charmander.getName(), charmander.getLevel()
                );
                processUserInput();
            } catch (Exception e) {
                System.out.println("게임이 종료 되었습니다.");
                break;
            }
        }
        scanner.close();
    }

    private void processUserInput() {
        String input = scanner.nextLine();
        int sleepingSeconds = 0; // test
//        int sleepingSeconds = 1500;

        switch (input) {
            case "1":
                System.out.println("-> '포인트 조회'를 선택했습니다.");
                printPoint();
                break;
            case "2":
                System.out.println("-> '레벨 업'을 선택했습니다.");
                levelUp();
                break;
            case "3":
                System.out.println("-> '몬스터 구매'를 선택했습니다.");
                break;
            case "0":
                System.out.println("-> 게임을 종료합니다.");
                System.exit(0);
                break;
            default:
                System.out.println("-> 잘못된 명령어입니다. 다시 입력해주세요.");
        }
        try {
            Thread.sleep(sleepingSeconds);
        } catch(InterruptedException e) {
            System.exit(1);
        }
    }

    private void printPoint() {
        System.out.println("-> 포인트: " + user.getPoint() + " 원 입니다.");
    }

    private void levelUp() {
        System.out.println("\n레벨 업");
        System.out.println("------------------------------------------");
        System.out.printf("%-20s | %15s\n", "이름", "가격(원)");
        System.out.println("------------------------------------------");

        int pointAmountOfSquirtle = squirtle.getLevel() * squirtle.getPointOfLevelUp();
        int pointAmountOfCharmander = charmander.getLevel() * charmander.getPointOfLevelUp();
        System.out.printf("1. %-18s | %15d\n", "꼬부기", pointAmountOfSquirtle);
        if (charmander.getName() != null) {
            System.out.printf("2. %-18s | %15d\n", "파이리", pointAmountOfCharmander);
        }

        System.out.println("0. 취소");
        System.out.println("------------------------------------------");
        System.out.print("명령어 입력: ");

        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                if (user.getPoint() < pointAmountOfSquirtle) {
                    System.out.println("-> 잔액이 부족합니다.");
                    break;
                }
                user.consumePoint(pointAmountOfSquirtle);
                squirtle.levelUp();
                System.out.println("-> 꼬부기 레벨 업!");
                break;
//            case "2":
//                if (charmander.getName() != null) {
//                    System.out.println("-> 파이리 레벨 업!");
//                } else {
//                    System.out.println("-> 잘못된 명령어입니다.");
//                }
//                break;
            case "0":
                System.out.println("-> 레벨 업을 취소합니다.");
                break;
            default:
                System.out.println("-> 잘못된 명령어입니다.");
                break;
        }
    }

    /**
     * 메인 게임 화면을 터미널에 출력합니다.
     *
     * @param squirtleName  꼬부기 이름
     * @param squirtleLevel 꼬부기 레벨
     * @param charmanderName 파이리 이름 (보유하지 않았을 경우 null)
     * @param charmanderLevel 파이리 레벨
     */
    private void printMain(String squirtleName, int squirtleLevel, String charmanderName, int charmanderLevel) {
        printUpper(squirtleName, squirtleLevel, charmanderName, charmanderLevel);

        System.out.println("\n--------------------------------------------------\n");
        System.out.println("몬스터 키우기");
        System.out.println("1. 포인트 조회");
        System.out.println("2. 레벨 업");
        System.out.println("3. 포켓몬스터 구매");
        System.out.println("0. 게임 종료");
        System.out.println();
        System.out.print("명령어 입력: ");
    }

    private void printUpper(String squirtleName, int squirtleLevel, String charmanderName, int charmanderLevel) {
        String[] squirtleArt = {
                "      .--.    ",
                "    .'  ..\\   ",
                "   /   .-' }  ",
                "  /   /`'--'  ",
                " /   |         ",
                "(_'. '  \\      ",
                "  '| |   |     ",
                "   '-\\   /     ",
                "      `-'      "
        };

        String[] charmanderArt = {
                "      /\\_/\\  ",
                "     ( o.o ) ",
                "      > ^ <  ",
                "     /  _  \\ ",
                "    /  / \\  \\",
                "   /  |   |  \\",
                "  /___|___|___\\",
                "      |   |  ` ",
                "      '---'    "
        };

        String[] unknownArt = {
                "┌───────────┐",
                "│           │",
                "│           │",
                "│     ?     │",
                "│           │",
                "│           │",
                "└───────────┘",
                "             ",
                "             "
        };

        // 꼬부기와 파이리(소유하지 않았다면 '?') 아트를 한 줄씩 번갈아 출력하여 나란히 보이게 함
        String[] rightSideArt = Objects.nonNull(charmanderName) ? charmanderArt : unknownArt;
        for (int i = 0; i < squirtleArt.length; i++) {
            System.out.printf("   %-25s", squirtleArt[i]);
            System.out.printf("%-25s\n", rightSideArt[i]);
        }

        // 포켓몬 레벨과 이름 출력
        System.out.printf("   Lv.%-2d %-20s", squirtleLevel, squirtleName);
        if (Objects.nonNull(charmanderName)) {
            System.out.printf("Lv.%-2d %-20s\n", charmanderLevel, charmanderName);
        } else {
            System.out.printf("%-20s\n", "?");
        }

    }
}
