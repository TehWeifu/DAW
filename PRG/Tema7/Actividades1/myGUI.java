import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Component;

public class myGUI extends JFrame {

    private final JPanel contentPane;
    private final JTextField textFieldID;
    private final JTextField textFieldName;

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

    /**
     * Create the frame.
     */
    public myGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        JPanel panelTitle = new JPanel();
        contentPane.add(panelTitle);
        panelTitle.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblTitle = new JLabel("INGRESO DE DATOS PERSONALES");
        panelTitle.add(lblTitle);
        lblTitle.setAlignmentX(0.5f);

        JPanel panelFrom = new JPanel();
        contentPane.add(panelFrom);
        panelFrom.setLayout(new BoxLayout(panelFrom, BoxLayout.Y_AXIS));

        JPanel panelFormID = new JPanel();
        panelFrom.add(panelFormID);
        panelFormID.setLayout(new BoxLayout(panelFormID, BoxLayout.X_AXIS));

        JLabel lblID = new JLabel("ID");
        panelFormID.add(lblID);

        textFieldID = new JTextField();
        textFieldID.setMaximumSize(new Dimension(100, 100));
        panelFormID.add(textFieldID);
        textFieldID.setColumns(10);

        JPanel paneFormName = new JPanel();
        panelFrom.add(paneFormName);
        paneFormName.setLayout(new BoxLayout(paneFormName, BoxLayout.X_AXIS));

        JLabel lblName = new JLabel("Nombre");
        paneFormName.add(lblName);

        textFieldName = new JTextField();
        textFieldName.setMaximumSize(new Dimension(100, 100));
        textFieldName.setColumns(10);
        paneFormName.add(textFieldName);

        JPanel paneFormHobbies = new JPanel();
        panelFrom.add(paneFormHobbies);
        paneFormHobbies.setLayout(new BoxLayout(paneFormHobbies, BoxLayout.X_AXIS));

        JLabel lblFormHobbies = new JLabel("Hobbies");
        lblFormHobbies.setAlignmentY(Component.TOP_ALIGNMENT);
        paneFormHobbies.add(lblFormHobbies);

        JScrollPane scrollPaneHobbies = new JScrollPane();
        paneFormHobbies.add(scrollPaneHobbies);

        JTextArea textAreaHobbies = new JTextArea();
        scrollPaneHobbies.setViewportView(textAreaHobbies);
        scrollPaneHobbies.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPaneHobbies.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel paneFormGroup = new JPanel();
        panelFrom.add(paneFormGroup);
        paneFormGroup.setLayout(new BoxLayout(paneFormGroup, BoxLayout.X_AXIS));

        JLabel lblGroup = new JLabel("Group");
        paneFormGroup.add(lblGroup);

        JComboBox comboBoxGroup = new JComboBox(new String[]{"Amigos", "Trabajo"});
        comboBoxGroup.setMaximumSize(new Dimension(100, 100));
        comboBoxGroup.setSelectedIndex(0);
        paneFormGroup.add(comboBoxGroup);

        JPanel panelBtns = new JPanel();
        contentPane.add(panelBtns);
        panelBtns.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btnClrear = new JButton("Limpiar");
        btnClrear.addActionListener(e -> {
            textFieldID.setText("");
            textFieldName.setText("");
            textAreaHobbies.setText("");
            comboBoxGroup.setSelectedIndex(0);
        });
        panelBtns.add(btnClrear);

        JButton btnSave = new JButton("Grabar");
        btnSave.addActionListener(e -> {
            System.out.printf("%s: %s%n%s: %s%n%s: %s%n%s: %s%n",
                    "ID", textFieldID.getText(),
                    "Nombres", textFieldName.getText(),
                    "Hobbies", textAreaHobbies.getText(),
                    "Grupo", comboBoxGroup.getSelectedItem());
        });
        panelBtns.add(btnSave);

        JButton btnExit = new JButton("Salir");
        btnExit.addActionListener(e -> System.exit(NORMAL));

        panelBtns.add(btnExit);

    }
}
