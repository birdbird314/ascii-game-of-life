package pl.januszekodu.gameoflife.runner;

import pl.januszekodu.gameoflife.Configuration;

import static pl.januszekodu.gameoflife.statetransformer.NextStateCalculatorFactory.aNextStateCalculator;

public class StepRunnerFactory {
  private StepRunnerFactory() {
  }

  public static StepRunner aStepRunner(Configuration configuration) {
    return new StepRunner(
        new StatePrinter(),
        new Delayer(configuration.getFramesPerMinute()),
        aNextStateCalculator(configuration),
        configuration.getInitialState()
    );
  }
}
