package DataHandler;

import Game.GameMaster;
import java.io.*;

public class DataManager implements Serializable{
    String filepath;

    public DataManager(String filepath) {
        this.filepath = filepath;
    }

    //Saves a Game object to a file given in the DataManagers filepath.
    public void saveGameObjectToFile (GameMaster currentGame) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(currentGame);
            objectOut.close();
            System.out.println("Game successfully saved.");
        } catch (Exception ex) {
            System.out.println("Something went wrong with the save.");
            ex.printStackTrace();
        }
    }
    //Loads a Game object from a file given in the DataManagers filepath.
    public GameMaster loadGameObjectFromFile() {
        try {
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Object currentGame = objectIn.readObject();
            objectIn.close();
            System.out.println("The Game has been read.");
            return (GameMaster) currentGame;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Something went wrong with the load.");
            return null;
        }
    }
}