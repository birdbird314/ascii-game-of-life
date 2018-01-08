package pl.januszekodu.gameoflife.stateretriever;

public enum Preset implements FileNameAware {
  BLINKER("blinker"), PULSAR("pulsar");

  private final String fileName;

  Preset(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public String getFileName() {
    return fileName;
  }
}
