package pl.januszekodu.gameoflife.stateretriever;

import static pl.januszekodu.gameoflife.stateretriever.Preset.PULSAR;

public class InitialStateRetrieverFactory {

  public static InitialStateRetrieverFactory anInitialStateRetrieverFactory() {
    return new InitialStateRetrieverFactory();
  }

  static InitialStateRetriever anInitialStateRetriever(Preset preset) {
    return new InitialStateRetriever(new ResourceFileReader(), preset);
  }

  public InitialStateRetriever createDefaultInitialStateRetriever() {
    return anInitialStateRetriever(PULSAR);
  }
}
