import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Game {


    final private List<Pile> piles;
    final private List<Player> players;
    private boolean isFinished;


    public Game(List<Player> players, int... obj) {
        this.piles = new ArrayList<>();
        for (int j : obj) {
            Pile pile = new Pile(j);
            this.piles.add(pile);
        }
        this.players = players;
        this.isFinished = false;
    }

    public List<Pile> getPiles() {
        return piles;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished() {
        this.isFinished = true;
    }

    public List<Integer> getSizeOfPiles() {
        List<Integer> result = new ArrayList<>();
        this.piles.forEach(p -> result.add(p.getSize()));
        return result;
    }

    public boolean checkIfPilesAreEmpty() {
        return this.getSizeOfPiles().stream().allMatch(n -> n == 0);
    }

    public boolean move(Player player) {
        try {
            var move = player.makeMove();
            return this.piles.get(move[0]).takeStones(move[1]);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("You can't take from pile that does not exist!");
            return false;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Wrong Input");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something went wrong while trying to read your answer");
            return false;
        }
    }

    public void play() {

        while (!this.checkIfPilesAreEmpty()) {
            if (this.players.get(0).isMyTurn()) {
                System.out.println("We have " + this.getSizeOfPiles() + " stones left");
                System.out.println("Its " + players.get(0).getName() + " turn");
                if (this.move(this.players.get(0))) this.players.get(1).setMyTurn();
            } else {
                System.out.println("We have " + this.getSizeOfPiles() + " stones left");
                System.out.println("Its " + players.get(1).getName() + " turn");
                if (this.move(this.players.get(1))) this.players.get(0).setMyTurn();
            }
        }
        if (this.players.get(0).isMyTurn()) {
            System.out.println("Player " + this.getPlayers().get(1).getName() + " won");
        } else {
            System.out.println("Player " + this.getPlayers().get(0).getName() + " won");
        }
    }
}
