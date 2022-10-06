package game.droids.heros;

import game.droids.Droid;
import static game.ToFile.*;


public class Sniper extends Droid {

    public Sniper(String name) {
        setName(name);
        setDamage(45);
        setHp(70);
        setMaxhp(70);
        setAccuracy(90);
        setCrit(35);
        setCritdamage(60);
        setType("Снайпер");
        setAttacks(0);
    }

    @Override
    public void ultimateAbility3v3(Droid ally1, Droid ally2, Droid damageReciever, Droid healReciever) {
        damageReciever.setHp(damageReciever.getHp() - 100);
        this.setAttacks(0);
        temp = this.getType() + " " + this.getName() + " використав свою здібність! " +
                "Тепер життя його жертви " + damageReciever.getType() + " " + damageReciever.getName() + " - " + damageReciever.getHp();
        System.out.println(temp);
        battleRecord.append(temp).append("\n");
    }

    @Override
    public void ultimateAbility1v1(Droid reciever) {
        this.setHp(getHp() + 30);
        if(this.getHp() > this.getMaxhp())
            this.setHp(this.getMaxhp());
        reciever.setHp(reciever.getHp() - 30);
        this.setAttacks(0);
        temp = this.getType() + " " + this.getName() + " використав свою здібність! " +
                "Тепер його здоров'я - " + this.getHp() + ", а здоров'я його опонента - " + reciever.getHp();
        System.out.println(temp);
        battleRecord.append(temp).append("\n");
    }
}
