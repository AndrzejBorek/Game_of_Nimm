import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


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
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Wrong Input");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something went wrong while trying to read your answer");
        }
        return false;
    }

    private void writeWinner(Player winner) {
        System.out.println(winner.getName() + " won");
    }

    public void play() {
        Random r = new Random();
        Player player1 = this.getPlayers().get(0);
        Player player2 = this.getPlayers().get(1);
        int randomPlayerStart = r.nextInt(2);
        this.players.get(randomPlayerStart).setMyTurn();
        while (!this.checkIfPilesAreEmpty()) {
            System.out.println("We have " + this.getSizeOfPiles() + " stones left");
            if (player1.isMyTurn()) {
                System.out.println("Its " + player1.getName() + " turn");
                if (this.move(player1)) {
                    player2.setMyTurn();
                } else {
                    player1.setMyTurn();
                }
            } else if (player2.isMyTurn()) {
                System.out.println("Its " + player2.getName() + " turn");
                if (this.move(player2)) {
                    player1.setMyTurn();
                } else {
                    player2.setMyTurn();
                }
            }
        }
        if (player1.isMyTurn()) {
            this.writeWinner(player2);
        } else {
            this.writeWinner(player1);
        }
    }
}
