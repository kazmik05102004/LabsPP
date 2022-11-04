package playroom;

import playroom.toyshop.ToyShop;

import java.io.FileNotFoundException;

import static playroom.ToFile.toFile;
import static playroom.menu.MainMenu.callMainMenu;
import static playroom.toyshop.ToyShop.createShop;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        createShop();
        callMainMenu();
        toFile();
    }
}