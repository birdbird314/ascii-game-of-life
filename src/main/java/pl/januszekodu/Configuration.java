package pl.januszekodu;

public interface Configuration {
  int getFramesPerMinute();

  String getDeadCellRepresentation();

  String getAliveCellRepresentation();

  String getInitialState();
}
