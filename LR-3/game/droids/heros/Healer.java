package game.droids.heros;
import game.droids.Droid;

import static game.ToFile.*;


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
        temp = teammates.getType() + " " + teammates.getName() + " був вилікуваний! Тепер його здоров'я - " + teammates.getHp();
        System.out.println(temp);
        battleRecord.append(temp).append("\n");

    }

    @Override
    public void ultimateAbility3v3(Droid ally1, Droid ally2, Droid damageReciever, Droid healReciever) {
        healReciever.setHp(healReciever.getHp() + 100);
        if(healReciever.getHp() > healReciever.getMaxhp()) {
            healReciever.setHp(healReciever.getMaxhp());
        }
        this.setAttacks(0);
        temp = this.getType() + " " + this.getName() + " використав свою здібність! " +
                "Тепер " + healReciever.getType() + " " + healReciever.getName()  + " має " + healReciever.getHp() + " здоров'я!\n";
        System.out.println(temp);
        battleRecord.append(temp).append("\n");
    }

    @Override
    public void ultimateAbilityBoss(Droid ally1, Droid ally2, Droid damageReciever, Droid healReciever) {
        if(healReciever.isDead())
            healReciever.setHp(50);
        this.setAttacks(0);
        temp = this.getType() + " " + this.getName() + " воскресив " + healReciever.getType() + " " + healReciever.getName() + " своєю здібністю!\n" +
                "Тепер " + healReciever.getType() + " " + healReciever.getName()  + " живий і має " + healReciever.getHp() + " здоров'я!\n";
        System.out.println(temp);
        battleRecord.append(temp).append("\n");
    }

        @Override
    public void ultimateAbility1v1(Droid reciever) {
        this.setHp(this.getMaxhp());
        this.setAttacks(0);
        temp = this.getType() + " " + this.getName() + " використав свою здібність! " +
                " Тепер його здоров'я - " + this.getHp();
        System.out.println(temp);
        battleRecord.append(temp).append("\n");
        }
}
