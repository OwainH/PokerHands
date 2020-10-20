import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class HandTest {

    @Test
    public void shouldSortHandAscending(){
        int[] numbers = {3, 2, 4, 6, 5};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Diamonds, Card.Suit.Clubs, Card.Suit.Spades, Card.Suit.Clubs};
        Hand hand = createHand(numbers, suit);
        hand.sort();
        assertTrue(hand.getCardByIndex(0).getNumber() == 2);
        assertTrue(hand.getCardByIndex(0).getNumber() == 3);
        assertTrue(hand.getCardByIndex(0).getNumber() == 4);
        assertTrue(hand.getCardByIndex(0).getNumber() == 5);
        assertTrue(hand.getCardByIndex(0).getNumber() == 6);
    }


    private Hand createHand(int numbers[], Card.Suit suits[]){
        List<Card> cards = new ArrayList<Card>();
        for(int i = 0; i < numbers.length; i++){
            cards.add(new Card(numbers[i], suits[i]));
        }
        return new Hand(cards);
    }
}
