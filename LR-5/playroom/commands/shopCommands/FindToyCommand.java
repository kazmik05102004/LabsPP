package playroom.commands.shopCommands;

import playroom.commands.Command;
import playroom.toyShop.ToyShop;

public class FindToyCommand implements Command {
    ToyShop shop;
    @Override
    public void execute() {
        shop.findToy(shop.toyShop);
    }
}
