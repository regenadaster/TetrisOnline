package utility;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import static utility.StringUtility.*;

public class Mapping {
  /**
   * transform the tree struct map to key value map;
   * 
   */
  public static Boolean transformMap2KV(Map sou, Map des, String prefix) {
    Iterator<Object> it = sou.keySet().iterator();
    while (it.hasNext()) {
      Object tmpKey = it.next();
      Object tmpValue = sou.get(tmpKey);
      if (tmpValue instanceof HashMap) {
        prefix += captureName((String) tmpKey);
        transformMap2KV((HashMap)tmpValue,des,prefix);
      } else {
        des.put(prefix+captureName((String) tmpKey), tmpValue);
      }
    }
    return true;
  }
}