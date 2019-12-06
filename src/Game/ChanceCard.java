package Game;

import java.io.Serializable;

public class ChanceCard implements Serializable {
    public String text;
    public int WealthChangePlayer;
    public int StealFromOpponents;
    public int Move;
    public int MoveTo;
    public boolean trainMove;
    public boolean doublePay;
    public int houseTax;
    public int hotelTax;
    public boolean JailBreakToken;
    public int playerValueBelow;
    public int conditionMetWealthChange;

    public ChanceCard(String text, int wealthChangePlayer, int stealFromOpponents, int move, int moveTo,
                      boolean trainMove, boolean doublePay, int houseTax, int hotelTax, boolean jailBreakToken,
                      int playerValueBelow, int conditionMetWealthChange) {
        this.text = text;
        this.WealthChangePlayer = wealthChangePlayer;
        this.StealFromOpponents = stealFromOpponents;
        this.Move = move;
        this.MoveTo = moveTo;
        this.trainMove = trainMove;
        this.doublePay = doublePay;
        this.houseTax = houseTax;
        this.hotelTax = hotelTax;
        this.JailBreakToken = jailBreakToken;
        this.playerValueBelow = playerValueBelow;
        this.conditionMetWealthChange = conditionMetWealthChange;
    }
}
