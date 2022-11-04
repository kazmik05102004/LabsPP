package playroom.commands.shopcommands.sortscommands;

import playroom.commands.Command;
import playroom.toyshop.ToyShop;

public class SortByGenderCommand implements Command {
    ToyShop shop = new ToyShop();
    @Override
    public void execute() {
        shop.sortByGender(shop.toyShop);
    }
}
