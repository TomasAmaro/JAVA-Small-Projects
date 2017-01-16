package org.academiadecodigo.MapEditor;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by tomasamaro on 26/10/16.
 */
public class Grid {

    public static int PADDING = 10;
    public static int CELL_SIZE = 10;

    private int cols;
    private int rows;
    private Cell cells[];



    public Grid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
    }

    public void gridCreator() {
        Rectangle grid = new Rectangle(PADDING, PADDING, cols * CELL_SIZE, rows * CELL_SIZE);
        grid.draw();
        cells = new Cell[cols * rows];
        int index = cols * rows;
        int col = 0;
        int row = 0;
        for (int i = 0; i < index; i++) {
            cells[i] = new Cell(col, row);
            col++;

            if (col % cols == 0) {
                col = 0;
                row++;
            }
        }

    }


    public void paintCell(Rectangle cell){
        cell.fill();
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public Cell[] getCells() {
        return cells;
    }
}
