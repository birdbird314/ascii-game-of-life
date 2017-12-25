package pl.januszekodu.statetransformer;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

class Cells {
  private final StateRepresentation stateRepresentation;
  private final String[][] cells;

  static Cells fromString(String table, StateRepresentation stateRepresentation) {
    String[] rows = table.split("\n");
    String[][] cells = Arrays.stream(rows).map(row -> row.split("")).toArray(String[][]::new);
    return new Cells(cells, stateRepresentation);
  }

  private Cells(String[][] cells, StateRepresentation stateRepresentation) {
    this.cells = cells;
    this.stateRepresentation = stateRepresentation;
  }

  int getWidth() {
    return cells[0].length;
  }

  int getHeight() {
    return cells.length;
  }

  boolean isAlive(CellIndex index) {
    try {
      return stateRepresentation.alive().equals(cells[index.getHeight()][index.getWidth()]);
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
        cells.stateRepresentation
    );
  }

  static class NextStepBuilder {
    private final StateRepresentation stateRepresentation;
    private final String[][] cells;

    private NextStepBuilder(int height, int width, StateRepresentation stateRepresentation) {
      this.cells = new String[height][width];
      this.stateRepresentation = stateRepresentation;
    }

    void setAlive(CellIndex index) {
      cells[index.getHeight()][index.getWidth()] = stateRepresentation.alive();
    }

    void setDead(CellIndex index) {
      cells[index.getHeight()][index.getWidth()] = stateRepresentation.dead();
    }

    Cells build() {
      return new Cells(cells, stateRepresentation);
    }
  }

}

