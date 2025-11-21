import java.util.*;
class Player {
    private String name;
    private int position = 0;

    public Player(String name) {
        this.name = name;
    }

    public void move(int steps) {
        position += steps;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}

class Board {
    private int size;
    private Map<Integer, Integer> snakes = new HashMap<>();
    private Map<Integer, Integer> ladders = new HashMap<>();

    public Board(int size) {
        this.size = size;
    }

    public void addSnake(int start, int end) {
        snakes.put(start, end);
    }

    public void addLadder(int start, int end) {
        ladders.put(start, end);
    }

    public int getSize() {
        return size;
    }

    public int checkPosition(int position) {
        if (snakes.containsKey(position)) {
            System.out.println(" Snake Bite! Move down to " + snakes.get(position));
            return snakes.get(position);
        }
        if (ladders.containsKey(position)) {
            System.out.println(" Ladder! Move up to " + ladders.get(position));
            return ladders.get(position);
        }
        return position;
    }
}

class Game {
    private Board board;
    private Player p1;
    private Player p2;

    public Game(Board board, Player p1, Player p2) {
        this.board = board;
        this.p1 = p1;
        this.p2 = p2;
    }

    public void start() {
        Random rand = new Random();
        Player currentPlayer = p1;

        System.out.println(" Snake & Ladder Game Started!");

        while (true) {
            System.out.println("\n " + currentPlayer.getName() + "'s turn");
            int dice = rand.nextInt(6) + 1;
            System.out.println("🎲 Dice: " + dice);

            currentPlayer.move(dice);

            if (currentPlayer.getPosition() > board.getSize()) {
                currentPlayer.setPosition(board.getSize());
            }

            int finalPos = board.checkPosition(currentPlayer.getPosition());
            currentPlayer.setPosition(finalPos);

            System.out.println(" " + currentPlayer.getName() + " is at " + currentPlayer.getPosition());

            if (currentPlayer.getPosition() == board.getSize()) {
                System.out.println("\n " + currentPlayer.getName() + " Wins!");
                break;
            }

            currentPlayer = (currentPlayer == p1) ? p2 : p1;
        }
    }
}

public class LadderGame {
    public static void main(String[] args) {

        Board board = new Board(100);

        board.addSnake(99, 54);
        board.addSnake(70, 55);
        board.addSnake(52, 42);
        board.addSnake(25, 2);
      
        board.addLadder(4, 25);
        board.addLadder(21, 39);
        board.addLadder(33, 48);
        board.addLadder(50, 90);

        Player p1 = new Player("Player 1");
        Player p2 = new Player("Player 2");

        Game game = new Game(board, p1, p2);
        game.start();
    }
}
