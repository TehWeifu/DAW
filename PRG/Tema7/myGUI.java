package myProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class myGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textFieldName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					myGUI frame = new myGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
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
		paneFormHobbies.add(lblFormHobbies);
		
		JScrollPane paneHobbies = new JScrollPane();
		paneHobbies.setMaximumSize(new Dimension(100, 100));
		paneFormHobbies.add(paneHobbies);
		
		JPanel paneFormGroup = new JPanel();
		panelFrom.add(paneFormGroup);
		paneFormGroup.setLayout(new BoxLayout(paneFormGroup, BoxLayout.X_AXIS));
		
		JLabel lblGroup = new JLabel("Group");
		paneFormGroup.add(lblGroup);
		
		JComboBox comboBoxGroup = new JComboBox();
		comboBoxGroup.setMaximumSize(new Dimension(100, 100));
		paneFormGroup.add(comboBoxGroup);
		
		JPanel panelBtns = new JPanel();
		contentPane.add(panelBtns);
		panelBtns.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnClrear = new JButton("Limpiar");
		btnClrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		panelBtns.add(btnClrear);
		
		JButton btnSave = new JButton("Grabar");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		panelBtns.add(btnSave);
		
		JButton btnExit = new JButton("Salir");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		panelBtns.add(btnExit);	
		
	}

}
