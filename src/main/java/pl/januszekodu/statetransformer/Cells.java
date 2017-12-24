package pl.januszekodu.statetransformer;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

class Cells {

  private static final String ALIVE = "*";
  private static final String DEAD = ".";

  private final String[][] cells;

  static Cells fromString(String table) {
    String[] rows = table.split("\n");
    String[][] cells = Arrays.stream(rows).map(row -> row.split("")).toArray(String[][]::new);
    return new Cells(cells);
  }

  private Cells(String[][] cells) {
    this.cells = cells;
  }

  int getWidth() {
    return cells[0].length;
  }

  int getHeight() {
    return cells.length;
  }

  boolean isAlive(CellIndex index) {
    try {
      return ALIVE.equals(cells[index.getHeight()][index.getWidth()]);
    } catch (ArrayIndexOutOfBoundsException e) {
      return false;
    }
  }

  boolean isDead(CellIndex index) {
    return !isAlive(index);
  }

  int countAliveNeighbours(CellIndex index) {
    return (int) index.getNeighbours().filter(this::isAlive).count();
  }

  @Override
  public String toString() {
    return Arrays.stream(cells)
        .map(row -> Arrays.stream(row).collect(joining()))
        .collect(joining("\n"));
  }

  static NextStepBuilder aNextStepBuilderFor(Cells cells) {
    return new NextStepBuilder(cells.getHeight(), cells.getWidth());
  }

  static class NextStepBuilder {
    private final String[][] cells;

    private NextStepBuilder(int height, int width) {
      this.cells = new String[height][width];
    }

    void setAlive(CellIndex index) {
      cells[index.getHeight()][index.getWidth()] = ALIVE;
    }

    void setDead(CellIndex index) {
      cells[index.getHeight()][index.getWidth()] = DEAD;
    }

    Cells build() {
      return new Cells(cells);
    }
  }

}

