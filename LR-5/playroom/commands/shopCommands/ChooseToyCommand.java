package playroom.commands.shopCommands;

import playroom.commands.Command;
import playroom.room.Room;
import playroom.toyShop.ToyShop;

public class ChooseToyCommand implements Command {
    Room room;
    ToyShop shop;
    @Override
    public void execute() {
        shop.chooseToy(shop.toyShop, room.toysInRoom);
    }

}
