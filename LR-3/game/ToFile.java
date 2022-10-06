package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class ToFile {

    public static StringBuilder battleRecord = new StringBuilder();
    public static String temp;
    public static void toFile(StringBuilder battleRecord) {
        try {
            PrintStream ps = new PrintStream(new File("C:\\Users\\Віталік\\OneDrive\\Desktop\\BattleRecord.txt"));
            PrintStream standard = System.out;
            System.setOut(ps);
            ps.print(battleRecord.toString());
            System.setOut(standard);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
