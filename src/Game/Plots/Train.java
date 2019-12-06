package Game.Plots;

public class Train extends Plot {

    public Train(int ID, String title) {
        super(ID, title);
        this.ID = ID;
        this.title = title;
        this.value = 4000;
        this.rent = new int[]{500, 1000, 2000, 4000};
        this.district = "GOLD";
    }
}
