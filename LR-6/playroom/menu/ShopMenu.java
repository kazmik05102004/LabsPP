package playroom.menu;

import playroom.commands.Command;
import playroom.commands.shopcommands.*;
import playroom.commands.shopcommands.sortscommands.*;

import static playroom.menu.MenuUtils.menuLoop;

public class ShopMenu {
    static String[] nameOfCommandsArray = { "Переглянути магазин", "Відсортувати іграшки за ціною", "Відсортувати іграшки за типом",
            "Відсортувати іграшки за розміром", "Відсортувати ігришки для хлопчиків/дівчат",
             "Повернутись в кімнату", "Вибрати іграшку"};

    public static void callShopMenu(){
        menuLoop(createShopCommandArray(), nameOfCommandsArray);
    }

    private static Command[] createShopCommandArray() {
        Command[] commandArray = {new ShowShopCommand(), new SortByPriceCommand(), new SortByTypeCommand(), new SortBySizeCommand(),
                new SortByGenderCommand(),  new BackToRoomCommand(), new ChooseToyCommand()};
        return commandArray;
    }
}