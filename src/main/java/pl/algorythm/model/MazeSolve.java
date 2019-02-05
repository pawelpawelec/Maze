package pl.algorythm.model;

import com.google.common.collect.ImmutableList;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@Builder
public class MazeSolve {

  private List<Node> path;
  private long sizePath;

  public long getSizePath() {
    return sizePath;
  }

  public List<Node> getPath() {
    return nonNull(path) ? ImmutableList.copyOf(path)
            : new ArrayList<>();
  }
}
