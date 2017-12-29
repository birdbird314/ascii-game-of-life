package pl.januszekodu.statetransformer;

import pl.januszekodu.Configuration;

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
