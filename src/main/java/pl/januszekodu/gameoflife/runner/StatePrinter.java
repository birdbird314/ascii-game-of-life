package pl.januszekodu.gameoflife.runner;

class StatePrinter {
  void clearAndPrint(String state) {
    clear();
    print(state);
  }

  private void clear() {
    final String ANSI_CLS = "\u001b[2J";
    final String ANSI_HOME = "\u001b[H";
    System.out.print(ANSI_CLS + ANSI_HOME);
    System.out.flush();
  }

  private void print(String text) {
    System.out.println(text);
    System.out.flush();
  }
}
