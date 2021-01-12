import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Card {

    private Rank rank;
    private Suit suit;
    public enum Suit{
        Spades,
        Diamonds,
        Clubs,
        Hearts
    }
    public enum Rank{
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

        private int value;
        private static Map<Rank, Integer> map = new HashMap<>();

        Rank(int value){
            this.value = value;
        }

        static {
            for(Rank rank : Rank.values()) {
                map.put(rank, rank.value);
            }
        }

        public static int valueOf(Rank rank){
            return map.get(rank);
        }

        public int getValue(){
            return value;
        }

    }

    public Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank(){
        return rank;
    }

    public Suit getSuit(){
        return suit;
    }

    public boolean isMatch(Card otherCard){
        return rank == otherCard.rank && suit == otherCard.suit;
    }

}
