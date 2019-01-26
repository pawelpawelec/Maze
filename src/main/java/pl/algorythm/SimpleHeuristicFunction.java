package pl.algorythm;

import pl.algorythm.model.Graph;
import pl.algorythm.model.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static pl.algorythm.NextNodesProvider.nextNodes;

public class SimpleHeuristicFunction implements HeuristicFunction {

  @Override
  public Node function(Node node, Graph graph, Node endpoint, LinkedList<Node> closedList) {
    Node nodeNext = node;
    List<Node> children = nextNodes(node, graph);
    double maxF = node.distance(endpoint);
    for (int i = 0; i < children.size(); i++) {
      Node child = children.get(i);
      double f = child.distance(endpoint);
      int x = child.getX();
      int y = child.getY();
      if (x < graph.length() && y < graph.width()
              && graph.isWay(x, y)
              && f <= maxF
              && !closedList.contains(child)) {
        nodeNext = child;
        maxF = f;
      }
    }
    if (nodeNext.equals(node)) {
      Node last;
      try {
        last = closedList.stream().filter(node1 -> !node1.isBack())
                .collect(Collectors.toCollection(LinkedList::new)).getLast();
      } catch (NoSuchElementException e) {
        throw new IllegalStateException("Labirynt nie ma wyjścia");
      }
      last.setBack(true);
      return last;
    }
    node.setBack(false);
    return nodeNext;
  }
}
