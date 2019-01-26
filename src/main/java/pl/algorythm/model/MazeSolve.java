package pl.algorythm.model;

import com.google.common.collect.ImmutableList;
import lombok.Builder;

import java.util.List;

@Builder
public class MazeSolve {

  private List<Node> path;
  private long sizePath;

  public long getSizePath() {
    return sizePath;
  }

  public List<Node> getPath() {
    return ImmutableList.copyOf(path);
  }
}
