package service;

import static model.Card.Rank.ACE;
import static model.Card.Rank.EIGHT;
import static model.Card.Rank.FIVE;
import static model.Card.Rank.FOUR;
import static model.Card.Rank.JACK;
import static model.Card.Rank.KING;
import static model.Card.Rank.QUEEN;
import static model.Card.Rank.SEVEN;
import static model.Card.Rank.SIX;
import static model.Card.Rank.TEN;
import static model.Card.Rank.THREE;
import static model.Card.Rank.TWO;
import static model.Card.Suit.Clubs;
import static model.Card.Suit.Diamonds;
import static model.Card.Suit.Hearts;
import static model.Card.Suit.Spades;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static service.PokerHands.PokerHandList.FLUSH;
import static service.PokerHands.PokerHandList.FOUR_OF_A_KIND;
import static service.PokerHands.PokerHandList.FULL_HOUSE;
import static service.PokerHands.PokerHandList.HIGH_CARD;
import static service.PokerHands.PokerHandList.PAIR;
import static service.PokerHands.PokerHandList.ROYAL_FLUSH;
import static service.PokerHands.PokerHandList.STRAIGHT;
import static service.PokerHands.PokerHandList.STRAIGHT_FLUSH;
import static service.PokerHands.PokerHandList.THREE_OF_A_KIND;
import static service.PokerHands.PokerHandList.TWO_PAIR;

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
  void shouldFindPair() {
    List<Rank> ranks = Arrays.asList(SIX, TWO, FOUR, FOUR, FIVE);
    List<Suit> suits = Arrays
        .asList(Clubs, Clubs, Clubs, Hearts,
            Clubs);
    Hand hand = createHand(ranks, suits);
    assertEquals(PAIR, pokerHands.getPokerHandFrom(hand));
  }

  @Test
  void shouldFindTwoPair() {
    List<Rank> ranks = Arrays.asList(SIX, TWO, FOUR, FOUR,
        TWO);
    List<Suit> suits = Arrays.asList(Clubs, Clubs, Clubs, Clubs,
        Hearts);
    Hand hand = createHand(ranks, suits);
    assertEquals(TWO_PAIR, pokerHands.getPokerHandFrom(hand));
  }

  @Test
  void shouldFindThreeOfAKind() {
    List<Rank> ranks = Arrays.asList(SIX, TWO, FOUR, FOUR,
        FOUR);
    List<Suit> suits = Arrays
        .asList(Clubs, Clubs, Clubs, Hearts,
            Spades);
    Hand hand = createHand(ranks, suits);
    assertEquals(THREE_OF_A_KIND, pokerHands.getPokerHandFrom(hand));
  }

  @Test
  void shouldFindStraight() {
    List<Rank> ranks = Arrays.asList(TWO, THREE, FOUR, SIX, FIVE);
    List<Suit> suits = Arrays.asList(Clubs, Diamonds, Clubs, Spades, Clubs);
    Hand hand = createHand(ranks, suits);
    assertEquals(STRAIGHT, pokerHands.getPokerHandFrom(hand));
  }

  @Test
  void shouldFindAceLowStraight() {
    List<Rank> ranks = Arrays.asList(ACE, THREE, FOUR, TWO,
        FIVE);
    List<Suit> suits = Arrays
        .asList(Clubs, Diamonds, Clubs, Spades,
            Clubs);
    Hand hand = createHand(ranks, suits);
    assertEquals(STRAIGHT, pokerHands.getPokerHandFrom(hand));
  }

  @Test
  void shouldFindFlush() {
    List<Rank> ranks = Arrays.asList(SIX, TWO, FOUR, FIVE,
        SEVEN);
    List<Suit> suits = Arrays
        .asList(Clubs, Clubs, Clubs, Clubs,
            Clubs);
    Hand hand = createHand(ranks, suits);
    assertEquals(FLUSH, pokerHands.getPokerHandFrom(hand));
  }

  @Test
  void shouldFindFullHouse() {
    List<Rank> ranks = Arrays.asList(TWO, TWO, FOUR, FOUR,
        FOUR);
    List<Suit> suits = Arrays.asList(Clubs, Diamonds, Clubs, Hearts,
        Spades);
    Hand hand = createHand(ranks, suits);
    assertEquals(FULL_HOUSE, pokerHands.getPokerHandFrom(hand));
  }

  @Test
  void shouldFindFourOfAKind() {
    List<Rank> ranks = Arrays.asList(SIX, FOUR, FOUR, FOUR,
        FOUR);
    List<Suit> suits = Arrays
        .asList(Clubs, Diamonds, Clubs, Hearts,
            Spades);
    Hand hand = createHand(ranks, suits);
    assertEquals(FOUR_OF_A_KIND, pokerHands.getPokerHandFrom(hand));
  }

  @Test
  void shouldFindStraightFlush() {
    List<Rank> ranks = Arrays.asList(TWO, FOUR, THREE, SIX,
        FIVE);
    List<Suit> suits = Arrays
        .asList(Clubs, Clubs, Clubs, Clubs,
            Clubs);
    Hand hand = createHand(ranks, suits);
    assertEquals(STRAIGHT_FLUSH, pokerHands.getPokerHandFrom(hand));
  }

  @Test
  void shouldFindRoyalFlush() {
    List<Rank> ranks = Arrays.asList(TEN, JACK, QUEEN, KING,
        ACE);
    List<Suit> suits = Arrays
        .asList(Clubs, Clubs, Clubs, Clubs,
            Clubs);
    Hand hand = createHand(ranks, suits);
    assertEquals(ROYAL_FLUSH, pokerHands.getPokerHandFrom(hand));
  }

  @Test
  void shouldNotFindStraightWhenOnlyFourInARow() {
    List<Rank> ranks = Arrays.asList(TWO, THREE, FOUR, FIVE,
        SEVEN);
    List<Suit> suits = Arrays
        .asList(Clubs, Diamonds, Clubs, Spades,
            Clubs);
    Hand hand = createHand(ranks, suits);
    assertEquals(HIGH_CARD, pokerHands.getPokerHandFrom(hand));
  }

  @Test
  void shouldReturnHighestCard() {
    List<Rank> ranks = Arrays.asList(EIGHT, TWO, THREE, FOUR, FIVE);
    List<Suit> suits = Arrays.asList(Diamonds, Clubs, Clubs, Clubs, Clubs);
    Hand hand = createHand(ranks, suits);
    assertEquals(HIGH_CARD, pokerHands.getPokerHandFrom(hand));
  }

  private Hand createHand(List<Rank> ranks, List<Suit> suits) {
    List<Card> cards =
        IntStream.range(0, ranks.size())
            .mapToObj(i -> new Card(ranks.get(i), suits.get(i)))
            .collect(Collectors.toList());
    return new Hand(cards);
  }
}

