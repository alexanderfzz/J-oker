import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Table {
    public int bigBlind, pot, currentBetOfTheRound;
    public Card[] board = new Card[5];
    public HashMap<Player, Integer> amountEachPlayerPutInPot = new HashMap<>();
    public LinkedList<Player> players = new LinkedList<>();
    public int buttonIndex;

    public void addPlayer(int index, Player target) {
        if (players.contains(target)) {
            return;
        }
        players.add(index, target);
    }
    public void removePlayer(Player target) {
        players.remove(target);
    }
    public Player determineWinningHand() {
        //TODO: figure this out
        return null;
    }

}