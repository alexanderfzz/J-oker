import java.util.Collections;
import java.util.LinkedList;

public class Deck {
    public LinkedList<Card> cards;

    public Deck(){
        this.cards = new LinkedList<>();
        for (Card.Suit suit : Card.Suit.values()){
            for (char value : Card.valueLookUp){
                this.cards.add(new Card(suit, value));
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(this.cards);
    }
}
