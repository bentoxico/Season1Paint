package org.academiadecodigo.heroisdovar;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Grid {

    public static final int PADDING = 10;
    public static int cellSize = 15;

    public static int maxGridCol = 32;

    public static int maxGridRow = 36;

    public static int gridWidth = cellSize * maxGridCol;

    public static int gridHeight = cellSize * maxGridRow;

    public void setGridSize(){
        Rectangle grid = new Rectangle(PADDING, PADDING,gridWidth,gridHeight);
        grid.draw();
        instructions();
    }

    public void instructions(){
        Text text = new Text(Grid.gridWidth + 30,30,"Instructions:");
        Text text1 = new Text(Grid.gridWidth + 30,50,"ARROW keys to move the cursor");
        Text text2 = new Text(Grid.gridWidth + 30,70,"Hold SPACEBAR do enter paint mode");
        Text text3 = new Text(Grid.gridWidth + 30,90,"C to clear all");
        Text text4 = new Text(Grid.gridWidth + 30,110,"D do erase a single block");
        Text text5 = new Text(Grid.gridWidth + 30,130,"S to save");
        Text text6 = new Text(Grid.gridWidth + 30,150,"L to load");
        Text text7 = new Text(Grid.gridWidth + 30,170,"1 to paint BLACK");
        Text text8 = new Text(Grid.gridWidth + 30,190,"2 to paint RED");
        Text text9 = new Text(Grid.gridWidth + 30,210,"3 to paint BLUE");
        Text text10 = new Text(Grid.gridWidth + 30,230,"4 to paint YELLOW");
        Text text11 = new Text(Grid.gridWidth + 30,250,"5 to paint GREEN");
        Text text12 = new Text(Grid.gridWidth + 30,270,"ESC to exit");



        text.draw();
        text1.draw();
        text2.draw();
        text3.draw();
        text4.draw();
        text5.draw();
        text6.draw();
        text7.draw();
        text8.draw();
        text9.draw();
        text10.draw();
        text11.draw();
        text12.draw();
    }
}
