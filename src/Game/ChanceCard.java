package Game;

public class ChanceCard {
    String text;
    int WealthChangePlayer;
    int StealFromOpponents;
    int Move;
    int MoveTo;
    boolean trainMove;
    boolean doublePay;
    int houseTax;
    int hotelTax;
    boolean JailBreakToken;
    int playerValueBelow;
    int conditionMetWealthChange;

    public ChanceCard(String text, int wealthChangePlayer, int stealFromOpponents, int move, int moveTo,
                      boolean trainMove, boolean doublePay, int houseTax, int hotelTax, boolean jailBreakToken,
                      int playerValueBelow, int conditionMetWealthChange) {
        this.text = text;
        WealthChangePlayer = wealthChangePlayer;
        StealFromOpponents = stealFromOpponents;
        Move = move;
        MoveTo = moveTo;
        this.trainMove = trainMove;
        this.doublePay = doublePay;
        this.houseTax = houseTax;
        this.hotelTax = hotelTax;
        JailBreakToken = jailBreakToken;
        this.playerValueBelow = playerValueBelow;
        this.conditionMetWealthChange = conditionMetWealthChange;
    }
}
