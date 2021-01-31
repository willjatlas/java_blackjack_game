import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> hand;
    private int handTotal;
    private boolean isBust;

    public Player(String name){
        this.name      = name;
        this.hand      = new ArrayList<>();
        this.handTotal = 0;
        this.isBust    = false;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public ArrayList<Card> getHand() { return hand; }

    public int getHandSize() { return hand.size(); }

    public int getHandTotal() { return handTotal; }

    public boolean getIsBust() { return isBust; }

    public void setIsBust(boolean value) { isBust = value;}

    public void addCardToHand(Card card) { this.hand.add(card); }

    public void emptyHand(){ this.hand.clear(); }

    public void calcHandTotal(){
        handTotal = 0;
        for(Card card : hand){
            handTotal += card.getRank().getValue();
        }
    }

}
