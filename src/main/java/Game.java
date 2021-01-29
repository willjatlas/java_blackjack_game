import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    private Deck deck;
    private Player dealer;
    private int numOfPlayers;

    public Game(){
        this.players = new ArrayList<Player>();
        this.deck    = new Deck();
        this.dealer  = new Player("Dealer");
    }

    public void addPlayer(Player player){ this.players.add(player); }

    public int countPlayers(){ return this.players.size(); }

    public void setUpCards(){
        deck.emptyDeck();
        deck.populateDeck();
        deck.shuffleDeck();
    }

    public void dealCardsToPlayers(){
        for(Player player : players){
            deck.dealCardToPlayer(player);
        }
    }

    public void playGame(){
        setUpCards();
        dealCardsToPlayers();


    }





}
