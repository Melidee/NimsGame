import java.util.Scanner;

public class Game {
    private int pieces;
    private Player p1;
    private Player p2;
    private Player currentPlayer;
    private Scanner sc = new Scanner(System.in);

    // Sets up the game with a random amount of pieces between 10 and 50
    // Sets up the players so they can be accessed
    public Game(Player p1, Player p2) {
        pieces = (int) (Math.random() * 40) + 10; // offset of 10; range of 40
        this.p1 = p1;
        this.p2 = p2;
    }

    // Allows a player to take a specific amount of pieces.
    // Adds the amount of pieces taken to the user's score.
    public int takePiece() {
        System.out.println("There are " + pieces + " remaining!");
        int take = -1;
        while (!isLegal(take)) {
            System.out.println("How many pieces would you like to take?");
            take = sc.nextInt();
        }
        pieces -= take;
        System.out.println("There are " + pieces + " remaining!");
        System.out.println("-----------------------");
        return take;
    }

    //Changes which players turn it is and returns the current player.
    public Player getNextPlayer() {
        currentPlayer = currentPlayer == p1 ? p2 : p1; // ternary operator
        return currentPlayer
    }

    // Checks whether or not the user's requested move is allowed or not.
    public boolean isLegal(int x) {
        return (x > 0) && x <= Math.floorDiv(pieces, 2) || x == 1 && pieces == 1;
    }

    // DO NOT CHANGE 
    public boolean isComplete() {
        return pieces == 0;
    }

    // DO NOT CHANGE
    public void setFirstPlayer(Player p) {
        currentPlayer = p;
    }
}
