package dwmichalak.cs2400.bagadt;

public class BagDriver {
    public static void main(String[] args) {
        BagInterface<Integer> newBag = new ArrayBag<>();
        newBag.add((Integer)69);
        newBag.add((Integer)84);
        newBag.add((Integer)1);
    }
}
