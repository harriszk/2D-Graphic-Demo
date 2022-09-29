import javax.swing.JFrame;

public class GraphingCalculatorFrame extends JFrame {
    GraphingCalculatorFrame(){
        this.add(new GraphingCalculatorPanel());
        this.setTitle("Graphing Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    } // end constructor
}


/*
 *     private JFrame frame;
    private int width;
    private int height;

    public GraphingCalculatorFrame(int width, int height) {
        frame = new JFrame();
        this.width = width;
        this.height = height;
    }

    public void setUp() {
        frame.setSize(this.width, this.height);
        frame.setTitle("Graphing Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
 */