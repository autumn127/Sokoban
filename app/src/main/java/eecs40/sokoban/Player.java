package eecs40.sokoban;

import android.util.Log;


/**
 * Created by autumnlee1 on 4/20/16.
 */
public class Player extends Entity{
    int x, y;   //coordinates in level
    int x1, y1, x2, y2; //coordinates on screen
    int width, height;
    int size;
    public Player(int width, int height, int x1, int y1, int x, int y){
        size = 50;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.x1 = x1;
        this.y1 = y1;
        x2 = x1 + cellsize;
        y2 = y1 + cellsize;

        Log.d("Log.DEBUG", "width=" + width + " height=" + height);

    }

    void selectDirection(Entity e[][], float x, float y){
        if (x >= width / 2 - size &&
                x <= width / 2 + size &&
                y >= height * 95 / 100 - size &&
                y <= height * 95 / 100 + size) {
            //move player down
            checkDest(e, this.x, this.y, 0, 1);
        }
        if (x >= width / 2 - size &&
                x <= width / 2 + size &&
                y >= height * 95 / 100 - size * 5 &&
                y <= height * 95 / 100 - size * 3) {
            //move player up
            checkDest(e, this.x, this.y, 0, -1);
        }
        if (x >= width / 2 - size * 3 &&
                x <= width / 2 - size &&
                y >= height * 95 / 100 - size * 3 &&
                y <= height * 95 / 100 - size) {
            // move player left
            checkDest(e, this.x, this.y, -1, 0);
        }
        if (x >= width / 2 + size &&
                x <= width / 2 + size * 3 &&
                y >= height * 95 / 100 - size * 3 &&
                y <= height * 95 / 100 - size) {
            //move player right
            checkDest(e, this.x, this.y, 1, 0);
        }
    }

    void checkDest(Entity e[][], int srcX, int srcY, int x, int y){
        if (e[srcX+x][srcY+y] != null){
            //check if destination is a box and check if space behind box is free
            if (e[srcX+x][srcY+y].getClass() == Box.class){
                if (e[srcX + 2*x][srcY + 2*y] == null){
                    e[srcX + x][srcY + y].move(e, srcX + x, srcY + y, x, y);
                    move(e, srcX, srcY, x, y);
                }
            }
            //do not need to do anything if destination is wall
        }
        else{
            move(e, srcX, srcY, x, y);
        }
    }

    void move(Entity e[][], int srcX, int srcY, int x, int y) {
        //player moves to destination
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

