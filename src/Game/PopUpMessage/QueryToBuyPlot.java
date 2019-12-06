package Game.PopUpMessage;

import Game.Player;
import Game.Plots.Plot;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.HashMap;
import java.util.Optional;

public class QueryToBuyPlot {

    public QueryToBuyPlot(Plot plot, Player player, HashMap<Integer, Integer> ownerships) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(plot.title);
        alert.setHeaderText(player.name + " will you buy " + plot.title + "?");
        alert.setContentText("The price for this property is: " + plot.value + ",-, you currently have: " +
            player.wealth + ",-");
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK) {
            player.wealth = player.wealth - plot.value;
            ownerships.put(plot.ID, player.ID);
        } else {
        }
    }

}
