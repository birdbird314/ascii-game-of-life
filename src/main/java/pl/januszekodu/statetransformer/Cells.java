package pl.januszekodu.statetransformer;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

class Cells {
  private final String dead;
  private final String alive;

  private final String[][] cells;

  static Cells fromString(String table, String dead, String alive) {
    String[] rows = table.split("\n");
    String[][] cells = Arrays.stream(rows).map(row -> row.split("")).toArray(String[][]::new);
    return new Cells(cells, dead, alive);
  }

  private Cells(String[][] cells, String dead, String alive) {
    this.cells = cells;
    this.dead = dead;
    this.alive = alive;
  }

  int getWidth() {
    return cells[0].length;
  }

  int getHeight() {
    return cells.length;
  }

  boolean isAlive(CellIndex index) {
    try {
      return alive.equals(cells[index.getHeight()][index.getWidth()]);
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
        cells.dead,
        cells.alive
    );
  }

  static class NextStepBuilder {
    private final String[][] cells;
    private final String dead;
    private final String alive;

    private NextStepBuilder(int height, int width, String dead, String alive) {
      this.cells = new String[height][width];
      this.dead = dead;
      this.alive = alive;
    }

    void setAlive(CellIndex index) {
      cells[index.getHeight()][index.getWidth()] = alive;
    }

    void setDead(CellIndex index) {
      cells[index.getHeight()][index.getWidth()] = dead;
    }

    Cells build() {
      return new Cells(cells, dead, alive);
    }
  }

}

