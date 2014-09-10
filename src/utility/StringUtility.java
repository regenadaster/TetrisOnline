package utility;

public class StringUtility {
  public static String captureName(String name) {
    char[] cs = name.toCharArray();
    cs[0] -= 32;
    return String.valueOf(cs);
  }

  public static String decaptureName(String name) {
    char[] cs = name.toCharArray();
    cs[0] += 32;
    return String.valueOf(cs);
  }

  public static String deleteAWord(String name) {
    char[] cs = name.toCharArray();
    int pos=cs.length;
    for (int i = cs.length - 1; i >= 0; i--) {
      if(cs[i]>='A'&& cs[i]<='Z'){
        pos=i;
        break;
      }
    }
    if(pos!=cs.length){
      return name.substring(0, pos);
    }
    else{
      return name;
    }
  }
}