package playroom.commands.shopCommands.sortsCommands;

import playroom.commands.Command;
import playroom.toyShop.ToyShop;

public class SortByAgeCategoryCommand implements Command {
    ToyShop shop;
    @Override
    public void execute() {
        shop.sortByAgeCategory(shop.toyShop);
    }
}
