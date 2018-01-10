package pl.januszekodu.gameoflife.argsparser;

import static pl.januszekodu.gameoflife.stateretriever.InitialStateRetrieverFactory.anInitialStateRetrieverFactory;

public class CliArgumentsParserFactory {
  private CliArgumentsParserFactory() {
  }

  public static CliArgumentsParser aCliArgumentsParser() {
    return new CliArgumentsParser(anInitialStateRetrieverFactory());
  }
}
