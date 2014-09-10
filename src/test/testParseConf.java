package test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;



import core.Parser;
import static utility.Mapping.*;

public class testParseConf{
  public static void main(String[] args) throws IOException {
    Parser par=new Parser();
    Map<String,Object>result=par.parseConfig();
    System.out.println(result);
    Map<Object,Object>contextMap=new HashMap<Object,Object>();
    transformMap2KV(result,contextMap,new String(""));
    Iterator it=contextMap.keySet().iterator();
    while(it.hasNext()){
      Object tempkey=it.next();
      Object tempvalue=contextMap.get(tempkey);
      System.out.println(tempkey+":"+tempvalue);
    }
  }
}