package game.battlefield;

import game.Interface.Colors;
import game.droids.Droid;
import game.droids.boss.Dragon;
import game.droids.heros.*;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static game.ToFile.*;

public class BattleWithBoss extends Battle{

    public static void start(Scanner read) {
        droidA1 = createDroid('A', read);
        read.nextLine();
        droidA2 = createDroid('A', read);
        read.nextLine();
        droidA3 = createDroid('A', read);
        read.nextLine();
        droidBoss = createDroid('B', read);
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
            temp = "Ви робите перший хід!";
            System.out.println(temp);
            battleRecord.append(temp).append("\n");
            while (true) {
                temp = "________________________________________________________________________________________________";
                System.out.println(temp);
                battleRecord.append(temp).append("\n");
                playerMove('A', droidA1, droidA2, droidA3, read);
                if (droidBoss.isDead()) {
                    temp = "Ви перемогли!";
                    System.out.println(Colors.GREEN + temp + Colors.YELLOW);
                    battleRecord.append(temp).append("\n");
                    return;
                }
                temp = "________________________________________________________________________________________________";
                System.out.println(temp);
                battleRecord.append(temp).append("\n");
                bossMove(droidBoss, droidA1, droidA2, droidA3);
                System.out.println(Colors.RED);
                if (droidA1.isDead() && droidA2.isDead() && droidA3.isDead()) {
                    temp = "Бос переміг!";
                    System.out.println(Colors.RED + temp + Colors.YELLOW);
                    battleRecord.append(temp).append("\n");
                    return;
                }
                System.out.println(Colors.YELLOW);
            }
        } else {
            temp = "Бос робить перший хід!";
            System.out.println(temp);
            battleRecord.append(temp).append("\n");
            while (true) {
                temp = "________________________________________________________________________________________________";
                System.out.println(temp);
                battleRecord.append(temp).append("\n");
                bossMove(droidBoss, droidA1, droidA2, droidA3);
                if (droidA1.isDead() && droidA2.isDead() && droidA3.isDead()) {
                    temp = "Бос переміг!";
                    System.out.println(Colors.RED + temp + Colors.YELLOW);
                    battleRecord.append(temp).append("\n");
                    return;
                }
                System.out.println("________________________________________________________________________________________________");
                playerMove('A', droidA1, droidA2, droidA3, read);
                if (droidBoss.isDead()) {
                    temp = "Ви перемогли!";
                    System.out.println(Colors.GREEN + temp + Colors.YELLOW);
                    battleRecord.append(temp).append("\n");
                    return;
                }
            }
        }
    }

    public static void playerMove(char player, Droid droid1, Droid droid2, Droid droid3, Scanner read) {
        setReciever(droidBoss);
        temp = "\nГравець " + player + " ходить!\n";
        System.out.println(temp);
        battleRecord.append(temp).append("\n");

        temp = "Виберіть дроїда, яким хочете зробити крок:\n" +
                "1 - " + droid1.getType() + " " + droid1.getName() + " - " + droid1.getHp() + " здоров'я\n" +
                "2 - " + droid2.getType() + " " + droid2.getName() + " - " + droid2.getHp() + " здоров'я\n" +
                "3 - " + droid3.getType() + " " + droid3.getName() + " - " + droid3.getHp() + " здоров'я\n" +
                "->";
        System.out.println(temp);
        int option = read.nextInt();
        battleRecord.append(temp).append("\n");

        switch (option) {
            case 1:
                if (droid1.isDead()) {
                    deadDroid();

                    playerMove(player, droid1, droid2, droid3, read);
                    return;
                } else {
                    setAttacker(droid1);
                    setAlly1(droid2);
                    setAlly2(droid3);
                }
                break;
            case 2:
                if (droid2.isDead()) {
                    deadDroid();
                    playerMove(player, droid1, droid2, droid3, read);
                    return;
                } else {
                    setAttacker(droid2);
                    setAlly1(droid1);
                    setAlly2(droid3);
                }
                break;
            case 3:
                if (droid3.isDead()) {
                    deadDroid();
                    playerMove(player, droid1, droid2, droid3, read);
                    return;
                } else {
                    setAttacker(droid3);
                    setAlly1(droid1);
                    setAlly2(droid2);
                }
                break;
            default:
                errorOption();
                playerMove(player, droid1, droid2, droid3, read);
        }

        if (attacker.getType().equals("Лікар")) {           // якщо дроїд - хіллер
            if (attacker.isUltimate()) {                     // якщо дроїд хіллер і в нього є ульт.
                moveHealerUltimate(player, read);
            } else {                                          // якщо дроїд хіллер і в нього немає ульт.
                moveHealer(player, read);
            }
        } else {                                              // якщо дроїд не хіллер
            if (attacker.isUltimate()) {                     // якщо дроїд хіллер і в нього є ульт.
                moveDroidUltimate(player, read);
            } else {                                          // якщо дроїд хіллер і в нього немає ульт.
                moveDroid(player, read);
            }
        }
    }

    public static void moveDroid(char player, Scanner read) {
        temp = "Гравець " + player + " " + attacker.getType() + " " + attacker.getName() + " атакує!";
        System.out.println(temp);
        battleRecord.append(temp).append("\n");

        attacker.damages(reciever);
    }

    public static void moveHealer(char player, Scanner read) {
        int option;
        temp = "Гравець " + player + ", продумує свій наступний хід:\n" +
                "1 - атакувати дракона\n" +
                "2 - підлікувати союзника\n" +
                "->";
        System.out.println(temp);
        battleRecord.append(temp).append("\n");

        option = read.nextInt();
        switch(option) {
            case 1:
                attacker.damages(reciever);
                break;

            case 2:
                chooseHealTarget(droidA1, droidA2, droidA3, read);
                teammates.setHp(teammates.getHp() + 30);
                break;
            default:
                errorOption();
                moveHealer(player, read);
        }
    }

    public static void moveDroidUltimate(char player, Scanner read) {
        int option;
        temp = "Гравець " + player + ", думає, що ж йому зробити:\n" +
                "1 - вдарити дракона\n" +
                "2 - використати здібність\n" +
                "->";
        System.out.println(temp);
        battleRecord.append(temp).append("\n");

        option = read.nextInt();
        switch(option) {
            case 1:
                attacker.damages(reciever);
                break;

            case 2:
                if(attacker.getType().equals("Снайпер"))
                        attacker.ultimateAbility3v3(ally1, ally2, reciever, ally1);
                if(attacker.getType().equals("Солдат"))
                    attacker.ultimateAbility3v3(ally1, ally2, reciever, ally1);
                if(attacker.getType().equals("Танк"))
                    attacker.ultimateAbility3v3(ally1, ally2, reciever, ally1);
                break;
            default:
                errorOption();
                moveDroidUltimate(player, read);
        }
    }

    public static void moveHealerUltimate(char player, Scanner read) {
        int option;
        temp = "Гравець " + player + ", думає, що зробити:\n" +
                "1 - атакувати дракона\n" +
                "2 - підлікувати союзника\n" +
                "3 - використати здібність\n" +
                "4 - воскресити союзника\n" +
                "->";
        System.out.println(temp);
        battleRecord.append(temp).append("\n");

        option = read.nextInt();
        switch(option) {
            case 1:
                attacker.damages(reciever);
                break;

            case 2:
                chooseHealTarget(droidA1, droidA2, droidA3, read);
                teammates.setHp(teammates.getHp() + 30);
                break;

            case 3:
                if(player == 'A') {
                    chooseHealTarget(droidA1, droidA2, droidA3, read);
                }
                attacker.ultimateAbility3v3(ally1, ally2, ally1, reciever);
                break;
            case 4:
                if(player == 'A') {
                    chooseReviveTarget(droidA1, droidA2, droidA3, read);
                }
                attacker.ultimateAbilityBoss(ally1, ally2, ally1, reciever);
                break;
            default:
                errorOption();
                moveHealerUltimate(player, read);
        }
    }
    public static void chooseReviveTarget(Droid droid1, Droid droid2, Droid droid3, Scanner read) {
        int option;

        int tmp = 1;
        while (tmp == 1) {
            temp = "Кого ви хочете відродити?\n" +
                    "1 - " + droid1.getType() + " " + droid1.getName() + " - " + droid1.getHp() + " здоров'я\n" +
                    "2 - " + droid2.getType() + " " + droid2.getName() + " - " + droid2.getHp() + " здоров'я\n" +
                    "3 - " + droid3.getType() + " " + droid3.getName() + " - " + droid3.getHp() + " здоров'я\n" +
                    "4 - назад\n" +
                    "->";
            System.out.println(temp);
            battleRecord.append(temp).append("\n");

            option = read.nextInt();

            switch (option) {
                case 1:
                    if(!droid1.isDead()) {
                        aliveDroid();
                        chooseReviveTarget(droid1, droid2, droid3, read);
                    }
                    setTeammates(droid1);
                    tmp = 0;
                    break;

                case 2:
                    if(!droid2.isDead()) {
                        aliveDroid();
                        chooseReviveTarget(droid1, droid2, droid3, read);
                    }
                    setTeammates(droid2);
                    tmp = 0;
                    break;

                case 3:
                    if(!droid3.isDead()) {
                      aliveDroid();
                      chooseReviveTarget(droid1, droid2, droid3, read);
                    }
                    setTeammates(droid3);
                    tmp = 0;
                    break;

                case 4:
                    moveHealerUltimate('A', read);
                    break;
                default:
                    errorOption();
            }
        }
    }
    public static void chooseHealTarget(Droid droid1, Droid droid2, Droid droid3, Scanner read) {
        int option;

        int tmp = 1;
        while (tmp == 1) {
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
                    setTeammates(droid1);
                    tmp = 0;
                    break;

                case 2:
                    setTeammates(droid2);
                    tmp = 0;
                    break;

                case 3:
                    setTeammates(droid3);
                    tmp = 0;
                    break;
                default:
                    errorOption();
            }
        }
    }



    public static void bossMove(Droid droidBoss, Droid droid1, Droid droid2, Droid droid3) {
        setYourTeam(droid1, droid2, droid3);
        if (droidBoss.isUltimate())
            droidBoss.ultimateAbilityOfBoss(droid1, droid2, droid3);
        else {
            int randomIndex;
            while (true) {
                randomIndex = ThreadLocalRandom.current().nextInt(yourTeam.length);
                if(!yourTeam[randomIndex].isDead())
                    break;
            }
            droidBoss.damages(yourTeam[randomIndex]);
        }
    }

    public static Droid createDroid(char player, Scanner read) {
        Droid droid;
        if (player == 'A')
        {
            temp = "Гравець " + player + ", вибирає ім'я дроїду: ";
            System.out.println(temp);
            battleRecord.append(temp).append("\n");
            String name = read.nextLine();
            while (true)
            {
                temp = "Гравець " + player + ", вибирає ім'я дроїду:\n" +
                        "1 - солдат\n" +
                        "2 - танк\n" +
                        "3 - снайпер\n" +
                        "4 - лікар\n" +
                        "5 - переглянути статистику та здібності дроїдів \n" +
                        "->";
                System.out.println(temp);
                battleRecord.append(temp).append("\n");
                int option = read.nextInt();
                switch (option)
                {
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
                        System.out.println(herosStars());
                        break;
                    default:
                        errorOption();
                }
            }
        }
        else
        {
            while (true)
            {
                temp = "Гравець " + player + ", вибирає ім'я дроїду:\n" +
                        "1 - дракон\n" +
                        "2 - переглянути статистику та здібності босів \n" +
                        "->";
                System.out.println(temp);
                battleRecord.append(temp).append("\n");

                int option = read.nextInt();
                switch (option)
                {
                    case 1:
                        droid = new Dragon();
                        return droid;
                    case 2:
                        System.out.println(bossStats());
                        break;
                    default:
                        errorOption();
                }
            }
        }
    }
    public static void aliveDroid()
    {
        temp = "Цей дроїд живий! Зробіть ще 1 вибір.";
        System.out.println(Colors.RED + temp + Colors.YELLOW);
        battleRecord.append(temp).append("\n");
    }
    public static String herosStars() {
        return "Статистика:\n" +
                "Тип дроїда:\t|Здоров'я:\t|Шкода:\t|Точність:\t|Шанс критичного удару:\t|Критична шкода:\t|Лікування:\n" +
                "Дракон\t\t|500\t|30\t\t\t|70\t\t\t|25%\t\t\t|80\t\t\t\t|-\n" +
                "Здібності:\n" +
                "Солдат: Збільшує свою точність до 100% і шанс критичного удару до 50%. Зменшує атаку усіх ворогів на 5 і наносить 20 здоров'я!\n";
    }
    public static String bossStats() {
        return "Статистика:\n" +
                "Тип дроїда:\t|Здоров'я:\t|Шкода:\t|Точність:\t|Шанс критичного удару:\t|Критична шкода:\t|Лікування:\n" +
                "Дракон\t\t|500\t|30\t\t\t|70\t\t\t|25%\t\t\t|80\t\t\t\t|-\n" +
                "Здібності:\n" +
                "Солдат: Збільшує свою точність до 100% і шанс критичного удару до 50%. Зменшує атаку усіх ворогів на 5 і наносить 20 здоров'я!\n";
    }
}