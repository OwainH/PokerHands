package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import model.Card;
import model.Hand;
import org.junit.jupiter.api.Test;

public class HandTest {

    @Test
    public void shouldSortHandAscending(){
        Card.Rank[] rank = {Card.Rank.THREE, Card.Rank.TWO, Card.Rank.FOUR, Card.Rank.SIX, Card.Rank.FIVE};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Diamonds, Card.Suit.Clubs, Card.Suit.Spades, Card.Suit.Clubs};
        Hand hand = createHand(rank, suit);
        hand.sort();
        assertEquals(2, hand.getCardByIndex(0).getRank().getValue());
        assertEquals(3, hand.getCardByIndex(1).getRank().getValue());
        assertEquals(4, hand.getCardByIndex(2).getRank().getValue());
        assertEquals(5, hand.getCardByIndex(3).getRank().getValue());
        assertEquals(6, hand.getCardByIndex(4).getRank().getValue());
    }


    private Hand createHand(Card.Rank[] ranks, Card.Suit[] suits){
        List<Card> cards = new ArrayList<Card>();
        for(int i = 0; i < ranks.length; i++){
            cards.add(new Card(ranks[i], suits[i]));
        }
        return new Hand(cards);
    }
}
