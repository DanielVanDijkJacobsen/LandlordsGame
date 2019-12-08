package Game.Management;

import Game.GameMaster;
import Game.Player;
import Game.Plots.Plot;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Map;

public class ManagementController {
    @FXML TableView tableOfProperties;
    TableColumn<Plot, String> titleColumn = new TableColumn<>("Title");
    TableColumn<Plot, Integer> valueColumn = new TableColumn<>("Value");
    TableColumn<Plot, Boolean> monopolyColumn = new TableColumn<>("Monopoly");
    TableColumn<Plot, Integer> housesColumn = new TableColumn<>("Houses");
    TableColumn<Plot, Boolean> hotelColumn = new TableColumn<>("Hotel");
    TableColumn<Plot, Integer> rentColumn = new TableColumn<>("Rent");
    TableColumn<Plot, Button> upgradeColumn = new TableColumn<>("Upgrade");
    TableColumn<Plot, Button> sellColumn = new TableColumn<>("Sell Assets");
    TableColumn<Plot, Button> pawnColumn = new TableColumn<>("Pawn");

    public GameMaster game;
    ObservableList<Plot> data = FXCollections.observableArrayList();

    public void fillTable() {
        Player activePlayer = game.players.get(game.turnOrder);
        for (Map.Entry<Integer,Integer> entry : game.board.ownerships.entrySet()) {
            if (entry.getValue() == activePlayer.ID) {
                data.add(game.board.plotsOnBoard.get(entry.getKey()));
            }
        }
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        tableOfProperties.setItems(data);
        tableOfProperties.getColumns().addAll(titleColumn,valueColumn,monopolyColumn,housesColumn,hotelColumn,
                rentColumn, upgradeColumn, sellColumn, pawnColumn);
    }
}
