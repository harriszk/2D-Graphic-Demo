import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class ImageDemo extends JFrame {
  public static void main(String[] args){
    new ImageDemo();
  } // end main

  public ImageDemo(){

    MyCanvas c = new MyCanvas();
    this.add(c, BorderLayout.CENTER);

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(640, 480);
    this.setVisible(true);
  } // end constructor


  class MyCanvas extends JPanel{

    public void paintComponent(Graphics g){
        g.drawRect(150, 50, 1, 1);
        //g.fillRect(150, 50, 200, 50);

        this.repaint();
    } // end paint

    public void drawPixel(Graphics g, )

  } // end class def

} // end class def