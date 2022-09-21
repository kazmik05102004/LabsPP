package game.Interface;

import game.battlefield.Battle1v1;
import game.battlefield.Battle3v3;
import game.battlefield.BattleWithBoss;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void menu() {
        Scanner read = new Scanner(System.in);
        System.out.println("Виберіть тип гри:\n" +
                "1 - 1v1\n" +
                "2 - 3v3\n" +
                "3 - 3vBoss\n" +
                "4 - передивитись свій останній бій\n" +
                "->");
        int option = read.nextInt();
        read.nextLine();
        switch (option) {
            case 1:
                Battle1v1.start(read);
                break;
            case 2:
                Battle3v3.start(read);
                break;
            case 3:
                BattleWithBoss.start(read);
                break;
            case 4:
                try {
                    BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Віталік\\OneDrive\\Desktop\\BattleRecord.txt"));
                    String line = in.readLine();
                    while (line != null) {
                        System.out.println(line);
                        line = in.readLine();
                    }
                    in.close();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;

            default:
                System.out.println("Неможлива опція. Будь ласка, спробуйте ще раз.");
                menu();
        }

        int check;
        System.out.println("\nХочете спробувати ще раз? (1 - ще раз, 0 - вийти)");
        check = read.nextInt();
        read.nextLine();
        if (check == 1) {
            menu();
        }
    }
}
