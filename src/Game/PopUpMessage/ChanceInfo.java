package Game.PopUpMessage;

import Game.ChanceCard;
import Game.GameMaster;
import Game.Plots.Train;
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
            int lastPlacement = game.players.get(game.turnOrder).boardPosition;
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
                //Determine if start have been passed.
                if (game.players.get(game.turnOrder).boardPosition < lastPlacement
                        && game.players.get(game.turnOrder).boardPosition != 0) {
                    game.players.get(game.turnOrder).wealth = game.players.get(game.turnOrder).wealth;
                }
            }
            //Move to nearest train.
            if (chanceCard.trainMove) {
                boolean trainFound = false;
                for (int i = game.players.get(game.turnOrder).boardPosition+1; i < game.board.plotsOnBoard.size(); i++) {
                    if (game.board.plotsOnBoard.get(i) instanceof Train) {
                        game.players.get(game.turnOrder).boardPosition = game.board.plotsOnBoard.get(i).ID;
                        //Code for double pay
                        if (chanceCard.doublePay) {
                            //INSERT CODE FOR PAYMENT, BOOLEAN TYPE?
                        }
                        trainFound = true;
                        break;
                    }
                }
                if (!trainFound) {
                    for (int i = 0; i < game.board.plotsOnBoard.size(); i++) {
                        if (game.board.plotsOnBoard.get(i) instanceof Train) {
                            game.players.get(game.turnOrder).boardPosition = game.board.plotsOnBoard.get(i).ID;
                            //Code for double pay
                            if (chanceCard.doublePay) {
                                //INSERT CODE FOR PAYMENT, BOOLEAN TYPE?
                            }
                            break;
                        }
                    }

                }
                //Determine if start have been passed.
                if (game.players.get(game.turnOrder).boardPosition < lastPlacement
                        && game.players.get(game.turnOrder).boardPosition != 0) {
                    game.players.get(game.turnOrder).wealth = game.players.get(game.turnOrder).wealth;
                }
            }
            //HouseTax and Hotel Tax
            //Jail Break Token
            if (chanceCard.jailBreakToken) {
                game.players.get(game.turnOrder).jailBreakTokens++;
            }
            //Determine legation.
            if (game.players.get(game.turnOrder).wealth < chanceCard.playerValueBelow) {
                game.players.get(game.turnOrder).wealth =
                        game.players.get(game.turnOrder).wealth + chanceCard.conditionMetWealthChange;
            }
        } else {
        }
    }
}
