package playroom.toyshop;

import playroom.Toy;

import java.util.Comparator;

public class SortByPrice implements Comparator<Toy> {
    public int compare(Toy a, Toy b) {
        if (Integer.parseInt( a.getPrice()) < Integer.parseInt(b.getPrice()))
            return -1;
        else if (Integer.parseInt( a.getPrice()) == Integer.parseInt(b.getPrice()))
            return 0;
        else return 1;
    }
}