package Game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class ChanceDeck implements Serializable {
    public ArrayList<ChanceCard> theDeck = new ArrayList<>();
    public ArrayList<ChanceCard> discardPile = new ArrayList<>();

    public ChanceDeck() {
    }

    //Should be placed under players
    public ChanceCard drawCard() {
        ChanceCard cardDrawn = this.theDeck.get(0);
        this.discardPile.add(this.theDeck.get(0));
        this.theDeck.remove(0);
        if (this.theDeck.size() == 0) {
            fill();
            shuffle();
        }
        return cardDrawn;
    }
    
    private void shuffle() {
        Collections.shuffle(theDeck);
    }

    private void fill() {
        for (int i = 0; i < discardPile.size(); i++) {
            this.theDeck.add(this.discardPile.get(i));
        }
        this.discardPile.clear();
    }
}

