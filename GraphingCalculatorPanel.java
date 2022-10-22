import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.*;

public class GraphingCalculatorPanel extends JPanel {
    private int iter = 0;
    private int SCREEN_WIDTH = 640;
    private int SCREEN_HEIGHT = 480;
    private int STEP_SIZE = 40;
    private JSlider zoom;
    // Our function is f(x) = ax^i + bx^j + cx^k
    // For a, b, c are reals and i, j, k are integers 
    private double a_hat = -1;
    private int i_hat = 3;
    private double b_hat = -3;
    private int j_hat = 2;
    private double c_hat = 2;
    private int k_hat = 0;
    private JTextField a;
    private JTextField b;
    private JTextField c;
    private JTextField i;
    private JTextField j;
    private JTextField k;
    private JButton regraph;
    private JLabel equation = new JLabel("x^");

    GraphingCalculatorPanel(){
        System.out.println("------- START -------");
        this.setPreferredSize(new Dimension(this.SCREEN_WIDTH, this.SCREEN_HEIGHT));
        zoom = new JSlider();
        a = new JTextField(2);
        i = new JTextField(2);
        b = new JTextField(2);
        j = new JTextField(2);
        c = new JTextField(2);
        k = new JTextField(2);
        regraph = new JButton("Graph the function");
        regraph.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try {
                    double a_prime = Double.parseDouble(a.getText());
                    int i_prime = Integer.parseInt(i.getText());
                    a_hat = a_prime;
                    i_hat = i_prime;

                    double b_prime = Double.parseDouble(b.getText());
                    int j_prime = Integer.parseInt(j.getText());
                    b_hat = b_prime;
                    j_hat = j_prime;

                    double c_prime = Double.parseDouble(c.getText());
                    int k_prime = Integer.parseInt(k.getText());
                    c_hat = c_prime;
                    k_hat = k_prime;
                } catch (NumberFormatException n) {
                    System.out.println(a.getText() + " cannot be converted to integer");
                }
            }
        });

        this.add(zoom);
        this.add(a);
        this.add(equation);
        this.add(i);
        this.add(b);
        this.add(j);
        this.add(c);
        this.add(k);
        this.add(regraph);
    }

    public void paintComponent(Graphics g){
        // This adjusts the zoom, we are just incresing or decreasing the step size
        this.STEP_SIZE = (int)(40 * ((double)zoom.getValue() / (double)50)) + 10;
        
        g.setColor(new Color(145, 151, 156));

        // Seeing how many divisions we need to the up and to the left. 
        // We need to stop drawing somewhere.
        int stopx = this.SCREEN_WIDTH / (2 * this.STEP_SIZE);
        int stopy = this.SCREEN_HEIGHT / (2 * this.STEP_SIZE);

        // Below draws the coordinate system (x- and y-axis)

        /* 
        // This draws the divisions between units
        for(int i = 1; i <= stopx + 1; i++)
        {
            paintMiddle(g, (this.SCREEN_WIDTH / 2) + (this.STEP_SIZE * i), (this.SCREEN_WIDTH / 2) + (this.STEP_SIZE * (i - 1)));
            paintMiddle(g, (this.SCREEN_WIDTH / 2) + (this.STEP_SIZE * (-1 * i)), (this.SCREEN_WIDTH / 2) + (this.STEP_SIZE * ((-1 * i) + 1)));
        }
        */
        
        // This draws the unit divisions horizontially and vertically
        for(int i = 1; i <= stopx; i++)
        {
            g.setColor(new Color(90, 94, 97));
            g.drawLine((this.SCREEN_WIDTH / 2) + (this.STEP_SIZE * i), 0, (this.SCREEN_WIDTH / 2) + (this.STEP_SIZE * i), this.SCREEN_HEIGHT);
            g.drawLine((this.SCREEN_WIDTH / 2) - (this.STEP_SIZE * i), 0, (this.SCREEN_WIDTH / 2) - (this.STEP_SIZE * i), this.SCREEN_HEIGHT);
        } // end for
        
        for(int i = 1; i <= stopy; i++)
        {
            g.drawLine(0, (this.SCREEN_HEIGHT / 2) + (this.STEP_SIZE * i), this.SCREEN_WIDTH, (this.SCREEN_HEIGHT / 2) + (this.STEP_SIZE * i));
            g.drawLine(0, (this.SCREEN_HEIGHT / 2) - (this.STEP_SIZE * i), this.SCREEN_WIDTH, (this.SCREEN_HEIGHT / 2) - (this.STEP_SIZE * i));
        } // end for
        
        // This is the x- and y-axis
        g.setColor(Color.BLACK);
        g.drawLine(0, this.SCREEN_HEIGHT / 2, this.SCREEN_WIDTH, this.SCREEN_HEIGHT / 2);
        g.drawLine(this.SCREEN_WIDTH / 2, 0, this.SCREEN_WIDTH / 2, this.SCREEN_HEIGHT);


        // ------ END COORDINATE SYSTEM DRAWING ------
        

        // Draw function to screen
        int prev_i = -1;
        int prev_j = -1;

        for(float mu = -stopx - 1; mu < stopx + 1; mu++)
        {
            for(float x = 0; x < this.STEP_SIZE; x++)
            {
                int x_tilda = (int)(x + (this.STEP_SIZE * mu));
                float actual_x = (x + (this.STEP_SIZE * mu)) / this.STEP_SIZE;
                
                double answer = -1 * (this.a_hat * Math.pow(actual_x, this.i_hat)) + (this.b_hat * Math.pow(actual_x, this.j_hat)) + (this.c_hat * Math.pow(actual_x, this.k_hat));
                //double answer = -1 * (this.a_hat * Math.pow(actual_x, this.i_hat));
                
                double y_tilda = this.STEP_SIZE * answer;
                
                x_tilda = x_tilda + (this.SCREEN_WIDTH / 2);
                y_tilda = y_tilda + (this.SCREEN_HEIGHT / 2);
                
                if(x_tilda < 0 || x_tilda > this.SCREEN_WIDTH || y_tilda < 0 || y_tilda > this.SCREEN_HEIGHT || prev_i == -1){
                    // Point is off the screen or we are at the start
                } else {
                    g.drawLine(prev_i, prev_j, x_tilda, (int)y_tilda);
                } // end if
                

                prev_i = x_tilda;
                prev_j = (int)y_tilda;
                
//                System.out.println("(" + prev_i + ", " + prev_j + ")");
                /* 
                int i, j, j_1, j_2, j_3;
                i = (int)(this.STEP_SIZE * x) + (int)y + (this.SCREEN_WIDTH / 2);
                //j = (int)(-1 * Math.ceil((this.a_hat * Math.pow((((this.STEP_SIZE * x) + y) / this.STEP_SIZE), this.i_hat) * this.STEP_SIZE) + (this.b_hat * Math.pow((((this.STEP_SIZE * x) + y) / this.STEP_SIZE), this.j_hat) * this.STEP_SIZE) + (this.c_hat * Math.pow((((this.STEP_SIZE * x) + y) / this.STEP_SIZE), this.k_hat) * this.STEP_SIZE)));
                j = (int)(-1 * Math.ceil(this.a_hat * Math.pow((((this.STEP_SIZE * x) + y) / this.STEP_SIZE), this.i_hat) * this.STEP_SIZE)) + (this.SCREEN_HEIGHT / 2);
                //j_2 = (int)(-1 * Math.ceil(this.b_hat * Math.pow((((this.STEP_SIZE * x) + y) / this.STEP_SIZE), this.j_hat) * this.STEP_SIZE)) + (this.SCREEN_HEIGHT / 2);
                //j_3 = (int)(-1 * Math.ceil(this.c_hat * Math.pow((((this.STEP_SIZE * x) + y) / this.STEP_SIZE), this.k_hat) * this.STEP_SIZE)) + (this.SCREEN_HEIGHT / 2);
                //j = j_1;
                //j = (int)(-1 * Math.sin(40 * x)) + 240;
                //j = (int)x + 240;
                //j=45;


                (int)(-1 * Math.ceil(this.b_hat *  * this.STEP_SIZE)) ;

                x = (((this.STEP_SIZE * x) + y) / this.STEP_SIZE)

                x^j

                + MIDDLE_VERTICAL_OFFSET

                if(i < 0 || i > this.SCREEN_WIDTH || j < 0 || j > this.SCREEN_HEIGHT || prev_i == -1){
                    // Point is off the screen or we are at the start
                } else {
                    g.drawLine(prev_i, prev_j, i, j);
                } // end if

                prev_i = i;
                prev_j = j;
                */
            } // end for
            //y = (int)Math.ceil(Math.pow((x / 40.0), 2));
            //System.out.println("x: " + x + ", y: " + y);
            //g.draw Rect(x, y, 1, 1);
        } // end for
        
        //g.drawString("test", 200, 200);
        this.repaint();
    } // end paintComponent


    public void paintMiddle(Graphics g, int start, int finish){
        int extend = (finish - start) / 2;
        g.drawLine(start + extend, 0, start + extend, this.SCREEN_HEIGHT);
    }
}
