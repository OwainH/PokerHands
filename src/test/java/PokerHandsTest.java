import static model.Card.Rank.ACE;
import static model.Card.Rank.FIVE;
import static model.Card.Rank.FOUR;
import static model.Card.Rank.JACK;
import static model.Card.Rank.KING;
import static model.Card.Rank.NINE;
import static model.Card.Rank.QUEEN;
import static model.Card.Rank.SIX;
import static model.Card.Rank.TEN;
import static model.Card.Rank.THREE;
import static model.Card.Rank.TWO;
import static model.Card.Suit.Clubs;
import static model.Card.Suit.Diamonds;
import static model.Card.Suit.Hearts;
import static model.Card.Suit.Spades;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Card;
import model.Card.Rank;
import model.Card.Suit;
import model.Hand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PokerHandsTest {

  PokerHands pokerHands;

  @BeforeEach
  void setUp() {
    pokerHands = new PokerHands();
  }

//  @Test
//  void shouldReturnHighestCard() {
//    Card.Rank[] numbers = {Card.Rank.SIX, Card.Rank.TWO, Card.Rank.THREE, Card.Rank.FOUR,
//        Card.Rank.FIVE};
//    Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs,
//        Card.Suit.Clubs};
//    Card expectedCard = new Card(Card.Rank.SIX, Card.Suit.Clubs);
//    Hand hand = createHand(numbers, suit);
//    assertTrue(pokerHands.selectHighestCard(hand).isMatch(expectedCard));
//  }
//
//  @Test
//  void shouldFindPair() {
//    Card.Rank[] numbers = {Card.Rank.SIX, Card.Rank.TWO, Card.Rank.FOUR, Card.Rank.FOUR,
//        Card.Rank.FIVE};
//    Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Hearts,
//        Card.Suit.Clubs};
//    Hand hand = createHand(numbers, suit);
//    assertTrue(pokerHands.hasMatchingCards(hand).contains(2));
//  }
//
//  @Test
//  void shouldNotFindPair() {
//    Card.Rank[] numbers = {Card.Rank.SIX, Card.Rank.TWO, Card.Rank.THREE, Card.Rank.FOUR,
//        Card.Rank.FIVE};
//    Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Hearts,
//        Card.Suit.Clubs};
//    Hand hand = createHand(numbers, suit);
//    assertFalse(pokerHands.hasMatchingCards(hand).contains(2));
//  }
//
  @Test
  void shouldFindTwoPair() {
    List<Rank> ranks = Arrays.asList(SIX, TWO, FOUR, FOUR,
        TWO);
    List<Suit> suits = Arrays.asList(Clubs, Clubs, Clubs, Clubs,
        Hearts);
    Hand hand = createHand(ranks, suits);
    assertTrue(pokerHands.hasMatchingCombination(hand, 2, 2));
  }
//
//  @Test
//  void shouldNotFindTwoPair() {
//    Card.Rank[] numbers = {Card.Rank.SIX, Card.Rank.EIGHT, Card.Rank.FOUR, Card.Rank.FOUR,
//        Card.Rank.TWO};
//    Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Hearts,
//        Card.Suit.Clubs};
//    Hand hand = createHand(numbers, suit);
//      assertFalse(pokerHands.hasMatchingCombination(hand, 2, 2));
//  }
//
//  @Test
//  void shouldFindThreeOfAKind() {
//    Card.Rank[] numbers = {Card.Rank.SIX, Card.Rank.TWO, Card.Rank.FOUR, Card.Rank.FOUR,
//        Card.Rank.FOUR};
//    Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Hearts,
//        Card.Suit.Spades};
//    Hand hand = createHand(numbers, suit);
//    assertTrue(pokerHands.hasMatchingCards(hand).contains(3));
//  }
//
//  @Test
//  void shouldNotFindThreeOfAKind() {
//    Card.Rank[] numbers = {Card.Rank.SIX, Card.Rank.TWO, Card.Rank.FOUR, Card.Rank.FOUR,
//        Card.Rank.FIVE};
//    Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Hearts,
//        Card.Suit.Spades};
//    Hand hand = createHand(numbers, suit);
//    assertFalse(pokerHands.hasMatchingCards(hand).contains(3));
//  }
//
//  @Test
//  void shouldFindFourOfAKind() {
//    Card.Rank[] numbers = {Card.Rank.SIX, Card.Rank.FOUR, Card.Rank.FOUR, Card.Rank.FOUR,
//        Card.Rank.FOUR};
//    Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Diamonds, Card.Suit.Clubs, Card.Suit.Hearts,
//        Card.Suit.Spades};
//    Hand hand = createHand(numbers, suit);
//    assertTrue(pokerHands.hasMatchingCards(hand).contains(4));
//  }
//
//  @Test
//  void shouldNotFindFourOfAKind() {
//    Card.Rank[] numbers = {Card.Rank.SIX, Card.Rank.TWO, Card.Rank.FOUR, Card.Rank.FOUR,
//        Card.Rank.FOUR};
//    Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Diamonds, Card.Suit.Clubs, Card.Suit.Hearts,
//        Card.Suit.Spades};
//    Hand hand = createHand(numbers, suit);
//    assertFalse(pokerHands.hasMatchingCards(hand).contains(Rank.FOUR));
//  }
//
  @Test
  void shouldFindFullHouse() {
    List<Rank> ranks = Arrays.asList(TWO, TWO, FOUR, FOUR,
        FOUR);
    List<Suit> suits = Arrays.asList(Clubs, Diamonds, Clubs, Hearts,
        Spades);

    Hand hand = createHand(ranks, suits);
    assertTrue(pokerHands.hasFullHouse(hand));
  }
//
//  @Test
//  void shouldNotFindFullHouse() {
//    Card.Rank[] numbers = {Card.Rank.TWO, Card.Rank.THREE, Card.Rank.FOUR, Card.Rank.FOUR,
//        Card.Rank.FOUR};
//    Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Diamonds, Card.Suit.Clubs, Card.Suit.Hearts,
//        Card.Suit.Spades};
//    Hand hand = createHand(numbers, suit);
//    assertFalse(pokerHands.hasFullHouse(hand));
//  }
//
//  @Test
//  void shouldFindFlush() {
//    Card.Rank[] numbers = {Card.Rank.SIX, Card.Rank.TWO, Card.Rank.FOUR, Card.Rank.FIVE,
//        Card.Rank.SEVEN};
//    Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs,
//        Card.Suit.Clubs};
//    Hand hand = createHand(numbers, suit);
//    assertTrue(pokerHands.hasFlush(hand));
//  }
//
//  @Test
//  void shouldNotFindFlush() {
//    Card.Rank[] numbers = {Card.Rank.SIX, Card.Rank.TWO, Card.Rank.FOUR, Card.Rank.FIVE,
//        Card.Rank.SEVEN};
//    Card.Suit[] suit = {Card.Suit.Diamonds, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs,
//        Card.Suit.Clubs};
//    Hand hand = createHand(numbers, suit);
//    assertFalse(pokerHands.hasFlush(hand));
//  }
//
  @Test
  void shouldFindStraight() {
    List<Rank> ranks = Arrays.asList(TWO, THREE, FOUR, SIX, FIVE);
    List<Suit> suits = Arrays.asList(Clubs, Diamonds, Clubs, Spades, Clubs);
    Hand hand = createHand(ranks, suits);
    assertTrue(pokerHands.hasStraight(hand));
  }
//
//  @Test
//  void shouldFindAceLowStraight() {
//    Card.Rank[] numbers = {Card.Rank.ACE, Card.Rank.THREE, Card.Rank.FOUR, Card.Rank.TWO,
//        Card.Rank.FIVE};
//    Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Diamonds, Card.Suit.Clubs, Card.Suit.Spades,
//        Card.Suit.Clubs};
//    Hand hand = createHand(numbers, suit);
//    assertTrue(pokerHands.hasStraight(hand));
//  }
//
//  @Test
//  void shouldFindAceHighStraight() {
//    Card.Rank[] numbers = {Card.Rank.ACE, Card.Rank.TEN, Card.Rank.QUEEN, Card.Rank.JACK,
//        Card.Rank.KING};
//    Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Diamonds, Card.Suit.Clubs, Card.Suit.Spades,
//        Card.Suit.Clubs};
//    Hand hand = createHand(numbers, suit);
//    assertTrue(pokerHands.hasStraight(hand));
//  }
//
  @Test
  void shouldNotFindStraight() {
    List<Rank> ranks = Arrays.asList(ACE, TWO, KING, THREE, FIVE);
    List<Suit> suits = Arrays.asList(Clubs, Diamonds, Clubs, Spades, Clubs);
    Hand hand = createHand(ranks, suits);
    assertFalse(pokerHands.hasStraight(hand));
  }
//
//  @Test
//  void shouldNotFindStraightWhenOnlyFourInARow() {
//    Card.Rank[] numbers = {Card.Rank.TWO, Card.Rank.THREE, Card.Rank.FOUR, Card.Rank.FIVE,
//        Card.Rank.SEVEN};
//    Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Diamonds, Card.Suit.Clubs, Card.Suit.Spades,
//        Card.Suit.Clubs};
//    Hand hand = createHand(numbers, suit);
//    assertFalse(pokerHands.hasStraight(hand));
//  }
//
//  @Test
//  void shouldFindStraightFlush() {
//    Card.Rank[] numbers = {Card.Rank.TWO, Card.Rank.FOUR, Card.Rank.THREE, Card.Rank.SIX,
//        Card.Rank.FIVE};
//    Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs,
//        Card.Suit.Clubs};
//    Hand hand = createHand(numbers, suit);
//    assertTrue(pokerHands.hasStraightFlush(hand));
//  }
//
//  @Test
//  void shouldNotFindStraightFlush() {
//    Card.Rank[] numbers = {Card.Rank.TWO, Card.Rank.FOUR, Card.Rank.THREE, Card.Rank.SIX,
//        Card.Rank.FIVE};
//    Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Diamonds, Card.Suit.Clubs, Card.Suit.Clubs,
//        Card.Suit.Clubs};
//    Hand hand = createHand(numbers, suit);
//    assertFalse(pokerHands.hasStraightFlush(hand));
//  }
//
//  @Test
//  void shouldFindRoyalFlush() {
//    Card.Rank[] numbers = {Card.Rank.TEN, Card.Rank.JACK, Card.Rank.QUEEN, Card.Rank.KING,
//        Card.Rank.ACE};
//    Card.Suit[] suit = {Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs, Card.Suit.Clubs,
//        Card.Suit.Clubs};
//    Hand hand = createHand(numbers, suit);
//    assertTrue(pokerHands.hasRoyalFlush(hand));
//  }

  @Test
  void shouldNotFindRoyalFlush() {
    List<Rank> ranks = Arrays.asList(TEN, JACK, QUEEN, KING,
        NINE);
    List<Suit> suits = Arrays.asList(Clubs, Clubs, Clubs, Clubs,
        Clubs);
    Hand hand = createHand(ranks, suits);
    assertFalse(pokerHands.hasRoyalFlush(hand));
  }


  private Hand createHand(List<Rank> ranks, List<Suit> suits) {
    List<Card> cards =
        IntStream.range(0, ranks.size())
            .mapToObj(i -> new Card(ranks.get(i), suits.get(i)))
            .collect(Collectors.toList());
    return new Hand(cards);
  }
}
