package com.exercise.path;

import com.exercise.path.Grid;
import com.exercise.path.LowestCostPath;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class LowestCostPathTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();
    @Test
    public void example1Solution_isCorrect() throws Exception {
        LowestCostPath polc = new LowestCostPath(50, 1, 5, 10, 100);
        Grid grid = new Grid(
            "3 4 1 2 8 6\n"+
            "6 1 8 2 7 4\n" +
            "5 9 3 9 9 5\n" +
            "8 4 1 3 2 6\n" +
            "3 7 2 8 6 4"
        );

        LowestCostPath.Solution solution = polc.solve(grid);
        assertEquals(16, solution.totalCost);
        assertArrayEquals(new Integer[]{1,2,3,4,4,5}, solution.pathRows);
    }



    @Test
    public void example2Solution_isCorrect() throws Exception {
        LowestCostPath polc = new LowestCostPath(50, 1, 5, 10, 100);

        Grid grid = new Grid(
                  "3 4 1 2 8 6\n"
                + "6 1 8 2 7 4\n"
                + "5 9 3 9 9 5\n"
                + "8 4 1 3 2 6\n"
                + "3 7 2 1 2 3"
        );

        LowestCostPath.Solution solution = polc.solve(grid);
        assertEquals(11, solution.totalCost);
        assertArrayEquals(new Integer[]{1,2,1,5,4,5}, solution.pathRows);
    }

    @Test
    public void example3Solution_isCorrect() throws Exception {
        LowestCostPath polc = new LowestCostPath(50, 1, 5, 10, 100);
        Grid grid = new Grid(
            "19 10 19 10 19\n"
            + "21 23 20 19 12\n"
            + "20 12 20 11 10\n"
        );

        LowestCostPath.Solution solution = polc.solve(grid);
        assertEquals(48, solution.totalCost);
        assertArrayEquals(new Integer[]{1,1,1}, solution.pathRows);
    }

    @Test
    public void negativeSolution_isCorrect() throws Exception {
        LowestCostPath polc = new LowestCostPath(50, 1, 5, 10, 100);
        Grid grid = new Grid(
                "-19 -10 -19 -10 -19\n"
                + "-21 -23 -20 -19 -12\n"
                + "-20 -12 -20 -11 -10\n"
        );

        LowestCostPath.Solution solution = polc.solve(grid);
        assertEquals(-102, solution.totalCost);
        assertArrayEquals(new Integer[]{2,2,2,2,1}, solution.pathRows);
    }

    @Test
    public void oneMatrix() throws Exception {
        LowestCostPath polc = new LowestCostPath(50, 1, 5, 10, 100);
        Grid grid = new Grid(
                "5 8 5 3 5"
        );

        LowestCostPath.Solution solution = polc.solve(grid);
        assertEquals(26, solution.totalCost);
        assertArrayEquals(new Integer[]{1,1,1,1,1}, solution.pathRows);
    }

    @Test
    public void fiveMatrix() throws Exception {
        LowestCostPath polc = new LowestCostPath(50, 1, 1, 5, 100);
        Grid grid = new Grid(
                "5\n"
                        + "8\n"
                        + "5\n"
                        + "3\n"
                        + "5\n"
        );

        LowestCostPath.Solution solution = polc.solve(grid);
    }

    @Test
    public void noNumericMatrix() throws Exception {
        LowestCostPath polc = new LowestCostPath(50, 1, 3, 10, 100);
        try {
            Grid grid = new Grid(
                    "5 4 H\n"
                            + "8 2 7\n"
                            + "5 7 5\n"
            );
            LowestCostPath.Solution solution = polc.solve(grid);
            assert false;
        } catch (Grid.BadGridException e) {
            assert true;
        }
    }

    @Test
    public void emptyMatrix() throws Exception {
        LowestCostPath polc = new LowestCostPath(50, 1, 5, 10, 100);
        Grid grid = new Grid(" \n");

        try {
            LowestCostPath.Solution solution = polc.solve(grid);
            assert false;
        } catch (LowestCostPath.BadColException e) {
            assert true;
        }

    }

    @Test
    public void fiftyMaxSolution_isCorrect() throws Exception {
        LowestCostPath polc = new LowestCostPath(300, 3, 5, 10, 100);
        Grid grid = new Grid(
                "69 10 19 10 19\n"
                        + "51 23 20 19 12\n"
                        + "60 12 20 11 10\n"
        );


        LowestCostPath.Solution solution = polc.solve(grid);
        assertEquals(100, solution.totalCost);
    }

    @Test
    public void MaxFiftySolution_isCorrect() throws Exception {
        LowestCostPath polc = new LowestCostPath(300, 3, 4, 10, 100);
        Grid grid = new Grid(
                "60 3 3 6\n"
                        + "6 3 7 9\n"
                        + "5 6 8 3\n"
        );

        LowestCostPath.Solution solution = polc.solve(grid);
        assertEquals(14, solution.totalCost);
        assertArrayEquals(new Integer[]{3,2,1,3}, solution.pathRows);
    }

}
