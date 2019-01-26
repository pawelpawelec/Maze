package pl.algorythm;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AlgorithmFactory {

  public static Algorithm create(Algorithms algorithm) {

    switch (algorithm) {
      case BSF:
        return new BsfAlgorithm();
      case DSF:
        throw new IllegalArgumentException(algorithm.name());
      case A_STAR:
      default:
        return new AlgorithmAStar(new SimpleHeuristicFunction());
    }
  }
}
