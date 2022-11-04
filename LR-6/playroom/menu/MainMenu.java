package playroom.menu;

import playroom.commands.Command;
import playroom.commands.roomcommands.*;
import playroom.room.Room;

import static playroom.menu.MenuUtils.menuLoop;

public class MainMenu {
    public static void callMainMenu() {
        menuLoop(createMainCommandArray(), nameOfCommandsArray());
    }
    private static Command[] createMainCommandArray(){
        return new Command[]{ new GoShopCommand(), new ShowListOfToysComman(), new FindToyCommand(),
                    new LastRoomInfoCommand()};
    }
    private static String[] nameOfCommandsArray() {
        return new String[]{"Зайти в магазин",
                    "Переглянути список іграшок в кімнаті", "Знайти іграшку",
                    "Переглянути інформацію за останньо створену кімнату"};
    }
}