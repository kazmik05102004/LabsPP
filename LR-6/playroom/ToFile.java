package playroom;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static playroom.room.Room.toysInRoom;

public class ToFile {
    private static StringBuilder record = new StringBuilder();
    public static void toFile() {
        for(Toy toy: toysInRoom) {
            record.append(toy.toString());
        }
        try {
            PrintStream ps = new PrintStream(new File("C:\\Users\\Віталік\\OneDrive\\Desktop\\LastRoom.txt"));
            PrintStream standard = System.out;
            System.setOut(ps);
            ps.print(record.toString());
            System.setOut(standard);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
