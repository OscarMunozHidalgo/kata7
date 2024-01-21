package software.moneyCalculator.viewer;

import software.moneyCalculator.Money;
import software.moneyCalculator.MoneyConverterCommand;
import software.moneyCalculator.Currency;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class MainFrame extends JFrame implements ActionListener{
    private JButton button1;
    private List<Currency> currencies;
    private String[] currenciesCode;
    private JLabel result;
    private JComboBox comboBoxFrom;
    private JComboBox comboBoxTo;
    private JTextField original;
    private Money moneyToExchange;

    public MainFrame(List<Currency> currencies){
        this.currencies = currencies;
        this.currenciesCode = currenciesToArray(currencies);

        this.setTitle("Money Calculator");
        this.getContentPane().setBackground(new Color(29,39,49));
        this.setSize(610,105);
        this.setLocationRelativeTo(null);
        //this.setMinimumSize(new Dimension(1220,400));
        this.setLayout(null);
        //this.setLayout(new BorderLayout(10,10)); //Separation in the border panels layout
        displayComponents();
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private String[] currenciesToArray(List<Currency> currencies) {
        return  currencies.
                stream().
                map(s->s.letterCode()).
                filter(s -> (s != null && s.length() > 0)).
                collect(toList()).toArray(new String[0]);
    }

    private void displayComponents() {
        JComponent panel1 = new Panel(new int[]{10,10,200,50}).getComponent();
        JComponent panel2 = new Panel(new int[]{280,10,200,50}).getComponent();
        JComponent panel3 = new Panel(new int[]{220,10,50,50}).getComponent();
        /*panel1.setBackground(Color.CYAN);
        panel1.setBounds(10,10,200,200);*/
        this.add(panel1);
        this.add(panel2);
        //this.add(panel3);

        //JComponent label1 = new Label(new int[]{10,10,30,30}, "TO:").getComponent();
        JComponent label1 = new Label(new int[]{235,15,50,50}, "→").getComponent();
        label1.setFont(new Font("Consolas", Font.PLAIN,40));
        this.add(label1);

        JButton button = new JButton("Convert");
        button.setBackground(new Color(8,60,93));
        button.setBounds(490,10,100,50);
        button.setMnemonic('a'); //alt+a press the button
        button.setForeground(new Color(255,187,57));
        button.setFont(new Font("Consolas", Font.BOLD,16));
        button.setOpaque(true);
        //button.setEnabled(false);
        button.setFocusPainted(false);
        button.addActionListener(this);
        button1 = button;
        this.add(button);

        JTextField textFieldFrom = new JTextField("Input");
        textFieldFrom.setFont(new Font("Consolas", Font.PLAIN,20));
        textFieldFrom.setBounds(10,10,100,30);
        textFieldFrom.setBackground(new Color(8,60,93));
        textFieldFrom.setForeground(new Color(255,187,57));
        original = textFieldFrom;
        panel1.add(textFieldFrom);

        JLabel textFieldTo = new JLabel("Output");
        textFieldTo.setHorizontalAlignment(SwingConstants.LEFT);
        textFieldTo.setFont(new Font("Consolas", Font.PLAIN,15));
        textFieldTo.setBounds(10,10,110,30);
        textFieldTo.setBackground(new Color(8,60,93));
        textFieldTo.setForeground(new Color(255,187,57));
//        textFieldTo.setEnabled(true);
        result = textFieldTo;
        panel2.add(textFieldTo);

        JComponent comboBox1 = new ComboBox(new int[]{120,10,70,30}, currenciesCode).getComponent();
        JComponent comboBox2 = new ComboBox(new int[]{120,10,70,30}, currenciesCode).getComponent();
        comboBoxFrom = (JComboBox) comboBox1;
        comboBoxTo = (JComboBox) comboBox2;
        panel1.add(comboBox1);
        panel2.add(comboBox2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){
            try{
                Double originalAmount = Double.parseDouble(original.getText());
                moneyToExchange = new Money(Double.parseDouble(original.getText()), currencies.get(comboBoxFrom.getSelectedIndex()));
                result.setText(new MoneyConverterCommand(moneyToExchange, currencies.get(comboBoxTo.getSelectedIndex())).execute());
                System.out.println(comboBoxFrom.getSelectedIndex());
            }catch (NumberFormatException ex){
                System.out.println("Input format not valid");
            }

        }
    }
}
