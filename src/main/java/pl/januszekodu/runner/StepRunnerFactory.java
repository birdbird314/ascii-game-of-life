package pl.januszekodu.runner;

import pl.januszekodu.Configuration;

import static pl.januszekodu.statetransformer.NextStateCalculatorFactory.aNextStateCalculator;

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
