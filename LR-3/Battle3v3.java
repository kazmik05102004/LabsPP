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

public class Battle3v3 {

    public static StringBuilder battleRecord2 = new StringBuilder();
    public static String temp2;
    private static Droid droidA1;
    private static Droid droidA2;
    private static Droid droidA3;
    private static Droid droidB1;
    private static Droid droidB2;
    private static Droid droidB3;

    private static Droid attacker;
    private static Droid reciever;
    private static Droid ally1;
    private static Droid ally2;


    public static void setAttacker(Droid attacker) { Battle3v3.attacker = attacker; }

    public static void setReciever(Droid reciever) {
        Battle3v3.reciever = reciever;
    }

    public static void setAlly1(Droid ally1) {
        Battle3v3.ally1 = ally1;
    }

    public static void setAlly2(Droid ally2) {
        Battle3v3.ally2 = ally2;
    }


    public static void start(Scanner read) {
        droidA1 = createDroid('A', 1, read);
        read.nextLine();
        droidA2 = createDroid('A', 2, read);
        read.nextLine();
        droidA3 = createDroid('A', 3, read);
        read.nextLine();
        droidB1 = createDroid('B', 1, read);
        read.nextLine();
        droidB2 = createDroid('B', 2, read);
        read.nextLine();
        droidB3 = createDroid('B', 3, read);
        read.nextLine();

        startBattle(read);
        toFile(battleRecord2);
    }

    public static void startBattle(Scanner read) {
        Random rand = new Random();
        temp2 = "Хто ж зробить перший крок?...";
        System.out.println(Colors.yellow + temp2);
        battleRecord2.append(temp2).append("\n");
        if (rand.nextInt(100) < 50) {
            temp2 = "Команда А робить перший хід!";
            System.out.println(temp2);
            battleRecord2.append(temp2).append("\n");
            while (true) {
                System.out.println("________________________________________________________________________________________________");
                playerMove('A', droidA1, droidA2, droidA3, read);
                if(droidB1.isDead() && droidB2.isDead() && droidB3.isDead()) {
                    temp2 = "Команда А перемогла!";
                    System.out.println(Colors.green + temp2 + Colors.yellow);
                    battleRecord2.append(temp2).append("\n");
                    return;
                }
                System.out.println("________________________________________________________________________________________________");
                playerMove('B', droidB1, droidB2, droidB3, read);
                if(droidA1.isDead() && droidA2.isDead() && droidA3.isDead()) {
                    temp2 = "Команда B перемогла!";
                    System.out.println(Colors.green + temp2 + Colors.yellow);
                    battleRecord2.append(temp2).append("\n");
                    return;
                }
            }
        }
        else {
            temp2 = "Команда B перемогла!";
            System.out.println(Colors.green + temp2 + Colors.yellow);
            battleRecord2.append(temp2).append("\n");
            while (true) {
                System.out.println("________________________________________________________________________________________________");
                playerMove('B', droidB1, droidB2, droidB3, read);
                if(droidA1.isDead() && droidA2.isDead() && droidA3.isDead()) {
                    temp2 = "Команда B перемогла!";
                    System.out.println(Colors.green + temp2 + Colors.yellow);
                    battleRecord2.append(temp2).append("\n");
                    return;
                }
                System.out.println("________________________________________________________________________________________________");
                playerMove('A', droidA1, droidA2, droidA3, read);
                if(droidB1.isDead() && droidB2.isDead() && droidB3.isDead()) {
                    temp2 = "Команда А перемогла!";
                    System.out.println(Colors.green + temp2 + Colors.yellow);
                    battleRecord2.append(temp2).append("\n");
                    return;
                }
            }
        }
    }




    public static void playerMove(char player, Droid droid1, Droid droid2, Droid droid3, Scanner read) {
        temp2 = "\nГравець " + player + " ходить!\n";
        System.out.println(temp2);
        battleRecord2.append(temp2).append("\n");

        temp2 = "Виберіть дроїда, яким хочете зробити крок:\n" +
                "1 - " + droid1.getType() + " " + droid1.getName() + " - " + droid1.getHp() + " здоров'я\n" +
                "2 - " + droid2.getType() + " " + droid2.getName() + " - " + droid2.getHp() + " здоров'я\n" +
                "3 - " + droid3.getType() + " " + droid3.getName() + " - " + droid3.getHp() + " здоров'я\n" +
                "->";
        System.out.println(temp2);
        battleRecord2.append(temp2).append("\n");

        int option = read.nextInt();
        switch (option) {
            case 1:
                if (droid1.isDead()) {
                    temp2 = "Цей дроїд мертвий! Виберіть іншого дроїда.";
                    System.out.println(Colors.red + temp2 + Colors.yellow);
                    battleRecord2.append(temp2).append("\n");
                    playerMove(player, droid1, droid2, droid3, read);
                    return;
                }
                else {
                    setAttacker(droid1);
                    setAlly1(droid2);
                    setAlly2(droid3);
                }
                break;
            case 2:
                if(droid2.isDead()) {
                    temp2 = "Цей дроїд мертвий! Виберіть іншого дроїда.";
                    System.out.println(Colors.red + temp2 + Colors.yellow);
                    battleRecord2.append(temp2).append("\n");
                    playerMove(player, droid1, droid2, droid3, read);
                    return;
                }
                else {
                    setAttacker(droid2);
                    setAlly1(droid1);
                    setAlly2(droid3);
                }
                break;
            case 3:
                if(droid3.isDead()) {
                    temp2 = "Цей дроїд мертвий! Виберіть іншого дроїда.";
                    System.out.println(Colors.red + temp2 + Colors.yellow);
                    battleRecord2.append(temp2).append("\n");
                    playerMove(player, droid1, droid2, droid3, read);
                    return;
                }
                else {
                    setAttacker(droid3);
                    setAlly1(droid1);
                    setAlly2(droid2);
                }
                break;
            default:
                temp2 = "Помилка: неправильна опція. Спробуйте ще раз...";
                System.out.println(Colors.red + temp2 + Colors.yellow);
                battleRecord2.append(temp2).append("\n");
                playerMove(player, droid1, droid2, droid3, read);
        }

        if(attacker.getType().equals("Healer")) {           // якщо дроїд - хіллер
            if (attacker.isUltimate()) {                     // якщо дроїд хіллер і в нього є ульт.
                moveHealerUltimate(player, read);
            }
            else {                                          // якщо дроїд хіллер і в нього немає ульт.
                moveHealer(player, read);
            }
        }

        else {                                              // якщо дроїд не хіллер
            if (attacker.isUltimate()) {                     // якщо дроїд хіллер і в нього є ульт.
                moveDroidUltimate(player, read);
            }
            else {                                          // якщо дроїд хіллер і в нього немає ульт.
                moveDroid(player, read);
            }
        }

    }

    public static void moveHealerUltimate(char player, Scanner read) {
        int option;
        temp2 = "Гравець " + player + ", думає, що зробити:\n" +
                "1 - вдарити опонента\n" +
                "2 - підлікувати союзника\n" +
                "3 - використати здібність\n" +
                "->";
        System.out.println(temp2);
        battleRecord2.append(temp2).append("\n");

        option = read.nextInt();
        switch(option) {
            case 1:
                if(player == 'A') {
                    chooseAttackTarget(droidB1, droidB2, droidB3, read);
                }
                else {
                    chooseAttackTarget(droidA1, droidA2, droidA3, read);
                }
                attacker.damages(reciever);
                break;

            case 2:
                if(player == 'A') {
                    chooseHealTarget(droidA1, droidA2, droidA3, read);
                }
                else {
                    chooseHealTarget(droidB1, droidB2, droidB3, read);
                }
                reciever.setHp(reciever.getHp() + 30);
                break;

            case 3:
                if(player == 'A') {
                    chooseHealTarget(droidA1, droidA2, droidA3, read);
                }
                else {
                    chooseHealTarget(droidB1, droidB2, droidB3, read);
                }
                attacker.ultimateAbility3v3(ally1, ally2, ally1, reciever);
                break;
            default:
                temp2 = "Помилка: неправильна опція. Спробуйте ще раз...";
                System.out.println(Colors.red + temp2 + Colors.yellow);
                battleRecord2.append(temp2).append("\n");
                moveHealerUltimate(player, read);
        }
    }

    public static void moveHealer(char player, Scanner read) {
        int option;
        temp2 = "Гравець " + player + ", обдумує хід:\n" +
                "1 - вдарити опонента\n" +
                "2 - підлікувати союзника\n" +
                "->";
        System.out.println(temp2);
        battleRecord2.append(temp2).append("\n");

        option = read.nextInt();
        switch(option) {
            case 1:
                if (player == 'A') {
                    chooseAttackTarget(droidB1, droidB2, droidB3, read);
                } else {
                    chooseAttackTarget(droidA1, droidA2, droidA3, read);
                }
                attacker.damages(reciever);
                break;

            case 2:
                if (player == 'A') {
                    chooseHealTarget(droidA1, droidA2, droidA3, read);
                } else {
                    chooseHealTarget(droidB1, droidB2, droidB3, read);
                }
                reciever.setHp(reciever.getHp() + 30);
                break;
            default:
                temp2 = "Помилка: неправильна опція. Спробуйте ще раз...";
                System.out.println(Colors.red + temp2 + Colors.yellow);
                battleRecord2.append(temp2).append("\n");
                moveHealer(player, read);
        }
    }

    public static void moveDroidUltimate(char player, Scanner read) {
        int option;
        temp2 = "Гравець " + player + ", обдумує хід:\n" +
                "1 - вдарити опонента\n" +
                "2 - використати здібність\n" +
                "->";
        System.out.println(temp2);
        battleRecord2.append(temp2).append("\n");
        option = read.nextInt();
        switch(option) {
            case 1:
                if(player == 'A') {
                    chooseAttackTarget(droidB1, droidB2, droidB3, read);
                }
                else {
                    chooseAttackTarget(droidA1, droidA2, droidA3, read);
                }
                attacker.damages(reciever);
                break;

            case 2:
                if(player == 'A') {
                    if(attacker.getType().equals("Снайпер")) {
                        chooseAttackTarget(droidB1, droidB2, droidB3, read);
                    }
                    if(reciever.isDead()) {
                        temp2 = "Цей дроїд мертвий! Виберіть іншого дроїда.";
                        System.out.println(Colors.red + temp2 + Colors.yellow);
                        battleRecord2.append(temp2).append("\n");
                        moveDroidUltimate(player, read);
                        return;
                    }
                    attacker.ultimateAbility3v3(ally1, ally2, reciever, ally1);
                }
                else {
                    if (attacker.getType().equals("Снайпер")) {
                        chooseAttackTarget(droidA1, droidA2, droidA3, read);
                    }
                    if (reciever.isDead()) {
                        temp2 = "Цей дроїд мертвий! Виберіть іншого дроїда.";
                        System.out.println(Colors.red + temp2 + Colors.yellow);
                        battleRecord2.append(temp2).append("\n");
                        moveDroidUltimate(player, read);
                        return;
                    }
                    attacker.ultimateAbility3v3(ally1, ally2, reciever, ally1);
                }
                break;

            default:
                temp2 = "Помилка: неправильна опція. Спробуйте ще раз...";
                System.out.println(Colors.red + temp2 + Colors.yellow);
                battleRecord2.append(temp2).append("\n");
                moveDroidUltimate(player, read);
        }
    }

    public static void moveDroid(char player, Scanner read) {
        temp2 = "Гравець " + player + " " + attacker.getType() + " " + attacker.getName() + " атакує!";
        System.out.println(temp2);
        battleRecord2.append(temp2).append("\n");
        if(player == 'A') {
            chooseAttackTarget(droidB1, droidB2, droidB3, read);
        }
        else {
            chooseAttackTarget(droidA1, droidA2, droidA3, read);
        }
        attacker.damages(reciever);
    }

    public static void chooseAttackTarget(Droid droid1, Droid droid2, Droid droid3, Scanner read) {
        int option;

        int tmp = 1;
        while(tmp == 1) {
            temp2 = "Кого ви хочете атакувати?\n" +
                    "1 - " + droid1.getType() + " " + droid1.getName() + " має " + droid1.getHp() + " здоров'я\n" +
                    "2 - " + droid2.getType() + " " + droid2.getName() + " має " + droid2.getHp() + " здоров'я\n" +
                    "3 - " + droid3.getType() + " " + droid3.getName() + " має " + droid3.getHp() + " здоров'я\n" +
                    "->";
            System.out.println(temp2);
            battleRecord2.append(temp2).append("\n");

            option = read.nextInt();

            switch (option) {
                case 1:
                    if (droid1.isDead()) {
                        temp2 = "Цей дроїд мертвий! Виберіть іншого дроїда.";
                        System.out.println(Colors.red + temp2 + Colors.yellow);
                        battleRecord2.append(temp2).append("\n");
                    } else {
                        setReciever(droid1);
                        tmp = 0;
                    }
                    break;

                case 2:
                    if (droid2.isDead()) {
                        temp2 = "Цей дроїд мертвий! Виберіть іншого дроїда.";
                        System.out.println(Colors.red + temp2 + Colors.yellow);
                        battleRecord2.append(temp2).append("\n");
                    } else {
                        setReciever(droid2);
                        tmp = 0;
                    }
                    break;

                case 3:
                    if (droid3.isDead()) {
                        temp2 = "Цей дроїд мертвий! Виберіть іншого дроїда.";
                        System.out.println(Colors.red + temp2 + Colors.yellow);
                        battleRecord2.append(temp2).append("\n");
                    } else {
                        setReciever(droid3);
                        tmp = 0;
                    }
                    break;
                default:
                    temp2 = "Помилка: неправильна опція. Спробуйте ще раз...";
                    System.out.println(Colors.red + temp2 + Colors.yellow);
                    battleRecord2.append(temp2).append("\n");
            }
        }
    }

    public static void chooseHealTarget(Droid droid1, Droid droid2, Droid droid3, Scanner read) {
        int option;

        int tmp = 1;
        while(tmp == 1) {
            temp2 = "Кого ви хочете підлікувати?\n" +
                    "1 - " + droid1.getType() + " " + droid1.getName() + " - " + droid1.getHp() + " здоров'я\n" +
                    "2 - " + droid2.getType() + " " + droid2.getName() + " - " + droid2.getHp() + " здоров'я\n" +
                    "3 - " + droid3.getType() + " " + droid3.getName() + " - " + droid3.getHp() + " здоров'я\n" +
                    "->";
            System.out.println(temp2);
            battleRecord2.append(temp2).append("\n");

            option = read.nextInt();

            switch (option) {
                case 1:
                    setReciever(droid1);
                    tmp = 0;
                    break;

                case 2:
                    setReciever(droid2);
                    tmp = 0;
                    break;

                case 3:
                    setReciever(droid3);
                    tmp = 0;
                    break;
                default:
                    temp2 = "Помилка: неправильна опція. Спробуйте ще раз...";
                    System.out.println(Colors.red + temp2 + Colors.yellow);
                    battleRecord2.append(temp2).append("\n");
            }
        }
    }

    public static Droid createDroid(char player, int number, Scanner read) {
        Droid droid;
        temp2 = "Гравець " + player + ", вибирає ім'я дроїду: ";
        System.out.println(temp2);
        battleRecord2.append(temp2).append("\n");
        String name = read.nextLine();

        while(true) {
            temp2 = "Гравець " + player + ", вибирає ім'я дроїду:\n" +
                    "1 - солдат\n" +
                    "2 - танк\n" +
                    "3 - снайпер\n" +
                    "4 - лікар\n" +
                    "5 - переглянути статистику та здібності дроїдів \n" +
                    "->";
            System.out.println(temp2);
            battleRecord2.append(temp2).append("\n");

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
                    System.out.println(StatsInfoOfHeros.stats3v3());
                    break;
                default:
                    temp2 = "Помилка: неправильна опція. Спробуйте ще раз...";
                    System.out.println(Colors.red + temp2 + Colors.yellow);
                    battleRecord2.append(temp2).append("\n");              }
        }
    }
}
