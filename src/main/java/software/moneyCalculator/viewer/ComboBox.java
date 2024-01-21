package software.moneyCalculator.viewer;

import javax.swing.*;
import java.awt.*;

public class ComboBox implements Display{
    private JComboBox comboBox;
    private int[] bounds;
    private String[] options;

    public ComboBox(int[] bounds, String[] options) {
        this.bounds = bounds;
        this.options = options;
        setup();
    }

    public ComboBox(String[] options) {
        this.options = options;
        setup();
    }

    public ComboBox(int[] bounds) {
        this.bounds = bounds;
        setup();
    }

    @Override
    public void setup() {
        comboBox = new JComboBox(options);
        if(bounds != null) comboBox.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
        comboBox.setOpaque(true);
        comboBox.setBackground(new Color(8,60,93));
        comboBox.setForeground(new Color(255,187,57));
        comboBox.setFont(new Font("Consolas", Font.PLAIN,20)); //Font(x, y, z) y==1 bold, y==2 italic
    }

    @Override
    public JComponent getComponent() {
        return comboBox;
    }
}
