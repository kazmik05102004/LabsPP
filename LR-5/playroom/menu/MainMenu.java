package playroom.menu;

import playroom.commands.Command;
import playroom.commands.roomCommands.*;
import playroom.room.Room;

import static playroom.menu.MenuUtils.menuLoop;

public class MainMenu {
    public static void callMainMenu() {
        menuLoop(createMainCommandArray(), nameOfCommandsArray());
    }

    private static Command[] createMainCommandArray(){
        Room room = new Room();
        if (room.getToysInRoom() == null)
            return new Command[]{ new GoShopCommand(), new LastRoomInfoCommand()};
        else
            return new Command[]{ new GoShopCommand(), new ShowListOfToysComman(), new CallChildrenCommand()};
    }
    private static String[] nameOfCommandsArray(){
        Room room = new Room();
        if (room.getToysInRoom() == null)
            return new String[]{ "Зайти в магазин", "Переглянути інформацію за останньо створену кімнату"};
        else
            return new String[]{ "Зайти в магазин", "Переглянути список іграшок в кімнаті", "Покликати дітей"};
    }
}