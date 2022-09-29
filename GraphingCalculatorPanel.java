import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.*;
import javax.swing.*;

public class GraphingCalculatorPanel extends JPanel {
    private int SCREEN_WIDTH = 640;
    private int SCREEN_HEIGHT = 480;
    private int STEP_SIZE = 40;
    private JSlider zoom;

    GraphingCalculatorPanel(){
        this.setPreferredSize(new Dimension(this.SCREEN_WIDTH, this.SCREEN_HEIGHT));
        zoom = new JSlider();
        this.add(zoom);
    }

    public void paintComponent(Graphics g){
        this.repaint();
        this.STEP_SIZE = (int)(40 * ((double)zoom.getValue() / (double)50));
        
        g.setColor(new Color(145, 151, 156));

        int stopx = this.SCREEN_WIDTH / (2 * this.STEP_SIZE);
        int stopy = this.SCREEN_HEIGHT / (2 * this.STEP_SIZE);

        // Draw coordinate system (x- and y-axis)
        
        // This draws the verical lines drawing two at a time (positive and negative)
        for(int i = 1; i <= stopx; i++)
        {
            g.drawLine((this.SCREEN_WIDTH / 2) + (this.STEP_SIZE * i), 0, (this.SCREEN_WIDTH / 2) + (this.STEP_SIZE * i), this.SCREEN_HEIGHT);
            g.drawLine((this.SCREEN_WIDTH / 2) - (this.STEP_SIZE * i), 0, (this.SCREEN_WIDTH / 2) - (this.STEP_SIZE * i), this.SCREEN_HEIGHT);
        }

        // This draws the horizontial lines drawing two at a time (positive and negative)
        for(int i = 1; i <= stopy; i++)
        {
            g.drawLine(0, (this.SCREEN_HEIGHT / 2) + (this.STEP_SIZE * i), this.SCREEN_WIDTH, (this.SCREEN_HEIGHT / 2) + (this.STEP_SIZE * i));
            g.drawLine(0, (this.SCREEN_HEIGHT / 2) - (this.STEP_SIZE * i), this.SCREEN_WIDTH, (this.SCREEN_HEIGHT / 2) - (this.STEP_SIZE * i));
        }
        
        

        g.setColor(Color.BLACK);
        g.drawLine(0, this.SCREEN_HEIGHT / 2, this.SCREEN_WIDTH, this.SCREEN_HEIGHT / 2);
        g.drawLine(this.SCREEN_WIDTH / 2, 0, this.SCREEN_WIDTH / 2, this.SCREEN_HEIGHT);

        

        // Draw function to screen
        for(float x = -10; x < 10; x++)
        {
            for(float y = -this.STEP_SIZE; y < this.STEP_SIZE; y++)
            {
                int i, j;
                i = (int)(this.STEP_SIZE * x) + (int)y + (this.SCREEN_WIDTH / 2);
                j = (int)(-1 * Math.ceil(Math.pow((((this.STEP_SIZE * x) + y) / this.STEP_SIZE), 2) * this.STEP_SIZE)) + (this.SCREEN_HEIGHT / 2);
                //j = (int)(-1 * Math.sin(40 * x)) + 240;
                //j = (int)x + 240;
                g.drawLine(i, j, i, j);
            }
            //y = (int)Math.ceil(Math.pow((x / 40.0), 2));
            //System.out.println("x: " + x + ", y: " + y);
            //g.drawRect(x, y, 1, 1);
        }
        //g.drawString("This is gona be awesome", 200, 200);
        
    }
}
