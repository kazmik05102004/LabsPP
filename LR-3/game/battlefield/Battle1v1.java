package game.battlefield;

import game.Interface.Colors;
import game.droids.Droid;

import java.util.Random;
import java.util.Scanner;

import static game.ToFile.*;

public class Battle1v1 extends Battle {
    public static void start(Scanner read) {
        droidA1 = createDroid('A', read);
        read.nextLine();
        droidB1 = createDroid('B', read);
        read.nextLine();

        startBattle(read);
        toFile(battleRecord);
    }

    public static void startBattle(Scanner read) {

        Random rand = new Random();
        temp = "Нехай вдача вирішить хто буде ходити першим...";
        System.out.println(temp);
        battleRecord.append(temp).append("\n");
        if (rand.nextInt(100) < 50) {
            temp = "Гравець А робить перший крок!";
            battleRecord.append(temp).append("\n");
            System.out.println(temp);
            while (true) {
                temp = "________________________________________________________________________________________________";
                System.out.println(temp);
                battleRecord.append(temp).append("\n");
                playerMove('A', droidA1, droidB1, read);
                if (droidB1.isDead()) {
                    temp = "Гравець А переміг!";
                    System.out.println(Colors.GREEN + temp + Colors.YELLOW);
                    battleRecord.append(temp).append("\n");
                    return;
                }
                System.out.println("________________________________________________________________________________________________");
                playerMove('B', droidB1, droidA1, read);
                if (droidA1.isDead()) {
                    temp = "Гравець B переміг!";
                    System.out.println(Colors.GREEN + temp + Colors.YELLOW);
                    battleRecord.append(temp).append("\n");
                    return;
                }
            }
        } else {
            System.out.println("Гравець В починає гру!");
            while (true) {
                System.out.println("________________________________________________________________________________________________");
                playerMove('B', droidB1, droidA1, read);
                if (droidA1.isDead()) {
                    temp = "Гравець B переміг!";
                    System.out.println(Colors.GREEN + temp + Colors.YELLOW);
                    battleRecord.append(temp).append("\n");
                    return;
                }
                System.out.println("________________________________________________________________________________________________");
                playerMove('A', droidA1, droidB1, read);
                if (droidB1.isDead()) {
                    temp = "Гравець А переміг!";
                    System.out.println(Colors.GREEN + temp + Colors.YELLOW);
                    battleRecord.append(temp).append("\n");
                    return;
                }
            }
        }

    }

    public static void playerMove(char player, Droid droid1, Droid droid2, Scanner read) {
        int option;
        if (droid1.getType().equals("Лікар")) {           // якщо дроїд - хіллер
            if (droid1.isUltimate()) {                     // якщо дроїд хіллер і в нього є ульт.
                temp = "Гравець " + player + " думає, що ж зробити...\n" +
                        "1 - ударити опонента\n" +
                        "2 - полікувати себе\n" +
                        "3 - використати здібність\n" +
                        "->";
                System.out.println(temp);
                battleRecord.append(temp).append("\n");
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
                        temp = "Помилка: неправильна опція. Спробуйте ще раз...";
                        battleRecord.append(temp).append("\n");
                        System.out.println(Colors.RED + temp + Colors.YELLOW);
                        playerMove(player, droid1, droid2, read);
                }
            } else if (droid1.getType().equals("Лікар")) {                                    // якщо дроїд - хіллер, але в нього немає ульт.
                temp = "Гравець " + player + ", думає, який би зробити хід:\n" +
                        "1 - вдарити опонента\n" +
                        "2 - полікувати себе\n" +
                        "->";
                System.out.println(temp);
                battleRecord.append(temp).append("\n");
                option = read.nextInt();
                switch (option) {
                    case 1:
                        droid1.damages(droid2);
                        break;
                    case 2:
                        droid1.healing(droid1);
                        break;
                    default:
                        temp = "Помилка: неправильна опція. Спробуйте ще раз...";
                        battleRecord.append(temp).append("\n");
                        System.out.println(Colors.RED + temp + Colors.YELLOW);
                        playerMove(player, droid1, droid2, read);
                }
            }

        } else {                                // якщо дроїд - не хіллер
            if (droid1.isUltimate()) {         // якщо дроїд не хіллер і в нього є ульт.
                temp = "Гравець " + player + " думає, що ж зробити...\n" +
                        "1 - ударити опонента\n" +
                        "2 - використати здібність\n" +
                        "->";
                System.out.println(temp);
                option = read.nextInt();
                switch (option) {
                    case 1:
                        droid1.damages(droid2);
                        break;
                    case 2:
                        droid1.ultimateAbility1v1(droid2);
                        break;
                    default:
                        temp = "Помилка: неправильна опція. Спробуйте ще раз...";
                        battleRecord.append(temp).append("\n");
                        System.out.println(Colors.RED + temp + Colors.YELLOW);
                        playerMove(player, droid1, droid2, read);
                }
            } else {              // якщо дроїд не хіллер і в нього немає ульт.
                temp = "Гравець " + player + " " + droid1.getType() + " " + droid1.getName() +
                        " атакує!";
                System.out.println(temp);
                battleRecord.append(temp).append("\n");
                droid1.damages(droid2);
            }
        }
    }
}