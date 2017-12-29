package pl.januszekodu;

import pl.januszekodu.runner.StepRunner;

import static pl.januszekodu.runner.StepRunnerFactory.aStepRunner;

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
    String blinker =
        ".....\n" +
        ".***.\n" +
        ".....";

    Configuration configuration = new Configuration() {
      @Override
      public int getFramesPerMinute() {
        return 60;
      }

      @Override
      public String getDeadCellRepresentation() {
        return ".";
      }

      @Override
      public String getAliveCellRepresentation() {
        return "*";
      }

      @Override
      public String getInitialState() {
        return blinker;
      }
    };

    new App(aStepRunner(configuration)).run();
  }
}
