package eecs40.sokoban;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by autumnlee1 on 4/20/16.
 */
public class Box extends Entity{
    int x1, y1, x2, y2;
    int x, y;
    public Box(int width, int height, int x, int y) {
        this.x = x;
        this.y = y;
        x1 = width;
        y1 = height;
        x2 = width + cellsize;
        y2 = height + cellsize;
    }

    void move(Entity e[][], int srcX, int srcY, int x, int y) {
        //box moves to destination
        e[srcX+x][srcY+y] = e[srcX][srcY];
        e[srcX][srcY] = null;
        //update coordinates in array
        this.x += x;
        this.y += y;
        //update coordinates on screen
        x1 += x * cellsize;
        y1 += y * cellsize;
        x2 += x * cellsize;
        y2 += y * cellsize;
    }



}
