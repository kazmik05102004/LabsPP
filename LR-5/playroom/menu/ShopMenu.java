package playroom.menu;

import playroom.commands.Command;
import playroom.commands.shopCommands.*;
import playroom.commands.shopCommands.sortsCommands.*;
import static playroom.menu.MenuUtils.printMenu;

public class ShopMenu {
    static String[] nameOfCommandsArray = { "Переглянути магазин", "Відсортувати іграшки за ціною", "Відсортувати іграшки за типом," +
            "Відсторувати іграшки за віковою категорією", "Відсортувати ігришки для хлопчиків/дівчат"};

    public static void callShopMenu(){
        printMenu(createShopCommandArray(), nameOfCommandsArray);
    }

    private static Command[] createShopCommandArray() {
        Command[] commandArray = new Command[8];
        int i = 0;
        commandArray[i] = new ShowShopCommand();
        commandArray[i++] = new SortByPriceCommand();
        commandArray[i++] = new SortByTypeCommand();
        commandArray[i++] = new SortByAgeCategoryCommand();
        commandArray[i++] = new SortByGenderCommand();
        commandArray[i++] = new FindToyCommand();

        return commandArray;
    }
}