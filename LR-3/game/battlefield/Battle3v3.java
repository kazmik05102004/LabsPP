package game.battlefield;

import game.Interface.Colors;
import game.droids.Droid;

import java.util.Random;
import java.util.Scanner;

import static game.ToFile.*;

public class Battle3v3 extends Battle{
    public static void start(Scanner read) {
        droidA1 = createDroid('A',  read);
        read.nextLine();
        droidA2 = createDroid('A',  read);
        read.nextLine();
        droidA3 = createDroid('A',  read);
        read.nextLine();
        droidB1 = createDroid('B',  read);
        read.nextLine();
        droidB2 = createDroid('B',  read);
        read.nextLine();
        droidB3 = createDroid('B',  read);
        read.nextLine();

        startBattle(read);
        toFile(battleRecord);
    }

    public static void startBattle(Scanner read) {
        Random rand = new Random();
        temp = "Хто ж зробить перший крок?...";
        System.out.println(Colors.YELLOW + temp);
        battleRecord.append(temp).append("\n");
        if (rand.nextInt(100) < 50) {
            temp = "Команда А робить перший хід!";
            System.out.println(temp);
            battleRecord.append(temp).append("\n");
            while (true) {
                System.out.println("________________________________________________________________________________________________");
                playerMove('A', droidA1, droidA2, droidA3, read);
                if(droidB1.isDead() && droidB2.isDead() && droidB3.isDead()) {
                    temp = "Команда А перемогла!";
                    System.out.println(Colors.GREEN + temp + Colors.YELLOW);
                    battleRecord.append(temp).append("\n");
                    return;
                }
                System.out.println("________________________________________________________________________________________________");
                playerMove('B', droidB1, droidB2, droidB3, read);
                if(droidA1.isDead() && droidA2.isDead() && droidA3.isDead()) {
                    temp = "Команда B перемогла!";
                    System.out.println(Colors.GREEN + temp + Colors.YELLOW);
                    battleRecord.append(temp).append("\n");
                    return;
                }
            }
        }
        else {
            temp = "Команда B перемогла!";
            System.out.println(Colors.GREEN + temp + Colors.YELLOW);
            battleRecord.append(temp).append("\n");
            while (true) {
                System.out.println("________________________________________________________________________________________________");
                playerMove('B', droidB1, droidB2, droidB3, read);
                if(droidA1.isDead() && droidA2.isDead() && droidA3.isDead()) {
                    temp = "Команда B перемогла!";
                    System.out.println(Colors.GREEN + temp + Colors.YELLOW);
                    battleRecord.append(temp).append("\n");
                    return;
                }
                System.out.println("________________________________________________________________________________________________");
                playerMove('A', droidA1, droidA2, droidA3, read);
                if(droidB1.isDead() && droidB2.isDead() && droidB3.isDead()) {
                    temp = "Команда А перемогла!";
                    System.out.println(Colors.GREEN + temp + Colors.YELLOW);
                    battleRecord.append(temp).append("\n");
                    return;
                }
            }
        }
    }




    public static void playerMove(char player, Droid droid1, Droid droid2, Droid droid3, Scanner read) {
        temp = "\nГравець " + player + " ходить!\n";
        System.out.println(temp);
        battleRecord.append(temp).append("\n");

        temp = "Виберіть дроїда, яким хочете зробити крок:\n" +
                "1 - " + droid1.getType() + " " + droid1.getName() + " - " + droid1.getHp() + " здоров'я\n" +
                "2 - " + droid2.getType() + " " + droid2.getName() + " - " + droid2.getHp() + " здоров'я\n" +
                "3 - " + droid3.getType() + " " + droid3.getName() + " - " + droid3.getHp() + " здоров'я\n" +
                "->";
        System.out.println(temp);
        battleRecord.append(temp).append("\n");

        int option = read.nextInt();
        switch (option) {
            case 1:
                if (droid1.isDead()) {
                    deadDroid();
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
                    deadDroid();
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
                    deadDroid();
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
                errorOption();
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
        temp = "Гравець " + player + ", думає, що зробити:\n" +
                "1 - вдарити опонента\n" +
                "2 - підлікувати союзника\n" +
                "3 - використати здібність\n" +
                "->";
        System.out.println(temp);
        battleRecord.append(temp).append("\n");

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
                errorOption();
                moveHealerUltimate(player, read);
        }
    }

    public static void moveHealer(char player, Scanner read) {
        int option;
        temp = "Гравець " + player + ", обдумує хід:\n" +
                "1 - вдарити опонента\n" +
                "2 - підлікувати союзника\n" +
                "->";
        System.out.println(temp);
        battleRecord.append(temp).append("\n");

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
                errorOption();
                moveHealer(player, read);
        }
    }

    public static void moveDroidUltimate(char player, Scanner read) {
        int option;
        temp = "Гравець " + player + ", обдумує хід:\n" +
                "1 - вдарити опонента\n" +
                "2 - використати здібність\n" +
                "->";
        System.out.println(temp);
        battleRecord.append(temp).append("\n");
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
                        deadDroid();
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
                        deadDroid();
                        moveDroidUltimate(player, read);
                        return;
                    }
                    attacker.ultimateAbility3v3(ally1, ally2, reciever, ally1);
                }
                break;
            default:
                errorOption();
                moveDroidUltimate(player, read);
        }
    }

    public static void moveDroid(char player, Scanner read) {
        temp = "Гравець " + player + " " + attacker.getType() + " " + attacker.getName() + " атакує!";
        System.out.println(temp);
        battleRecord.append(temp).append("\n");
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
            temp = "Кого ви хочете атакувати?\n" +
                    "1 - " + droid1.getType() + " " + droid1.getName() + " має " + droid1.getHp() + " здоров'я\n" +
                    "2 - " + droid2.getType() + " " + droid2.getName() + " має " + droid2.getHp() + " здоров'я\n" +
                    "3 - " + droid3.getType() + " " + droid3.getName() + " має " + droid3.getHp() + " здоров'я\n" +
                    "->";
            System.out.println(temp);
            battleRecord.append(temp).append("\n");

            option = read.nextInt();

            switch (option) {
                case 1:
                    if (droid1.isDead()) {
                        deadDroid();
                    } else {
                        setReciever(droid1);
                        tmp = 0;
                    }
                    break;
                case 2:
                    if (droid2.isDead()) {
                        deadDroid();
                    } else {
                        setReciever(droid2);
                        tmp = 0;
                    }
                    break;
                case 3:
                    if (droid3.isDead()) {
                        deadDroid();
                    } else {
                        setReciever(droid3);
                        tmp = 0;
                    }
                    break;
                default:
                    errorOption();
            }
        }
    }

    public static void chooseHealTarget(Droid droid1, Droid droid2, Droid droid3, Scanner read) {
        int option;

        int tmp = 1;
        while(tmp == 1) {
            temp = "Кого ви хочете підлікувати?\n" +
                    "1 - " + droid1.getType() + " " + droid1.getName() + " - " + droid1.getHp() + " здоров'я\n" +
                    "2 - " + droid2.getType() + " " + droid2.getName() + " - " + droid2.getHp() + " здоров'я\n" +
                    "3 - " + droid3.getType() + " " + droid3.getName() + " - " + droid3.getHp() + " здоров'я\n" +
                    "->";
            System.out.println(temp);
            battleRecord.append(temp).append("\n");

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
                    errorOption();
            }
        }
    }
}
