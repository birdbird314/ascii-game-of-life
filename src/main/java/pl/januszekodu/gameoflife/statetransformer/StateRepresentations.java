package pl.januszekodu.gameoflife.statetransformer;

class StateRepresentations {
  private final String dead;
  private final String alive;

  StateRepresentations(String dead, String alive) {
    this.dead = dead;
    this.alive = alive;
  }

  String dead() {
    return dead;
  }

  String alive() {
    return alive;
  }
}
