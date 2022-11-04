package playroom.toyshop;

import playroom.Toy;
import playroom.room.Room;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static playroom.menu.MainMenu.callMainMenu;
import static playroom.menu.ShopMenu.callShopMenu;
import static playroom.room.Room.money;
import static playroom.room.Room.toysInRoom;
import static playroom.toyshop.SortShopUtils.*;

public class ToyShop {
    public static List<Toy> toyShop = new ArrayList<>();

    public static List<Toy> createShop() throws FileNotFoundException {
        String path = "C:\\Users\\Віталік\\OneDrive\\Desktop\\Toys.txt";
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        String[] array = new String[5];
        String name; String type;
        String price; String gender;
        String size; String line;
        while (scanner.hasNextLine())
        {
            line = scanner.nextLine();
            array = line.split(",");

            name = array[0];
            type = array[1];
            price = array[2];
            gender = array[3];
            size = array[4];

            Toy toy = new Toy(name, type, price, gender, size);
            toyShop.add(toy);
        }
        return toyShop;
    }

    public void sortByType(List<Toy> shop) {
        System.out.println("" +
                "1) ляльки\n" +
                "2) лего\n" +
                "3) плюшеві іграшки\n" +
                "4) машинки\n" +
                "5) настільні ігри\n" +
                "6) головоломки\n" +
                "7) назад\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть ваш вибір: ");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    searchToys(shop, "лялька");
                    break;
                case 2:
                    searchToys(shop, "лего");
                    break;
                case 3:
                    searchToys(shop, "плюшева іграшка");
                    break;
                case 4:
                    searchToys(shop, "машина");
                    break;
                case 5:
                    searchToys(shop, "настільна гра");
                    break;
                case 6:
                    searchToys(shop, "головоломка");
                    break;
                case 7:
                    callShopMenu();
                    break;
            }
        choose(shop);
    }

    public void sortByGender(List<Toy> shop){
        System.out.println("" +
                "1) для хлопчика\n" +
                "2) для дівчинки\n" +
                "3) для хлопчика і дівчинки\n" +
                "4) назад\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть ваш вибір: ");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1:
                searchToys(shop, "хлопчика");
                break;
            case 2:
                searchToys(shop, "дівчинки");
                break;
            case 3:
                searchToys(shop, "хлопчика і дівчинки");
                break;
            case 4:
                callShopMenu();
                break;
        }
        choose(shop);
    }
    public void sortBySize(List<Toy> shop){
        System.out.println("" +
                "1) малий\n" +
                "2) середній\n" +
                "3) великий\n" +
                "4) назад\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть ваш вибір: ");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1:
                searchToys(shop, "малий");
                break;
            case 2:
                searchToys(shop, "середній");
                break;
            case 3:
                searchToys(shop, "великий");
                break;
            case 4:
                callShopMenu();
                break;
        }
        choose(shop);
    }
    public void sortByPrice(List<Toy> shop){
        Collections.sort(shop, new SortByPrice());
        for(Toy toy : shop)
            System.out.println(toy);
    }
    public void backToRoom(){callMainMenu();}

    public void showShop(List<Toy> shop){
        for (Toy toy: shop)
            System.out.println(toy);
    }

    public static List<Toy> chooseToy(List<Toy> shop){
        System.out.println("Введіть назву іграшки, яку хочете купити: ");
        Scanner scanner = new Scanner(System.in);
        String toyInShop = scanner.nextLine();
        for(Toy toy : shop)
            if(toy.getName().equals(toyInShop))
            {
                if(money - Integer.parseInt(toy.getPrice()) <= 0)
                {
                    System.out.println("Недостатньо грошей для покупки");
                    break;
                }
                money = money - Integer.parseInt(toy.getPrice());
                toysInRoom.add(toy);
            }
        System.out.println("Чи бажаєте купити ще якусь іграшку?\n" +
                "1) Так\n" +
                "2) Ні\n");
        int choose = scanner.nextInt();
        if(choose == 1)
            chooseToy(shop);
        else
            callShopMenu();
        System.out.println("\nТепер у вас " + money + " грошей\n");
        return toysInRoom;
    }
}