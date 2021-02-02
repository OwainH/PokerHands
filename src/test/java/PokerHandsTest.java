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
import static model.Card.Rank.EIGHT;
import static model.Card.Rank.SEVEN;


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

  @Test
  void shouldReturnHighestCard() {
    List<Rank> ranks = Arrays.asList(SIX, TWO, THREE, FOUR, FIVE);
    List<Suit> suits = Arrays.asList(Clubs, Clubs, Clubs, Clubs, Clubs);
    Card expectedCard = new Card(SIX, Clubs);
    Hand hand = createHand(ranks, suits);
    assertTrue(pokerHands.selectHighestCard(hand).isMatch(expectedCard));
  }

  @Test
  void shouldFindPair() {
    List<Rank> ranks = Arrays.asList(SIX, TWO, FOUR, FOUR, FIVE);
    List<Suit> suits = Arrays
        .asList(Clubs, Clubs, Clubs, Hearts,
            Clubs);
    Hand hand = createHand(ranks, suits);
    assertTrue(pokerHands.hasMatchingCombination(hand, 2, 1));
  }

  @Test
  void shouldNotFindPair() {
    List<Rank> ranks = Arrays.asList(SIX, TWO, THREE, FOUR,
        FIVE);
    List<Suit> suits = Arrays
        .asList(Clubs, Clubs, Clubs, Hearts,
            Clubs);
    Hand hand = createHand(ranks, suits);
    assertFalse(pokerHands.hasMatchingCombination(hand, 2, 1));
  }

  @Test
  void shouldFindTwoPair() {
    List<Rank> ranks = Arrays.asList(SIX, TWO, FOUR, FOUR,
        TWO);
    List<Suit> suits = Arrays.asList(Clubs, Clubs, Clubs, Clubs,
        Hearts);
    Hand hand = createHand(ranks, suits);
    assertTrue(pokerHands.hasMatchingCombination(hand, 2, 2));
  }

  @Test
  void shouldNotFindTwoPair() {
    List<Rank> ranks = Arrays.asList(SIX, EIGHT, FOUR, FOUR,
        TWO);
    List<Suit> suits = Arrays
        .asList(Clubs, Clubs, Clubs, Hearts,
            Clubs);
    Hand hand = createHand(ranks, suits);
    assertFalse(pokerHands.hasMatchingCombination(hand, 2, 2));
  }

  @Test
  void shouldFindThreeOfAKind() {
    List<Rank> ranks = Arrays.asList(SIX, TWO, FOUR, FOUR,
        FOUR);
    List<Suit> suits = Arrays
        .asList(Clubs, Clubs, Clubs, Hearts,
            Spades);
    Hand hand = createHand(ranks, suits);
    assertTrue(pokerHands.hasMatchingCombination(hand, 3, 1));
  }

  @Test
  void shouldNotFindThreeOfAKind() {
    List<Rank> ranks = Arrays.asList(SIX, TWO, FOUR, FOUR,
        FIVE);
    List<Suit> suits = Arrays
        .asList(Clubs, Clubs, Clubs, Hearts,
            Spades);
    Hand hand = createHand(ranks, suits);
    assertFalse(pokerHands.hasMatchingCombination(hand, 3, 1));
  }

  @Test
  void shouldFindFourOfAKind() {
    List<Rank> ranks = Arrays.asList(SIX, FOUR, FOUR, FOUR,
        FOUR);
    List<Suit> suits = Arrays
        .asList(Clubs, Diamonds, Clubs, Hearts,
            Spades);
    Hand hand = createHand(ranks, suits);
    assertTrue(pokerHands.hasMatchingCombination(hand, 4, 1));
  }

  @Test
  void shouldNotFindFourOfAKind() {
    List<Rank> ranks = Arrays.asList(SIX, TWO, FOUR, FOUR,
        FOUR);
    List<Suit> suits = Arrays
        .asList(Clubs, Diamonds, Clubs, Hearts,
            Spades);
    Hand hand = createHand(ranks, suits);
    assertFalse(pokerHands.hasMatchingCombination(hand, 4, 1));
  }

  @Test
  void shouldFindFullHouse() {
    List<Rank> ranks = Arrays.asList(TWO, TWO, FOUR, FOUR,
        FOUR);
    List<Suit> suits = Arrays.asList(Clubs, Diamonds, Clubs, Hearts,
        Spades);

    Hand hand = createHand(ranks, suits);
    assertTrue(pokerHands.hasFullHouse(hand));
  }

  @Test
  void shouldNotFindFullHouse() {
    List<Rank> ranks = Arrays.asList(TWO, THREE, FOUR, FOUR,
        FOUR);
    List<Suit> suits = Arrays
        .asList(Clubs, Diamonds, Clubs, Hearts,
            Spades);
    Hand hand = createHand(ranks, suits);
    assertFalse(pokerHands.hasFullHouse(hand));
  }

  @Test
  void shouldFindFlush() {
    List<Rank> ranks = Arrays.asList(SIX, TWO, FOUR, FIVE,
        SEVEN);
    List<Suit> suits = Arrays
        .asList(Clubs, Clubs, Clubs, Clubs,
            Clubs);
    Hand hand = createHand(ranks, suits);
    assertTrue(pokerHands.hasFlush(hand));
  }

  @Test
  void shouldNotFindFlush() {
    List<Rank> ranks = Arrays.asList(SIX, TWO, FOUR, FIVE,
        SEVEN);
    List<Suit> suits = Arrays
        .asList(Diamonds, Clubs, Clubs, Clubs,
            Clubs);
    Hand hand = createHand(ranks, suits);
    assertFalse(pokerHands.hasFlush(hand));
  }

  @Test
  void shouldFindStraight() {
    List<Rank> ranks = Arrays.asList(TWO, THREE, FOUR, SIX, FIVE);
    List<Suit> suits = Arrays.asList(Clubs, Diamonds, Clubs, Spades, Clubs);
    Hand hand = createHand(ranks, suits);
    assertTrue(pokerHands.hasStraight(hand));
  }

  @Test
  void shouldFindAceLowStraight() {
    List<Rank> ranks = Arrays.asList(ACE, THREE, FOUR, TWO,
        FIVE);
    List<Suit> suits = Arrays
        .asList(Clubs, Diamonds, Clubs, Spades,
            Clubs);
    Hand hand = createHand(ranks, suits);
    assertTrue(pokerHands.hasStraight(hand));
  }

  @Test
  void shouldFindAceHighStraight() {
    List<Rank> ranks = Arrays.asList(ACE, TEN, QUEEN, JACK,
        KING);
    List<Suit> suits = Arrays
        .asList(Clubs, Diamonds, Clubs, Spades,
            Clubs);
    Hand hand = createHand(ranks, suits);
    assertTrue(pokerHands.hasStraight(hand));
  }

  @Test
  void shouldNotFindStraight() {
    List<Rank> ranks = Arrays.asList(ACE, TWO, KING, THREE, FIVE);
    List<Suit> suits = Arrays.asList(Clubs, Diamonds, Clubs, Spades, Clubs);
    Hand hand = createHand(ranks, suits);
    assertFalse(pokerHands.hasStraight(hand));
  }

  @Test
  void shouldNotFindStraightWhenOnlyFourInARow() {
    List<Rank> ranks = Arrays.asList(TWO, THREE, FOUR, FIVE,
        SEVEN);
    List<Suit> suits = Arrays
        .asList(Clubs, Diamonds, Clubs, Spades,
            Clubs);
    Hand hand = createHand(ranks, suits);
    assertFalse(pokerHands.hasStraight(hand));
  }

  @Test
  void shouldFindStraightFlush() {
    List<Rank> ranks = Arrays.asList(TWO, FOUR, THREE, SIX,
        FIVE);
    List<Suit> suits = Arrays
        .asList(Clubs, Clubs, Clubs, Clubs,
            Clubs);
    Hand hand = createHand(ranks, suits);
    assertTrue(pokerHands.hasStraightFlush(hand));
  }

  @Test
  void shouldNotFindStraightFlush() {
    List<Rank> ranks = Arrays.asList(TWO, FOUR, THREE, SIX,
        FIVE);
    List<Suit> suits = Arrays
        .asList(Clubs, Diamonds, Clubs, Clubs,
            Clubs);
    Hand hand = createHand(ranks, suits);
    assertFalse(pokerHands.hasStraightFlush(hand));
  }

  @Test
  void shouldFindRoyalFlush() {
    List<Rank> ranks = Arrays.asList(TEN, JACK, QUEEN, KING,
        ACE);
    List<Suit> suits = Arrays
        .asList(Clubs, Clubs, Clubs, Clubs,
            Clubs);
    Hand hand = createHand(ranks, suits);
    assertTrue(pokerHands.hasRoyalFlush(hand));
  }

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

