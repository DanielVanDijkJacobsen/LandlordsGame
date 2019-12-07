package Game.PopUpMessage;

import Game.GameMaster;
import Game.Player;
import Game.Plots.Plot;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class PayRentInfoNormal {

    public PayRentInfoNormal(GameMaster game) {
        Player playerToPay = game.players.get(game.turnOrder);
        Plot plot = game.board.plotsOnBoard.get(playerToPay.boardPosition);
        Player playerToReceive = game.players.get(game.board.ownerships.get(plot.ID));
        int rent = plot.rent[plot.upgrades];

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Pay Rent.");
        alert.setHeaderText(playerToPay.name + " must pay " + playerToReceive.name + " a rent of " +
                rent + " for visiting " + plot.title);
        alert.setContentText("Press to pay, you have no choice.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            playerToPay.wealth = playerToPay.wealth - rent;
            playerToReceive.wealth = playerToReceive.wealth + rent;
        } else {
        }
    }
}
