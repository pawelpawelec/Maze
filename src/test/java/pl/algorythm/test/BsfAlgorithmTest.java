package pl.algorythm.test;

import org.junit.Assert;
import org.junit.Test;
import pl.algorythm.Algorithm;
import pl.algorythm.Algorithms;
import pl.algorythm.impl.AlgorithmFactory;
import pl.algorythm.model.Graph;
import pl.algorythm.model.MazeSolve;
import pl.algorythm.model.Node;

public class BsfAlgorithmTest extends AlgorithBaseTest {

  @Test
  public void solve1() {

    // given
    int[][] maze = {
            {0, 1, 0, 1, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1},
            {1, 0, 1, 0, 0, 0},
            {1, 0, 1, 1, 0, 1},
            {1, 1, 1, 1, 1, 1}
    };
    Algorithm bsfAlgorithm = AlgorithmFactory.create(Algorithms.BSF);

    // when
    MazeSolve solve = bsfAlgorithm.solve(new Graph(maze), new Node(0, 1), new Node(5, 5));

    // then
    Assert.assertEquals(10, solve.getSizePath());
    Assert.assertArrayEquals(new int[][]{
            {0, 8, 0, 1, 0, 0},
            {0, 8, 0, 0, 0, 0},
            {1, 8, 8, 1, 1, 1},
            {1, 0, 8, 0, 0, 0},
            {1, 0, 8, 8, 0, 1},
            {1, 1, 1, 8, 8, 8}
    }, solveMaze(maze, solve.getPath()));
  }

  @Test
  public void solve2() {

    // given
    int[][] maze = {
            {0, 1, 0, 1, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1},
            {0, 0, 0, 1, 0, 0},
            {1, 0, 1, 1, 0, 0},
            {0, 0, 1, 1, 1, 1}
    };
    Algorithm bsfAlgorithm = AlgorithmFactory.create(Algorithms.BSF);

    // when
    MazeSolve solve = bsfAlgorithm.solve(new Graph(maze), new Node(0, 1), new Node(5, 5));

    // then
    Assert.assertEquals(10, solve.getSizePath());
    Assert.assertArrayEquals(new int[][]{
            {0, 8, 0, 1, 0, 0},
            {0, 8, 0, 0, 0, 0},
            {0, 8, 8, 8, 1, 1},
            {0, 0, 0, 8, 0, 0},
            {1, 0, 1, 8, 0, 0},
            {0, 0, 1, 8, 8, 8}
    }, solveMaze(maze, solve.getPath()));

  }


  public void solve3() {

    // given
    int[][] maze = {
            {0, 1, 1, 1, 1, 1},
            {0, 1, 0, 0, 0, 0},
            {0, 1, 0, 1, 1, 1},
            {0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 0, 1},
            {0, 0, 1, 1, 1, 1}
    };
    Algorithm bsfAlgorithm = AlgorithmFactory.create(Algorithms.BSF);

    // when
    MazeSolve solve = bsfAlgorithm.solve(new Graph(maze), new Node(0, 1), new Node(5, 5));

    // then
    Assert.assertEquals(0, solve.getSizePath());
    Assert.assertArrayEquals(new int[][]{
            {0, 1, 1, 1, 1, 1},
            {0, 1, 0, 0, 0, 0},
            {0, 1, 0, 1, 1, 1},
            {0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 0, 1},
            {0, 0, 1, 1, 1, 1}
    }, solveMaze(maze, solve.getPath()));
  }

  @Test
  public void solve4() {

    // given
    int[][] maze = {
            {0, 1, 0, 1, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1},
            {0, 0, 0, 1, 0, 0},
            {1, 0, 1, 1, 0, 0},
            {0, 0, 1, 1, 1, 1}
    };
    Algorithm bsfAlgorithm = AlgorithmFactory.create(Algorithms.BSF);

    // when
    MazeSolve solve = bsfAlgorithm.solve(new Graph(maze), new Node(2, 5), new Node(5, 5));

    // then
    Assert.assertEquals(8, solve.getSizePath());
    Assert.assertArrayEquals(new int[][]{
            {0, 1, 0, 1, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {0, 1, 1, 8, 8, 8},
            {0, 0, 0, 8, 0, 0},
            {1, 0, 1, 8, 0, 0},
            {0, 0, 1, 8, 8, 8}
    }, solveMaze(maze, solve.getPath()));
  }
}