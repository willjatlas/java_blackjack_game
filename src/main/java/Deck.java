import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static java.util.Collections.shuffle;

public class Deck {

    private ArrayList<Card> cardDeck;

    public Deck() { this.cardDeck = new ArrayList<Card>(); }

    public ArrayList<Card> getCardDeck() { return cardDeck; }

    public void setCardDeck(ArrayList<Card> cardDeck) { this.cardDeck = cardDeck; }

    public int getDeckCount() { return this.cardDeck.size(); }

    public Card getCardByElement(int index){ return this.cardDeck.remove(index); }

    public void addCard(Card card) {
        this.cardDeck.add(card);
    }

    public void emptyDeck(){ this.cardDeck.clear(); }

    public void populateDeck() {
        for (SuitType suit : SuitType.values()){
            for (RankType rank : RankType.values()){
                addCard(new Card(suit, rank));
            }
        }
    }

    public void shuffleDeck(){
        shuffle(cardDeck);
    }

    public Card dealCard() {
        return getCardByElement(0);
    }

    public void dealCardToPlayer(Player player) {
        player.addCardToHand(dealCard());
    }
}
