import java.util.*;

public class PokerHands {

    final int HANDSIZE = 5;
    private List<Card> cards;

    public Card selectHighestCard(Hand hand) {
        cards = hand.getCards();

        Card highestCard = hand.getCardByIndex(0);
        for (int i = 0; i < HANDSIZE; i++) {
            if (hand.getCardByIndex(i).getNumber() > highestCard.getNumber()) {
                highestCard = hand.getCardByIndex(i);
            }
        }
        return highestCard;
    }

    public List<Integer> hasMatchingCards(Hand hand) {

        List<Card> cards = hand.getCards();
        Map<Integer, Integer> cardNumberCount =  new HashMap<Integer, Integer>();

        List<Integer> matches = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

        for (int i = 0; i < HANDSIZE; i++) {
            int newValue = matches.get(hand.getCardByIndex(i).getNumber() - 2) + 1;
            matches.set(hand.getCardByIndex(i).getNumber() - 2, newValue);
        }

        return matches;
    }

    public boolean hasMatchingCombination(Hand hand, int matches, int frequency){
        return Collections.frequency(hasMatchingCards(hand), matches) == frequency;
    }

    public boolean hasFullHouse(Hand hand) {
        List<Integer> matches = hasMatchingCards(hand);
        return matches.contains(2) && matches.contains(3);
    }

    public boolean hasFlush(Hand hand) {
        cards = hand.getCards();
        Map<Card.Suit, Integer> suitCount =  new HashMap<Card.Suit, Integer>();
        suitCount.put(Card.Suit.Diamonds, 0);
        suitCount.put(Card.Suit.Hearts, 0);
        suitCount.put(Card.Suit.Clubs, 0);
        suitCount.put(Card.Suit.Spades, 0);

        cards.forEach(card -> suitCount.compute(card.getSuit(), (key, value) -> value + 1));

        return suitCount.containsValue(HANDSIZE);
    }

    public boolean hasStraight(Hand hand) {
        hand.sort();
        for (int i = 0; i < HANDSIZE - 1; i++) {
            if (currentCardIsAceAndFirstCardIsTwo(hand, i)) {
                if (hand.getCardByIndex(0).getNumber() == 2) {
                    return true;
                }
            } else if (!isNextCardOneNumberHigher(hand, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean currentCardIsAceAndFirstCardIsTwo(Hand hand, int i) {
        return hand.getCardByIndex(HANDSIZE - 1).getNumber() == 14 && i == HANDSIZE - 2;
    }

    private boolean isNextCardOneNumberHigher(Hand hand, int i) {
        return hand.getCardByIndex(i).getNumber() + 1 == hand.getCardByIndex(i + 1).getNumber();
    }

    public boolean hasStraightFlush(Hand hand) {
        return hasFlush(hand) && hasStraight(hand);
    }

    public boolean hasRoyalFlush(Hand hand) {
        return (hasFlush(hand) && hasStraight(hand)) && (selectHighestCard(hand).getNumber() == 14);
    }

}
