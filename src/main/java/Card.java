import java.time.Duration;

public class Card {

    private int number;
    private Suit suit;
    public enum Suit{
        Spades,
        Diamonds,
        Clubs,
        Hearts
    }

    public Card(int number, Suit suit){
        this.number = number;
        this.suit = suit;
    }

    public int getNumber(){
        return number;
    }

    public Suit getSuit(){
        return suit;
    }

    public boolean isMatch(Card otherCard){
        return number == otherCard.number && suit == otherCard.suit;
    }

}
