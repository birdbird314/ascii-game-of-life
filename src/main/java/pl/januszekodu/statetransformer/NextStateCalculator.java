package pl.januszekodu.statetransformer;

import pl.januszekodu.statetransformer.Cells.NextStepBuilder;

import static pl.januszekodu.statetransformer.CellIndex.allPossibleIndexes;
import static pl.januszekodu.statetransformer.Cells.aNextStepBuilderFor;
import static pl.januszekodu.statetransformer.ShouldSetAlivePredicate.shouldSetAlivePredicate;

public class NextStateCalculator {

  private final StateRepresentations stateRepresentations;

  public NextStateCalculator(String dead, String alive) {
    this.stateRepresentations = new StateRepresentations(dead, alive);
  }

  public String calculate(String stringCells) {
    Cells cells = Cells.fromString(stringCells, stateRepresentations);
    return calculateNextStep(cells).toString();
  }

  private static Cells calculateNextStep(Cells cells) {
    NextStepBuilder nextStepBuilder = aNextStepBuilderFor(cells);
    allPossibleIndexes(cells.getHeight(), cells.getWidth())
        .forEach(i -> setNextStepState(cells, nextStepBuilder, i));
    return nextStepBuilder.build();
  }

  private static void setNextStepState(Cells cells, NextStepBuilder nextStepBuilder, CellIndex index) {
    if (shouldSetAlivePredicate(cells).test(index)) {
      nextStepBuilder.setAlive(index);
    } else {
      nextStepBuilder.setDead(index);
    }
  }
}
