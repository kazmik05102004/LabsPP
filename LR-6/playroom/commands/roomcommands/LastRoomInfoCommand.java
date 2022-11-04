package playroom.commands.roomcommands;

import playroom.commands.Command;
import playroom.room.Room;

public class LastRoomInfoCommand implements Command {
    Room room = new Room();
    @Override
    public void execute() {
        room.lastRoomInfo();
    }
}