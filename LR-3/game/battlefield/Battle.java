package game.battlefield;

import game.Interface.Colors;
import game.droids.Droid;
import game.droids.heros.Healer;
import game.droids.heros.Sniper;
import game.droids.heros.Soldier;
import game.droids.heros.Tank;

import java.util.Scanner;

import static game.ToFile.battleRecord;
import static game.ToFile.temp;

public class Battle {
    protected static Droid droidA1;
    protected static Droid droidA2;
    protected static Droid droidA3;
    protected static Droid droidB1;
    protected static Droid droidB2;
    protected static Droid droidB3;
    protected static Droid droidBoss;
    protected static Droid[] yourTeam = new Droid[3];
    protected static Droid teammates;
    protected static Droid attacker;
    protected static Droid reciever;
    protected static Droid ally1;
    protected static Droid ally2;

    public static void setYourTeam(Droid droid1, Droid droid2, Droid droid3) {
        yourTeam[0] = droid1;
        yourTeam[1] = droid2;
        yourTeam[2] = droid3;
    }

    public static void setTeammates(Droid teammates) {
        Battle.teammates = teammates;
    }

    public static void setAttacker(Droid attacker) {
        Battle.attacker = attacker;
    }

    public static void setReciever(Droid reciever) {
        Battle.reciever = reciever;
    }

    public static void setAlly1(Droid ally1) {
        Battle.ally1 = ally1;
    }

    public static void setAlly2(Droid ally2) {
        Battle.ally2 = ally2;
    }
/*public static void setTeammates(Droid teammate) {
        teammates = teammate;
    }

    public static void setAttacker(Droid attacker_) {
        attacker = attacker_;
    }

    public static void setReciever(Droid reciever_) {
        reciever = reciever_;
    }

    public static Droid[] getYourTeam() {
        return yourTeam;
    }

    public static void setAlly1(Droid ally1_) {
        ally1 = ally1_;
    }

    public static void setAlly2(Droid ally2_) {
        ally2 = ally2_;
    }*/

    public static void deadDroid() {
        temp = "Цей дроїд мертвий! Виберіть іншого дроїда.";
        System.out.println(Colors.RED + temp + Colors.YELLOW);
        battleRecord.append(temp).append("\n");

    }

    public static void errorOption() {
        temp = "Помилка: неправильна опція. Спробуйте ще раз...";
        System.out.println(Colors.RED + temp + Colors.YELLOW);
        battleRecord.append(temp).append("\n");
    }

    public static Droid createDroid(char player, Scanner read) {
        Droid droid;
        temp = "Гравець " + player + ", вибирає ім'я дроїду: ";
        System.out.println(temp);
        battleRecord.append(temp).append("\n");
        String name = read.nextLine();

        while(true) {
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
                    System.out.println(stats());
                    break;
                default:
                    errorOption();
            }
        }
    }

    public static String stats() {
        return "1v1\n" +
                "Статистика:\n" +
                "Тип дроїда:\t|Здоров'я:\t|Шкода:\t|Точність:\t|Шанс критичного удару:\t|Критична шкода:\t|Лікування:\n" +
                "Солдат\t\t|100\t|30\t\t\t|70\t\t\t|20%\t\t\t|45\t\t\t\t|-\n" +
                "Танк\t\t|200\t|10\t\t\t|80\t\t\t|30%\t\t\t|30\t\t\t\t|-\n" +
                "Снайпер\t\t|70\t\t|45\t\t\t|90\t\t\t|35%\t\t\t|60\t\t\t\t|-\n" +
                "Лікар\t\t|60\t\t|10\t\t\t|70\t\t\t|25%\t\t\t|30\t\t\t\t|30\n\n" +
                "3v3 Ультимативні здібності:\n" +
                "Солдат: Збільшує точність до 100% і подвоює шанс нанесення критичного удару собі та всім союзникам\n" +
                "Танк: Збільшує HP до 150% поточного HP собі та всім союзникам\n" +
                "Снайпер: Завдає 100 шкоди обраному супернику\n" +
                "Лікар: Лікує обраного союзника на 100 HP (може оживити мертвого союзника у битві проти боса)\n\n\n" +

                "3v3\n" +
                "Статистика:\n" +
                "Тип дроїда:\t|Здоров'я:\t|Шкода:\t|Точність:\t|Шанс критичного удару:\t|Критична шкода:\t|Лікування:\n" +
                "Солдат\t\t|100\t|30\t\t\t|70\t\t\t|20%\t\t\t|45\t\t\t\t|-\n" +
                "Танк\t\t|200\t|10\t\t\t|80\t\t\t|30%\t\t\t|30\t\t\t\t|-\n" +
                "Снайпер\t\t|70\t\t|45\t\t\t|90\t\t\t|35%\t\t\t|60\t\t\t\t|-\n" +
                "Лікар\t\t|60\t\t|10\t\t\t|70\t\t\t|25%\t\t\t|30\t\t\t\t|30\n\n" +
                "3v3 Ультимативні здібності:\n" +
                "Солдат: Збільшує точність до 100% і подвоює шанс нанесення критичного удару собі та всім союзникам\n" +
                "Танк: Збільшує HP до 150% поточного HP собі та всім союзникам\n" +
                "Снайпер: Завдає 100 шкоди обраному супернику\n" +
                "Лікар: Лікує обраного союзника на 100 HP (може оживити мертвого союзника у битві проти боса)\n";
    }
}