import java.util.*;


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

    public static Card.Value[] valueArray = {
            Card.Value.TWO,
            Card.Value.THREE,
            Card.Value.FOUR,
            Card.Value.FIVE,
            Card.Value.SIX,
            Card.Value.SEVEN,
            Card.Value.EIGHT,
            Card.Value.NINE,
            Card.Value.TEN,
            Card.Value.JACK,
            Card.Value.QUEEN,
            Card.Value.KING,
            Card.Value.ACE
    };

    public static Card.Value[] valueArrayReversed = {
            Card.Value.ACE,
            Card.Value.KING,
            Card.Value.QUEEN,
            Card.Value.JACK,
            Card.Value.TEN,
            Card.Value.NINE,
            Card.Value.EIGHT,
            Card.Value.SEVEN,
            Card.Value.SIX,
            Card.Value.FIVE,
            Card.Value.FOUR,
            Card.Value.THREE,
            Card.Value.TWO,

    };

    public static Card.Value straightLastBegins = Card.Value.FIVE;

    public static Card.Value getPrevValue(Card.Value value){
        if (value == Card.Value.TWO){
            return Card.Value.TWO;
        }
        return valueArray[(value.index-1)%12]; // Two will return an ace
    }

    public static Card.Value getNextValue(Card.Value value){
        if (value == Card.Value.ACE){
            return Card.Value.TWO;
        }
        return valueArray[(value.index+1)%12];
    }

    public static HandTypeHandPair strongestHand(LinkedList<Card> hand) {
        LinkedList<Card> royalFlush = getRoyalFlush(hand);
        if (royalFlush != null){
            return new HandTypeHandPair(HandType.ROYAL_FLUSH, royalFlush);
        }

        return null;
    }

    public static LinkedList<Card> getRoyalFlush(LinkedList<Card> hand){
        for (Card.Suit suit : Card.Suit.values()){
            boolean nulled = false;
            LinkedList<Card> royalFlush = new LinkedList<>();
            for (Card.Value value : new Card.Value[]{Card.Value.ACE, Card.Value.KING, Card.Value.QUEEN, Card.Value.JACK, Card.Value.TEN}){
                Card candidate = getValueSuitInHand(value, suit, hand);
                if (candidate == null){
                    nulled = true;
                    break;
                }
                royalFlush.add(candidate);
            }
            if (!nulled){
                return royalFlush;
            }
        }
        return null;
    }

    public static LinkedList<Card> getStraightFlush(LinkedList<Card> hand){
        for (Card.Suit suit : Card.Suit.values()){
            for (Card.Value straightBegins : Arrays.copyOfRange(valueArrayReversed, 0, 13-straightLastBegins.index)){ // 13 instead of 12 to avoid off-by-one error
                Card.Value lookingForValue = straightBegins;
                boolean nulled = false;
                LinkedList<Card> straightFlush = new LinkedList<>();
                for (int i = 0; i < 5; i++){
                    Card candidate = getValueSuitInHand(lookingForValue, suit, hand);
                    if (candidate == null){
                        nulled = true;
                        break;
                    }
                    straightFlush.add(candidate);
                    lookingForValue = getNextValue(lookingForValue);
                }
                if (!nulled){
                    return straightFlush;
                }
            }
        }
        return null;
    }

    public static LinkedList<Card> getFourOfAKind(LinkedList<Card> hand){
        for (Card.Value value : Card.Value.values()){
            LinkedList<Card> fourOfAKind = new LinkedList<>();
            for (Card.Suit suit : Card.Suit.values()){
                Card card = getValueSuitInHand(value, suit, hand);
                if (card != null){
                    fourOfAKind.add(card);
                }
            }
            if (fourOfAKind.size() == 4){
                return fourOfAKind;
            }
        }
        return null;
    }

    public static LinkedList<Card> getThreeOfAKind(LinkedList<Card> hand){
        HashMap<Card.Value, CardFrequency> cardFrequencyTable = getCardFrequencyTable(hand);
        LinkedList<CardFrequency> cardFrequencyList = new LinkedList<>(cardFrequencyTable.values());
        cardFrequencyList.sort((o1, o2) -> {return o2.value.index - o1.value.index;});
        for (CardFrequency cardFrequency : cardFrequencyList){
            if (cardFrequency.count == 3){
                return cardFrequency.cards;
            }
        }
        return null;
    }

    public static Card getValueInHand(Card.Value value, LinkedList<Card> hand){
        for (Card card : hand){
            if (card.value == value){
                return card;
            }
        }
        return null;
    }

    public static Card getValueSuitInHand(Card.Value value, Card.Suit suit, LinkedList<Card> hand){
        for (Card card : hand){
            if (card.value == value && card.suit == suit){
                return card;
            }
        }
        return null;
    }


    public static void sortHand(LinkedList<Card> hand){
        hand.sort((c1, c2) -> {
                return c2.value.index - c1.value.index;
            }
        );
    }

    public static HashMap<Card.Value, CardFrequency> getCardFrequencyTable(LinkedList<Card> hand){
        HashMap<Card.Value, CardFrequency> cardFrequencyTable = new HashMap<>();
        for (Card card : hand){
            if (!cardFrequencyTable.containsKey(card.value)){
                cardFrequencyTable.put(card.value, new CardFrequency());
            }
            cardFrequencyTable.get(card.value).add(card);
        }
        return cardFrequencyTable;
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

class CardFrequency{
    public LinkedList<Card> cards;
    public int count;
    public Card.Value value;

    public CardFrequency(){
        this.cards = new LinkedList<>();
        this.count = 0;
        this.value = null;
    }

    public void add(Card card){
        this.cards.add(card);
        this.count++;
        this.value = card.value;
    }

    @Override
    public String toString(){
        return "[count=" + Integer.toString(this.count) + ", value=" +  this.value.toString() + ", cards=" + this.cards.toString();
    }
}