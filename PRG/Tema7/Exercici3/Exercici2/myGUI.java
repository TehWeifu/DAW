import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class myGUI extends JFrame {
    public myGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 300);
        setResizable(false);
        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Start labels
        JLabel labelName = new JLabel("Dime tu nombre:");
        labelName.setBounds(10, 10, 200, 20);
        contentPane.add(labelName);

        JLabel labelHobby = new JLabel("Intereses:");
        labelHobby.setBounds(10, 50, 100, 20);
        contentPane.add(labelHobby);

        JLabel labelGender = new JLabel("Sexo:");
        labelGender.setBounds(10, 120, 100, 20);
        contentPane.add(labelGender);

        JLabel labelCity = new JLabel("Ciudad:");
        labelCity.setBounds(10, 190, 100, 20);
        contentPane.add(labelCity);
        // End Labels

        // Start TextFields
        JTextField textFieldName = new JTextField();
        textFieldName.setBounds(140, 10, 100, 20);
        contentPane.add(textFieldName);
        // End TextFields

        // Start CheckBox
        JCheckBox checkBoxFly = new JCheckBox("Interesado en viajar");
        checkBoxFly.setBounds(10, 80, 200, 20);
        contentPane.add(checkBoxFly);

        JCheckBox checkBoxSports = new JCheckBox("Aficionado a los deportes");
        checkBoxSports.setBounds(10, 100, 300, 20);
        contentPane.add(checkBoxSports);
        // End CheckBox

        // Start RadioButton
        JRadioButton buttonGenderMale = new JRadioButton("Hombre", true);
        buttonGenderMale.setBounds(10, 140, 100, 20);
        buttonGenderMale.setActionCommand("Hombre");
        contentPane.add(buttonGenderMale);

        JRadioButton buttonGenderFemale = new JRadioButton("Mujer");
        buttonGenderFemale.setBounds(10, 160, 100, 20);
        buttonGenderMale.setActionCommand("Mujer");
        contentPane.add(buttonGenderFemale);

        ButtonGroup buttonGroupGender = new ButtonGroup();
        buttonGroupGender.add(buttonGenderMale);
        buttonGroupGender.add(buttonGenderFemale);
        // End RadioButton

        // Start ComboBox
        JComboBox<String> comboBoxCities = new JComboBox<>(new String[]{"Madrid", "Sevilla"});
        comboBoxCities.setBounds(80, 190, 100, 20);
        contentPane.add(comboBoxCities);
        // End ComboBox

        // Start Button
        JButton buttonSend = new JButton("Enviar");
        buttonSend.setBounds(10, 230, 80, 20);
        contentPane.add(buttonSend);
        // End Button

        // Start Button EventListener
        buttonSend.addActionListener(actionEvent -> {
            try {
                FileWriter myFile = new FileWriter("./users.txt", true);
                myFile.write(String.format("%s: %s%n%s: %b%n%s: %b%n%s: %s%n%s: %s%n%n",
                        "Nombre", textFieldName.getText(),
                        "Interesado en viajar", checkBoxFly.isSelected(),
                        "Aficionado a los deportes", checkBoxSports.isSelected(),
                        "Sexo", buttonGroupGender.getSelection().getActionCommand(),
                        "Ciudad", comboBoxCities.getSelectedItem()));
                myFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

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
