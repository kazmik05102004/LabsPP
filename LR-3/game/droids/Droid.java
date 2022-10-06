    package game.droids;
    import game.Interface.Colors;
    import java.util.Random;
    import static game.ToFile.*;

    public class Droid {
        private String name;
        private int hp;
        private int damage;
        private boolean ultimate;
        private int accuracy;
        private int crit;
        private int critdamage;
        private String type;
        protected int attacks;
        private int maxhp;
        private boolean dead;

        private Droid droid;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getHp() {
            return hp;
        }

        public void setHp(int hp) {
            this.hp = hp;
        }

        public int getDamage() {
            return damage;
        }

        public void setDamage(int damage) {
            this.damage = damage;
        }

        public boolean isUltimate() {
            if (this.attacks >= 2)
                return true;
            else
                return false;
        }

        public int getAccuracy() {
            return accuracy;
        }

        public void setAccuracy(int accuracy) {
            this.accuracy = accuracy;
        }

        public int getCrit() {
            return crit;
        }

        public void setCrit(int crit) {
            this.crit = crit;
        }

        public int getCritdamage() {
            return critdamage;
        }

        public void setCritdamage(int critdamage) {
            this.critdamage = critdamage;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getAttacks() {
            return attacks;
        }

        public void setAttacks(int attacks) {
            this.attacks = attacks;
        }

        public int getMaxhp() {
            return maxhp;
        }

        public void setMaxhp(int maxhp) {
            this.maxhp = maxhp;
        }

        public boolean isDead() {
            if (this.getHp() < 1)
                return true;
            else
                return false;
        }

        public void damages(Droid reciever) {
            Random rand = new Random();
            if (rand.nextInt(100) < getAccuracy()) {
                if (rand.nextInt(100) < getCrit()) {
                    reciever.setHp(reciever.getHp() - getCritdamage());
                    setAttacks(getAttacks() + 1);
                    temp = "Критичний удар! "
                            + this.getName() + " пошкодив " + reciever.getName() + " на " + this.getCritdamage() + " здоров'я! "
                            + reciever.getName() + " має " + reciever.getHp() + " здоров'я\n";
                    System.out.println(Colors.RED + temp + Colors.YELLOW);
                    battleRecord.append(temp).append("\n");

                } else {
                    reciever.setHp(reciever.getHp() - getDamage());
                    this.setAttacks(getAttacks() + 1);
                    temp = "Удар! "
                            + this.getName() + " пошкодив " + reciever.getName() + " на " + this.getDamage() + " здоров'я! "
                            + reciever.getName() + " має " + reciever.getHp() + " здоров'я\n";
                    System.out.println(Colors.RED + temp + Colors.YELLOW);
                    battleRecord.append(temp).append("\n");

                }
            } else {
                temp = "Промах! " + this.name + " не влучив у свою ціль! "
                        + reciever.name + " все ще має " + reciever.getHp() + " здоров'я\n";
                System.out.println( Colors.RED + temp + Colors.YELLOW);
                battleRecord.append(temp).append("\n");
            }
        }

        public void healing(Droid reciever) {

        }

        public void ultimateAbility1v1(Droid reciever) {

        }

        public void ultimateAbility3v3(Droid ally1, Droid ally2, Droid damageReciever, Droid healReciever) {

        }

        public void ultimateAbilityBoss(Droid ally1, Droid ally2, Droid damageReciever, Droid healReciever) {

        }
        public void ultimateAbilityOfBoss(Droid droid1, Droid droid2, Droid droid3) {
        }
    }