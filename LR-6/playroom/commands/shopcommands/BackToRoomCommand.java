package playroom.commands.shopcommands;

import playroom.commands.Command;
import playroom.room.Room;
import playroom.toyshop.ToyShop;

public class BackToRoomCommand implements Command {
    ToyShop shop = new ToyShop();
    @Override
    public void execute() {
        shop.backToRoom();
    }

}
