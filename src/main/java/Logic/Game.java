package Logic;

import Front.main_screen;
import Login.LoginPanel;

import javax.swing.*;
import java.util.ArrayList;

public class Game {
    GameStatus gameStatus;
    public Game(GameStatus gameStatus) {
        this.gameStatus=GameStatus.playing;
    }

    public static void main(String[] args) {
        main_screen m=new main_screen(null);
//        ArrayList tilesDeck=new ArrayList<Tile>();
//        createList(tilesDeck);
//        printdeck(tilesDeck);
//        Deck deck=new Deck();
//        ImageIcon icon=deck.tilesDeck.get(0).getImages();
//        System.out.println(icon);
    }
}
