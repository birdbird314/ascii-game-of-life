package pl.januszekodu.gameoflife;

public interface Configuration {
  int getFramesPerMinute();

  String getDeadCellRepresentation();

  String getAliveCellRepresentation();

  String getInitialState();
}
