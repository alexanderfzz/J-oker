public class Card implements Comparable<Card> {
    enum Suit {
        HEART,
        DIAMOND,
        SPADE,
        CLUB
    };
    char[] valueLookUp = {'1', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};


    public Suit suit;
    public char value;

    public Card(String suit, char value) {
        this.value = value;
        this.suit = Suit.valueOf(suit);
    }

    @Override
    public int compareTo(Card o) {
        return 0;
    }
}