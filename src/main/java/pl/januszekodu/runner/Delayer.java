package pl.januszekodu.runner;

import static java.lang.Thread.sleep;

class Delayer {

  private final int delayInMilliseconds;

  Delayer(int framesPerMinute) {
    delayInMilliseconds = (1000 * 60) / framesPerMinute;
  }

  void delay() {
    try {
      sleep(delayInMilliseconds);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

