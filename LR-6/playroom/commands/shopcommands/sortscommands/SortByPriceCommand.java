package playroom.commands.shopcommands.sortscommands;

import playroom.commands.Command;
import playroom.toyshop.ToyShop;

public class SortByPriceCommand implements Command {
    ToyShop shop = new ToyShop();
    @Override
    public void execute() {
        shop.sortByPrice(shop.toyShop);
    }
}
