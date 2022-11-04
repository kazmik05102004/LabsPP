package playroom.menu;
import playroom.commands.Command;
import java.util.Scanner;

public class MenuUtils {
    public static final Scanner in = new Scanner(System.in);
    public static void printMenu(Command[] commandArray, String[] nameOfCommandsArray){
        for (int i = 0; i < commandArray.length; i++)
            System.out.println(i + ") - " + nameOfCommandsArray[i]);
        System.out.println("-1) - Вийти");
    }
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

            if (choice == -1)
                break;
            if (choice > -1 && choice < commandArray.length + 1)
                commandArray[choice].execute();
            if(choice < -1 || choice > commandArray.length + 1)
                System.out.println("Не вірний вибір, спробуйте ще раз!");
        }
    }
}