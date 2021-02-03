import static model.Card.Rank.ACE;
import static model.Card.Rank.EIGHT;
import static model.Card.Rank.FIVE;
import static model.Card.Rank.JACK;
import static model.Card.Rank.KING;
import static model.Card.Rank.NINE;
import static model.Card.Rank.QUEEN;
import static model.Card.Rank.SEVEN;
import static model.Card.Rank.SIX;
import static model.Card.Rank.TEN;
import static model.Card.Rank.THREE;
import static model.Card.Rank.TWO;
import static model.Card.Rank.FOUR;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import model.Card;
import model.Card.Rank;
import model.Card.Suit;
import model.Hand;

public class PokerHands {

  final int HAND_SIZE = 5;

  public Card selectHighestCard(Hand hand) {
    Card highestCard = hand.getCardByIndex(0);
    for (int i = 0; i < HAND_SIZE; i++) {
      if (hand.getCardByIndex(i).getRankValue() > highestCard.getRankValue()) {
        highestCard = hand.getCardByIndex(i);
      }
    }
    return highestCard;
  }

  public boolean hasPair(Hand hand){
    return hasMatchingCombination(hand, 2, 1);
  }

  public boolean hasTwoPair(Hand hand){
    return hasMatchingCombination(hand, 2, 2);
  }

  public boolean hasThreeOfAKind(Hand hand){
    return hasMatchingCombination(hand, 3, 1);
  }

  public boolean hasFourOfAKind(Hand hand){
    return hasMatchingCombination(hand, 4, 1);
  }

  private boolean hasMatchingCombination(Hand hand, int matches, int frequency) {
    return frequency == Collections.frequency(getCountOfRanksFrom(hand).values(), matches);
  }

  public boolean hasFullHouse(Hand hand) {
    return getCountOfRanksFrom(hand).containsValue(2) && getCountOfRanksFrom(hand).containsValue(3);
  }

  public boolean hasFlush(Hand hand) {
    return getCountOfSuitsFrom(hand).containsValue(HAND_SIZE);
  }

  public boolean hasStraight(Hand hand) {
    List<Rank> ranks = findSingleOccurrencesOfRankIn(hand);
    Collections.sort(ranks);
    return isConditionForStraight(ranks) && ranks.size() == HAND_SIZE;
  }

  private List<Rank> findSingleOccurrencesOfRankIn(Hand hand) {
    return getCountOfRanksFrom(hand).entrySet().stream()
        .filter(entrySet -> entrySet.getValue().equals(1))
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());
  }

  private boolean isConditionForStraight(List<Rank> ranks) {
    return differenceBetweenHighestAndLowestCardRankIsFourIn(ranks) || hasFiveHighStraightIn(ranks);
  }

  private boolean differenceBetweenHighestAndLowestCardRankIsFourIn(List<Rank> ranks) {
    return getRankFromEndOf(ranks).getValue() - getRankFromStartOf(ranks).getValue() == 4;
  }

  private boolean hasFiveHighStraightIn(List<Rank> ranks) {
    return ranks.equals(Arrays.asList(TWO, THREE, FOUR, FIVE, ACE));
  }

  private Rank getRankFromEndOf(List<Rank> ranks) {
    return ranks.get(ranks.size()-1);
  }

  private Rank getRankFromStartOf(List<Rank> ranks) {
    return ranks.get(0);
  }

  public boolean hasStraightFlush(Hand hand) {
    return hasFlush(hand) && hasStraight(hand);
  }

  public boolean hasRoyalFlush(Hand hand) {
    return (hasFlush(hand) && hasStraight(hand)) && (selectHighestCard(hand).getRank()
        == ACE);
  }

  private Map<Rank, Integer> getCountOfRanksFrom(Hand hand) {
    Map<Rank, Integer> rankCount = new HashMap<>();
    rankCount.put(TWO, 0);
    rankCount.put(THREE, 0);
    rankCount.put(Rank.FOUR, 0);
    rankCount.put(FIVE, 0);
    rankCount.put(SIX, 0);
    rankCount.put(SEVEN, 0);
    rankCount.put(EIGHT, 0);
    rankCount.put(NINE, 0);
    rankCount.put(TEN, 0);
    rankCount.put(JACK, 0);
    rankCount.put(QUEEN, 0);
    rankCount.put(KING, 0);
    rankCount.put(ACE, 0);
    hand.getCards()
        .forEach(card -> rankCount.compute(card.getRank(), (key, value) -> setToZeroIfNull(value) + 1));
    return rankCount;
  }

  private Map<Suit, Integer> getCountOfSuitsFrom(Hand hand) {
    Map<Suit, Integer> suitCount = new HashMap<>();
    suitCount.put(Suit.Diamonds, 0);
    suitCount.put(Suit.Hearts, 0);
    suitCount.put(Suit.Clubs, 0);
    suitCount.put(Suit.Spades, 0);
    hand.getCards()
        .forEach(card -> suitCount.compute(card.getSuit(), (key, value) -> setToZeroIfNull(value) + 1));
    return suitCount;
  }

  private Integer setToZeroIfNull(Integer value) {
    return Optional.ofNullable(value)
        .orElse(0);
  }

}
