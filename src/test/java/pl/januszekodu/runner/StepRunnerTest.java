package pl.januszekodu.runner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.januszekodu.statetransformer.NextStateCalculator;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@RunWith(MockitoJUnitRunner.class)
public class StepRunnerTest {

  private static final String SOME_STATE = "someState";
  private static final String SOME_OTHER_STATE = "someOtherState";

  @Mock private StatePrinter printer;
  @Mock private Delayer delayer;
  @Mock private NextStateCalculator nextStateCalculator;

  private StepRunner runner;

  @Before
  public void setUp() throws Exception {
    runner = new StepRunner(printer, delayer, nextStateCalculator, SOME_STATE);
  }

  @Test
  public void shouldPrintAndDelayCurrentState() {
    runner.run();

    then(printer).should().clearAndPrint(SOME_STATE);
    then(delayer).should().delay();
  }

  @Test
  public void shouldCreateNextStateRunner() {
    given(nextStateCalculator.calculate(SOME_STATE)).willReturn(SOME_OTHER_STATE);

    runner.next().run();

    then(printer).should().clearAndPrint(SOME_OTHER_STATE);
    then(delayer).should().delay();
  }

}
