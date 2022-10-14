package playroom.commands.shopCommands.sortsCommands;

import playroom.commands.Command;
import playroom.toyShop.ToyShop;

public class SortByTypeCommand implements Command {
    ToyShop shop;
    @Override
    public void execute() {
        shop.sortByType(shop.toyShop);
    }
}
