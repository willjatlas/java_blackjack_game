import java.lang.reflect.Array;
import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> hand;

    public Player(String name){
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public ArrayList<Card> getHand() { return hand; }

    public void addCardToHand(Card card) { this.hand.add(card); }

    public void emptyHand(){ this.hand.clear(); }

}
