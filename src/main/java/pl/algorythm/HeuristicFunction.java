package pl.algorythm;

import pl.algorythm.model.Graph;
import pl.algorythm.model.Node;

import java.util.LinkedList;

@FunctionalInterface
interface HeuristicFunction {

  Node function(Node node, Graph graph, Node endpoint, LinkedList<Node> closedList);
}
