import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class myGUI extends JFrame {
    /**
     * Create the frame.
     */
    public myGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 600);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

//      Here begins the labels
        JLabel labelFloor = new JLabel("Piso");
        labelFloor.setBounds(300, 100, 100, 20);
        contentPane.add(labelFloor);

        JLabel labelFloorNum = new JLabel("1");
        labelFloorNum.setBounds(450, 100, 100, 20);
        contentPane.add(labelFloorNum);

        JLabel labelDirection = new JLabel("Direccion");
        labelDirection.setBounds(300, 200, 100, 20);
        contentPane.add(labelDirection);

        JLabel labelCurrentDirection = new JLabel("");
        labelCurrentDirection.setBounds(450, 200, 100, 20);
        contentPane.add(labelCurrentDirection);
        //      Here ends the labels


        // Start Button Group
        ButtonGroup buttonGroupFloors = new ButtonGroup();

        JToggleButton buttonFloor4 = new JToggleButton("4", false);
        buttonFloor4.setBounds(100, 50, 50, 50);
        contentPane.add(buttonFloor4);

        JToggleButton buttonFloor3 = new JToggleButton("3", false);
        buttonFloor3.setBounds(100, 125, 50, 50);
        contentPane.add(buttonFloor3);

        JToggleButton buttonFloor2 = new JToggleButton("2", false);
        buttonFloor2.setBounds(100, 200, 50, 50);
        contentPane.add(buttonFloor2);

        JToggleButton buttonFloor1 = new JToggleButton("1", true);
        buttonFloor1.setBounds(100, 275, 50, 50);
        contentPane.add(buttonFloor1);

        buttonGroupFloors.add(buttonFloor1);
        buttonGroupFloors.add(buttonFloor2);
        buttonGroupFloors.add(buttonFloor3);
        buttonGroupFloors.add(buttonFloor4);

        buttonGroupFloors.getElements().asIterator().forEachRemaining(btn -> {
            btn.addActionListener(actionEvent -> {
                String currentFloor = labelFloorNum.getText();
                System.out.println("currentFloor = " + currentFloor);
                labelFloorNum.setText(btn.getText());

                if (currentFloor.compareTo(btn.getText()) > 0) {
                    labelCurrentDirection.setText("Baja");
                } else if (currentFloor.compareTo(btn.getText()) == 0) {
                    labelCurrentDirection.setText("Ya esta aqui");
                } else {
                    labelCurrentDirection.setText("Sube");
                }
            });
        });
        // End Button Group
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
