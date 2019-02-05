package pl.algorythm.test;

import pl.algorythm.model.Node;

import java.util.List;

class AlgorithBaseTest {

  protected int[][] solveMaze(int[][] maze, List<Node> nodes) {
    int[][] mazeSolve = copyArray(maze);
    for (Node node : nodes) {
      mazeSolve[node.getX()][node.getY()] = 8;
    }
    return mazeSolve;
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
