package pl.januszekodu.gameoflife.statetransformer;

import pl.januszekodu.gameoflife.Configuration;

public class NextStateCalculatorFactory {
  private NextStateCalculatorFactory() {
  }

  public static NextStateCalculator aNextStateCalculator(Configuration configuration) {
    return new NextStateCalculator(
        configuration.getDeadCellRepresentation(),
        configuration.getAliveCellRepresentation()
    );
  }
}
