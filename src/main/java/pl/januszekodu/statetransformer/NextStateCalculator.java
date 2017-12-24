package pl.januszekodu.statetransformer;

import pl.januszekodu.statetransformer.Cells.NextStepBuilder;

import java.util.function.Predicate;

import static java.util.Arrays.asList;
import static pl.januszekodu.statetransformer.CellIndex.allPossibleIndexes;
import static pl.januszekodu.statetransformer.Cells.aNextStepBuilderFor;

public class NextStateCalculator {

  public String calculate(String stringCells) {
    Cells cells = Cells.fromString(stringCells);
    return calculateNextStep(cells).toString();
  }

  private static Cells calculateNextStep(Cells cells) {
    NextStepBuilder nextStepBuilder = aNextStepBuilderFor(cells);
    allPossibleIndexes(cells.getHeight(), cells.getWidth())
        .forEach(i -> setNextStepState(cells, nextStepBuilder, i));
    return nextStepBuilder.build();
  }

  private static void setNextStepState(Cells cells, NextStepBuilder resultBuilder, CellIndex index) {
    if (shouldSetAlivePredicate(cells).test(index)) {
      resultBuilder.setAlive(index);
    } else {
      resultBuilder.setDead(index);
    }
  }

  private static Predicate<CellIndex> shouldSetAlivePredicate(Cells cells) {
    return index ->
             isAliveCellWithTwoOrThreeAliveNeighbours(cells, index)
          || isDeadCellWithThreeAliveNeighbours(cells, index);
  }

  private static boolean isDeadCellWithThreeAliveNeighbours(Cells cells, CellIndex index) {
    return cells.isDead(index) && cells.countAliveNeighbours(index) == 3;
  }

  private static boolean isAliveCellWithTwoOrThreeAliveNeighbours(Cells cells, CellIndex index) {
    return cells.isAlive(index) && asList(2, 3).contains(cells.countAliveNeighbours(index));
  }
}
