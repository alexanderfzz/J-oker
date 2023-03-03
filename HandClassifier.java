import java.util.ArrayList;
import java.util.LinkedList;


public class HandClassifier {
    enum HandType {
        HIGH_CARD,
        TWO_PAIR,
        THREE_OF_A_KIND,
        STRAIGHT,
        FLUSH,
        FULL_HOUSE,
        FOUR_OF_A_KIND,
        STRAIGHT_FLUSH,
        ROYAL_FLUSH
    }
    public static HandTypeHandPair strongestHand(LinkedList<Card> hand) {
        return new HandTypeHandPair(HandType.ROYAL_FLUSH, hand);
    }
}

class HandTypeHandPair{
    public HandClassifier.HandType handType;
    public LinkedList<Card> hand;
    public HandTypeHandPair(HandClassifier.HandType handType, LinkedList<Card> hand){
        this.handType = handType;
        this.hand = hand;
    }
}