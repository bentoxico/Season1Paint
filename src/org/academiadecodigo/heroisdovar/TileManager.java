package org.academiadecodigo.heroisdovar;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

import java.io.*;
import java.util.Arrays;

public class TileManager {

    private Color color = Color.BLACK;
    private boolean painting = false;

    public boolean isPainting() {
        return painting;
    }

    public void setPainting(boolean painting) {
        this.painting = painting;
    }

    private Tile mapTiles[][] = new Tile[Grid.maxGridCol][Grid.maxGridRow];

    private int[][] numberTile = new int[Grid.maxGridCol][Grid.maxGridRow];


    public void loadTiles() {
        for (int col = 0; col < Grid.maxGridCol; col++) {
            for (int row = 0; row < Grid.maxGridRow; row++) {
                mapTiles[col][row] = new Tile(col * Grid.cellSize + Grid.PADDING, row * Grid.cellSize + Grid.PADDING);
                mapTiles[col][row].draw();
            }

        }
    }

    public void paintTile(Ellipse cursor) {
        for (int col = 0; col < Grid.maxGridCol; col++) {
            for (int row = 0; row < Grid.maxGridRow; row++) {
                if (cursor.getX() == mapTiles[col][row].getX() && cursor.getY() == mapTiles[col][row].getY()) {
                    mapTiles[col][row].setTileColor(paintSpecificColor(color));
                    mapTiles[col][row].setPainted(true);
                }
            }
        }
    }

    public Color paintSpecificColor(Color color) {
        return this.color = color;
    }

    public void eraseTile(Ellipse cursor) {
        for (int col = 0; col < Grid.maxGridCol; col++) {
            for (int row = 0; row < Grid.maxGridRow; row++) {
                if (cursor.getX() == mapTiles[col][row].getX() && cursor.getY() == mapTiles[col][row].getY() && mapTiles[col][row].isPainted()) {
                    mapTiles[col][row].setTileColor(Color.BLACK);
                    mapTiles[col][row].draw();
                }
            }
        }
    }

    public void save(String file) throws IOException {

        FileWriter writer = new FileWriter(file);
        BufferedWriter bWriter = new BufferedWriter(writer);

        for (int row = 0; row < Grid.maxGridRow; row++) {
            for (int col = 0; col < Grid.maxGridCol; col++) {

                if (mapTiles[col][row].getColor() == Color.BLACK) {
                    bWriter.write("1");
                    continue;
                } else if (mapTiles[col][row].getColor() == Color.RED) {
                    bWriter.write("2");
                    continue;
                } else if (mapTiles[col][row].getColor() == Color.BLUE) {
                    bWriter.write("3");
                    continue;
                } else if (mapTiles[col][row].getColor() == Color.YELLOW) {
                    bWriter.write("4");
                    continue;
                } else if (mapTiles[col][row].getColor() == Color.GREEN) {
                    bWriter.write("5");
                    continue;
                }
                bWriter.write("0");
            }
            bWriter.write("\n");
        }
        System.out.println("saved");
        bWriter.flush();
        bWriter.close();
    }


    public void loadLastSave(String file) throws IOException {

        FileReader reader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(reader);

        int col = 0;
        int row = 0;

        while (col < Grid.maxGridCol && row < Grid.maxGridRow) {
            String line = bReader.readLine();
            while (col < Grid.maxGridCol) {

                String[] number = line.split("");

                int num = Integer.parseInt(number[col]);

                numberTile[col][row] = num;

                if (num == 1) {
                    mapTiles[col][row].setTileColor(Color.BLACK);
                }
                if (num == 2) {
                    mapTiles[col][row].setTileColor(Color.RED);
                }
                if (num == 3) {
                    mapTiles[col][row].setTileColor(Color.BLUE);
                }
                if (num == 4) {
                    mapTiles[col][row].setTileColor(Color.YELLOW);
                }
                if (num == 5) {
                    mapTiles[col][row].setTileColor(Color.GREEN);
                }


                col++;
            }
            col = 0;
            row++;
        }
        System.out.println("loaded");
    }

    public void clearAll() {
        for (int row = 0; row < Grid.maxGridRow; row++) {
            for (int col = 0; col < Grid.maxGridCol; col++) {
                if (mapTiles[col][row].isPainted()) {
                    mapTiles[col][row].setTileColor(Color.BLACK);
                    mapTiles[col][row].draw();
                }
            }
        }
        System.out.println("clear");
    }
}
