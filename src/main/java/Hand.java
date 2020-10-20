import java.util.List;

public class Hand {

    private List<Card> cards;
    private int rank;

    public Hand(List<Card> cards){
        this.cards = cards;
    }

    public Card getCardByIndex(int index){
        return cards.get(index);
    }
}
