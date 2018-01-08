package pl.januszekodu.gameoflife.stateretriever;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ResourceFileReader implements FileReader{
  @Override
  public String read(String path) {
    try (BufferedReader reader = getResourceBufferedReader(path)) {
      return readAllLines(reader);
    } catch (IOException ioe) {
      ioe.printStackTrace();
      return "";
    }
  }

  private static String readAllLines(BufferedReader reader) throws IOException {
    String line, result = "";
    while ((line = reader.readLine()) != null) {
        result += line + "\n";
    }
    return result;
  }

  private static BufferedReader getResourceBufferedReader(String path) {
    return new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(path)));
  }
}
