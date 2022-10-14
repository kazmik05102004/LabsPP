package playroom.commands.roomCommands;

import playroom.commands.Command;
import playroom.room.Room;

public class CallChildrenCommand implements Command {
    Room room;
    @Override
    public void execute() {
        room.callChildren();
    }
}
