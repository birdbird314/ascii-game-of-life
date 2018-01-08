package pl.januszekodu.gameoflife;

import pl.januszekodu.gameoflife.runner.StepRunner;
import pl.januszekodu.gameoflife.stateretriever.Preset;

import static pl.januszekodu.gameoflife.runner.StepRunnerFactory.aStepRunner;
import static pl.januszekodu.gameoflife.stateretriever.InitialStateRetrieverFactory.anInitialStateRetriever;

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
        return anInitialStateRetriever(Preset.BLINKER).retrieve();
      }
    };

    new App(aStepRunner(configuration)).run();
  }
}
