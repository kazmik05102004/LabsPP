package game.battlefield;

import game.Interface.Colors;
import game.droids.Droid;
import game.droids.heros.*;
import game.droids.boss.*;
import game.droids.statsInfo.*;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static game.ToFile.toFile;

public class    BattleWithBoss {

    public static StringBuilder battleRecord3 = new StringBuilder();
    public static String temp3;
    private static Droid droidA1;
    private static Droid droidA2;
    private static Droid droidA3;
    private static Droid droidBoss;
    private static Droid [] yourTeam = new Droid[3];
    private static Droid attacker;
    private static Droid teammates;
    private static Droid reciever;
    private static Droid ally1;
    private static Droid ally2;

    public static void setYourTeam(Droid droid1, Droid droid2, Droid droid3) {
        yourTeam[0] = droid1;
        yourTeam[1] = droid2;
        yourTeam[2] = droid3;
    }

    public static Droid[] getYourTeam() {
        return yourTeam;
    }

    public static void setTeammates(Droid teammates) {
        BattleWithBoss.teammates = teammates;
    }

    public static void setAttacker(Droid attacker) {
        BattleWithBoss.attacker = attacker;
    }

    public static void setReciever(Droid reciever) {
        BattleWithBoss.reciever = reciever;
    }

    public static void setAlly1(Droid ally1) {
        BattleWithBoss.ally1 = ally1;
    }

    public static void setAlly2(Droid ally2) {
        BattleWithBoss.ally2 = ally2;
    }

    public static void start(Scanner read) {
        droidA1 = createDroid('A', 1, read);
        read.nextLine();
        droidA2 = createDroid('A', 2, read);
        read.nextLine();
        droidA3 = createDroid('A', 3, read);
        read.nextLine();
        droidBoss = createDroid('B', 1, read);
        read.nextLine();


        startBattle(read);
        toFile(battleRecord3);
    }

    public static void startBattle(Scanner read) {
        Random rand = new Random();
        temp3 = "Хто ж зробить перший крок?...";
        System.out.println(Colors.yellow + temp3);
        battleRecord3.append(temp3).append("\n");

        if (rand.nextInt(100) < 50) {
            temp3 = "Ви робите перший хід!";
            System.out.println(temp3);
            battleRecord3.append(temp3).append("\n");
            while (true) {
                temp3 = "________________________________________________________________________________________________";
                System.out.println(temp3);
                battleRecord3.append(temp3).append("\n");
                playerMove('A', droidA1, droidA2, droidA3, read);
                if (droidBoss.isDead()) {
                    temp3 = "Ви перемогли!";
                    System.out.println(Colors.green + temp3 + Colors.yellow);
                    battleRecord3.append(temp3).append("\n");
                    return;
                }
                temp3 = "________________________________________________________________________________________________";
                System.out.println(temp3);
                battleRecord3.append(temp3).append("\n");
                bossMove(droidBoss, droidA1, droidA2, droidA3);
                System.out.println(Colors.red);
                if (droidA1.isDead() && droidA2.isDead() && droidA3.isDead()) {
                    temp3 = "Бос переміг!";
                    System.out.println(Colors.red + temp3 + Colors.yellow);
                    battleRecord3.append(temp3).append("\n");
                    return;
                }
                System.out.println(Colors.yellow);
            }
        } else {
            temp3 = "Бос робить перший хід!";
            System.out.println(temp3);
            battleRecord3.append(temp3).append("\n");
            while (true) {
                temp3 = "________________________________________________________________________________________________";
                System.out.println(temp3);
                battleRecord3.append(temp3).append("\n");
                bossMove(droidBoss, droidA1, droidA2, droidA3);
                if (droidA1.isDead() && droidA2.isDead() && droidA3.isDead()) {
                    temp3 = "Бос переміг!";
                    System.out.println(Colors.red + temp3 + Colors.yellow);
                    battleRecord3.append(temp3).append("\n");
                    return;
                }
                System.out.println("________________________________________________________________________________________________");
                playerMove('A', droidA1, droidA2, droidA3, read);
                if (droidBoss.isDead()) {
                    temp3 = "Ви перемогли!";
                    System.out.println(Colors.green + temp3 + Colors.yellow);
                    battleRecord3.append(temp3).append("\n");
                    return;
                }
            }
        }
    }

    public static void playerMove(char player, Droid droid1, Droid droid2, Droid droid3, Scanner read) {
        setReciever(droidBoss);
        temp3 = "\nГравець " + player + " ходить!\n";
        System.out.println(temp3);
        battleRecord3.append(temp3).append("\n");

        temp3 = "Виберіть дроїда, яким хочете зробити крок:\n" +
                "1 - " + droid1.getType() + " " + droid1.getName() + " - " + droid1.getHp() + " здоров'я\n" +
                "2 - " + droid2.getType() + " " + droid2.getName() + " - " + droid2.getHp() + " здоров'я\n" +
                "3 - " + droid3.getType() + " " + droid3.getName() + " - " + droid3.getHp() + " здоров'я\n" +
                "->";
        System.out.println(temp3);
        int option = read.nextInt();
        battleRecord3.append(temp3).append("\n");

        switch (option) {
            case 1:
                if (droid1.isDead()) {
                    temp3 = "Цей дроїд мертвий! Виберіть іншого дроїда.";
                    System.out.println(Colors.red + temp3 + Colors.yellow);
                    battleRecord3.append(temp3).append("\n");

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
                    temp3 = "Цей дроїд мертвий! Виберіть іншого дроїда.";
                    System.out.println(Colors.red + temp3 + Colors.yellow);
                    battleRecord3.append(temp3).append("\n");

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
                    temp3 = "Цей дроїд мертвий! Виберіть іншого дроїда.";
                    System.out.println(Colors.red + temp3 + Colors.yellow);
                    battleRecord3.append(temp3).append("\n");
                    playerMove(player, droid1, droid2, droid3, read);
                    return;
                } else {
                    setAttacker(droid3);
                    setAlly1(droid1);
                    setAlly2(droid2);
                }
                break;
            default:
                temp3 = "Помилка: неправильна опція. Спробуйте ще раз...";
                System.out.println(Colors.red + temp3 + Colors.yellow);
                battleRecord3.append(temp3).append("\n");
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
        temp3 = "Гравець " + player + " " + attacker.getType() + " " + attacker.getName() + " атакує!";
        System.out.println(temp3);
        battleRecord3.append(temp3).append("\n");

        attacker.damages(reciever);
    }

    public static void moveHealer(char player, Scanner read) {
        int option;
        temp3 = "Гравець " + player + ", продумує свій наступний хід:\n" +
                "1 - атакувати дракона\n" +
                "2 - підлікувати союзника\n" +
                "->";
        System.out.println(temp3);
        battleRecord3.append(temp3).append("\n");

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
                temp3 = "Помилка: неправильна опція. Спробуйте ще раз...";
                System.out.println(Colors.red + temp3 + Colors.yellow);
                battleRecord3.append(temp3).append("\n");
                moveHealer(player, read);
        }
    }

    public static void moveDroidUltimate(char player, Scanner read) {
        int option;
        temp3 = "Гравець " + player + ", думає, що ж йому зробити:\n" +
                "1 - вдарити дракона\n" +
                "2 - використати здібність\n" +
                "->";
        System.out.println(temp3);
        battleRecord3.append(temp3).append("\n");

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
                temp3 = "Помилка: неправильна опція. Спробуйте ще раз...";
                System.out.println(Colors.red + temp3 + Colors.yellow);
                battleRecord3.append(temp3).append("\n");
                moveDroidUltimate(player, read);
        }
    }

    public static void moveHealerUltimate(char player, Scanner read) {
        int option;
        temp3 = "Гравець " + player + ", думає, що зробити:\n" +
                "1 - атакувати дракона\n" +
                "2 - підлікувати союзника\n" +
                "3 - використати здібність\n" +
                "4 - воскресити союзника\n" +
                "->";
        System.out.println(temp3);
        battleRecord3.append(temp3).append("\n");

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
                temp3 = "Помилка: неправильна опція. Спробуйте ще раз...";
                System.out.println(Colors.red + temp3 + Colors.yellow);
                battleRecord3.append(temp3).append("\n");
                moveHealerUltimate(player, read);
        }
    }
    public static void chooseReviveTarget(Droid droid1, Droid droid2, Droid droid3, Scanner read) {
        int option;

        int tmp = 1;
        while (tmp == 1) {
            temp3 = "Кого ви хочете відродити?\n" +
                    "1 - " + droid1.getType() + " " + droid1.getName() + " - " + droid1.getHp() + " здоров'я\n" +
                    "2 - " + droid2.getType() + " " + droid2.getName() + " - " + droid2.getHp() + " здоров'я\n" +
                    "3 - " + droid3.getType() + " " + droid3.getName() + " - " + droid3.getHp() + " здоров'я\n" +
                    "4 - назад\n" +
                    "->";
            System.out.println(temp3);
            battleRecord3.append(temp3).append("\n");

            option = read.nextInt();

            switch (option) {
                case 1:
                    if(!droid1.isDead()) {
                        temp3 = "Цей дроїд живий! Зробіть ще 1 вибір.";
                        System.out.println(Colors.red + temp3 + Colors.yellow);
                        battleRecord3.append(temp3).append("\n");

                        chooseReviveTarget(droid1, droid2, droid3, read);
                    }
                    setTeammates(droid1);
                    tmp = 0;
                    break;

                case 2:
                    if(!droid2.isDead()) {
                        temp3 = "Цей дроїд живий! Зробіть ще 1 вибір.";
                        System.out.println(Colors.red + temp3 + Colors.yellow);
                        battleRecord3.append(temp3).append("\n");

                        chooseReviveTarget(droid1, droid2, droid3, read);
                    }
                    setTeammates(droid2);
                    tmp = 0;
                    break;

                case 3:
                    if(!droid3.isDead()) {
                        temp3 = "Цей дроїд живий! Зробіть ще 1 вибір.";
                        System.out.println(Colors.red + temp3 + Colors.yellow  );
                        battleRecord3.append(temp3).append("\n");

                        chooseReviveTarget(droid1, droid2, droid3, read);
                    }
                    setTeammates(droid3);
                    tmp = 0;
                    break;

                case 4:
                    moveHealerUltimate('A', read);
                    break;
                default:
                    temp3 = "Помилка: неправильна опція. Спробуйте ще раз...";
                    System.out.println(Colors.red + temp3 + Colors.yellow);
                    battleRecord3.append(temp3).append("\n");
            }
        }
    }
    public static void chooseHealTarget(Droid droid1, Droid droid2, Droid droid3, Scanner read) {
        int option;

        int tmp = 1;
        while (tmp == 1) {
            temp3 = "Кого ви хочете підлікувати?\n" +
                    "1 - " + droid1.getType() + " " + droid1.getName() + " - " + droid1.getHp() + " здоров'я\n" +
                    "2 - " + droid2.getType() + " " + droid2.getName() + " - " + droid2.getHp() + " здоров'я\n" +
                    "3 - " + droid3.getType() + " " + droid3.getName() + " - " + droid3.getHp() + " здоров'я\n" +
                    "->";
            System.out.println(temp3);
            battleRecord3.append(temp3).append("\n");
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
                    temp3 = "Помилка: неправильна опція. Спробуйте ще раз...";
                    System.out.println(Colors.red + temp3 + Colors.yellow);
                    battleRecord3.append(temp3).append("\n");
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


    public static Droid createDroid(char player, int number, Scanner read) {
        Droid droid;
        if (player == 'A')
        {
            temp3 = "Гравець " + player + ", вибирає ім'я дроїду: ";
            System.out.println(temp3);
            battleRecord3.append(temp3).append("\n");
            String name = read.nextLine();
            while (true)
            {
                temp3 = "Гравець " + player + ", вибирає ім'я дроїду:\n" +
                        "1 - солдат\n" +
                        "2 - танк\n" +
                        "3 - снайпер\n" +
                        "4 - лікар\n" +
                        "5 - переглянути статистику та здібності дроїдів \n" +
                        "->";
                System.out.println(temp3);
                battleRecord3.append(temp3).append("\n");
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
                        System.out.println(StatsInfoOfHeros.stats3v3());
                        break;
                    default:
                        temp3 = "Помилка: неправильна опція. Спробуйте ще раз...";
                        System.out.println(Colors.red + temp3 + Colors.yellow);
                        battleRecord3.append(temp3).append("\n");
                }
            }
        }
        else
        {
            while (true)
            {
                temp3 = "Гравець " + player + ", вибирає ім'я дроїду:\n" +
                        "1 - дракон\n" +
                        "2 - переглянути статистику та здібності босів \n" +
                        "->";
                System.out.println(temp3);
                battleRecord3.append(temp3).append("\n");

                int option = read.nextInt();
                switch (option)
                {
                    case 1:
                        droid = new Dragon();
                        return droid;
                    case 2:
                        System.out.println(StatsInfoOfBoss.bossStats());
                        break;
                    default:
                        temp3 = "Помилка: неправильна опція. Спробуйте ще раз...";
                        System.out.println(Colors.red + temp3 + Colors.yellow);
                        battleRecord3.append(temp3).append("\n");
                }
            }
        }
    }
}