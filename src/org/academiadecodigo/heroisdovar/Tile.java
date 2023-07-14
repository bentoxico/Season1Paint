package org.academiadecodigo.heroisdovar;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

import static org.academiadecodigo.heroisdovar.Grid.PADDING;

public class Tile {

    private Rectangle tile;
    private Color color;
    private boolean painted = false;

    public Tile(int row, int col){
        tile = new Rectangle(row,col,Grid.cellSize,Grid.cellSize);
    }

    public Color getColor() {
        return color;
    }

    public boolean isPainted() {
        return painted;
    }

    public void setPainted(boolean painted) {
        this.painted = painted;
    }
    public void draw(){
        tile.draw();
    }

    public void setTileColor(Color color){
        tile.setColor(color);
        this.color = color;
        tile.fill();
    }

    public int getX(){
        return tile.getX();
    }

    public int getY(){
        return tile.getY();
    }
}
