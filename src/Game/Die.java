package Game;

public class Die {
    int facets;
    int result;

    public Die(int facets) {
        this.facets = facets;
    }

    public void roll() {
        result = (int) (Math.random()*this.facets);
    }
}
