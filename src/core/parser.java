package core;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class parser {

  private Map<String, Object> confResult;
  private String fileName = "Tetric.conf";
  char[] chars = new char[1024];
  int index = 0;

  public void parseConfig() throws IOException {
    FileReader fr = new FileReader(fileName);
    while (true) {
      parseLine(fr);
    }
  }

  public void parseLine(FileReader fr) throws IOException {
    int r;
    this.index = 0;
    while ((r = fr.read()) != -1) {
      if (r == '\r') {
        
      } else {
        if (r == ':') {

        } else {
          if (r == ' ') {

          }
        }
      }
    }
  }
}