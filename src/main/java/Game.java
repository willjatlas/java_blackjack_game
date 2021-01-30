import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private ArrayList<Player> players;
    private Deck deck;
    private Player dealer;
    private Player winner;
    private Scanner gameIn;
    private int numOfPlyrs;
    private int highHand;

    public Game(){
        this.players    = new ArrayList<Player>();
        this.deck       = new Deck();
        this.dealer     = new Player("Dealer");
        this.winner     = null;
        this.gameIn     = new Scanner(System.in);
        this.numOfPlyrs = 0;
        this.highHand   = 0;
    }

    public Deck getDeck(){ return this.deck; }

    public void addPlayer(Player player){ this.players.add(player); }

    public int getPlayersCount(){ return players.size();}

    public Player getWinner(){ return winner; }

    public void setNumOfPlyrs(int i){ numOfPlyrs = i; }

    public void askForNumOfPlayers(){
        System.out.println("How many players?: ");
        setNumOfPlyrs(gameIn.nextInt());
    }

    public void askForPlayerNames(){
        gameIn.nextLine();
        for(int i=1; i<=numOfPlyrs; i++){
            System.out.println("Player " + i + "'s name: ");
            String name = gameIn.nextLine();
            addPlayer(new Player(name.trim()));
        }
    }

    public Player getPlayerByName(String plyr){
        for(Player player : players){
            if(player.getName().equals(plyr)){
                return player;
            }
        }
        return null;
    }

    public void setUpCards(){
        deck.emptyDeck();
        deck.populateDeck();
        deck.shuffleDeck();
    }

    public void dealCardToPlayers(){
        for(Player player : players){
            deck.dealCardToPlayer(player);
        }
    }

    public void displayCards(){
        for(Player player : players){
            System.out.println(player.getName() + ": ");
            for(Card card : player.getHand()){
                System.out.println(card.getRank() + " of "
                                   + card.getSuit());
            }
        }
    }

   public void calcWinner(){
        for(Player player : players){
            player.calcHandTotal();
            int pTotal = player.getHandTotal();
            if(pTotal > highHand){
                highHand = pTotal;
                winner = player;
            }
        }
    }

    public void displayWinner(){
        System.out.println(winner.getName() +
                          " Won with a score of " +
                           winner.getHandTotal());
    }

    public void playGame(){
        setUpCards();
        addPlayer(dealer);
        askForNumOfPlayers();
        askForPlayerNames();
        dealCardToPlayers();
        dealCardToPlayers();
        displayCards();
        calcWinner();
        displayWinner();
        gameIn.close();
    }





}
