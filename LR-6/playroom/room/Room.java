package playroom.room;

import playroom.Toy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static playroom.menu.MainMenu.callMainMenu;
import static playroom.menu.ShopMenu.callShopMenu;

public class Room {
    public static List<Toy> toysInRoom = new ArrayList<>();
    public static int money = 4000;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List<Toy> getToysInRoom() {
        return toysInRoom;
    }

    public void setToysInRoom(List<Toy> toysInRoom) {
        this.toysInRoom.addAll(toysInRoom);
    }

    public void removeToy(List<Toy> toysInRoom) {
        showListOfToys();
        System.out.println("Введіть назву іграшки, яку хочете повернути: ");
        Scanner scanner = new Scanner(System.in);
        String toyInRoom = scanner.nextLine();
        for (Toy toy : toysInRoom)
            if (toy.getName().equals(toyInRoom)) {
                money = money + Integer.parseInt(toy.getPrice());
                toysInRoom.remove(toy);
            }
        System.out.println("\nТепер у вас " + money + " грошей\n");
    }

    public void findToy(List<Toy> toysInRoom) {
        System.out.println("Оберіть за чим хочете знайти іграшку:");
        System.out.println("" +
                "1) назва\n" +
                "2) тип\n" +
                "3) стать дитини\n" +
                "4) розміром\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть ваш вибір: ");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1:
                printFoundToys(toysInRoom, "назва");
                break;
            case 2:
                printFoundToys(toysInRoom, "тип");
                break;
            case 3:
                printFoundToys(toysInRoom, "стать дитини");
                break;
            case 4:
                printFoundToys(toysInRoom, "розміром");
                break;
        }
    }

    public void printFoundToys(List<Toy> toysInRoom, String specifier) {
        Scanner scanner = new Scanner(System.in);
        if (specifier.equals("назва")) {
            System.out.println("Введіть назву іграшки: ");
            String choose = scanner.nextLine();
            for (Toy toy : toysInRoom)
                if (toy.getName().equals(choose))
                    System.out.println(toy);
        } else if (specifier.equals("тип")) {
            System.out.println("" +
                    "1) ляльки\n" +
                    "2) лего\n" +
                    "3) плюшеві іграшки\n" +
                    "4) машинки\n" +
                    "5) настільні ігри\n" +
                    "6) головоломки\n" +
                    "7) назад\n");
            System.out.println("Введіть ваш вибір: ");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    printToys(toysInRoom, "лялька");
                    break;
                case 2:
                    printToys(toysInRoom, "лего");
                    break;
                case 3:
                    printToys(toysInRoom, "плюшева іграшка");
                    break;
                case 4:
                    printToys(toysInRoom, "машина");
                    break;
                case 5:
                    printToys(toysInRoom, "настільна гра");
                    break;
                case 6:
                    printToys(toysInRoom, "головоломка");
                    break;
                case 7:
                    callMainMenu();
                    break;
            }
        }
        if (specifier.equals("стать дитини")) {
            System.out.println("" +
                    "1) для хлопчика\n" +
                    "2) для дівчинки\n" +
                    "3) для хлопчика і дівчинки\n" +
                    "4) назад\n");
            System.out.println("Введіть ваш вибір: ");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    printToys(toysInRoom, "хлопчика");
                    break;
                case 2:
                    printToys(toysInRoom, "дівчинки");
                    break;
                case 3:
                    printToys(toysInRoom, "хлопчика і дівчинки");
                    break;
                case 4:
                    callMainMenu();
                    break;
            }
        }
        if (specifier.equals("розміром")) {
            System.out.println("" +
                    "1) малий\n" +
                    "2) середній\n" +
                    "3) великий\n" +
                    "4) назад\n");
            System.out.println("Введіть ваш вибір: ");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    printToys(toysInRoom, "малий");
                    break;
                case 2:
                    printToys(toysInRoom, "середній");
                    break;
                case 3:
                    printToys(toysInRoom, "великий");
                    break;
                case 4:
                    callMainMenu();
                    break;
            }
        }
    }

    public void printToys(List<Toy> toysInRoom, String specifier) {
        for (Toy toy : toysInRoom)
            if (toy.getType().equals(specifier) || toy.getGender().equals(specifier) || toy.getSize().equals(specifier))
                System.out.println(toy);
    }

    public void showListOfToys() {
        for (Toy toy : toysInRoom)
            System.out.println(toy);
    }

    public static void goShop() {
        callShopMenu();
    }

    public void lastRoomInfo() {
        try {
            BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Віталік\\OneDrive\\Desktop\\LastRoom.txt"));
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
    }
}
