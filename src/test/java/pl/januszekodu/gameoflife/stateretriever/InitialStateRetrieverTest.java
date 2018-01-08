package pl.januszekodu.gameoflife.stateretriever;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class InitialStateRetrieverTest {

  @Mock private FileReader reader;
  @Mock private FileNameAware preset;

  @Test
  public void shouldRetrieveBlinker() {
    InitialStateRetriever retriever = new InitialStateRetriever(reader, preset);
    given(preset.getFileName()).willReturn("someFilename");
    given(reader.read("resources/presets/someFilename")).willReturn("someValue");

    String result = retriever.retrieve();

    assertThat(result).isEqualTo("someValue");
  }
}
