package Game.PopUpMessage;

import Game.ChanceCard;
import Game.Player;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class TaxPay {

    public TaxPay(Player player) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Tax.");
        alert.setHeaderText(player.name + " you must either pay 10% of " + player.value +
                " which is the value of your assets or 4000,-?");
        alert.setContentText("Will you pay to 10%?");
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK) {
            player.wealth = player.wealth - (player.value/10);
        } else {
            player.wealth = player.wealth -4000;
        }
    }
}
