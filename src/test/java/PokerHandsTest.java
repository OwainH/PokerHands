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
        Card.Rank[] numbers = {Card.Rank.SIX, Card.Rank.TWO, Card.Rank.THREE , Card.Rank.FOUR, Card.Rank.FIVE};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs};
        Card expectedCard = new Card(Card.Rank.SIX, Card.Suit.Clubs);
        Hand hand = createHand(numbers, suit);
        assertTrue(pokerHands.selectHighestCard(hand).isMatch(expectedCard));
    }

    @Test
    void shouldFindPair(){
        Card.Rank[] numbers = {Card.Rank.SIX, Card.Rank.TWO, Card.Rank.FOUR, Card.Rank.FOUR, Card.Rank.FIVE};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Hearts, Card.Suit.Clubs};
        Hand hand = createHand(numbers, suit);
        assertTrue(pokerHands.hasMatchingCards(hand).contains(2));
    }

    @Test
    void shouldNotFindPair(){
        Card.Rank[] numbers = {Card.Rank.SIX, Card.Rank.TWO,Card.Rank.THREE, Card.Rank.FOUR, Card.Rank.FIVE};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Hearts, Card.Suit.Clubs};
        Hand hand = createHand(numbers, suit);
        assertTrue(!pokerHands.hasMatchingCards(hand).contains(2));
    }

    @Test
    void shouldFindTwoPair(){
        Card.Rank[] numbers = {Card.Rank.SIX, Card.Rank.TWO, Card.Rank.FOUR, Card.Rank.FOUR, Card.Rank.TWO};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Hearts, Card.Suit.Clubs};
        Hand hand = createHand(numbers, suit);
        assertTrue(pokerHands.hasMatchingCombination(hand, 2, 2));
    }

    @Test
    void shouldNotFindTwoPair(){
        Card.Rank[] numbers = {Card.Rank.SIX, Card.Rank.EIGHT, Card.Rank.FOUR, Card.Rank.FOUR, Card.Rank.TWO};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Hearts, Card.Suit.Clubs};
        Hand hand = createHand(numbers, suit);
        assertTrue(!pokerHands.hasMatchingCombination(hand, 2, 2));
    }

    @Test
    void shouldFindThreeOfAKind(){
        Card.Rank[] numbers = {Card.Rank.SIX, Card.Rank.TWO, Card.Rank.FOUR, Card.Rank.FOUR, Card.Rank.FOUR};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Hearts, Card.Suit.Spades};
        Hand hand = createHand(numbers, suit);
        assertTrue(pokerHands.hasMatchingCards(hand).contains(3));
    }

    @Test
    void shouldNotFindThreeOfAKind(){
        Card.Rank[] numbers = {Card.Rank.SIX, Card.Rank.TWO, Card.Rank.FOUR, Card.Rank.FOUR, Card.Rank.FIVE};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Hearts, Card.Suit.Spades};
        Hand hand = createHand(numbers, suit);
        assertTrue(!pokerHands.hasMatchingCards(hand).contains(3));
    }

    @Test
    void shouldFindFourOfAKind(){
        Card.Rank[] numbers = {Card.Rank.SIX, Card.Rank.FOUR, Card.Rank.FOUR, Card.Rank.FOUR, Card.Rank.FOUR};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Diamonds, Card.Suit.Clubs, Card.Suit.Hearts, Card.Suit.Spades};
        Hand hand = createHand(numbers, suit);
        assertTrue(pokerHands.hasMatchingCards(hand).contains(4));
    }

    @Test
    void shouldNotFindFourOfAKind(){
        Card.Rank[] numbers = {Card.Rank.SIX, Card.Rank.TWO, Card.Rank.FOUR, Card.Rank.FOUR, Card.Rank.FOUR};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Diamonds, Card.Suit.Clubs, Card.Suit.Hearts, Card.Suit.Spades};
        Hand hand = createHand(numbers, suit);
        assertTrue(!pokerHands.hasMatchingCards(hand).contains(Card.Rank.FOUR));
    }

    @Test
    void shouldFindFullHouse(){
        Card.Rank[] numbers = {Card.Rank.TWO, Card.Rank.TWO, Card.Rank.FOUR, Card.Rank.FOUR, Card.Rank.FOUR};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Diamonds, Card.Suit.Clubs, Card.Suit.Hearts, Card.Suit.Spades};
        Hand hand = createHand(numbers, suit);
        assertTrue(pokerHands.hasFullHouse(hand));
    }

    @Test
    void shouldNotFindFullHouse(){
        Card.Rank[] numbers = {Card.Rank.TWO,Card.Rank.THREE, Card.Rank.FOUR, Card.Rank.FOUR, Card.Rank.FOUR};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Diamonds, Card.Suit.Clubs, Card.Suit.Hearts, Card.Suit.Spades};
        Hand hand = createHand(numbers, suit);
        assertTrue(!pokerHands.hasFullHouse(hand));
    }

    @Test
    void shouldFindFlush(){
        Card.Rank[] numbers = {Card.Rank.SIX, Card.Rank.TWO, Card.Rank.FOUR, Card.Rank.FIVE, Card.Rank.SEVEN};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs};
        Hand hand = createHand(numbers, suit);
        assertTrue(pokerHands.hasFlush(hand));
    }

    @Test
    void shouldNotFindFlush(){
        Card.Rank[] numbers = {Card.Rank.SIX, Card.Rank.TWO, Card.Rank.FOUR, Card.Rank.FIVE, Card.Rank.SEVEN};
        Card.Suit[] suit = {Card.Suit.Diamonds, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs};
        Hand hand = createHand(numbers, suit);
        assertTrue(!pokerHands.hasFlush(hand));
    }

    @Test
    void shouldFindStraight(){
        Card.Rank[] numbers = {Card.Rank.TWO,Card.Rank.THREE, Card.Rank.FOUR, Card.Rank.SIX, Card.Rank.FIVE};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Diamonds, Card.Suit.Clubs, Card.Suit.Spades, Card.Suit.Clubs};
        Hand hand = createHand(numbers, suit);
        assertTrue(pokerHands.hasStraight(hand));
    }

    @Test
    void shouldFindAceLowStraight(){
        Card.Rank[] numbers = {Card.Rank.ACE, Card.Rank.THREE, Card.Rank.FOUR, Card.Rank.TWO, Card.Rank.FIVE};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Diamonds, Card.Suit.Clubs, Card.Suit.Spades, Card.Suit.Clubs};
        Hand hand = createHand(numbers, suit);
        assertTrue(pokerHands.hasStraight(hand));
    }

    @Test
    void shouldFindAceHighStraight(){
        Card.Rank[] numbers = {Card.Rank.ACE, Card.Rank.TEN, Card.Rank.QUEEN, Card.Rank.JACK, Card.Rank.KING};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Diamonds, Card.Suit.Clubs, Card.Suit.Spades, Card.Suit.Clubs};
        Hand hand = createHand(numbers, suit);
        assertTrue(pokerHands.hasStraight(hand));
    }

    @Test
    void shouldNotFindStraight(){
        Card.Rank[] numbers = {Card.Rank.ACE, Card.Rank.TWO, Card.Rank.KING,Card.Rank.THREE, Card.Rank.FOUR};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Diamonds, Card.Suit.Clubs, Card.Suit.Spades, Card.Suit.Clubs};
        Hand hand = createHand(numbers, suit);
        assertTrue(!pokerHands.hasStraight(hand));
    }

    @Test
    void shouldNotFindStraightWhenOnlyFourInARow(){
        Card.Rank[] numbers = {Card.Rank.TWO,Card.Rank.THREE, Card.Rank.FOUR, Card.Rank.FIVE, Card.Rank.SEVEN};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Diamonds, Card.Suit.Clubs, Card.Suit.Spades, Card.Suit.Clubs};
        Hand hand = createHand(numbers, suit);
        assertTrue(!pokerHands.hasStraight(hand));
    }

    @Test
    void shouldFindStraightFlush(){
        Card.Rank[] numbers = {Card.Rank.TWO, Card.Rank.FOUR,Card.Rank.THREE, Card.Rank.SIX, Card.Rank.FIVE};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs};
        Hand hand = createHand(numbers, suit);
        assertTrue(pokerHands.hasStraightFlush(hand));
    }

    @Test
    void shouldNotFindStraightFlush(){
        Card.Rank[] numbers = {Card.Rank.TWO, Card.Rank.FOUR,Card.Rank.THREE, Card.Rank.SIX, Card.Rank.FIVE};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Diamonds, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs};
        Hand hand = createHand(numbers, suit);
        assertTrue(!pokerHands.hasStraightFlush(hand));
    }

    @Test
    void shouldFindRoyalFlush(){
        Card.Rank[] numbers = {Card.Rank.TEN, Card.Rank.JACK, Card.Rank.QUEEN, Card.Rank.KING, Card.Rank.ACE};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs};
        Hand hand = createHand(numbers, suit);
        assertTrue(pokerHands.hasRoyalFlush(hand));
    }

    @Test
    void shouldNotFindRoyalFlush(){
        Card.Rank[] numbers = {Card.Rank.TEN, Card.Rank.JACK, Card.Rank.QUEEN, Card.Rank.KING, Card.Rank.NINE};
        Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs};
        Hand hand = createHand(numbers, suit);
        assertTrue(!pokerHands.hasRoyalFlush(hand));
    }


    private Hand createHand(Card.Rank[] numbers, Card.Suit[] suits){
        List<Card> cards = new ArrayList<Card>();
        for(int i = 0; i < numbers.length; i++){
            cards.add(new Card(numbers[i], suits[i]));
        }
        return new Hand(cards);
    }
}
