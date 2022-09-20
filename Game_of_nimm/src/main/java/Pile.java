import java.util.ArrayList;

public class Pile {
    final private ArrayList<Integer> stones;

    public Pile(int howMany) {
        this.stones = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            this.stones.add(1);
        }
    }

    public ArrayList<Integer> getStones() {
        return stones;
    }

    public int getSize() {
        return this.stones.size();
    }

    public boolean takeStones(int numberOfStones) {
        if (numberOfStones > this.stones.size() || numberOfStones < 1) {
            System.out.println("Try again, you cant take that many stones.");
            return false;
        } else {
            for (int i = 0; i < numberOfStones; i++) {
                this.stones.remove(this.stones.size() - 1);
            }
        }
        return true;
    }

}
