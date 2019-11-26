package StartMenu;

import Game.GUI;
import GameCreator.GameCreator;
import LoadGameInterface.LoadGameScreen;
import Options.OptionsInterface;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartMenuController implements Initializable {
    @FXML
    private Button newGame;
    @FXML
    private Button loadGame;
    @FXML
    private Button options;
    @FXML
    private Button exit;
    private JFXPanel stage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void runNewGame(ActionEvent event) {
        try {
            Stage gameCreatorStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/GameCreator/GameCreator.fxml").openStream());
            GameCreator gameCreator = (GameCreator)loader.getController();
            Scene scene = new Scene(root);
            gameCreatorStage.setScene(scene);
            gameCreatorStage.setTitle("Start new game");
            gameCreatorStage.setResizable(false);
            gameCreatorStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void runLoadGame(ActionEvent event) {
        try {
            Stage loadGameStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            FileChooser fileChooser = new FileChooser();
            Button btn = new Button("Select File");
            btn.setOnAction(e -> {
                File selectedFile = fileChooser.showOpenDialog(loadGameStage);
            });
            VBox vBox = new VBox(btn);
            Scene scene = new Scene(vBox, 400, 400);
            loadGameStage.setScene(scene);
            loadGameStage.show();
            Pane root = (Pane)loader.load(getClass().getResource("/LoadGameInterface/LoadGameScreen.fxml").openStream());
            LoadGameScreen loadGameScreen = (LoadGameScreen) loader.getController();
            loadGameStage.setScene(scene);
            loadGameStage.setTitle("Start new game");
            loadGameStage.setResizable(false);
            loadGameStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void runOptions(ActionEvent event) {
        try {
            Stage optionsStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/Options/OptionsInterface.fxml").openStream());
            OptionsInterface optionsInterface = (OptionsInterface) loader.getController();
            Scene scene = new Scene(root);
            optionsStage.setScene(scene);
            optionsStage.setTitle("Options");
            optionsStage.setResizable(false);
            optionsStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void exitGame(ActionEvent event) {
        System.exit(1);
    }
}
