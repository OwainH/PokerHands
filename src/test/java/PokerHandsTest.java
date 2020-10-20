import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class PokerHandsTest {

    PokerHands pokerHands;

    @BeforeEach
    void setUp(){
        pokerHands = new PokerHands();
    }

    @Test
    void shouldReturnHighestCard(){
        int[] numbers = {6,2,3,4,5};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs};
        Card expectedCard = new Card(5, Card.Suit.Clubs);
        Hand hand = createHand(numbers, suit);
        assertTrue(pokerHands.selectHighestCard(hand).isMatch(expectedCard));
    }

    @Test
    void shouldFindPair(){
        int[] numbers = {6, 2, 4, 4, 5};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Hearts, Card.Suit.Clubs};
        Hand hand = createHand(numbers, suit);
        assertTrue(pokerHands.hasMatchingCards(hand, 2));
    }

    @Test
    void shouldNotFindPair(){
        int[] numbers = {6, 2, 3, 4, 5};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Hearts, Card.Suit.Clubs};
        Hand hand = createHand(numbers, suit);
        assertTrue(!pokerHands.hasMatchingCards(hand, 2));
    }

    @Test
    void shouldFindThreeOfAKind(){
        int[] numbers = {6, 2, 4, 4, 4};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Hearts, Card.Suit.Spades};
        Hand hand = createHand(numbers, suit);
        assertTrue(pokerHands.hasMatchingCards(hand, 3));
    }

    @Test
    void shouldNotFindThreeOfAKind(){
        int[] numbers = {6, 2, 4, 4, 5};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Hearts, Card.Suit.Spades};
        Hand hand = createHand(numbers, suit);
        assertTrue(!pokerHands.hasMatchingCards(hand, 3));
    }

    @Test
    void shouldFindFourOfAKind(){
        int[] numbers = {6, 4, 4, 4, 4};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Diamonds, Card.Suit.Clubs, Card.Suit.Hearts, Card.Suit.Spades};
        Hand hand = createHand(numbers, suit);
        assertTrue(pokerHands.hasMatchingCards(hand, 4));
    }

    @Test
    void shouldNotFindFourOfAKind(){
        int[] numbers = {6, 2, 4, 4, 4};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Diamonds, Card.Suit.Clubs, Card.Suit.Hearts, Card.Suit.Spades};
        Hand hand = createHand(numbers, suit);
        assertTrue(!pokerHands.hasMatchingCards(hand, 4));
    }

    @Test
    void shouldFindFullHouse(){
        int[] numbers = {2, 2, 4, 4, 4};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Diamonds, Card.Suit.Clubs, Card.Suit.Hearts, Card.Suit.Spades};
        Hand hand = createHand(numbers, suit);
        assertTrue(pokerHands.hasFullHouse(hand));
    }

    @Test
    void shouldNotFindFullHouse(){
        int[] numbers = {2, 3, 4, 4, 4};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Diamonds, Card.Suit.Clubs, Card.Suit.Hearts, Card.Suit.Spades};
        Hand hand = createHand(numbers, suit);
        assertTrue(!pokerHands.hasFullHouse(hand));
    }

    @Test
    void shouldFindFlush(){
        int[] numbers = {6, 2, 4, 5, 7};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs};
        Hand hand = createHand(numbers, suit);
        assertTrue(pokerHands.hasFlush(hand));
    }

    @Test
    void shouldNotFindFlush(){
        int[] numbers = {6, 2, 4, 5, 7};
        Card.Suit[] suit = {Card.Suit.Diamonds, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs};
        Hand hand = createHand(numbers, suit);
        assertTrue(!pokerHands.hasFlush(hand));
    }

    @Test
    void shouldFindStraight(){
        int[] numbers = {2, 3, 4, 6, 5};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Diamonds, Card.Suit.Clubs, Card.Suit.Spades, Card.Suit.Clubs};
        Hand hand = createHand(numbers, suit);
        assertTrue(pokerHands.hasStraight(hand));
    }

    @Test
    void shouldNotFindStraight(){
        int[] numbers = {2, 3, 4, 6, 7};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Diamonds, Card.Suit.Clubs, Card.Suit.Spades, Card.Suit.Clubs};
        Hand hand = createHand(numbers, suit);
        assertTrue(!pokerHands.hasStraight(hand));
    }

    @Test
    void shouldFindStraightFlush(){
        int[] numbers = {2, 4, 3, 6, 5};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs};
        Hand hand = createHand(numbers, suit);
        assertTrue(pokerHands.hasStraightFlush(hand));
    }

    @Test
    void shouldNotFindStraightFlush(){
        int[] numbers = {2, 4, 3, 6, 5};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Diamonds, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs};
        Hand hand = createHand(numbers, suit);
        assertTrue(!pokerHands.hasStraightFlush(hand));
    }

    @Test
    void shouldFindRoyalFlush(){
        int[] numbers = {10, 12, 11, 13, 14};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs};
        Hand hand = createHand(numbers, suit);
        assertTrue(pokerHands.hasRoyalFlush(hand));
    }


    private Hand createHand(int numbers[], Card.Suit suits[]){
        List<Card> cards = new ArrayList<Card>();
        for(int i = 0; i < numbers.length; i++){
            cards.add(new Card(numbers[i], suits[i]));
        }
        return new Hand(cards);
    }
}
