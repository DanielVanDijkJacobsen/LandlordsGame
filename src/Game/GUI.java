package Game;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;

public class GUI {
    public GameMaster theGame;

    @FXML private Button rollDice;

    @FXML private Group playerTokens;
    @FXML private Label playerName1; @FXML private Label playerWealth1; @FXML private Label playerPosition1;
    @FXML private Label playerName2; @FXML private Label playerWealth2; @FXML private Label playerPosition2;
    @FXML private Label playerName3; @FXML private Label playerWealth3; @FXML private Label playerPosition3;
    @FXML private Label playerName4; @FXML private Label playerWealth4; @FXML private Label playerPosition4;
    @FXML private Label playerName5; @FXML private Label playerWealth5; @FXML private Label playerPosition5;
    @FXML private Label playerName6; @FXML private Label playerWealth6; @FXML private Label playerPosition6;

    @FXML private Group plots;

    @FXML
    private void rollDiceAction(Event event) {
        if (theGame.players.get(theGame.turnOrder).boardPosition == 0) {
            //Make jail actions. Break and Return functions to break method.
        } else {
            theGame.throwDiceToMove(theGame.players.get(theGame.turnOrder));
        }
        System.out.println(theGame.turnOrder + " " + theGame.players.get(theGame.turnOrder).boardPosition);
        updatePlayerTokens();
        if (theGame.board.plotsOnBoard.get((theGame.players.get(theGame.turnOrder).boardPosition)-1).event != null) {
            //Do event stuff.
        } else if (theGame.board.ownerships.get(theGame.players.get(theGame.turnOrder).boardPosition) == null) {
            //Do buy property stuff.
        } else {
            //Do payment stuff.
        }
        if (theGame.die1.result == theGame.die2.result) {
            theGame.throwDiceToMove(theGame.players.get(theGame.turnOrder));
            updatePlayerTokens();
            //Take an extra turn.
            if (theGame.die1.result == theGame.die2.result) {
                theGame.throwDiceToMove(theGame.players.get(theGame.turnOrder));
                updatePlayerTokens();
                if (theGame.die1.result == theGame.die2.result) {
                    //Go to jail, you criminal, think of the dice!
                    theGame.players.get(theGame.turnOrder).boardPosition = 0;
                    updatePlayerTokens();
                } else {
                    //Take another extra turn.
                }

            }
        }
        updatePlayerStatistics();
        //Check for bankruptcy and game objectives.
        theGame.endTurn();
    }

    public void updatePlayerTokens() {
        playerTokens.getChildren().get(theGame.turnOrder).setLayoutY(plots.getChildren().get(theGame.players.
                get(theGame.turnOrder).boardPosition).getLayoutY()+(10+(8*theGame.turnOrder)));
        playerTokens.getChildren().get(theGame.turnOrder).setLayoutX(plots.getChildren().get(theGame.players.
                get(theGame.turnOrder).boardPosition).getLayoutX()+10);
    }

    public void updateAllPlayerTokens() {
        for (int i = 0; i < theGame.players.size(); i++) {
            playerTokens.getChildren().get(i).setLayoutY(plots.getChildren().get(theGame.players.get(i).boardPosition).
                    getLayoutY()+(10+(8*i)));
            playerTokens.getChildren().get(i).setLayoutX(plots.getChildren().get(theGame.players.get(i).boardPosition).
                    getLayoutX()+10);
        }
    }

    public void updatePlayerStatistics() {
        for (int i = 0; i < theGame.players.size(); i++) {
            theGame.players.get(i).javaFXlabels.get("Name").setText(theGame.players.get(i).name);
            theGame.players.get(i).javaFXlabels.get("Wealth").setText(theGame.players.get(i).wealth + ",-");
            theGame.players.get(i).javaFXlabels.get("Placement").setText("Placement: " +
                    theGame.players.get(i).boardPosition);
        }
    }

    public void setupBoard() {
        for (int i =0; i < plots.getChildren().size(); i++) {
            Node nodeRectangle = plots.getChildren().get(i);
            if (nodeRectangle instanceof Rectangle && theGame.board.plotsOnBoard.get(i).district != null) {
                Stop[] stops = new Stop[] {new Stop(0, Color.BLACK),
                        new Stop(1, Color.valueOf(theGame.board.plotsOnBoard.get(i).district))};
                LinearGradient linearGradient = new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE, stops);
                ((Rectangle) nodeRectangle).setFill(linearGradient);
            }
        }
    }

    public void setupPlayers() {
        theGame.players.get(0).javaFXlabels.put("Name",playerName1);
        theGame.players.get(0).javaFXlabels.put("Wealth",playerWealth1);
        theGame.players.get(0).javaFXlabels.put("Placement",playerPosition1);
        theGame.players.get(1).javaFXlabels.put("Name",playerName2);
        theGame.players.get(1).javaFXlabels.put("Wealth",playerWealth2);
        theGame.players.get(1).javaFXlabels.put("Placement",playerPosition2);
        theGame.players.get(2).javaFXlabels.put("Name",playerName3);
        theGame.players.get(2).javaFXlabels.put("Wealth",playerWealth3);
        theGame.players.get(2).javaFXlabels.put("Placement",playerPosition3);
        if (theGame.players.size() > 3) {
            theGame.players.get(3).javaFXlabels.put("Name",playerName4);
            theGame.players.get(3).javaFXlabels.put("Wealth",playerWealth4);
            theGame.players.get(3).javaFXlabels.put("Placement",playerPosition4);
            if (theGame.players.size() > 4) {
                theGame.players.get(4).javaFXlabels.put("Name",playerName5);
                theGame.players.get(4).javaFXlabels.put("Wealth",playerWealth5);
                theGame.players.get(4).javaFXlabels.put("Placement",playerPosition5);
                if (theGame.players.size() > 5) {
                    theGame.players.get(5).javaFXlabels.put("Name",playerName6);
                    theGame.players.get(5).javaFXlabels.put("Wealth",playerWealth6);
                    theGame.players.get(5).javaFXlabels.put("Placement",playerPosition6);
                } else {
                    playerName6.setVisible(false);
                    playerWealth6.setVisible(false);
                    playerPosition6.setVisible(false);
                    playerTokens.getChildren().get(5).setVisible(false);
                }
            } else {
                playerName5.setVisible(false);
                playerWealth5.setVisible(false);
                playerPosition5.setVisible(false);
                playerTokens.getChildren().get(4).setVisible(false);
                playerName6.setVisible(false);
                playerWealth6.setVisible(false);
                playerPosition6.setVisible(false);
                playerTokens.getChildren().get(5).setVisible(false);
            }
        } else {
            playerName4.setVisible(false);
            playerWealth4.setVisible(false);
            playerPosition4.setVisible(false);
            playerTokens.getChildren().get(3).setVisible(false);
            playerName5.setVisible(false);
            playerWealth5.setVisible(false);
            playerPosition5.setVisible(false);
            playerTokens.getChildren().get(4).setVisible(false);
            playerName6.setVisible(false);
            playerWealth6.setVisible(false);
            playerPosition6.setVisible(false);
            playerTokens.getChildren().get(5).setVisible(false);
        }
    }
}
