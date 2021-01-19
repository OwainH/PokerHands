package model;

public class Card {

    private final Rank rank;
    private final Suit suit;

    public enum Suit {
        Spades,
        Diamonds,
        Clubs,
        Hearts
    }

    public enum Rank {
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13),
        ACE(14);

        private final Integer value;

        Rank(Integer value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Integer getRankValue() {
        return getRank().getValue();
    }

    public Suit getSuit(){
        return suit;
    }

    public boolean isMatch(Card otherCard){
        return rank == otherCard.rank && suit == otherCard.suit;
    }

}
