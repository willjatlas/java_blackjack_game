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

    public void setIfBust(Player player) {
        if (player.getHandTotal() > 21) player.setIsBust(true);
    }

    public void displayAllCards(){
        for(Player player : players){
            System.out.println(player.getName() + ": ");
            for(Card card : player.getHand()){
                System.out.println(card.getRank() + " of "
                                   + card.getSuit());
            }
        }
    }

    public void displayPlayerCards(Player player){
        System.out.println(player.getName() + ": ");
        for(Card card : player.getHand()){
            System.out.println(card.getRank() + " of "
                    + card.getSuit());
        }
    }

   public void calcWinner(){
        for (Player player : players) {
            if (!player.getIsBust()) {
                player.calcHandTotal();
                int pTotal = player.getHandTotal();
                if (pTotal > highHand) {
                    highHand = pTotal;
                    winner = player;
                }
            }
        }
    }

    public void displayWinner(){
        if(winner != null) {
            System.out.println(winner.getName() +
                    " Won with a score of " +
                    winner.getHandTotal());
        }
        else System.out.println("Everyone is BUST");
    }

    public boolean checkYesOrNo(String input){
        String i = input.trim().toLowerCase();
        boolean out = false;
        if(i.equals("y")){
            out = true;
        }
        else if (!"n".equals(i)) {
            System.out.println("Unrecognised input, try (y) or (n)...");
            checkYesOrNo(gameIn.nextLine());
        }
        return out;
    }

    public void askTwistOrStick(Player player){
        System.out.println(player.getName() + ", twist (y) or stick (n) ?! ");
        if(checkYesOrNo(gameIn.nextLine())){
            deck.dealCardToPlayer(player);
            displayPlayerCards(player);
            player.calcHandTotal();
            System.out.println(player.getHandTotal());
            setIfBust(player);
            if(!player.getIsBust()) {
                askTwistOrStick(player);
            }
            else System.out.println("Sorry " + player.getName() + ", you're BUST!");
        }
    }

    public void checkPlayersTwistOrStick(){
        for(Player player : players.subList(1, players.size())){
            askTwistOrStick(player);
        }
    }

    public void checkDealerPlay(){
        dealer.calcHandTotal();
        if(dealer.getHandTotal() < 16){
            deck.dealCardToPlayer(dealer);
            dealer.calcHandTotal();
            setIfBust(dealer);
            if(!dealer.getIsBust()) {
                checkDealerPlay();
            }
            else System.out.println("Dealer is bust!");
        }
    }

    public void playGame(){
        setUpCards();
        addPlayer(dealer);
        askForNumOfPlayers();
        askForPlayerNames();
        dealCardToPlayers();
        dealCardToPlayers();
        displayAllCards();
        checkPlayersTwistOrStick();
        checkDealerPlay();
        displayAllCards();
        calcWinner();
        displayWinner();
        gameIn.close();
    }

}
