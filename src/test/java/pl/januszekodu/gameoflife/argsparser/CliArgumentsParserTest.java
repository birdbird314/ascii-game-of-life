package pl.januszekodu.gameoflife.argsparser;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.januszekodu.gameoflife.Configuration;
import pl.januszekodu.gameoflife.stateretriever.InitialStateRetriever;
import pl.januszekodu.gameoflife.stateretriever.InitialStateRetrieverFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class CliArgumentsParserTest {

  private static final String SOME_INITIAL_STATE = "someInitialState";

  @Mock private InitialStateRetrieverFactory initialStateRetrieverFactory;
  @Mock private InitialStateRetriever initialStateRetriever;

  @InjectMocks private CliArgumentsParser parser;

  @Test
  public void shouldCreateDefaultConfigurationForEmptyArgs() {
    given(initialStateRetrieverFactory.createDefaultInitialStateRetriever()).willReturn(initialStateRetriever);
    given(initialStateRetriever.retrieve()).willReturn(SOME_INITIAL_STATE);

    Configuration configuration = parser.parse(new String[0]);

    assertThat(configuration.getAliveCellRepresentation()).isEqualTo("O");
    assertThat(configuration.getDeadCellRepresentation()).isEqualTo(".");
    assertThat(configuration.getFramesPerMinute()).isEqualTo(200);
    assertThat(configuration.getInitialState()).isEqualTo(SOME_INITIAL_STATE);
  }
}
