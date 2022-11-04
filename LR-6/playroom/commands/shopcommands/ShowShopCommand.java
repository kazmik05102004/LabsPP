package playroom.commands.shopcommands;

import playroom.commands.Command;
import playroom.toyshop.ToyShop;

import java.io.FileNotFoundException;

public class ShowShopCommand implements Command {
    ToyShop shop = new ToyShop();
    @Override
    public void execute() {
        shop.showShop(shop.toyShop);
    }
}
