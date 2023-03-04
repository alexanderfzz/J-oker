import java.util.LinkedList;

public class Player {
    String name;
    int capital;
    int handsPlayedVoluntarily, handsPlayedTotal;
    LinkedList<Card> hand;

    public Player(String name, int capital) {
        this.name = name;
        this.capital = capital;
        this.handsPlayedVoluntarily = 0;
        this.handsPlayedTotal = 0;
    }

    public void withdrawCapital(int amount) {
        this.capital -= amount;
    }
    public void depositCapital(int amount) {
        this.capital += amount;
    }
    public void leaveTable() {
        //TODO: pop player from existing table
    }

    public void showHand() {
        // if endgamecondition perform action
    }
}
