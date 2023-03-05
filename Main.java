import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Card> hand = new LinkedList<>();
        hand.add(new Card(Card.Suit.HEART, Card.Value.ACE));
        hand.add(new Card(Card.Suit.HEART, Card.Value.TWO));
        hand.add(new Card(Card.Suit.HEART, Card.Value.ACE));
        hand.add(new Card(Card.Suit.HEART, Card.Value.KING));
        hand.add(new Card(Card.Suit.CLUB, Card.Value.KING));
        hand.add(new Card(Card.Suit.CLUB, Card.Value.KING));
        hand.add(new Card(Card.Suit.CLUB, Card.Value.JACK));
        hand.add(new Card(Card.Suit.CLUB, Card.Value.JACK));
        hand.add(new Card(Card.Suit.CLUB, Card.Value.JACK));
        System.out.println(HandClassifier.getThreeOfAKind(hand));
    }

}