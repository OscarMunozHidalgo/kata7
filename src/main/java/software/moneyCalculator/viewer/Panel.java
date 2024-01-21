package software.moneyCalculator.viewer;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel implements Display{
    private JPanel panel;
    private int[] bounds;
    private String message;

    public Panel(int[] bounds, String message) {
        this.bounds = bounds;
        this.message = message;
        setup();
    }
    
    public Panel(String message) {
        this.message = message;
        setup();
    }

    public Panel(int[] bounds) {
        this.bounds = bounds;
        setup();
    }
    
    public void setup() {
        panel = new JPanel();
        if(bounds != null) panel.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
        panel.setOpaque(true);
        panel.setBackground(new Color(8,60,93)); //80,60,93
        panel.setFont(new Font("Consolas", Font.PLAIN,20)); //Font(x, y, z) y==1 bold, y==2 italic
        panel.setLayout(null);
    }
    
    public JComponent getComponent() {
        return panel;
    }


}