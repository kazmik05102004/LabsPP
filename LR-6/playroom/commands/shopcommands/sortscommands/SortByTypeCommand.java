package playroom.commands.shopcommands.sortscommands;

import playroom.commands.Command;
import playroom.toyshop.ToyShop;

public class SortByTypeCommand implements Command {
    ToyShop shop = new ToyShop();
    @Override
    public void execute() {
        shop.sortByType(shop.toyShop);
    }
}
