package playroom.commands.shopcommands;

import playroom.commands.Command;
import playroom.room.Room;
import playroom.toyshop.ToyShop;

public class ChooseToyCommand implements Command {
    ToyShop shop = new ToyShop();
    @Override
    public void execute() {
        shop.chooseToy(shop.toyShop);
    }
}
