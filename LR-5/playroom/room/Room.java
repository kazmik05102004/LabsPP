package playroom.room;

import playroom.Toy;
import java.util.List;

public class Room {
    public List<Toy> toysInRoom;
    public int money;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    public List<Toy> getToysInRoom() {
        return toysInRoom;
    }
    public void callChildren(){}
    public void backToShop(){}
    public void emotionOfChildren(){}
    public void removeToy(){}
    public void showListOfToys(){}
    public void goShop(){}
    public void lastRoomInfo(){}



}
