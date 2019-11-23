package GameCreator;

import Game.GUI;
import Game.GameMaster;
import Game.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class GameCreator {
    @FXML
    private ComboBox numberOfPlayers;
    @FXML
    private TextField namePlayer1;
    @FXML
    private TextField namePlayer2;
    @FXML
    private TextField namePlayer3;
    @FXML
    private TextField namePlayer4;
    @FXML
    private TextField namePlayer5;
    @FXML
    private TextField namePlayer6;
    @FXML
    private ComboBox maxNumberOfRounds;
    @FXML
    private ComboBox boardOfChoice;
    @FXML
    private CheckBox auctionIfNotBought;
    @FXML
    private CheckBox fastStart;
    @FXML
    private CheckBox endOnBankruptcy;
    @FXML
    private CheckBox endOnOverwhelmingWealth;
    @FXML
    private CheckBox differingInheritance;
    @FXML
    private CheckBox randomizeTurnOrder;
    @FXML
    private Button startNewGame;

    public GameCreator() {
    }

    @FXML
    private void updateItems(Event event) {
        ObservableList playerNumber = FXCollections.observableArrayList("3 players","4 players","5 players",
                "6 players");
        this.numberOfPlayers.setItems(playerNumber);
        ObservableList numberOfRounds = FXCollections.observableArrayList("10 rounds","15 rounds","20 rounds",
                "25 rounds");
        this.maxNumberOfRounds.setItems(numberOfRounds);
        ObservableList listOfBoards = FXCollections.observableArrayList("Matador");
        this.boardOfChoice.setItems(listOfBoards);
    }

    @FXML
    private void startNewGameAction(javafx.event.ActionEvent event) {
        //Don't know if this will create a maxNumberOfRounds value for the creator, needs testing for 3 players as default, can we pick others?
        numberOfPlayers.getSelectionModel().selectFirst();
        GameMaster theGame = new GameMaster((Integer) maxNumberOfRounds.getValue(), (String) boardOfChoice.getValue(),
                auctionIfNotBought.isSelected(), fastStart.isSelected(), endOnBankruptcy.isSelected(),
                endOnOverwhelmingWealth.isSelected(), differingInheritance.isSelected(),
                randomizeTurnOrder.isSelected());
        Player player1 = new Player((String) namePlayer1.getCharacters()); theGame.players.add(player1);
        Player player2 = new Player((String) namePlayer2.getCharacters()); theGame.players.add(player2);
        Player player3 = new Player((String) namePlayer3.getCharacters()); theGame.players.add(player3);
        if ((Integer) numberOfPlayers.getValue() > 3) {
            Player player4 = new Player((String) namePlayer4.getCharacters()); theGame.players.add(player4);
            if ((Integer) numberOfPlayers.getValue() > 4) {
                Player player5 = new Player((String) namePlayer5.getCharacters()); theGame.players.add(player5);
                if ((Integer) numberOfPlayers.getValue() > 5) {
                    Player player6 = new Player((String) namePlayer6.getCharacters()); theGame.players.add(player6);
                }
            }
        }
        try {
            Stage gameCreatorStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/Game/GUI.fxml").openStream());
            GUI GUI = (GUI) loader.getController();
            GUI.theGame = theGame;
            Scene scene = new Scene(root);
            gameCreatorStage.setScene(scene);
            gameCreatorStage.setTitle("Landlord's Game");
            gameCreatorStage.setResizable(false);
            gameCreatorStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
