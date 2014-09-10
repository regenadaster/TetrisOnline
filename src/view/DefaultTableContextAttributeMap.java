package view;

import java.util.HashMap;
import java.util.Map;

public class DefaultTableContextAttributeMap implements TableContextAttributeMap{
  private Map<Object,Object>contextMap=new HashMap<Object,Object>();
  @Override
  public Object getAttribute(Object key) { 
    if(contextMap.containsKey(key)){
      return contextMap.get(key);
    }
    else{
      return null;
    }
  }

  @Override
  public void setAttribute(Object key, Object value) {
    contextMap.put(key, value);
  }
  
  
}