package pl.januszekodu.statetransformer;

import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.IntStream.range;

class CellIndex {
  private final int height;
  private final int width;

  private CellIndex(int height, int width) {
    this.height = height;
    this.width = width;
  }

  static Stream<CellIndex> allPossibleIndexes(int cellsHeight, int cellsWidth) {
    return range(0, cellsHeight)
        .mapToObj(height -> range(0, cellsWidth).mapToObj(w -> new CellIndex(height, w)))
        .flatMap(Function.identity());
  }

  Stream<CellIndex> getNeighbours() {
    return Stream.of(
        new CellIndex(height    , width + 1),
        new CellIndex(height    , width - 1),
        new CellIndex(height + 1, width),
        new CellIndex(height + 1, width + 1),
        new CellIndex(height + 1, width - 1),
        new CellIndex(height - 1, width),
        new CellIndex(height - 1, width + 1),
        new CellIndex(height - 1, width - 1)
    );
  }

  int getHeight() {
    return height;
  }

  int getWidth() {
    return width;
  }
}
