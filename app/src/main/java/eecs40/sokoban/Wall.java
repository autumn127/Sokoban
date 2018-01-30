package eecs40.sokoban;

/**
 * Created by autumnlee1 on 4/20/16.
 */
public class Wall extends Entity{
    int x1, y1, x2, y2;
    public Wall(int x, int y){
        x1 = x;
        y1 = y;
        x2 = x + cellsize;
        y2 = y + cellsize;
    }
}

