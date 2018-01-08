package pl.januszekodu.gameoflife.stateretriever;

public class InitialStateRetriever {

  private final FileReader reader;
  private final FileNameAware preset;

  public InitialStateRetriever(FileReader reader, FileNameAware preset) {
    this.reader = reader;
    this.preset = preset;
  }

  public String retrieve() {
    return reader.read("presets/" + preset.getFileName());
  }
}
