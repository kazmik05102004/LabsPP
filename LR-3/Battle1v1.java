package game.battlefield;

import game.Interface.Colors;
import game.droids.Droid;
import game.droids.heros.Healer;
import game.droids.heros.Sniper;
import game.droids.heros.Soldier;
import game.droids.heros.Tank;
import game.droids.statsInfo.StatsInfoOfHeros;

import java.util.Random;
import java.util.Scanner;

import static game.ToFile.toFile;

public class Battle1v1 {
    public static String temp1;
    public static StringBuilder battleRecord1 = new StringBuilder();
    private static Droid droidA;
    private static Droid droidB;

    public static void start(Scanner read) {
        droidA = createDroid('A', read);
        read.nextLine();
        droidB = createDroid('B', read);
        read.nextLine();

        startBattle(read);
        toFile(battleRecord1);
    }

    public static Droid createDroid(char player, Scanner read) {
        Droid droid;
        temp1 = "Гравець" + player + ", вибирає ім'я дроїду: ";
        System.out.println(Colors.yellow + temp1);
        battleRecord1.append(temp1).append("\n");
        String name = read.nextLine();

        while(true) {
            temp1 = "Гравець " + player + ", вибирає ім'я дроїду:\n" +
                    "1 - солдат\n" +
                    "2 - танк\n" +
                    "3 - снайпер\n" +
                    "4 - лікар\n" +
                    "5 - переглянути статистику та здібності дроїдів \n" +
                    "->";
            System.out.println(temp1);
            battleRecord1.append(temp1).append("\n");

            int option = read.nextInt();
            switch (option) {
                case 1:
                    droid = new Soldier(name);
                    return droid;
                case 2:
                    droid = new Tank(name);
                    return droid;
                case 3:
                    droid = new Sniper(name);
                    return droid;
                case 4:
                    droid = new Healer(name);
                    return droid;
                case 5:
                    System.out.println(StatsInfoOfHeros.stats1v1());
                    break;
                default:
                    temp1 = "Помилка: неправильна опція. Спробуйте ще раз...";
                    battleRecord1.append(temp1).append("\n");
                    System.out.println(Colors.red + temp1 + Colors.yellow);
            }
        }
    }

    public static void startBattle(Scanner read) {

        Random rand = new Random();
        temp1 = "Нехай вдача вирішить хто буде ходити першим...";
        System.out.println(temp1);
        battleRecord1.append(temp1).append("\n");
        if (rand.nextInt(100) < 50) {
            temp1 = "Гравець А робить перший крок!";
            battleRecord1.append(temp1).append("\n");
            System.out.println(temp1);
            while (true) {
                temp1 = "________________________________________________________________________________________________";
                System.out.println(temp1);
                battleRecord1.append(temp1).append("\n");
                playerMove('A', droidA, droidB, read);
                if (droidB.isDead()) {
                    temp1 = "Гравець А переміг!";
                    System.out.println(Colors.green + temp1 + Colors.yellow);
                    battleRecord1.append(temp1).append("\n");
                    return;
                }
                System.out.println("________________________________________________________________________________________________");
                playerMove('B', droidB, droidA, read);
                if (droidA.isDead()) {
                    temp1 = "Гравець B переміг!";
                    System.out.println(Colors.green + temp1 + Colors.yellow);
                    battleRecord1.append(temp1).append("\n");
                    return;
                }
            }
        }

        else {
            System.out.println("Гравець В починає гру!");
            while (true) {
                System.out.println("________________________________________________________________________________________________");
                playerMove('B', droidB, droidA, read);
                if (droidA.isDead()) {
                    temp1 = "Гравець B переміг!";
                    System.out.println(Colors.green + temp1 + Colors.yellow);
                    battleRecord1.append(temp1).append("\n");
                    return;
                }
                System.out.println("________________________________________________________________________________________________");
                playerMove('A', droidA, droidB, read);
                if (droidB.isDead()) {
                    temp1 = "Гравець А переміг!";
                    System.out.println(Colors.green + temp1 + Colors.yellow);
                    battleRecord1.append(temp1).append("\n");
                    return;
                }
            }
        }

    }

    public static void playerMove(char player, Droid droid1, Droid droid2, Scanner read) {
        int option;
        if(droid1.getType().equals("Лікар")) {           // якщо дроїд - хіллер
            if(droid1.isUltimate()) {                     // якщо дроїд хіллер і в нього є ульт.
                temp1 = "Гравець " + player + " думає, що ж зробити...\n" +
                        "1 - ударити опонента\n" +
                        "2 - полікувати себе\n" +
                        "3 - використати здібність\n" +
                        "->";
                System.out.println(temp1);
                battleRecord1.append(temp1).append("\n");
                option = read.nextInt();
                switch (option) {
                    case 1:
                        droid1.damages(droid2);
                        break;
                    case 2:
                        droid1.healing(droid1);
                        break;
                    case 3:
                        droid1.ultimateAbility1v1(droid1);
                        break;
                    default:
                        temp1 = "Помилка: неправильна опція. Спробуйте ще раз...";
                        battleRecord1.append(temp1).append("\n");
                        System.out.println(Colors.red + temp1 + Colors.yellow);
                        playerMove(player, droid1, droid2, read);
                }
            }
            else if (droid1.getType().equals("Лікар")) {                                    // якщо дроїд - хіллер, але в нього немає ульт.
                temp1 = "Гравець " + player + ", думає, який би зробити хід:\n" +
                        "1 - вдарити опонента\n" +
                        "2 - полікувати себе\n" +
                        "->";
                System.out.println(temp1);
                battleRecord1.append(temp1).append("\n");
                option = read.nextInt();
                switch (option) {
                    case 1:
                        droid1.damages(droid2);
                        break;
                    case 2:
                        droid1.healing(droid1);
                        break;
                    default:
                        temp1 = "Помилка: неправильна опція. Спробуйте ще раз...";
                        battleRecord1.append(temp1).append("\n");
                        System.out.println(Colors.red + temp1 + Colors.yellow);
                        playerMove(player, droid1, droid2, read);
                }
            }

        }
        else {                                // якщо дроїд - не хіллер
            if(droid1.isUltimate()) {         // якщо дроїд не хіллер і в нього є ульт.
                temp1 = "Гравець " + player + " думає, що ж зробити...\n" +
                        "1 - ударити опонента\n" +
                        "2 - використати здібність\n" +
                        "->";
                System.out.println(temp1);
                option = read.nextInt();
                switch (option) {
                    case 1:
                        droid1.damages(droid2);
                        break;
                    case 2:
                        droid1.ultimateAbility1v1(droid2);
                        break;
                    default:
                        temp1 = "Помилка: неправильна опція. Спробуйте ще раз...";
                        battleRecord1.append(temp1).append("\n");
                        System.out.println(Colors.red + temp1 + Colors.yellow);
                        playerMove(player, droid1, droid2, read);
                }
            }
            else {              // якщо дроїд не хіллер і в нього немає ульт.
                temp1 = "Гравець " + player + " " + droid1.getType() + " " + droid1.getName() +
                        " атакує!";
                System.out.println(temp1);
                battleRecord1.append(temp1).append("\n");
                droid1.damages(droid2);
            }
        }
    }
}
