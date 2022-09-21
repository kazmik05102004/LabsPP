package game.droids.heros;

import game.droids.Droid;

import static game.battlefield.Battle1v1.battleRecord1;
import static game.battlefield.Battle1v1.temp1;
import static game.battlefield.Battle3v3.battleRecord2;
import static game.battlefield.Battle3v3.temp2;
import static game.battlefield.BattleWithBoss.battleRecord3;
import static game.battlefield.BattleWithBoss.temp3;

public class Soldier extends Droid {

    public Soldier(String name) {
        setName(name);
        setDamage(30);
        setHp(100);
        setMaxhp(100);
        setAccuracy(70);
        setCrit(20);
        setCritdamage(45);
        setType("Солдат");
        setAttacks(0);
    }
    @Override
    public void ultimateAbility1v1(Droid reciever) {
        this.setAccuracy(100);
        this.setCrit(50);
        reciever.setAccuracy(50);
        this.setAttacks(0);
        temp1 = this.getType() + " " + this.getName() + " використав здібність!" +
                " Тепер його точність 100%, шанс критичного удару 50%, точність ворога - 50%!";
        System.out.println(temp1);
        battleRecord1.append(temp1).append("\n");

    }
    @Override
    public void ultimateAbility3v3(Droid ally1, Droid ally2, Droid damageReciever, Droid healReciever) {
        this.setAccuracy(100);
        ally1.setAccuracy(100);
        ally2.setAccuracy(100);
        this.setCrit(40);
        ally1.setCrit(ally1.getCrit() * 2);
        ally2.setCrit(ally2.getCrit() * 2);
        this.setAttacks(0);
        String temp = this.getType() + " " + this.getName() + " використав здібність!" +
                " Тепер вся його команда має точність 100%, і подвоєний шанс критичної атаки!";
        temp2 = this.getType() + " " + this.getName() + " використав здібність!" +
                " Тепер вся його команда має точність 100%, і подвоєний шанс критичної атаки!";
        temp3 = this.getType() + " " + this.getName() + " використав здібність!" +
                " Тепер вся його команда має точність 100%, і подвоєний шанс критичної атаки!";
        System.out.println(temp);
        battleRecord2.append(temp2).append("\n");
        battleRecord3.append(temp3).append("\n");
    }

    @Override
    public String drawHero()
    {
        return "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⡿⠛⠉⠉⣉⣛⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣛⣉⠉⠉⠛⢿⣿⣿\n" +
                "⣿⣿⠁⠄⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣆⠄⠈⣿⣿\n" +
                "⣿⡇⠄⠄⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠄⠄⢸⣿\n" +
                "⣿⡇⠄⠄⠸⣿⣿⣿⣿⣿⣿⡿⠛⠁⠄⠄⠈⠛⢿⣿⣿⣿⣿⣿⣿⠇⠄⠄⢸⣿\n" +
                "⣿⡇⠄⠄⠄⠄⠉⣿⡍⠈⣿⣇⠄⠄⢠⡄⠄⠄⣸⣿⠁⢩⣿⠉⠄⠄⠄⠄⢸⣿\n" +
                "⣿⣧⣄⠄⠄⠄⠄⢻⡇⠄⠈⢿⣦⣠⣿⣿⣄⣴⡿⠁⠄⢸⡿⠄⠄⠄⠄⣠⣼⣿\n" +
                "⣿⣿⣿⣿⣦⣄⡀⢸⡇⠄⠄⠄⠙⠿⠃⠘⠿⠋⠄⠄⠄⢸⡇⢀⣠⣴⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣧⠄⣿⣶⣦⣄⠄⠄⣠⣴⣶⣿⠄⣼⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⠇⠄⠙⢿⣿⣿⣤⣤⣿⣿⡿⠋⠄⠸⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⠄⠄⠄⠈⠉⢹⣿⣿⡏⠉⠁⠄⠄⠄⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⡿⢿⣷⣄⠄⠄⠄⢸⣿⣿⡇⠄⠄⠄⣠⣾⡿⢿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⡉⠄⠄⠙⢿⣷⡄⠄⢸⣿⣿⡇⠄⢠⣾⡿⠋⠄⠄⢉⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣶⣤⣷⣦⣽⣿⣦⡀⣿⣿⢀⣴⣿⣯⣴⣾⣤⣶⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿";
    }
}