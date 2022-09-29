import java.awt.*;
import javax.swing.*;

public class Image extends JFrame {
    int width = 640;
    int height = 480;

    public static void main(String[] args)
    {
        new Image();
    } // end main

    public Image()
    {
        
        MyCanvas c = new MyCanvas();
        this.add(c, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(this.width, this.height);
        this.setVisible(true);
    } // end constructor

    class MyCanvas extends JPanel {
        int width = 640;
        int height = 480;
        int STEP_SIZE = 40;

        public void paintComponent(Graphics g){

            g.setColor(new Color(145, 151, 156));

            int stopx = this.width / (2 * this.STEP_SIZE);
            int stopy = this.height / (2 * this.STEP_SIZE);

            // Draw coordinate system (x- and y-axis)
            for(int i = 1; i < stopx; i++)
            {
                g.drawRect((this.width / 2) + (this.STEP_SIZE * i), 0, 0, this.height);
                g.drawRect((this.width / 2) - (this.STEP_SIZE * i), 0, 0, this.height);
                if(i < stopy)
                {
                    g.drawRect(0, (this.height / 2) + (this.STEP_SIZE * i), this.width, 0);
                    g.drawRect(0, (this.height / 2) - (this.STEP_SIZE * i), this.width, 0);
                }
                
            }

            g.setColor(Color.BLACK);
            g.drawRect(0, this.height / 2, this.width, 1);
            g.drawRect(this.width / 2, 0, 1, this.height);


            // Draw function to screen
            for(float x = -4; x < 4; x++)
            {
                for(float y = -40; y < 40; y++)
                {
                    int i, j;
                    i = (int)(40 * x) + (int)y + 320;
                    j = (int)(-1 * Math.ceil(Math.pow((((40 * x) + y) / 40), 2) * 40)) + 240;
                    g.drawRect(i, j, 1, 1);
                }
                //y = (int)Math.ceil(Math.pow((x / 40.0), 2));
                //System.out.println("x: " + x + ", y: " + y);
                //g.drawRect(x, y, 1, 1);
            }

            //g.fillRect(150, 50, 200, 50);

            //this.repaint();
        } // end paint

  } // end class def
}