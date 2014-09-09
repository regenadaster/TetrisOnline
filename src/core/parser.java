package core;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utility.NullObject;
import utility.Pair;

public class Parser {

  private Map<String, Object> confResult;
  private String fileName = "Tetris.conf";
  char[] chars = new char[1024];
  int index = 0;
  private int currentMap;
  List<Map<String,Object>> maps=new ArrayList<Map<String,Object>>();
  
  public Parser(){
    confResult=new HashMap<String,Object>();
    maps.add(confResult);
  }
  public Map<String, Object> parseConfig() throws IOException {
    FileReader fr = new FileReader(fileName);
    currentMap=0;
    while (true) {
      Pair<String, Object> resultPair = parseLine(fr);
      if (resultPair.getKey() != null) {
        if(resultPair.getValue() instanceof NullObject){
          maps.add(new HashMap<String,Object>());
          maps.get(currentMap).put(resultPair.getKey(), maps.get(currentMap+1));
          currentMap++;
        }
        else{
          maps.get(currentMap).put(resultPair.getKey(),resultPair.getValue());
        }
      } else {
        break;
      }
    }
    return confResult;
  }

  public String packString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < index; i++) {
      sb.append(chars[i]);
    }
    index = 0;
    return sb.toString();
  }

  public Pair<String, Object> parseLine(FileReader fr) throws IOException {
    int r;
    boolean firstChar=true;
    String key = null;
    Object value = null;
    this.index = 0;
    while ((r = fr.read()) != -1) {
      if (r == '\r') {
        if(this.index==0){
          value=new NullObject();
        }else{
          value = packString();
        }
        break;
      } else {
        if (r == ':') {
          key = packString();
        } else {
          if (r == ' ') {
            if(firstChar){
              currentMap--;
            }
            firstChar=false;
            continue;
          }
          else{
            firstChar=false;
            chars[index++]=(char)r;
          }
        }
      }
    }
    return new Pair<String, Object>(key, value);
  }
}