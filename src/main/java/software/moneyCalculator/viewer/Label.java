package software.moneyCalculator.viewer;

import javax.swing.*;
import java.awt.*;

public class Label implements Display{
    private JLabel label;
    private int[] bounds;
    private String message;

    public Label(int[] bounds, String message) {
        this.bounds = bounds;
        this.message = message;
        setup();
    }

    public Label(String message) {
        this.message = message;
        setup();
    }

    public Label(int[] bounds) {
        this.bounds = bounds;
        setup();
    }

    @Override
    public void setup() {
        label = new JLabel(message);
        if(bounds != null) label.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
        label.setForeground(new Color(255,187,57));
        label.setFont(new Font("Consolas", Font.PLAIN,20)); //Font(x, y, z) y==1 bold, y==2 italic
    }

    @Override
    public JComponent getComponent() {
        return label;
    }


}
