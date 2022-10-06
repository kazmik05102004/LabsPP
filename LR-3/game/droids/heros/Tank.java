package game.droids.heros;
import game.droids.Droid;

import static game.ToFile.*;


public class Tank extends Droid {

    public Tank(String name) {
        setName(name);
        setDamage(10);
        setHp(200);
        setMaxhp(300);
        setAccuracy(80);
        setCrit(30);
        setCritdamage(30);
        setType("Танк");
        setAttacks(0);
    }

    @Override
    public void ultimateAbility3v3(Droid ally1, Droid ally2, Droid damageReciever, Droid healReciever) {
        this.setHp(this.getHp() + (this.getHp() / 2));
        if(this.getHp() > this.getMaxhp())
            this.setHp(this.getMaxhp());
        ally1.setHp(ally1.getHp() + (ally1.getHp() / 2));
        if(ally1.getHp() > ally1.getMaxhp())
            ally1.setHp(ally1.getMaxhp());
        ally2.setHp(ally2.getHp() + (ally2.getHp() / 2));
        if(ally2.getHp() > ally2.getMaxhp())
            ally2.setHp(ally2.getMaxhp());
        this.setAttacks(0);

        temp = this.getType() + " " + this.getName() + " використав свою здібність! " +
                "Тепер його здоров'я - " + this.getHp() + ", " +
                ally1.getType() + " " + ally1.getName() + " - " + ally1.getHp() + ", " +
                ally2.getType() + " " + ally2.getName() + " - " + ally2.getHp() + ".";
        System.out.println(temp);
        battleRecord.append(temp).append("\n");
    }

    @Override
    public void ultimateAbility1v1(Droid reciever) {
        this.setHp(this.getHp() + (this.getHp() / 2));
        if(this.getHp() > this.getMaxhp())
            this.setHp(this.getMaxhp());
        this.setAttacks(0);
        temp = this.getType() + " " + this.getName() + " використав здібність!" +
                " Тепер його здоров'я - " + this.getHp();
        System.out.println(temp);
        battleRecord.append(temp).append("\n");

    }
}
