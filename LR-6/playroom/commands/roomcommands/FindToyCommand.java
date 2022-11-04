package playroom.commands.roomcommands;

import playroom.commands.Command;
import playroom.room.Room;
import playroom.toyshop.ToyShop;

public class FindToyCommand implements Command {
    Room room = new Room();
    @Override
    public void execute() {
        room.findToy(room.getToysInRoom());
    }
}
