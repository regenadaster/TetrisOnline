package test;

import view.GameTable;


public class testView{
  public static void main(String[] args) {
    GameTable gt=new GameTable.Builder().build();
    gt.start();
  }
}