package Game.PopUpMessage;

import Game.ChanceCard;
import Game.GameMaster;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class ChanceInfo {

    public ChanceInfo (ChanceCard chanceCard, GameMaster game) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Chance Card.");
        alert.setHeaderText(chanceCard.text);
        alert.setContentText("Exciting!");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            //Adjust riches.
            game.players.get(game.turnOrder).wealth =
                    game.players.get(game.turnOrder).wealth + chanceCard.WealthChangePlayer;
            //Receive money from opponents.
            for (int i = 0; i < game.players.size(); i++) {
                game.players.get(game.turnOrder).wealth =
                        game.players.get(game.turnOrder).wealth + chanceCard.StealFromOpponents;
                game.players.get(i).wealth = game.players.get(i).wealth - chanceCard.StealFromOpponents;
            }
            //Move adjustment.
            game.players.get(game.turnOrder).boardPosition =
                    game.players.get(game.turnOrder).boardPosition + chanceCard.Move;
            //Move to.
            if (chanceCard.MoveTo != -1) {
                game.players.get(game.turnOrder).boardPosition = chanceCard.MoveTo;
            }
            //Move to nearest train.
            
        } else {
        }
    }
}
