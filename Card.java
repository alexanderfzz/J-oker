public class Card implements Comparable<Card> {
    enum Color{
        RED,
        BLACK,
    }
    enum Suit {
        HEART(Color.RED),
        DIAMOND(Color.RED),
        SPADE(Color.BLACK),
        CLUB(Color.BLACK);
        public final Color c;
        private Suit(Color c){
            this.c = c;
        }
    }

    enum Value {
        TWO(0),
        THREE(1),
        FOUR(2),
        FIVE(3),
        SIX(4),
        SEVEN(5),
        EIGHT(6),
        NINE(7),
        TEN(8),
        JACK(9),
        QUEEN(10),
        KING(11),
        ACE(12);

        public final int index;
        private Value(int index){
            this.index = index;
        }
    }

    public Suit suit;
    public Value value;

    public Card(Suit suit, Value value) {
        this.value = value;
        this.suit = suit;
    }

    /*
    Comparable Interface method
    When sorted, values goes from smallest to greatest
    */
    @Override
    public String toString() {
        return this.value.toString() + "_" + this.suit.toString();
    }

    @Override
    public int compareTo(Card o) {
        return this.value.index - o.value.index;
    }
}