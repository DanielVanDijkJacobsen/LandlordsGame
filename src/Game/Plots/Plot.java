package Game.Plots;

import java.io.Serializable;

public class Plot implements Serializable {
    public int ID;
    public int value;
    public String event; public String title;
    int rent[];
    public String district;

    //Creates dummy plot.
    public Plot(int ID) {
        this.ID = ID;
    }

    //Creates event plot.
    public Plot(int ID, String event) {
        this.ID = ID;
        this.event = event;
    }

    //Creates a plot belonging to a coloured monopoly
    public Plot(int ID, String title, int value, int rent, int U1, int U2, int U3, int U4, int U5, String district) {
        this.ID = ID;
        this.title = title;
        this.value = value;
        this.rent = new int[]{rent,U1,U2,U3,U4,U5};
        this.district = district;
    }

}
