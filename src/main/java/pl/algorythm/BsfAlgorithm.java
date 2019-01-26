package pl.algorythm;

import com.google.common.base.Preconditions;
import pl.algorythm.model.Graph;
import pl.algorythm.model.MazeSolve;
import pl.algorythm.model.Node;

import java.util.*;

import static java.util.Objects.nonNull;
import static pl.algorythm.NextNodesProvider.nextNodes;

class BsfAlgorithm implements Algorithm {

  @Override
  public MazeSolve solve(Graph graph, Node startPoint, Node endPoint) {

    Preconditions.checkArgument(nonNull(graph));
    Preconditions.checkArgument(nonNull(startPoint));
    Preconditions.checkArgument(nonNull(endPoint));

    Queue<Node> queue = new LinkedList<>();
    List<MazeSolve> paths = new ArrayList<>();
    queue.add(startPoint);
    while (!queue.isEmpty()) {
      Node poll = queue.poll();
      if ((graph.existInGraph(poll)
              || poll.getX() < graph.length()
              && poll.getY() < graph.width()
              && graph.isWall(poll.getX(), poll.getY()))) {
      } else if (poll.equals(endPoint)) {
        int path = 1;
        List<Node> pathNodes = new ArrayList<>();
        Node x = poll;
        pathNodes.add(x);
        while (nonNull(x.getParent())) {
          path++;
          x = x.getParent();
          pathNodes.add(x);
        }
        paths.add(MazeSolve.builder()
                .path(pathNodes)
                .sizePath(path).build());
        queue.add(startPoint);
      } else {
        graph.visitNode(poll);
        List<Node> children = nextNodes(poll, graph);
        children.remove(startPoint);
        queue.addAll(children);
      }
    }
    try {
      return paths.stream().min(Comparator.comparing(MazeSolve::getSizePath)).orElseGet(() -> MazeSolve.builder().build());
    } catch (NoSuchElementException e) {
      throw new IllegalStateException("Labirynt nie ma wyjścia");
    }
  }
}
