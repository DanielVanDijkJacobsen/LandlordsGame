package Game;

import java.util.ArrayList;
import java.util.Collections;

public class ChanceDeck {
    public ArrayList<ChanceCard> theDeck;

    public ChanceDeck() {
        fill();
        shuffle();
    }

    //Should be placed under players
    public ChanceCard drawCard() {
        ChanceCard cardDrawn = this.theDeck.get(0);
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
        for (int i = 0; i < 40; i++) {
            ChanceCard aCard = new ChanceCard("Card number "+i);
        }
    }
}

class ChanceCard {
    String text;

    public ChanceCard(String text) {
        this.text = text;
    }
}