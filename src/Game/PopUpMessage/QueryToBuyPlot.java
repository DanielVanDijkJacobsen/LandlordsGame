package Game.PopUpMessage;

import Game.Player;
import Game.Plots.Plot;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class QueryToBuyPlot {

    public QueryToBuyPlot(Plot plot, Player player) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(plot.title);
        alert.setHeaderText(player.name + " will you buy " + plot.title + "?");
        alert.setContentText("The price for this property is: " + plot.value + ",-");

        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK) {
        } else {
        }

    }
}
