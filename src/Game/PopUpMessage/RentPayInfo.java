package Game.PopUpMessage;

import Game.GameMaster;
import Game.Player;
import Game.Plots.Plot;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.HashMap;
import java.util.Optional;

import static sun.audio.AudioPlayer.player;

public class RentPayInfo {

public RentPayInfo(GameMaster game, Plot plot, Player player, HashMap<Integer, Integer> ownerships) {

    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(plot.title);
    alert.setHeaderText(player.name + "You have landed on " + plot.title);
    alert.setContentText("The rent for " + plot.title + "is " + plot.value);
    Optional<ButtonType> result = alert.showAndWait();
    if(result.get() == ButtonType.OK) {
        if (plot.ID==player.ID) {
            player.wealth = plot.value + player.wealth;


        }

   // else if (player.wealth = 0 || player.wealth < plot.rent)

    else {
        alert.setContentText("You have insufficient funds, you need to pawn something"); //skal tilføjes en måde at tilgå pantsætnings funktion

    }
    }


}
    public static void checkForupgrades(Plot plot, Player player, GameMaster game) {

    }
    public static void payRent (Plot plot, Player player, GameMaster game) {


    }
}
