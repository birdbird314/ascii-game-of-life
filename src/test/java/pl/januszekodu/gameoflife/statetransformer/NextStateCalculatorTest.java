package pl.januszekodu.gameoflife.statetransformer;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;
import static junitparams.JUnitParamsRunner.$;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class NextStateCalculatorTest {

  private NextStateCalculator nextStateCalculator;

  @Before
  public void setUp() {
    nextStateCalculator = new NextStateCalculator(".", "*");
  }

  @Test
  public void shouldDoNothingIfTableConsistOfOneDeadCell() {
    String result = nextStateCalculator.calculate(".");

    assertThat(result).isEqualTo(".");
  }

  static Object[] lessThanTwoLiveNeighboursParams() {
    return $(
        $("**", ".."),
        $("**\n..", "..\n..")
    );
  }

  @Test
  @Parameters(method = "lessThanTwoLiveNeighboursParams")
  public void shouldKillLiveCellWithLessThatTwoLiveNeighbours(String cells, String expected) {
    String result = nextStateCalculator.calculate(cells);

    assertThat(result).isEqualTo(expected);
  }

  static Object[] twoLiveNeighboursParams() {
    return $(
        $("***", ".*."),
        $("***.", ".*..")
    );
  }

  @Test
  @Parameters(method = "twoLiveNeighboursParams")
  public void shouldNotKillAliveCellWithTwoLiveNeighbours(String cells, String expected) {
    String result = nextStateCalculator.calculate(cells);

    assertThat(result).isEqualTo(expected);
  }

  @Test
  public void shouldBreedDeathCellWithThreeAliveNeighbours() {
    String result = nextStateCalculator.calculate(cells(
        "**",
        "*."
    ));

    assertThat(result).isEqualTo(cells(
        "**",
        "**"
    ));
  }

  @Test
  public void shouldNotKillAliveCellWithThreeAliveNeighbours() {
    String result = nextStateCalculator.calculate(cells(
        "**.",
        ".**"
    ));

    assertThat(result).isEqualTo(cells(
        "***",
        "***"
    ));
  }

  @Test
  public void shouldKillAliveCellWithMoreThanThreeAliveNeighbours() {
    String result = nextStateCalculator.calculate(cells(
        "***",
        ".**"
    ));

    assertThat(result).isEqualTo(cells(
        "*.*",
        "*.*"
    ));
  }

  private static String cells(String... rows) {
    return Arrays.stream(rows).collect(joining("\n"));
  }
}
