public class Card implements Comparable<Card> {
    enum Suit {
        HEART,
        DIAMOND,
        SPADE,
        CLUB
    }
    public static char[] valueLookUp = {'1', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};


    public Suit suit;
    public char value;

    public Card(Suit suit, char value) {
        this.value = value;
        this.suit = suit;
    }

    @Override
    public int compareTo(Card o) {
        String temp = new String(valueLookUp);
        return temp.indexOf(o.value) - temp.indexOf(this.value);
    }
}