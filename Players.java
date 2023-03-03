import java.util.ArrayList;

public class Players {
    public ArrayList<Player> players;
    public int pointer;
    public Players(){}

    public Player next(){
        pointer++;
        return players.get(pointer % players.size());
    }
}
