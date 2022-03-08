import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class myGUI extends JFrame {
    /**
     * Create the frame.
     */
    public myGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 640, 480);
        setResizable(false);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

//        Start Button Group
        ButtonGroup buttonGroupSizes = new ButtonGroup();

        JRadioButton radioButtonSmall = new JRadioButton("640x480", true);
        radioButtonSmall.putClientProperty("values", new int[]{640, 480});
        radioButtonSmall.setBounds(20, 20, 100, 20);
        contentPane.add(radioButtonSmall);

        JRadioButton radioButtonMedium = new JRadioButton("800x600");
        radioButtonMedium.putClientProperty("values", new int[]{800, 600});
        radioButtonMedium.setBounds(20, 60, 100, 20);
        contentPane.add(radioButtonMedium);

        JRadioButton radioButtonBig = new JRadioButton("1024x768");
        radioButtonBig.putClientProperty("values", new int[]{1024, 768});
        radioButtonBig.setBounds(20, 100, 100, 20);
        contentPane.add(radioButtonBig);

        buttonGroupSizes.add(radioButtonSmall);
        buttonGroupSizes.add(radioButtonMedium);
        buttonGroupSizes.add(radioButtonBig);

        buttonGroupSizes.getElements().asIterator().forEachRemaining(btn -> {
            btn.addActionListener(actionEvent -> {
                this.setBounds(100, 100, ((int[]) btn.getClientProperty("values"))[0], ((int[]) btn.getClientProperty("values"))[1]);
            });
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
