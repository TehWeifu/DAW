import javax.swing.*;
import java.awt.*;

public class myGUI extends JFrame {
    public myGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Start Labels
        JLabel labelTitle = new JLabel("Captura de datos");
        labelTitle.setBounds(10, 30, 350, 20);
        contentPane.add(labelTitle);

        JLabel labelName = new JLabel("Nombre");
        labelName.setBounds(30, 70, 200, 20);
        contentPane.add(labelName);

        JLabel labelAge = new JLabel("Edad");
        labelAge.setBounds(40, 100, 200, 20);
        contentPane.add(labelAge);
        // End Labels

        // Start TextField
        JTextField textFieldName = new JTextField("");
        textFieldName.setBounds(100, 70, 200, 20);
        contentPane.add(textFieldName);

        JTextField textFieldAge = new JTextField("");
        textFieldAge.setBounds(100, 100, 100, 20);
        contentPane.add(textFieldAge);
        // End TextField

        // Start button
        JButton buttonSnd = new JButton("aceptar");
        buttonSnd.setBounds(200, 150, 100, 20);
        contentPane.add(buttonSnd);

        buttonSnd.addActionListener(actionEvent -> {
            int tmpAge = 0;
            boolean isValidAge = true;
            try {
                tmpAge = Integer.parseInt(textFieldAge.getText());
            } catch (NumberFormatException e) {
                isValidAge = false;
            }

            if (isValidAge && tmpAge < 0 ) isValidAge = false;

            if (isValidAge) {
                labelTitle.setText(String.format("Nombre: %s | Edad: %d", textFieldName.getText(), tmpAge));
            } else {
                labelTitle.setText("La edad no es valida");
            }
        });
        // End button
    }

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
