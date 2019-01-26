package pl.algorythm.test;

import org.junit.Assert;
import org.junit.Test;
import pl.algorythm.Algorithm;
import pl.algorythm.AlgorithmFactory;
import pl.algorythm.Algorithms;
import pl.algorythm.model.Graph;
import pl.algorythm.model.MazeSolve;
import pl.algorythm.model.Node;

import java.util.List;

public class BsfAlgorithmTest {

  @Test
  public void solve1() {

    int[][] maze = {
            {0, 1, 0, 1, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1},
            {1, 0, 1, 0, 0, 0},
            {1, 0, 1, 1, 0, 1},
            {1, 1, 1, 1, 1, 1}
    };
    Algorithm bsfAlgorithm = AlgorithmFactory.create(Algorithms.BSF);
    MazeSolve solve = bsfAlgorithm.solve(new Graph(maze), new Node(0, 1), new Node(5, 5));
    long path = solve.getSizePath();
    print(maze, solve.getPath());
    Assert.assertEquals(10, path);
  }

  @Test
  public void solve2() {

    int[][] maze = {
            {0, 1, 0, 1, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1},
            {0, 0, 0, 1, 0, 0},
            {1, 0, 1, 1, 0, 0},
            {0, 0, 1, 1, 1, 1}
    };
    Algorithm bsfAlgorithm = AlgorithmFactory.create(Algorithms.BSF);
    MazeSolve solve = bsfAlgorithm.solve(new Graph(maze), new Node(0, 1), new Node(5, 5));
    long path = solve.getSizePath();
    print(maze, solve.getPath());
    Assert.assertEquals(10, path);
    MazeSolve solve1 = bsfAlgorithm.solve(new Graph(maze), new Node(2, 5), new Node(5, 5));
    print(maze, solve1.getPath());
    path = solve1.getSizePath();
    Assert.assertEquals(8, path);
  }

  @Test(expected = IllegalStateException.class)
  public void solve3() {

    int[][] maze = {
            {0, 1, 1, 1, 1, 1},
            {0, 1, 0, 0, 0, 0},
            {0, 1, 0, 1, 1, 1},
            {0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 0, 1},
            {0, 0, 1, 1, 1, 1}
    };
    Algorithm bsfAlgorithm = AlgorithmFactory.create(Algorithms.BSF);
    MazeSolve solve = bsfAlgorithm.solve(new Graph(maze), new Node(0, 1), new Node(5, 5));
    long path = solve.getSizePath();
    print(maze, solve.getPath());
    Assert.assertEquals(0, path);
  }

  private void print(int[][] maze, List<Node> nodes) {
    int[][] mazeSolve = copyArray(maze);
    for (Node node : nodes) {
      mazeSolve[node.getX()][node.getY()] = 8;
    }
    for (int i = 0; i < maze.length; i++) {
      for (int j = 0; j < maze[i].length; j++) {
        System.out.print(mazeSolve[i][j] + " ");
      }
      System.out.println();
    }
  }

  private int[][] copyArray(int[][] maze) {
    int[][] mazeCopy = new int[maze.length][maze[0].length];
    for (int i = 0; i < maze.length; i++) {
      for (int j = 0; j < maze[i].length; j++) {
        mazeCopy[i][j] = maze[i][j];
      }
    }
    return mazeCopy;
  }
}