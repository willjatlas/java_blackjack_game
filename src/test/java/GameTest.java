import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    Game game;
    Player player1;
    Player player2;

    @Before
    public void before(){
        game    = new Game();
        player1 = new Player("Jackie Chan");
        player2 = new Player("Bruce Lee");
    }

    @Test
    public void canSetUpCards(){
        game.setUpCards();
        assertEquals(52, game.getDeck().getDeckCount());
    }

    @Test
    public void canDealPlayersACardEach(){
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.setUpCards();
        game.dealCardsToPlayers();
        assertEquals(1, game.getPlayerByName("Jackie Chan").getHandSize());
    }




}
