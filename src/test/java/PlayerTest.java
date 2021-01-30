import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Player player;
    Card card1;
    Card card2;

    @Before
    public void before(){
        player = new Player("Frankie");
        card1  = new Card(SuitType.HEARTS, RankType.JACK);
        card2  = new Card(SuitType.DIAMONDS, RankType.FIVE);
    }

    @Test
    public void canAddCardToHand(){
        player.addCardToHand(card1);
        assertEquals(1, player.getHandSize());
    }

    @Test
    public void canCalulateHandTotal(){
        player.addCardToHand(card1);
        player.addCardToHand(card2);
        player.calcHandTotal();
        assertEquals(15, player.getHandTotal());
    }

    @Test
    public void canEmptyHand(){
        player.addCardToHand(card1);
        player.addCardToHand(card2);
        player.emptyHand();
        assertEquals(0, player.getHandSize());
    }
}
