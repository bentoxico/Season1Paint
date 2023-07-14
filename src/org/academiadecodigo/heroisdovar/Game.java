package org.academiadecodigo.heroisdovar;

public class Game {

    private TileManager tileManager = new TileManager();
    private Grid grid1 = new Grid();

    public void init(){
        grid1.setGridSize();
        tileManager.loadTiles();
        new Cursor(tileManager);
    }
}
