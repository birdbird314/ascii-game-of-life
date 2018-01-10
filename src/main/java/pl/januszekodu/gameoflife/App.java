package pl.januszekodu.gameoflife;

import pl.januszekodu.gameoflife.runner.StepRunner;

import static pl.januszekodu.gameoflife.argsparser.CliArgumentsParserFactory.aCliArgumentsParser;
import static pl.januszekodu.gameoflife.runner.StepRunnerFactory.aStepRunner;

public class App {
  private final StepRunner stepRunner;

  private App(StepRunner stepRunner) {
    this.stepRunner = stepRunner;
  }

  private void run() {
    for(StepRunner runner = stepRunner; true; runner = runner.next())
      runner.run();
  }

  public static void main(String[] args) {
    Configuration configuration = aCliArgumentsParser().parse(args);
    anAppWithConfiguration(configuration).run();
  }

  private static App anAppWithConfiguration(Configuration configuration) {
    return new App(aStepRunner(configuration));
  }
}
