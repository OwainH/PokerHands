import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static service.PokerHands.PokerHandList.PAIR;
import static service.PokerHands.PokerHandList.TWO_PAIR;

import model.Hand;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import service.PokerHands;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationTest {

  @Mock
  private PokerHands pokerHands;

  @InjectMocks
  private Application application;


  @Before
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void shouldSayTwoPairBeatsASinglePair() {
    Hand firstHand = mock(Hand.class);
    Hand secondHand = mock(Hand.class);
    when(pokerHands.getPokerHandFrom(any())).thenReturn(TWO_PAIR, PAIR);
    Assertions.assertEquals(1, application.compare(firstHand, secondHand));
  }

//  @Test
//  public void shouldSayTwoPairBeatsASinglePair() {
//    Hand hand1 = mock(Hand.class);
//    Hand hand2 = mock(Hand.class);
//    when(pokerHands.hasMatchingCombination(any(), any(), any())).thenReturn(true);
//    assertEquals(1, game.compare(hand1, hand2));
//  }
}
