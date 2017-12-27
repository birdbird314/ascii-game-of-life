package pl.januszekodu.runner;

import pl.januszekodu.statetransformer.NextStateCalculator;

public class StepRunner {

  private final StatePrinter printer;
  private final Delayer delayer;
  private final NextStateCalculator nextStateCalculator;
  private final String state;

  StepRunner(StatePrinter printer, Delayer delayer, NextStateCalculator nextStateCalculator, String someState) {
    this.printer = printer;
    this.delayer = delayer;
    this.nextStateCalculator = nextStateCalculator;
    this.state = someState;
  }

  public void run() {
    printer.clearAndPrint(state);
    delayer.delay();
  }

  public StepRunner next() {
    return aStepRunnerWithState(nextStateCalculator.calculate(state));
  }

  private StepRunner aStepRunnerWithState(String state) {
    return new StepRunner(printer, delayer, nextStateCalculator, state);
  }
}
