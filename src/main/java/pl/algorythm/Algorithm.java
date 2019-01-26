package pl.algorythm;

import pl.algorythm.model.Graph;
import pl.algorythm.model.MazeSolve;
import pl.algorythm.model.Node;

public interface Algorithm {

  MazeSolve solve(Graph graph, Node startPoint, Node endPoint);
}
