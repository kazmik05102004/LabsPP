package playroom.toyshop;

import playroom.Toy;
import playroom.room.Room;

import java.util.List;
import java.util.Scanner;

import static playroom.menu.ShopMenu.callShopMenu;

public class SortShopUtils {
    public static void searchToys(List<Toy> shop, String specifier) {
        for(Toy toy : shop)
            if(toy.getType().equals(specifier) || toy.getGender().equals(specifier) || toy.getSize().equals(specifier))
                System.out.println(toy);
    }

    public static void choose(List<Toy> shop){
        ToyShop toyShop = new ToyShop();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n" +
                "1) купити іграшку\n" +
                "2) повернутись в магазин\n");
        System.out.println("Введіть ваш вибір: ");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1:
                toyShop.chooseToy(shop);
                break;
            case 2:
                callShopMenu();
                break;
        }
    }
}
