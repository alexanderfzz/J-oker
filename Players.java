import java.util.ArrayList;

public class Players {
    public ArrayList<Player> players;
    public int pointer;
    public Players(){
        this.players = new ArrayList<>();
    }

    public Player roller(){
        Player roller = players.get(pointer % players.size());
        pointer++;
        return roller;
    }
}
