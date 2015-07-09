package Collected_Questions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

final class Coordinate {
    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        this.x = x; 
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Maze {

    private final int[][] maze;

    public Maze(int[][] maze) {
        if (maze == null) {
            throw new NullPointerException("The input maze cannot be null");
        }
        if (maze.length == 0) {
            throw new IllegalArgumentException("The size of maze should be greater than 0");
        }

        this.maze = maze;
    }

    public List<Coordinate> solve() {
        return getMazePath(0, 0, new Stack<Coordinate>());
    }

    private List<Coordinate> getMazePath(int row, int col, Stack<Coordinate> stack) {
        assert stack != null;

        stack.add(new Coordinate(row, col));

        if ((row == maze.length - 1) && (col == maze[0].length - 1)) {
            Coordinate[] coordinateArray = stack.toArray(new Coordinate[stack.size()]);
            return Arrays.asList(coordinateArray);
        }

        for (int j = col; j < maze[row].length; j++) {

            if ((j + 1) < maze[row].length && maze[row][j + 1] == 1) {
                return getMazePath(row, j + 1, stack);
            }

            if ((row + 1) < maze.length && maze[row + 1][col] == 1) {
                return getMazePath(row + 1, col, stack);
            }
        }

        return Collections.emptyList();
    }


    public static void main(String[] args) {
        int[][] m = {  {1, 0, 0},
                       {1, 1, 0},
                       {0, 1, 1} };

        Maze maze = new Maze(m);

        for (Coordinate coord :  maze.solve()) {
            System.out.println(coord.getX() + " : " + coord.getY());
        }
    }
}