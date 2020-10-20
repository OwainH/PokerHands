public class PokerHands {

    final int HANDSIZE = 5;


    public Card selectHighestCard(Hand hand){
        Card highestCard = hand.getCardByIndex(0);
        for(int i = 1; i < HANDSIZE; i++){
            if(hand.getCardByIndex(i).getNumber() > highestCard.getNumber()){
                highestCard = hand.getCardByIndex(i);
            }
        }
        return new Card(5, Card.Suit.Clubs);
    }

    public boolean hasMatchingCards(Hand hand, int requiredMatches){
        for(int i = 0; i < HANDSIZE; i++){
            int matches = 1;
            for(int j = 0; j < HANDSIZE; j++){
                if(i != j && hand.getCardByIndex(i).getNumber() == hand.getCardByIndex(j).getNumber()){
                    matches++;
                }
            }
            if(matches == requiredMatches){
                return true;
            }
        }
        return false;
    }

    public boolean hasFullHouse(Hand hand){
        return hasMatchingCards(hand, 2) && hasMatchingCards(hand, 3);
    }

    public boolean hasFlush(Hand hand){
        for(int i = 0; i < HANDSIZE; i++){
            int matches = 1;
            for(int j = 0; j < HANDSIZE; j++){
                if(i != j && hand.getCardByIndex(i).getSuit() == hand.getCardByIndex(j).getSuit()){
                    matches++;
                }
            }
            if(matches == HANDSIZE){
                return true;
            }
        }
        return false;
    }

    public boolean hasStraight(Hand hand){
        hand.sort();
        for(int i = 0; i < HANDSIZE - 1; i++){
            if(!(hand.getCardByIndex(i).getNumber() + 1 == hand.getCardByIndex(i + 1).getNumber())){
                return false;
            }
        }
        return true;
    }

    public boolean hasStraightFlush(Hand hand){
        return hasFlush(hand) && hasStraight(hand);
    }

    public boolean hasRoyalFlush(Hand hand){
        return hasFlush(hand) && hasStraight(hand) && (selectHighestCard(hand).getNumber() == 14);
    }

}
