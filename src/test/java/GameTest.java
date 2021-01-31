import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    Game game;
    Player player1;
    Player player2;
    Card card1;
    Card card2;
    Card card3;

    @Before
    public void before(){
        game    = new Game();
        player1 = new Player("Jackie Chan");
        player2 = new Player("Bruce Lee");
        card1   = new Card(SuitType.CLUBS, RankType.FIVE);
        card2   = new Card(SuitType.DIAMONDS, RankType.KING);
        card3   = new Card(SuitType.SPADES, RankType.ACE);
    }

    @Test
    public void canSetUpCards(){
        game.setUpCards();
        assertEquals(52, game.getDeck().getDeckCount());
    }

    @Test
    public void canAddPlayer(){
        game.addPlayer(player1);
        assertEquals(1, game.getPlayersCount());
    }

    @Test
    public void canGetPlayerByName(){
        game.addPlayer(player1);
        game.addPlayer(player2);
        assertEquals(player1, game.getPlayerByName("Jackie Chan"));
    }

    @Test
    public void canDealPlayersACardEach(){
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.setUpCards();
        game.dealCardToPlayers();
        assertEquals(1, game.getPlayerByName("Jackie Chan").getHandSize());
    }

    @Test
    public void canCalculateWinner(){
        player1.addCardToHand(card2);
        player2.addCardToHand(card2);
        player1.addCardToHand(card1);
        player2.addCardToHand(card3);
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.calcWinner();
        assertEquals(player1, game.getWinner());

    }

}
