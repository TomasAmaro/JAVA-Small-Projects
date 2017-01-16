package org.academiadecodigo.MapEditor;

/**
 * Created by tomasamaro on 26/10/16.
 */
public class Position {

    private int col;
    private int row;

    public int getCol() {
        return col;
    }

    public void setCol(int dif) {
        col += dif;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int dif) {
        row += dif;
    }


    @Override
    public String toString() {
        return "Position{" +
                "col=" + col +
                ", row=" + row +
                '}';
    }
}
