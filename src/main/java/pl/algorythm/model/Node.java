package pl.algorythm.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Node {
  private Node parent;
  private int x;
  private int y;
  private boolean back;

  public Node(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public double distance(Node endpoint) {
    return Math.floor(Math.sqrt(Math.pow(endpoint.y - y, 2) + Math.pow(endpoint.x - x, 2)));
  }

  @Override
  public String toString() {
    return "Node{" +
            "x=" + x +
            ", y=" + y +
            ", back=" + back +
            '}';
  }
}
