package eecs40.sokoban;

import android.graphics.Canvas;

/**
 * Created by Kevin on 4/24/2016.
 */
public class Entity {
    static int cellsize = 80;

    public Entity() {

    }

    void selectDirection(Entity e[][], float x, float y) {

    }

    void move(Entity e[][], int srcX, int srcY, int x, int y) {

    }

    static void loadLevel(Entity e[][], int choice, int width, int height, int levelX, int levelY) {
        //hardcode levels
        for (int y = 0; y < levelY; y++)
            for (int x = 0; x < levelX; x++) {
                e[x][y] = null;
            }

        switch (choice) {
            case 0:
                for (int y = 0; y < levelY - 10; y++)
                    for (int x = 0; x < levelX - 5; x++) {
                        e[x][y] = new Wall(x * cellsize, y * cellsize);
                    }
                for (int y = 1; y < levelY - 11; y++)
                    for (int x = 1; x < levelX - 6; x++) {
                        e[x][y] = null;
                    }

                e[7][5] = null;
                e[0][5] = null;
                e[1][5] = null;
                e[2][5] = null;
                e[1][4] = new Wall(1 * cellsize, 4 * cellsize);
                e[2][4] = new Wall(2 * cellsize, 4 * cellsize);
                e[3][4] = new Wall(3 * cellsize, 4 * cellsize);
                e[6][4] = new Wall(6 * cellsize, 4 * cellsize);
                e[5][2] = new Player(width, height, 5 * cellsize, 2 * cellsize, 5, 2);
                e[2][2] = new Box(2 * cellsize, 2 * cellsize, 2, 2);
                e[3][2] = new Box(3 * cellsize, 2 * cellsize, 3, 2);
                e[4][2] = new Box(4 * cellsize, 2 * cellsize, 4, 2);
                e[5][3] = new Box(5 * cellsize, 3 * cellsize, 5, 3);
                break;


            case 1:
                for (int y = 0; y < levelY - 8; y++)
                    for (int x = 0; x < levelX - 1; x++) {
                        e[x][y] = new Wall(x * cellsize, y * cellsize);
                    }
                for (int x = 0; x < levelX - 10; x++) {
                    int y = 0;
                    e[x][y] = null;
                }
                for (int y = 0; y < levelX - 10; y++) {
                    int x = 0;
                    e[x][y] = null;
                }
                for (int x = 9; x < levelX - 1; x++) {
                    int y = 0;
                    e[x][y] = null;
                }
                for (int y = 0; y < levelX - 10; y++) {
                    int x = 11;
                    e[x][y] = null;
                }

                for (int y = 2; y < levelY - 9; y++)
                    for (int x = 2; x < levelX - 3; x++) {
                        e[x][y] = null;
                    }
                e[5][1] = null;
                e[6][1] = null;
                e[1][4] = null;
                e[1][5] = null;
                e[10][4] = null;
                e[10][5] = null;
                e[0][7] = null;
                e[11][7] = null;

                e[4][5] = new Player(width, height, 4 * cellsize, 5 * cellsize, 4, 5);
                e[5][2] = new Box(5 * cellsize, 2 * cellsize, 5, 2);
                e[6][2] = new Box(6 * cellsize, 2 * cellsize, 6, 2);
                e[2][3] = new Box(2 * cellsize, 3 * cellsize, 2, 3);
                e[3][3] = new Box(3 * cellsize, 3 * cellsize, 3, 3);
                e[8][3] = new Box(8 * cellsize, 3 * cellsize, 8, 3);
                e[9][3] = new Box(9 * cellsize, 3 * cellsize, 9, 3);
                break;


            case 2:
                for (int y = 0; y < levelY - 5; y++)
                    for (int x = 0; x < levelX - 3; x++) {
                        e[x][y] = new Wall(x * cellsize, y * cellsize);
                    }
                for (int y = 1; y < levelY - 6; y++)
                    for (int x = 1; x < levelX - 4; x++) {
                        e[x][y] = null;
                    }
                e[0][0] = null;
                e[0][1] = null;
                e[9][0] = null;
                e[9][1] = null;
                e[1][1] = new Wall(1 * cellsize, 1 * cellsize);
                e[1][2] = new Wall(1 * cellsize, 2 * cellsize);
                e[8][1] = new Wall(8 * cellsize, 1 * cellsize);
                e[8][2] = new Wall(8 * cellsize, 2 * cellsize);
                e[3][2] = new Wall(3 * cellsize, 2 * cellsize);
                e[4][2] = new Wall(4 * cellsize, 2 * cellsize);
                e[5][2] = new Wall(5 * cellsize, 2 * cellsize);
                e[2][4] = new Wall(2 * cellsize, 4 * cellsize);
                e[3][4] = new Wall(3 * cellsize, 4 * cellsize);
                e[4][4] = new Wall(4 * cellsize, 4 * cellsize);
                e[5][4] = new Wall(5 * cellsize, 4 * cellsize);
                e[7][5] = new Wall(7 * cellsize, 5 * cellsize);
                e[1][6] = new Wall(1 * cellsize, 6 * cellsize);
                e[3][6] = new Wall(3 * cellsize, 6 * cellsize);
                e[4][6] = new Wall(4 * cellsize, 6 * cellsize);
                e[5][6] = new Wall(5 * cellsize, 6 * cellsize);
                e[7][6] = new Wall(7 * cellsize, 6 * cellsize);
                e[4][8] = new Wall(4 * cellsize, 8 * cellsize);
                e[5][8] = new Wall(5 * cellsize, 8 * cellsize);
                e[7][8] = new Wall(7 * cellsize, 8 * cellsize);
                e[8][8] = new Wall(7 * cellsize, 8 * cellsize);

                e[3][3] = new Player(width, height, 3 * cellsize, 3 * cellsize, 3, 3);
                e[2][2] = new Box(2 * cellsize, 2 * cellsize, 2, 2);
                e[6][2] = new Box(6 * cellsize, 2 * cellsize, 6, 2);
                e[2][6] = new Box(2 * cellsize, 6 * cellsize, 2, 6);
                e[2][8] = new Box(2 * cellsize, 8 * cellsize, 2, 8);
                e[6][6] = new Box(6 * cellsize, 6 * cellsize, 6, 6);
                break;

            case 3:
                for (int y = 0; y < levelY; y++)
                    for (int x = 0; x < levelX - 2; x++) {
                        e[x][y] = new Wall(x * cellsize, y * cellsize);
                    }
                for (int y = 1; y < levelY - 1; y++)
                    for (int x = 1; x < levelX - 3; x++) {
                        e[x][y] = null;
                    }
                for (int y = 0; y < levelY - 5; y++) {
                    int x = 0;
                    e[x][y] = null;
                }

                for (int y = 0; y < levelY - 4; y++) {
                    int x = 1;
                    e[x][y] = new Wall(x * cellsize, y * cellsize);
                }

                for (int y = 0; y < levelY; y++) {
                    int x = 4;
                    if (y != 12) {
                        e[x][y] = new Wall(x * cellsize, y * cellsize);
                    }
                }
                for (int y = 0; y < levelY; y++) {
                    int x = 7;
                    if (y != 11) {
                        e[x][y] = new Wall(x * cellsize, y * cellsize);
                    }
                }

                e[2][13] = new Player(width, height, 2 * cellsize, 13 * cellsize, 2, 13);
                e[2][2] = new Box(2 * cellsize, 2 * cellsize, 2, 2);
                e[2][4] = new Box(2 * cellsize, 4 * cellsize, 2, 4);
                e[2][6] = new Box(2 * cellsize, 6 * cellsize, 2, 6);
                e[2][8] = new Box(2 * cellsize, 8 * cellsize, 2, 8);
                e[2][10] = new Box(2 * cellsize, 10 * cellsize, 2, 10);
                e[5][2] = new Box(5 * cellsize, 2 * cellsize, 5, 2);
                e[5][4] = new Box(5 * cellsize, 4 * cellsize, 5, 4);
                e[5][6] = new Box(5 * cellsize, 6 * cellsize, 5, 6);
                e[5][8] = new Box(5 * cellsize, 8 * cellsize, 5, 8);
                e[5][10] = new Box(5 * cellsize, 10 * cellsize, 5, 10);
                e[8][2] = new Box(2 * cellsize, 2 * cellsize, 2, 2);
                e[8][4] = new Box(2 * cellsize, 4 * cellsize, 2, 4);
                e[8][6] = new Box(2 * cellsize, 6 * cellsize, 2, 6);
                e[8][8] = new Box(2 * cellsize, 8 * cellsize, 2, 8);
                break;
        }

    }

    static boolean checkBox(int choice, Entity e[][]) {
        //check that boxes are in the goals
        switch (choice) {
            case 0:
                if (e[2][1] != null && e[2][1].getClass() == Box.class &&
                        e[3][1] != null && e[3][1].getClass() == Box.class &&
                        e[4][1] != null && e[4][1].getClass() == Box.class &&
                        e[4][2] != null && e[4][2].getClass() == Box.class) {
                    return true;
                }
            case 1:
                if (e[4][2] != null && e[4][2].getClass() == Box.class &&
                        e[5][2] != null && e[5][2].getClass() == Box.class &&
                        e[5][1] != null && e[5][1].getClass() == Box.class &&
                        e[6][1] != null && e[6][1].getClass() == Box.class &&
                        e[6][2] != null && e[6][2].getClass() == Box.class &&
                        e[7][2] != null && e[7][2].getClass() == Box.class) {
                    return true;
                }

            case 2:
                if (e[4][9] != null && e[4][9].getClass() == Box.class &&
                        e[5][9] != null && e[5][9].getClass() == Box.class &&
                        e[6][9] != null && e[6][9].getClass() == Box.class &&
                        e[7][9] != null && e[7][9].getClass() == Box.class &&
                        e[8][9] != null && e[8][9].getClass() == Box.class) {
                    return true;
                }

            case 3:
                if (e[3][1] != null && e[3][1].getClass() == Box.class &&
                        e[3][2] != null && e[3][2].getClass() == Box.class &&
                        e[3][3] != null && e[3][3].getClass() == Box.class &&
                        e[3][4] != null && e[3][4].getClass() == Box.class &&
                        e[3][5] != null && e[3][5].getClass() == Box.class &&
                        e[6][1] != null && e[6][1].getClass() == Box.class &&
                        e[6][2] != null && e[6][2].getClass() == Box.class &&
                        e[6][3] != null && e[6][3].getClass() == Box.class &&
                        e[6][4] != null && e[6][4].getClass() == Box.class &&
                        e[6][5] != null && e[6][5].getClass() == Box.class &&
                        e[9][1] != null && e[9][1].getClass() == Box.class &&
                        e[9][2] != null && e[9][2].getClass() == Box.class &&
                        e[9][3] != null && e[9][3].getClass() == Box.class &&
                        e[9][4] != null && e[9][4].getClass() == Box.class) {
                    return true;
                }
        }
        return false;
    }
}

