package game.droids.boss;

import game.droids.Droid;

import static game.ToFile.battleRecord;
import static game.ToFile.temp;


public class Dragon extends Droid {
    public Dragon() {
        setName("Дракон");
        setDamage(30);
        setHp(500);
        setMaxhp(500);
        setAccuracy(70);
        setCrit(15);
        setCritdamage(80);
        setType("Бос");
        setAttacks(0);
    }
    @Override
    public boolean isUltimate() {
        if (this.attacks >= 3)
            return true;
        else
            return false;
    }

    public void ultimateAbilityOfBoss(Droid ally1, Droid ally2, Droid ally3) {
        this.setAccuracy(100);
        ally1.setAccuracy(50);
        ally2.setAccuracy(50);
        this.setCrit(50);
        ally1.setAttacks(ally1.getAttacks() - 5);
        ally2.setAttacks(ally2.getAttacks() - 5);
        ally3.setAttacks(ally3.getAttacks() - 5);
        ally1.setHp(ally1.getHp() - 20);
        ally2.setHp(ally2.getHp() - 20);
        ally3.setHp(ally2.getHp() - 20);
        this.setAttacks(0);

        temp = this.getType() + " " + this.getName() + " використав здібність!" +
                " Тепер вся його точність 100%, шанс критичного удару 50%!\n Усі у вашій команді отримали удар на 20 урону і їхня атака зменшилась на 5";
        System.out.println(temp);
        battleRecord.append(temp).append("\n");
    }
}
