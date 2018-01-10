package pl.januszekodu.gameoflife.argsparser;

import pl.januszekodu.gameoflife.Configuration;

class DefaultConfiguration implements Configuration {

  private final String initialState;

  static Configuration aDefaultConfigurationWithInitialState(String initialState) {
    return new DefaultConfiguration(initialState);
  }

  private DefaultConfiguration(String initialState) {
    this.initialState = initialState;
  }

  @Override
  public int getFramesPerMinute() {
    return 200;
  }

  @Override
  public String getDeadCellRepresentation() {
    return ".";
  }

  @Override
  public String getAliveCellRepresentation() {
    return "O";
  }

  @Override
  public String getInitialState() {
    return initialState;
  }
}
