import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player {
    private final String name;
    private boolean isMyTurn;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isMyTurn() {
        return isMyTurn;
    }

    public void setMyTurn() {
        isMyTurn = true;
    }

    public int[] makeMove() throws IOException {
        int[] result = new int[2];
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("First write pile from which you take");

        // Reading data using readLine
        int pile = Integer.parseInt(reader.readLine()) - 1;

        System.out.println("Now write how many stones you want to take");
        int stones = Integer.parseInt(reader.readLine());
        result[0] = pile;
        result[1] = stones;
        this.isMyTurn = false;
        return result;
    }
}
