package pl.algorythm;

import com.google.common.base.Preconditions;
import lombok.AllArgsConstructor;
import pl.algorythm.model.Graph;
import pl.algorythm.model.MazeSolve;
import pl.algorythm.model.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@AllArgsConstructor
class AlgorithmAStar implements Algorithm {

  private HeuristicFunction heuristicFunction;

  public MazeSolve solve(Graph graph, Node startPoint, Node endPoint) {

    Preconditions.checkArgument(nonNull(graph));
    Preconditions.checkArgument(nonNull(startPoint));
    Preconditions.checkArgument(nonNull(endPoint));

    LinkedList<Node> openList = new LinkedList<>();
    LinkedList<Node> closedList = new LinkedList<>();
    openList.add(startPoint);
    while (!openList.isEmpty()) {
      Node node = openList.getFirst();
      openList.remove(node);
      if (!closedList.contains(node)) {
        closedList.add(node);
      }
      if (node.equals(endPoint)) {
        break;
      } else {
        node = heuristicFunction.function(node, graph, endPoint, closedList);
        openList.add(node);
      }
    }
    List<Node> nodeStream = closedList.stream().filter(s -> nonNull(s) && !s.isBack()).collect(Collectors.toList());
    return MazeSolve.builder()
            .path(nodeStream)
            .sizePath(nodeStream.size())
            .build();
  }
}
