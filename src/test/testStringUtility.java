package test;

import static utility.StringUtility.*;

public class testStringUtility{
  public static void main(String[] args) {
    String hello="HelloWorld";
    String world=deleteAWord(hello);
    System.out.println(world);
  }
}