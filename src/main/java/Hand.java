import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<Card> cards;
    private int rank;
    private final int HANDSIZE = 5;

    public Hand(List<Card> cards){
        this.cards = cards;
    }

    public Card getCardByIndex(int index){
        return cards.get(index);
    }

    public void sort(){
        List<Card> newHand = new ArrayList<>();
        for(int i = 0; i < HANDSIZE; i++){
            newHand.add(getAndRemoveLowestCard());
        }
        cards = newHand;
    }

    private Card getAndRemoveLowestCard(){
        Card lowestCard = cards.get(0);
        for(int i = 0; i < cards.size(); i++){
            if(cards.get(i).getNumber() < lowestCard.getNumber()){
                lowestCard = cards.get(i);
            }
        }
        cards.remove(lowestCard);
        return lowestCard;
    }
}
