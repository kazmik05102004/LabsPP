package playroom.commands.shopCommands.sortsCommands;

import playroom.commands.Command;
import playroom.toyShop.ToyShop;

public class SortByPriceCommand implements Command {
    ToyShop shop;
    @Override
    public void execute() {
        shop.sortByPrice(shop.toyShop);
    }
}
