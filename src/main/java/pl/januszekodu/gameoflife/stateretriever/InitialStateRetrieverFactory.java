package pl.januszekodu.gameoflife.stateretriever;

public class InitialStateRetrieverFactory {

  private InitialStateRetrieverFactory() {
  }

  public static InitialStateRetriever anInitialStateRetriever(Preset preset) {
    return new InitialStateRetriever(new ResourceFileReader(), preset);
  }
}
