package playroom.commands.roomCommands;

import playroom.commands.Command;
import playroom.room.Room;

public class LastRoomInfoCommand implements Command {
    Room room;
    @Override
    public void execute() {
        room.lastRoomInfo();
    }
}