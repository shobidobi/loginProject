package Logic;

import org.hibernate.mapping.Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    ArrayList<Tile> tilesDeck;

    public Deck() {
        this.tilesDeck=new ArrayList<Tile>();
        createList();
        Collections.shuffle(tilesDeck);

    }

    /**
     * The function creates the tile deck.
     */
    private void createList(){
        Tile tileY,tileU,tileB,tileR;
        for (Number num : Number.values()) {

            tileB=new Tile(num,Color.black);
            tilesDeck.add(tileB);
            tileR=new Tile(num,Color.red);
            tilesDeck.add(tileR);
            if(num!=Number.joker){
                tileY=new Tile(num,Color.yellow);
                tilesDeck.add(tileY);
                tileU=new Tile(num,Color.blue);
                tilesDeck.add(tileU);
            }
        }
        for (Number num : Number.values()) {
            if (num==Number.joker){continue;}
            tileB=new Tile(num,Color.black);
            tilesDeck.add(tileB);
            tileR=new Tile(num,Color.red);
            tilesDeck.add(tileR);
            tileY=new Tile(num,Color.yellow);
            tilesDeck.add(tileY);
            tileU=new Tile(num,Color.blue);
            tilesDeck.add(tileU);
        }

    }
    public void printdeck(){
        for (Tile t:tilesDeck) {
            System.out.println(t.toString());
        }
    }
    //הוצאת קלף
    public void pull_out_tile(int num_tiles,Player player){

    }

}
