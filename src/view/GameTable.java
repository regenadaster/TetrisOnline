package view;

import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;

public class GameTable{
  
  private Display display;
  private Shell gameShell;
  
  public GameTable(Builder builder){
    display=builder.defaultDisplay;
    gameShell=builder.shell;
  }
  public void start(){
    this.gameShell.open();
    while (!gameShell.isDisposed()) {
      if (!display.readAndDispatch()) display.sleep();
    }
    display.dispose();
  }
  
  public static class Builder{
    private Display defaultDisplay=new Display();
    private Shell shell;
    public Builder(){
      createShell();
    }
    public void setDisplay(Display display){
      this.defaultDisplay=display;
    }
    private void createShell(){
      shell=new Shell(this.defaultDisplay);
    }
    public void setShellPosition(Rectangle rect){
      this.shell.setBounds(rect);
    }
    public GameTable build(){
      return new GameTable(this);
    }
  }
}