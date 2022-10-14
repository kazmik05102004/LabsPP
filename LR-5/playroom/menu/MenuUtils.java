package playroom.menu;
import playroom.commands.Command;
import java.util.Scanner;

public class MenuUtils {
    public static final Scanner in = new Scanner(System.in);

    public static void menuLoop(Command[] commandArray, String[] nameOfCommandsArray){
        int choice;

        while (true) {
            printMenu(commandArray, nameOfCommandsArray);
            try {
                System.out.print("Ваш вибір >>> ");
                choice = in.nextInt();
            } catch (Exception e) {
                in.nextLine();
                choice = -2;
            }

            if (choice == 0)
                break;
            if (choice > 0 && choice < commandArray.length + 1)
                commandArray[choice + 1].execute();
            if(choice < 0 || choice > commandArray.length + 1)
                System.out.println("Не вірний вибір, спробуйте ще раз!");
        }
    }

    public static void printMenu(Command[] commandArray, String[] nameOfCommandsArray){
        for (int i = 0; i < commandArray.length; i++)
            System.out.println("[" + (i + 1) + "] - " + nameOfCommandsArray[i]);
        System.out.println("[0] - Вийти");
    }
}