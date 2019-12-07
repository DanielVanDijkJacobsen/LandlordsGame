package Game.Management;

import Game.GameMaster;
import Game.Player;
import Game.Plots.Plot;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.Map;

public class ManagementController {
    @FXML TableView<Plot> tableOfProperties;
    @FXML TableColumn<Plot, String> titleColumn; @FXML TableColumn valueColumn; @FXML TableColumn monopolyColumn;
    @FXML TableColumn housesColumn; @FXML TableColumn hotelColumn; @FXML TableColumn rentColumn;
    @FXML TableColumn upgradeColumn; @FXML TableColumn sellColumn; @FXML TableColumn pawnColumn;

    public GameMaster game;
    ObservableList<Plot> plots = FXCollections.observableArrayList();

    public void fillTable() {
        Player activePlayer = game.players.get(game.turnOrder);
        for (Map.Entry<Integer,Integer> entry : game.board.ownerships.entrySet()) {
            if (entry.getValue() == activePlayer.ID) {
                plots.add(game.board.plotsOnBoard.get(entry.getKey()));
            }
        }
        tableOfProperties.setItems(plots);
        tableOfProperties.getColumns().addAll(titleColumn, valueColumn, monopolyColumn, housesColumn, hotelColumn,
                rentColumn, upgradeColumn, sellColumn, pawnColumn);
    }
}
