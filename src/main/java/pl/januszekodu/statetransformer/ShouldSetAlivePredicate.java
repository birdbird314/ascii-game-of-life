package pl.januszekodu.statetransformer;

import static java.util.Arrays.asList;

class ShouldSetAlivePredicate {

  private final Cells cells;

  static ShouldSetAlivePredicate shouldSetAlivePredicate(Cells cells) {
    return new ShouldSetAlivePredicate(cells);
  }

  private ShouldSetAlivePredicate(Cells cells) {
    this.cells = cells;
  }

  boolean test(CellIndex index) {
    return isAliveCellWithTwoOrThreeAliveNeighbours(index)
        || isDeadCellWithThreeAliveNeighbours(index);
  }

  private boolean isDeadCellWithThreeAliveNeighbours(CellIndex index) {
    return cells.isDead(index) && 3 == countAliveNeighboursOf(index);
  }

  private boolean isAliveCellWithTwoOrThreeAliveNeighbours(CellIndex index) {
    return cells.isAlive(index) && asList(2, 3).contains(countAliveNeighboursOf(index));
  }

  private int countAliveNeighboursOf(CellIndex index) {
    return (int) index.getNeighbours().filter(cells::isAlive).count();
  }
}
