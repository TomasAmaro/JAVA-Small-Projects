package org.academiadecodigo.MapEditor;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by tomasamaro on 26/10/16.
 */
public class Cell {

    private Position pos;
    private boolean painted = false;
    private Rectangle cell;
    private MapEditor mapEditor;


    public Cell(int col, int row) {
        pos = new Position();
        pos.setCol(col);
        pos.setRow(row);
        cell = new Rectangle(col*Grid.CELL_SIZE+Grid.PADDING,row*Grid.CELL_SIZE+Grid.PADDING,Grid.CELL_SIZE,Grid.CELL_SIZE);
        cell.setColor(Color.BLACK);
        cell.draw();
    }

    public void toggleCell(){
        painted = !painted;
    }

    public Rectangle getCell() {
        return cell;
    }

    public void paintCell(Color color){
        painted = true;
        cell.setColor(color);
        cell.fill();
    }

    public void eraseCell(){
        cell.setColor(Color.BLACK);
        cell.draw();
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public void setPainted(boolean painted) {
        this.painted = painted;
    }

    public boolean isPainted() {
        return painted;
    }

    @Override
    public String toString() {
//        return "Cell{" +
//                "pos=" + pos +
//                ", painted=" + painted +
//                ", cell=" + cell +
//                '}';

        if (painted) {
            return "1";

        }
        return "0";
    }
}



