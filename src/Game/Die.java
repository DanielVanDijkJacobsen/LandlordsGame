package Game;

import java.io.Serializable;

public class Die implements Serializable {
    int facets;
    public int result;

    public Die(int facets) {
        this.facets = facets;
    }

    public void roll() {
        result = (int) (Math.random()*this.facets);
    }
}
