import model.Hand;
import org.springframework.beans.factory.annotation.Autowired;
import service.PokerHands;
import service.PokerHands.PokerHandList;

public class Application {

  @Autowired
  PokerHands pokerHands;

  public int compare(Hand hand1, Hand hand2){
    PokerHandList firstHandRank = pokerHands.getPokerHandFrom(hand1);
    PokerHandList secondHandRank = pokerHands.getPokerHandFrom(hand2);
    if(firstHandRank.getHandRanking() > secondHandRank.getHandRanking()) {
      return 1;
    } else {
      return 2;
    }
  }

}
