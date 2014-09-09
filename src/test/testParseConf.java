package test;

import java.io.IOException;
import java.util.Map;

import core.Parser;

public class testParseConf{
  public static void main(String[] args) throws IOException {
    Parser par=new Parser();
    Map<String,Object>result=par.parseConfig();
    System.out.println(result);
    
  }
}