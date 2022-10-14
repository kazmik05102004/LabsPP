package playroom.commands.shopCommands.sortsCommands;

import playroom.commands.Command;
import playroom.toyShop.ToyShop;

public class SortByGenderCommand implements Command {
    ToyShop shop;
    @Override
    public void execute() {
        shop.sortByGender(shop.toyShop);
    }
}
