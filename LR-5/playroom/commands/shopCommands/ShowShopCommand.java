package playroom.commands.shopCommands;

import playroom.commands.Command;
import playroom.toyShop.ToyShop;

public class ShowShopCommand implements Command {
    ToyShop shop;
    @Override
    public void execute() {
        shop.showShop(shop.toyShop);
    }
}
