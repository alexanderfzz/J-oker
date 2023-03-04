import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Table {
    public int bigBlind;
    public boolean canStraddle;
    public LinkedList<Card> board;
    public LinkedList<Player> players;
    public int buttonIndex;


    /*
    * bigBlind defines the mandatory investment by certain players
    * canStraddle defines an optional feature
    */
    public Table(int bb, boolean canStraddle) {
        this.bigBlind = bb;
        this.canStraddle = canStraddle;
        this.board = new LinkedList<>();
        this.players = new LinkedList<>();
    }

    //add player to the table
    public int addPlayer(int index, Player target) {
        if (players.contains(target)) {
            return -1;
        }
        players.add(index, target);
        return 0;
    }

    //remove player from the table
    public void removePlayer(Player target) {
        players.remove(target);
    }

    public void startGame() {
        Game game = new Game();
    }

    public void incrementButtonPosition() {
        //check if people left the table in between rounds
        //else:
        buttonIndex++;
    }

}