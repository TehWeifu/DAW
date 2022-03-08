import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class myGUI extends JFrame {
    /**
     * Create the frame.
     */
    public myGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 150);
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Create original list
        JList<String> listColors = new JList<>(new String[]{"Blue", "Cyan", "Dark Gray", "Gray", "Green", "White", "Black", "Red", "Purple"});
        listColors.setBounds(10, 10, 100, 70);

        JScrollPane paneColors = new JScrollPane(listColors);
        paneColors.setBounds(10, 10, 100, 70);
        paneColors.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        contentPane.add(paneColors);
        // End Original list

        // Start buttons
        JButton buttonAdd = new JButton("Copy >>>");
        buttonAdd.setBounds(150, 40, 150, 20);
        contentPane.add(buttonAdd);
        // End buttons

        JTextArea textAreaResult = new JTextArea();
        textAreaResult.setBounds(280, 10, 100, 70);
        textAreaResult.setBorder(new LineBorder(Color.BLACK));

        JScrollPane paneResults = new JScrollPane(textAreaResult);
        paneResults.setBounds(330, 10, 100, 70);
        paneResults.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        contentPane.add(paneResults);

        buttonAdd.addActionListener(actionEvent -> {
            StringBuilder tmpString = new StringBuilder();
            listColors.getSelectedValuesList().forEach(color -> {
                tmpString.append(color).append(System.lineSeparator());
            });
            textAreaResult.setText(textAreaResult.getText().concat(tmpString.toString()));
        });
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
