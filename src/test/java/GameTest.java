import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Card;
import model.Card.Rank;
import model.Card.Suit;
import model.Hand;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameTest  {

  @Mock
  private PokerHands pokerHands;
  @InjectMocks
  private Game game;


  @Before
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

//  @Test
//  public void shouldSayTwoPairBeatsASinglePair() {
//    Hand hand1 = mock(Hand.class);
//    Hand hand2 = mock(Hand.class);
//    when(pokerHands.hasMatchingCombination(any(), any(), any())).thenReturn(true);
//    assertEquals(1, game.compare(hand1, hand2));
//  }
}
