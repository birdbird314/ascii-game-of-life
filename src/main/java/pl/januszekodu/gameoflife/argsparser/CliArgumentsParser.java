package pl.januszekodu.gameoflife.argsparser;

import pl.januszekodu.gameoflife.Configuration;
import pl.januszekodu.gameoflife.stateretriever.InitialStateRetriever;
import pl.januszekodu.gameoflife.stateretriever.InitialStateRetrieverFactory;

public class CliArgumentsParser {

  private final InitialStateRetrieverFactory initialStateRetrieverFactory;

  CliArgumentsParser(InitialStateRetrieverFactory initialStateRetrieverFactory) {
    this.initialStateRetrieverFactory = initialStateRetrieverFactory;
  }

  public Configuration parse(String[] args) {
    InitialStateRetriever retriever = initialStateRetrieverFactory.createDefaultInitialStateRetriever();
    return DefaultConfiguration.aDefaultConfigurationWithInitialState(retriever.retrieve());
  }
}
