import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.metal.MetalBorders;
import java.awt.*;

public class myGUI extends JFrame {
    /**
     * Create the frame.
     */
    public myGUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 600, 600);
        JPanel contentPane = new JPanel();
        this.setContentPane(contentPane);
        contentPane.setLayout(null);

//        Here goes the labels
        JLabel labelDrinks = new JLabel("BEBIDAS");
        labelDrinks.setBounds(10, 10, 100, 20);
        contentPane.add(labelDrinks);

        JLabel labelPrice = new JLabel("PRECIO");
        labelPrice.setBounds(250, 10, 100, 20);
        contentPane.add(labelPrice);

        JLabel labelEuros = new JLabel("Euros");
        labelEuros.setBounds(400, 100, 100, 20);
        contentPane.add(labelEuros);

        JLabel labelCents = new JLabel("Centimos");
        labelCents.setBounds(400, 300, 100, 20);
        contentPane.add(labelCents);

        JLabel labelReturn = new JLabel("VUELTAS");
        labelReturn.setBounds(300, 500, 100, 20);
        contentPane.add(labelReturn);
//        Here ends the labels

//        Here starts the textAreas
        JTextArea textAreaPrice = new JTextArea("0.80");
        textAreaPrice.setBounds(250, 100, 100, 125);
        textAreaPrice.setFocusable(false);
        textAreaPrice.setBorder(new LineBorder(Color.BLACK));
        contentPane.add(textAreaPrice);

        JTextArea textAreaReturns = new JTextArea();
        textAreaReturns.setBounds(400, 475, 125, 50);
        textAreaReturns.setFocusable(false);
        textAreaReturns.setBorder(new LineBorder(Color.BLACK));
        contentPane.add(textAreaReturns);
        // Here ends the text Areas

        //Here begins the combo box
        JComboBox<Float> comboBoxEuros = new JComboBox<>(new Float[]{0.0f, 1.0f, 2.0f, 3.0f, 4.0f, 5.0f});
        comboBoxEuros.setSelectedIndex(0);
        comboBoxEuros.setBounds(500, 100, 50, 20);
        contentPane.add(comboBoxEuros);

        JComboBox<Float> comboBoxCents = new JComboBox<>(new Float[]{0.0f, 0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f});
        comboBoxCents.setSelectedIndex(0);
        comboBoxCents.setBounds(500, 300, 50, 20);
        contentPane.add(comboBoxCents);
        // Here ends the combo box

        //Here begins the buttons
        JButton buttonCalculate = new JButton("Extraer");
        buttonCalculate.setBounds(100, 500, 100, 20);
        contentPane.add(buttonCalculate);
        // Here ends the buttons declaration

        // Here begins the button group
        ButtonGroup drinkGroup = new ButtonGroup();

        JRadioButton drinkWater = new JRadioButton("Agua", true);
        drinkWater.setBounds(10, 50, 100, 20);
        drinkWater.putClientProperty("price", "0.80");
        drinkGroup.add(drinkWater);
        contentPane.add(drinkWater);

        JRadioButton drinkCoke = new JRadioButton("Coca Cola");
        drinkCoke.setBounds(10, 100, 100, 20);
        drinkCoke.putClientProperty("price", "1.20");
        drinkGroup.add(drinkCoke);
        contentPane.add(drinkCoke);

        JRadioButton drinkAlcohol = new JRadioButton("Güisqui");
        drinkAlcohol.setBounds(10, 150, 100, 20);
        drinkAlcohol.putClientProperty("price", "3.10");
        drinkGroup.add(drinkAlcohol);
        contentPane.add(drinkAlcohol);
        // Here begins the button group

        // Start Event Listeners
        buttonCalculate.addActionListener(actionEvent -> {
            float prodcutPrice = Float.parseFloat(textAreaPrice.getText());
            float userMoney = (float) comboBoxEuros.getSelectedItem() + (float) comboBoxCents.getSelectedItem();
            float total = userMoney - prodcutPrice;
            if (total < 0) {
                textAreaReturns.setText(String.format("Te faltan %.2f$", -total));
            } else {
                textAreaReturns.setText(String.format("%.2f$", total));
            }
        });

        drinkGroup.getElements().asIterator().forEachRemaining(btn -> {
            btn.addActionListener(actionEvent -> {
                textAreaPrice.setText(btn.getClientProperty("price").toString());
            });
        });
        // End Event Listeners
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                myGUI frame = new myGUI();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
