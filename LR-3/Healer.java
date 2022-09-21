package game.droids.heros;

import game.droids.Droid;

import static game.battlefield.Battle1v1.battleRecord1;
import static game.battlefield.Battle1v1.temp1;
import static game.battlefield.Battle3v3.battleRecord2;
import static game.battlefield.Battle3v3.temp2;
import static game.battlefield.BattleWithBoss.battleRecord3;
import static game.battlefield.BattleWithBoss.temp3;


public class Healer extends Droid {

    public Healer(String name) {
        setName(name);
        setDamage(10);
        setHp(100);
        setMaxhp(100);
        setAccuracy(70);
        setCrit(25);
        setCritdamage(30);
        setType("Лікар");
        setAttacks(0);
    }

    @Override
    public void healing(Droid teammates) {
        teammates.setHp(teammates.getHp() + 30);
        if (teammates.getHp() > teammates.getMaxhp())
            teammates.setHp(teammates.getMaxhp());
        this.setAttacks(getAttacks() + 1);
        String temp = teammates.getType() + " " + teammates.getName() + " був вилікуваний! Тепер його здоров'я - " + teammates.getHp();
        temp1 = teammates.getType() + " " + teammates.getName() + " був вилікуваний! Тепер його здоров'я - " + teammates.getHp();
        temp2 = teammates.getType() + " " + teammates.getName() + " був вилікуваний! Тепер його здоров'я - " + teammates.getHp();
        temp3 = teammates.getType() + " " + teammates.getName() + " був вилікуваний! Тепер його здоров'я - " + teammates.getHp();
        System.out.println(temp);



        battleRecord1.append(temp1).append("\n");
        battleRecord2.append(temp2).append("\n");
        battleRecord3.append(temp3).append("\n");

    }

    @Override
    public void ultimateAbility3v3(Droid ally1, Droid ally2, Droid damageReciever, Droid healReciever) {
        healReciever.setHp(healReciever.getHp() + 100);
        if(healReciever.getHp() > healReciever.getMaxhp()) {
            healReciever.setHp(healReciever.getMaxhp());
        }
        this.setAttacks(0);
        temp2 = this.getType() + " " + this.getName() + " використав свою здібність! " +
                "Тепер " + healReciever.getType() + " " + healReciever.getName()  + " має " + healReciever.getHp() + " здоров'я!\n";
        System.out.println(temp2);
        battleRecord2.append(temp2).append("\n");
    }

    @Override
    public void ultimateAbilityBoss(Droid ally1, Droid ally2, Droid damageReciever, Droid healReciever) {
        if(healReciever.isDead())
            healReciever.setHp(50);
        this.setAttacks(0);
        temp3 = this.getType() + " " + this.getName() + " воскресив " + healReciever.getType() + " " + healReciever.getName() + " своєю здібністю!\n" +
                "Тепер " + healReciever.getType() + " " + healReciever.getName()  + " живий і має " + healReciever.getHp() + " здоров'я!\n";
        System.out.println(temp3);
        battleRecord3.append(temp3).append("\n");
    }

        @Override
    public void ultimateAbility1v1(Droid reciever) {
        this.setHp(this.getMaxhp());
        this.setAttacks(0);
        temp1 = this.getType() + " " + this.getName() + " використав свою здібність! " +
                " Тепер його здоров'я - " + this.getHp();
        System.out.println(temp1);
            battleRecord1.append(temp1).append("\n");
        }

    @Override
    public String drawHero()
    {
        return "████████████████▀▀▀▀▀█████████████████\n" +
                "████████████████░▄▄▄░█████████████████\n" +
                "████████████████░█░█░█████████████████\n" +
                "████████████░▄▄▄▄█░█▄▄▄▄░█████████████\n" +
                "████████████░▀▀▀▀█░█▀▀▀▀░█████████████\n" +
                "████████████████░█░█░█████████████████\n" +
                "████████████████░█░█░█████████████████\n" +
                "███▀▀▀▀▀▀▀▀▀▀▀▀▀░█░█░▀▀▀▀▀▀▀▀▀▀▀▀▀▀███\n" +
                "███░██████████████░██████████████░░███\n" +
                "███▄▄▄▄▄▄▄▄▄▄▄▄▄░█░█░▄▄▄▄▄▄▄▄▄▄▄▄▄▄███\n" +
                "████████████████░█░█░█████████████████\n" +
                "████████████████░█░█░█████████████████\n" +
                "████████████████░█░█░█████████████████\n" +
                "████████████████░█░█░█████████████████\n" +
                "████████████▀███░█░█░█████████████████\n" +
                "████████████░▄▀▀░█░█░█████████████████\n" +
                "████████████░▀██▄█░█░█████████████████\n" +
                "██████████████▄▀▀█░█░▀████████████████\n" +
                "████████████████░█▀███▄▄▀█████████████\n" +
                "████████████████░█░█░▀▀█░█████████████\n" +
                "████████████████░█░█░██▄░█████████████\n" +
                "████████████████░█░█░█████████████████\n" +
                "████████████████░█░█░█████████████████\n" +
                "████████████████░█░█░█████████████████\n" +
                "████████████████░▀▀▀░█████████████████\n" +
                "██████████████████████████████████████";
    }
}
