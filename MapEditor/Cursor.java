package org.academiadecodigo.MapEditor;

/**
 * Created by tomasamaro on 26/10/16.
 */
public class Cursor extends Cell {

    private MapEditor mapEditor;


    public Cursor(int col, int row) {
        super(col, row);
        this.getCell().fill();
    }


    public void move(Directions direction) {

        switch (direction) {
            case UP:
                this.getCell().translate(0, -Grid.CELL_SIZE);
                super.getPos().setRow(-1);
                break;
            case DOWN:
                    this.getCell().translate(0, Grid.CELL_SIZE);
                    super.getPos().setRow(1);
                break;
            case LEFT:
                this.getCell().translate(-Grid.CELL_SIZE, 0);
                super.getPos().setCol(-1);
                break;
            case RIGHT:
                this.getCell().translate(Grid.CELL_SIZE, 0);
                super.getPos().setCol(1);
                break;
            default:
                System.out.println("Something went wrong on Direction Switch");
        }

    }


}
