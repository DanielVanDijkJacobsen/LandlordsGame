package GameCreator;

import DataHandler.JSONImporter;
import Game.GUI;
import Game.GameMaster;
import Game.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
        ObservableList playerNumber = FXCollections.observableArrayList("3","4","5","6");
        this.numberOfPlayers.setItems(playerNumber);
        ObservableList numberOfRounds = FXCollections.observableArrayList("0","10","15","20","25");
        this.maxNumberOfRounds.setItems(numberOfRounds);
        ObservableList listOfBoards = FXCollections.observableArrayList("Matador");
        this.boardOfChoice.setItems(listOfBoards);
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void startNewGameAction(ActionEvent event) {
        if (maxNumberOfRounds.getValue() != null && boardOfChoice.getValue() != null && numberOfPlayers != null) {
            GameMaster theGame = new GameMaster(Integer.parseInt((String) maxNumberOfRounds.getValue()), (String) boardOfChoice.getValue(),
                    auctionIfNotBought.isSelected(), fastStart.isSelected(), endOnBankruptcy.isSelected(),
                    endOnOverwhelmingWealth.isSelected(), differingInheritance.isSelected(),
                    randomizeTurnOrder.isSelected());
            JSONImporter jsonImporter = new JSONImporter();
            theGame.board = jsonImporter.createBoardJSON((String) boardOfChoice.getValue());
            Player player1 = new Player(namePlayer1.getCharacters().toString());
            theGame.players.add(player1);
            Player player2 = new Player(namePlayer2.getCharacters().toString());
            theGame.players.add(player2);
            Player player3 = new Player(namePlayer3.getCharacters().toString());
            theGame.players.add(player3);
            if (Integer.parseInt((String) numberOfPlayers.getValue()) > 3) {
                Player player4 = new Player(namePlayer4.getCharacters().toString());
                theGame.players.add(player4);
                if (Integer.parseInt((String) numberOfPlayers.getValue()) > 4) {
                    Player player5 = new Player(namePlayer5.getCharacters().toString());
                    theGame.players.add(player5);
                    if (Integer.parseInt((String) numberOfPlayers.getValue()) > 5) {
                        Player player6 = new Player(namePlayer6.getCharacters().toString());
                        theGame.players.add(player6);
                    }
                }
            }
            try {
                Stage gameCreatorStage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                Pane root = (Pane) loader.load(getClass().getResource("/Game/GUI.fxml").openStream());
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
}
