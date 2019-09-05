package pl.algorythm.impl;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.algorythm.model.Graph;
import pl.algorythm.model.Node;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class NextNodesProvider {

  static List<Node> nextNodes(Node node, Graph graph) {
    List<Node> nodes = new ArrayList<>();

    for (int i = node.getY() - 1; i <= node.getY() + 1; i++) {
      Node addNode = new Node(node.getX(), i);
      addNode.setParent(node);
      if (i >= 0 && !addNode.equals(node) && graph.availableInGraph(addNode))
        nodes.add(addNode);
    }
    for (int j = node.getX() - 1; j <= node.getX() + 1; j++) {
      Node addNode = new Node(j, node.getY());
      addNode.setParent(node);
      if (j >= 0 && !addNode.equals(node) && graph.availableInGraph(addNode))
        nodes.add(addNode);
    }
    nodes.remove(node);
    return nodes;
  }
}
