package eecs40.sokoban;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
/**
 * Created by autumnlee1 on 4/21/16.
 */
public class SokobanView extends SurfaceView
    implements SurfaceHolder. Callback {
    public SokobanView(Context context) {
        super(context);
        // Notify the SurfaceHolder that you’d like to receive
        // SurfaceHolder callbacks .
        getHolder().addCallback(this);
        setFocusable(true);
        // Initialize game state variables. DON'T RENDER THE GAME YET
    }

    SokobanThread st;
    int size = 50;
    //change levelX and levelY to change level size
    int levelY = 16;
    int levelX = 13;
    int levelNumber;
    boolean gameWon;
    Rect bmp = new Rect();
    Entity level[][] = new Entity[levelX][levelY];
    Bitmap player = BitmapFactory.decodeResource(getResources(), R.mipmap.bun);
    Bitmap directionalPad = BitmapFactory.decodeResource(getResources(), R.mipmap.dpad);
    Bitmap lettuce = BitmapFactory.decodeResource(getResources(), R.mipmap.lettuce);
    Bitmap fence = BitmapFactory.decodeResource(getResources(), R.mipmap.fence);
    Bitmap grass = BitmapFactory.decodeResource(getResources(), R.mipmap.grass);
    Bitmap hole = BitmapFactory.decodeResource(getResources(), R.mipmap.hole);
    Bitmap victory = BitmapFactory.decodeResource(getResources(), R.mipmap.victorybun);

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // Construct game initial state
        // Launch animator thread.
        st = new SokobanThread(this);
        levelNumber = 0;
        gameWon = false;
        Entity.loadLevel(level, levelNumber, getWidth(), getHeight(), levelX, levelY);
        st.start();

    }

    public void draw(Canvas c) {
        bmp.set(0, 0, getWidth(), getHeight());
        c.drawBitmap(grass, null, bmp, null);
        bmp.set(getWidth() / 2 - size * 3, getHeight() * 95 / 100 - size * 5, getWidth() / 2 + size * 3, getHeight() * 95 / 100 + size);
        c.drawBitmap(directionalPad, null, bmp, null);
        //draw targets depending on level
        switch (levelNumber) {
            case 0:
                bmp.set(2 * Entity.cellsize, 1 * Entity.cellsize, 3 * Entity.cellsize, 2 * Entity.cellsize);
                c.drawBitmap(hole, null, bmp, null);
                bmp.set(3 * Entity.cellsize, 1 * Entity.cellsize, 4 * Entity.cellsize, 2 * Entity.cellsize);
                c.drawBitmap(hole, null, bmp, null);
                bmp.set(4 * Entity.cellsize, 1 * Entity.cellsize, 5 * Entity.cellsize, 2 * Entity.cellsize);
                c.drawBitmap(hole, null, bmp, null);
                bmp.set(4 * Entity.cellsize, 2 * Entity.cellsize, 5 * Entity.cellsize, 3 * Entity.cellsize);
                c.drawBitmap(hole, null, bmp, null);
                break;

            case 1:
                bmp.set(4 * Entity.cellsize, 2 * Entity.cellsize, 5 * Entity.cellsize, 3 * Entity.cellsize) ;
                c.drawBitmap(hole, null, bmp, null);
                bmp.set(5 * Entity.cellsize, 2 * Entity.cellsize, 6 * Entity.cellsize, 3 * Entity.cellsize);
                c.drawBitmap(hole, null, bmp, null);
                bmp.set(5 * Entity.cellsize, 1 * Entity.cellsize, 6 * Entity.cellsize, 2 * Entity.cellsize);
                c.drawBitmap(hole, null, bmp, null);
                bmp.set(6 * Entity.cellsize, 1 * Entity.cellsize, 7 * Entity.cellsize, 2 * Entity.cellsize);
                c.drawBitmap(hole, null, bmp, null);
                bmp.set(6 * Entity.cellsize, 2 * Entity.cellsize, 7 * Entity.cellsize, 3 * Entity.cellsize);
                c.drawBitmap(hole, null, bmp, null);
                bmp.set(7 * Entity.cellsize, 2 * Entity.cellsize, 8 * Entity.cellsize, 3 * Entity.cellsize);
                c.drawBitmap(hole, null, bmp, null);
                break;

            case 2:
                for (int x = 4; x < 9; x++) {
                    bmp.set(x * Entity.cellsize, 9 * Entity.cellsize, (x + 1) * Entity.cellsize, 10 * Entity.cellsize);
                    c.drawBitmap(hole, null, bmp, null);
                }
                break;
            case 3:
                for (int y = 1; y < 6; y++) {
                    int x = 3;
                    bmp.set(x * Entity.cellsize, y * Entity.cellsize, (x + 1) * Entity.cellsize, (y + 1) * Entity.cellsize);
                    c.drawBitmap(hole, null, bmp, null);
                }
                for (int y = 1; y < 6; y++) {
                    int x = 6;
                    bmp.set(x * Entity.cellsize, y * Entity.cellsize, (x + 1) * Entity.cellsize, (y + 1) * Entity.cellsize);
                    c.drawBitmap(hole, null, bmp, null);
                }
                for (int y = 1; y < 5; y++) {
                    int x = 9;
                    bmp.set(x * Entity.cellsize, y * Entity.cellsize, (x + 1) * Entity.cellsize, (y + 1) * Entity.cellsize);
                    c.drawBitmap(hole, null, bmp, null);
                }
                break;

        }
        //draw entities
        for (int y = 0; y < levelY; y++) {
            for (int x = 0; x < levelX; x++) {
                if (level[x][y] != null) {
                    if (level[x][y].getClass() == Player.class) {
                        bmp.set(x * Entity.cellsize, y * Entity.cellsize, (x + 1) * Entity.cellsize, (y + 1) * Entity.cellsize);
                        c.drawBitmap(player, null, bmp, null);
                    }
                    if (level[x][y].getClass() == Box.class) {
                        bmp.set(x * Entity.cellsize, y * Entity.cellsize, (x + 1) * Entity.cellsize, (y + 1) * Entity.cellsize);
                        c.drawBitmap(lettuce, null, bmp, null);
                    }
                    if (level[x][y].getClass() == Wall.class) {
                        bmp.set(x * Entity.cellsize, y * Entity.cellsize, (x + 1) * Entity.cellsize, (y + 1) * Entity.cellsize);
                        c.drawBitmap(fence, null, bmp, null);
                    }
                }
            }
        }

        //check if level has been completed
        if (!gameWon) {
            if (Entity.checkBox(levelNumber, level)) {
                gameWon = true;
            }
        }
        //display victory icon when player wins
        else{
            bmp.set(getWidth() / 2 - 2 * size, getHeight() / 2 + 7 * size, getWidth() / 2 + 2 * size, getHeight() / 2 + 11 * size);
            c.drawBitmap(victory, null, bmp, null);
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder,
                               int format, int width, int height) {
        // Respond to surface changes , e.g. , aspect ration changes.
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        // The cleanest way to stop a thread is by interrupting it.
        // SpaceThread regularly checks its interrupt flag. st.interrupt();
        st.interrupt();
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        // Update game state in response to events:
        // touch -down, touch -up, and touch-move.
        float dx = 0;
        float dy = 0;
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN: //pressing on screen
                dx = e.getX();
                dy = e.getY();
                break;
            case MotionEvent.ACTION_UP: //releasing on screen
                break;
            case MotionEvent.ACTION_MOVE: // dragging on screen
                break;
        }
        if(!gameWon){
        //move player if game is still in progress
            for (int y = 0; y < levelY; y++) {
                for (int x = 0; x < levelX; x++) {
                    if (level[x][y] != null && level[x][y].getClass() == Player.class) {
                        level[x][y].selectDirection(level, dx, dy);
                        //break out of loops once player has been found and moved
                        y = levelY;
                        break;
                    }
                }
            }
        }
        else{
        //game has been won, load new level when user touches victory icon
            if (dx >= getWidth() / 2 - size * 2 &&
                    dx <= getWidth() / 2 + size * 2 &&
                    dy >= getHeight() / 2 + 7 * size &&
                    dy <= getHeight() / 2 + 11 * size){
                gameWon = false;
                levelNumber++;
                levelNumber %= 4;
                Entity.loadLevel(level, levelNumber, getWidth(), getHeight(), levelX, levelY);
            }
        }
        return true;
    }

}




