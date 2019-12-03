package DataHandler;

import Game.Board;
import Game.ChanceCard;
import Game.ChanceDeck;
import Game.Plots.Plot;
import Game.Plots.Train;
import Game.Plots.Utility;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

//Følger denne guide https://howtodoinjava.com/library/json-simple-read-write-json-examples/

public class JSONImporter {
    JSONParser parser = new JSONParser();
    FileReader reader;

    public ChanceDeck createChanceDeckJson(String boardName) {
        ArrayList<ChanceCard> cardsForDeck = new ArrayList<>();
        try {
            reader = new FileReader("package.json");
            Object object = parser.parse(reader);
            JSONObject initialFile = (JSONObject) object;
            JSONObject boardObject = (JSONObject) initialFile.get("chanceCards");
            JSONArray arrayOfCards = (JSONArray) boardObject.get(boardName);
            for (int i = 0; i < arrayOfCards.size(); i++) {
                JSONObject cardJSONObject = (JSONObject) arrayOfCards.get(i);
                String cardText = cardJSONObject.get("Text").toString();
                int wealthPlayerChange;
                if (cardJSONObject.get("WealthChangePlayer") == null) {
                    wealthPlayerChange = 0;
                } else {
                    wealthPlayerChange = (int) (long) cardJSONObject.get("WealthChangePlayer");
                }
                int move;
                if (cardJSONObject.get("Move") == null) {
                    move = 0;
                } else {
                    move = (int) (long) cardJSONObject.get("Move");
                }
                int moveTo;
                if (cardJSONObject.get("MoveTo") == null) {
                    moveTo = -1;
                } else {
                    moveTo = (int) (long) cardJSONObject.get("MoveTo");
                }
                boolean trainMove;
                if (cardJSONObject.get("TrainMove") == null) {
                    trainMove = false;
                } else {
                    trainMove = (boolean) cardJSONObject.get("TrainMove");
                }
                boolean doublePay;
                if (cardJSONObject.get("DoublePay") == null) {
                    doublePay = false;
                } else {
                    doublePay = (boolean) cardJSONObject.get("DoublePay");
                }
                int stealFromOpponents;
                if (cardJSONObject.get("StealFromOpponents") == null) {
                    stealFromOpponents = 0;
                } else {
                    stealFromOpponents = (int) (long) cardJSONObject.get("StealFromOpponents");
                }
                int houseTax;
                if (cardJSONObject.get("HouseTax") == null) {
                    houseTax = 0;
                } else {
                    houseTax = (int) (long)  cardJSONObject.get("HouseTax");
                }
                int hotelTax;
                if (cardJSONObject.get("HotelTax") == null) {
                    hotelTax = 0;
                } else {
                    hotelTax = (int) (long)  cardJSONObject.get("HotelTax");
                }
                boolean jailBreakToken;
                if (cardJSONObject.get("JailBreakToken") == null) {
                    jailBreakToken = false;
                } else {
                    jailBreakToken = (boolean) cardJSONObject.get("JailBreakToken");
                }
                int playerValueBelow;
                if (cardJSONObject.get("PlayerValueBelow") == null) {
                    playerValueBelow = 0;
                } else {
                    playerValueBelow = (int) (long)  cardJSONObject.get("PlayerValueBelow");
                }
                int conditionMetWealthChange;
                if (cardJSONObject.get("ConditionMetWealthChange") == null) {
                    conditionMetWealthChange = 0;
                } else {
                    conditionMetWealthChange = (int) (long)  cardJSONObject.get("ConditionMetWealthChange");
                }
                ChanceCard chanceCard = new ChanceCard(cardText, wealthPlayerChange,stealFromOpponents,move,moveTo,
                        trainMove,doublePay,houseTax,hotelTax,jailBreakToken,playerValueBelow,conditionMetWealthChange);
                cardsForDeck.add(chanceCard);
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        ChanceDeck chanceDeck = new ChanceDeck();
        chanceDeck.theDeck.addAll(cardsForDeck);
        return chanceDeck;
    }

    public Board createBoardJSON(String boardName) {
        ArrayList <Plot> plotsForBoard = new ArrayList<>();
        try {
            reader = new FileReader("package.json");
            Object object = parser.parse(reader);
            Plot plot;
            JSONObject initialFile = (JSONObject) object;
            JSONObject boardObject = (JSONObject) initialFile.get("plots");
            JSONArray arrayOfPlots = (JSONArray) boardObject.get(boardName);
            for (int i = 0; i < arrayOfPlots.size(); i++) {
                JSONObject plotJSONObject = (JSONObject) arrayOfPlots.get(i);
                int plotID = Integer.parseInt(plotJSONObject.get("ID").toString());
                if (plotJSONObject.size() == 2) {
                    if (plotJSONObject.get("EVENT") == null) {
                        if (plotJSONObject.get("TRAIN") != null) {
                            plot = new Train(plotID,plotJSONObject.get("TRAIN").toString());
                        } else if (plotJSONObject.get("UTILITY") != null) {
                            plot = new Utility(plotID,plotJSONObject.get("UTILITY").toString());
                        } else {
                            plot = new Plot(plotID);
                        }
                    } else {
                        plot = new Plot(plotID,plotJSONObject.get("EVENT").toString());
                    }
                } else if (plotJSONObject.size() == 10) {
                    plot = new Plot(plotID, plotJSONObject.get("TITLE").toString(),
                            Integer.parseInt(plotJSONObject.get("PRICE").toString()),
                            Integer.parseInt(plotJSONObject.get("RENT").toString()),
                            Integer.parseInt(plotJSONObject.get("U1").toString()),
                            Integer.parseInt(plotJSONObject.get("U2").toString()),
                            Integer.parseInt(plotJSONObject.get("U3").toString()),
                            Integer.parseInt(plotJSONObject.get("U4").toString()),
                            Integer.parseInt(plotJSONObject.get("U5").toString()),
                            plotJSONObject.get("DISTRICT").toString());
                } else {
                    plot = new Plot(plotID);
                }
                plotsForBoard.add(plot);
            }
        } catch (ParseException | IOException e) {
                e.printStackTrace();
        }
        Board board = new Board();
        board.plotsOnBoard.addAll(plotsForBoard);
        return board;
    }

}
