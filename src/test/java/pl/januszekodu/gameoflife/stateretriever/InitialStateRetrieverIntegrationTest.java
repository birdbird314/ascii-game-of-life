package pl.januszekodu.gameoflife.stateretriever;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.januszekodu.gameoflife.stateretriever.InitialStateRetrieverFactory.anInitialStateRetriever;

public class InitialStateRetrieverIntegrationTest {
  @Test
  public void shouldRetrieveBlinker() {
    InitialStateRetriever retriever = anInitialStateRetriever(Preset.BLINKER);
    String blinker =
        ".....\n" +
        ".***.\n" +
        ".....\n";

    assertThat(retriever.retrieve()).isEqualTo(blinker);
  }

}
