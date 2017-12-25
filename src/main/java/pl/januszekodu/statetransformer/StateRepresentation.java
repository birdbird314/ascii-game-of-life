package pl.januszekodu.statetransformer;

class StateRepresentation {
  private final String dead;
  private final String alive;

  StateRepresentation(String dead, String alive) {
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
