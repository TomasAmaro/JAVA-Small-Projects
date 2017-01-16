package org.academiadecodigo.MapEditor;

import org.academiadecodigo.simplegraphics.graphics.Color;

import java.io.IOException;

/**
 * Created by tomasamaro on 26/10/16.
 */
public class MapEditor {

    private Grid grid;
    private Cursor cursor;
    private KeyboardforGrid keyboard;
    FileManager fileManager;

    public MapEditor(int gridCols, int gridRows) {
        this.grid = new Grid(gridCols, gridRows);
        grid.gridCreator();
        this.cursor = new Cursor(0, 0);
        this.keyboard = new KeyboardforGrid(this);
        this.fileManager = new FileManager();
    }

    public void init() {
       /* new Grid(50,50);
        new Cursor(0,0);
        new KeyboardforGrid(cursor);*/
    }


    public void toggleCell(Color color) {
        for (int i = 0; i < grid.getCells().length; i++) {

            if (grid.getCells()[i].getPos().getCol() == cursor.getPos().getCol() &&
                    grid.getCells()[i].getPos().getRow() == cursor.getPos().getRow() &&
                    grid.getCells()[i].isPainted()==false) {
                System.out.println(i);
                grid.getCells()[i].paintCell(color);
                grid.getCells()[i].setPainted(true);
                System.out.println("isPainted toggle state: " + grid.getCells()[i].isPainted());
            }
         /*   else {
                grid.getCells()[i].eraseCell();
                grid.getCells()[i].setPainted(false);
                System.out.println("isPainted toggle state: " + grid.getCells()[i].isPainted());
            }*/
        }

    }
/*
    public void eraseCell(){
        for (int i = 0; i < grid.getCells().length; i++) {
            if((grid.getCells()[i].getPos().getCol() == cursor.getPos().getCol()
                    && grid.getCells()[i].getPos().getRow() == cursor.getPos().getRow() &&grid.getCells()[i].isPainted())){
                System.out.println("isPainted toggle state: "+ grid.getCells()[i].isPainted());
                getGrid().getCells()[i].eraseCell();
                grid.getCells()[i].setPainted(false);
            }
        }
    }*/


    public void saveFile() throws IOException {
        String tempCharArray = "";
        for (int i = 0; i < grid.getCells().length; i++) {
            if (grid.getCells()[i].isPainted()) {
                tempCharArray = tempCharArray + "1";
                if (i % grid.getCols() == 0 && i != 0) {
                    tempCharArray = tempCharArray + "\n";
                }
            } else {
                tempCharArray = tempCharArray + "0";
                if (i % grid.getCols() == 0 && i != 0) {
                    tempCharArray = tempCharArray + "\n";
                }
            }
        }
        System.out.println(tempCharArray.toCharArray());
        fileManager.writeFile(
                tempCharArray.toCharArray(), "resources/MapText.txt"
        );

    }

    /*    public void moveCursor(Directions direction){
            switch (direction){
                case UP:
                    cursor.getCell().translate(0,-Grid.CELL_SIZE);
                    super.getPos().setRow(-1);
                    break;
                case DOWN:
                    cursor.getCell().translate(0,Grid.CELL_SIZE);
                    super.getPos().setRow(1);
                    break;
                case LEFT:
                    cursor.getCell().translate(-Grid.CELL_SIZE,0);
                    super.getPos().setCol(-1);
                    break;
                case RIGHT:
                    cursor.getCell().translate(Grid.CELL_SIZE,0);
                    super.getPos().setCol(1);
                    break;
                default:
                    System.out.println("Something went wrong on Direction Switch");

        }
        */
    public Cursor getCursor() {
        return cursor;
    }

    public Grid getGrid() {
        return grid;
    }
}


//TODO loadFile(){};
