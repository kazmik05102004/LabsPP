package playroom.commands.shopcommands;

import playroom.commands.Command;
import playroom.room.Room;

public class FindToyCommand implements Command {
    Room room = new Room();
    @Override
    public void execute() {
        room.findToy(room.getToysInRoom());
    }
}
