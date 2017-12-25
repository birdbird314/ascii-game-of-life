package pl.januszekodu.statetransformer;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

class Cells {
  private final StateRepresentations stateRepresentations;
  private final String[][] cells;

  static Cells fromString(String table, StateRepresentations stateRepresentations) {
    String[] rows = table.split("\n");
    String[][] cells = Arrays.stream(rows).map(row -> row.split("")).toArray(String[][]::new);
    return new Cells(cells, stateRepresentations);
  }

  private Cells(String[][] cells, StateRepresentations stateRepresentations) {
    this.cells = cells;
    this.stateRepresentations = stateRepresentations;
  }

  int getWidth() {
    return cells[0].length;
  }

  int getHeight() {
    return cells.length;
  }

  boolean isAlive(CellIndex index) {
    try {
      return stateRepresentations.alive().equals(cells[index.getHeight()][index.getWidth()]);
    } catch (ArrayIndexOutOfBoundsException e) {
      return false;
    }
  }

  boolean isDead(CellIndex index) {
    return !isAlive(index);
  }

  @Override
  public String toString() {
    return Arrays.stream(cells)
        .map(row -> Arrays.stream(row).collect(joining()))
        .collect(joining("\n"));
  }

  static NextStepBuilder aNextStepBuilderFor(Cells cells) {
    return new NextStepBuilder(
        cells.getHeight(),
        cells.getWidth(),
        cells.stateRepresentations
    );
  }

  static class NextStepBuilder {
    private final StateRepresentations stateRepresentations;
    private final String[][] cells;

    private NextStepBuilder(int height, int width, StateRepresentations stateRepresentations) {
      this.cells = new String[height][width];
      this.stateRepresentations = stateRepresentations;
    }

    void setAlive(CellIndex index) {
      cells[index.getHeight()][index.getWidth()] = stateRepresentations.alive();
    }

    void setDead(CellIndex index) {
      cells[index.getHeight()][index.getWidth()] = stateRepresentations.dead();
    }

    Cells build() {
      return new Cells(cells, stateRepresentations);
    }
  }

}

