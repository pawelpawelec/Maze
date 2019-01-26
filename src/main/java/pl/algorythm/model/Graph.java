package pl.algorythm.model;

import java.util.ArrayList;
import java.util.List;

public class Graph {

  private final List<Node> visitedNodes;

  private final int[][] graph;

  public Graph(int[][] graph) {
    this.visitedNodes = new ArrayList<>();
    this.graph = graph;
  }

  public int length() {
    return graph.length;
  }

  public int width() {
    return graph[0].length;
  }

  public boolean isWay(int x, int y) {
    return graph[x][y] == 1;
  }

  public boolean isWall(int x, int y) {
    return graph[x][y] == 0;
  }

  public void visitNode(Node node) {
    visitedNodes.add(node);
  }

  public boolean existInGraph(Node node) {
    return visitedNodes.equals(node);
  }

  public boolean availableInGraph(Node node) {
    return node.getX() < this.length()
            && node.getY() < this.width()
            && this.isWay(node.getX(), node.getY())
            && !visitedNodes.contains(node);
  }
}
