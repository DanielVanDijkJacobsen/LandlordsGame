package Game;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Arrays;

public class GUI {
    public GameMaster theGame;

    @FXML private Button rollDice;

    @FXML private Circle playerToken1; @FXML private Circle playerToken2; @FXML private Circle playerToken3;
    @FXML private Circle playerToken4; @FXML private Circle playerToken5; @FXML private Circle playerToken6;

    @FXML private Rectangle plot0; @FXML private Rectangle plot1; @FXML private Rectangle plot2;
    @FXML private Rectangle plot3; @FXML private Rectangle plot4; @FXML private Rectangle plot5;
    @FXML private Rectangle plot6; @FXML private Rectangle plot7; @FXML private Rectangle plot8;
    @FXML private Rectangle plot9; @FXML private Rectangle plot10; @FXML private Rectangle plot11;
    @FXML private Rectangle plot12; @FXML private Rectangle plot13; @FXML private Rectangle plot14;
    @FXML private Rectangle plot15; @FXML private Rectangle plot16; @FXML private Rectangle plot17;
    @FXML private Rectangle plot18; @FXML private Rectangle plot19; @FXML private Rectangle plot20;
    @FXML private Rectangle plot21; @FXML private Rectangle plot22; @FXML private Rectangle plot23;
    @FXML private Rectangle plot24; @FXML private Rectangle plot25; @FXML private Rectangle plot26;
    @FXML private Rectangle plot27; @FXML private Rectangle plot28; @FXML private Rectangle plot29;
    @FXML private Rectangle plot30; @FXML private Rectangle plot31; @FXML private Rectangle plot32;
    @FXML private Rectangle plot33; @FXML private Rectangle plot34; @FXML private Rectangle plot35;
    @FXML private Rectangle plot36; @FXML private Rectangle plot37; @FXML private Rectangle plot38;
    @FXML private Rectangle plot39; @FXML private Rectangle plot40;
    @FXML private ArrayList<Rectangle> plots = new ArrayList<>(Arrays.asList(plot0, plot1, plot2, plot3, plot4, plot5,
            plot6, plot7, plot8, plot9, plot10, plot11, plot12, plot13, plot14, plot15, plot16, plot17, plot18, plot19,
            plot20, plot21, plot22, plot23, plot24, plot25, plot26, plot27, plot28, plot29, plot30, plot31, plot32,
            plot33, plot34, plot35, plot36, plot37, plot38, plot39, plot40));

    @FXML
    private void rollDiceAction(Event event) {
        theGame.throwDiceToMove(theGame.players.get(0));
        System.out.println(plot1.getLayoutX());
        System.out.println(theGame.players.get(0).name);
        System.out.println(playerToken1.getLayoutX());
        System.out.println(theGame.players.get(0).boardPosition);
        playerToken1.setLayoutY(plot0.getLayoutY());
        playerToken1.setLayoutX(plots.get(theGame.players.get(0).boardPosition).getLayoutX());
        playerToken1.setLayoutY(plots.get(theGame.players.get(0).boardPosition).getLayoutY());
    }
}
