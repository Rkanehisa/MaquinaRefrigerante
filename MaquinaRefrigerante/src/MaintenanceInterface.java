import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.fabric.xmlrpc.base.Data;

import dominio.Latas;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.awt.event.ActionEvent;
import mbean.BebidasMBeam;
import mbean.LatasMBeam;
import mbean.TrocoMBeam;


public class MaintenanceInterface extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JComboBox comboBox = new JComboBox();
	private JComboBox comboBox_1 = new JComboBox();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MaintenanceInterface frame = new MaintenanceInterface();
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
	public MaintenanceInterface() {
		setTitle("Manuten\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setText("Usu\u00E1rio:");
		textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(10, 11, 100, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(120, 11, 174, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("Quantidade");
		textField_2.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_2.setColumns(10);
		textField_2.setBounds(120, 50, 50, 20);
		contentPane.add(textField_2);
		
		JButton button = new JButton("Inserir Latas");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int quantidade= Integer.parseInt(textField_2.getText());
					int lata = BebidasMBeam.getBebidaIndex(comboBox.getSelectedItem().toString());
					Date dataReposicao = new Date();
					int index = (LatasMBeam.getMaxIndex())+1;
					for(int i = 0; i < quantidade; i++){
						Latas l = new Latas(index,lata,false,dataReposicao);
						LatasMBeam.addLatas(l);
						index += 1;
					}
					
					textField_2.setText("");
					
					
					
				}
				catch(NumberFormatException err){
					// Not an Integer
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(180, 49, 114, 23);
		contentPane.add(button);
		
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Coca Cola", "Pepsi", "Mtn. Dew", "Soylent Green", "Crystal Pepsi", "Dr. Pepper"}));
		comboBox.setSelectedIndex(0);
		comboBox.setMaximumRowCount(6);
		comboBox.setBounds(10, 50, 100, 20);
		contentPane.add(comboBox);
		
		
		comboBox_1.setMaximumRowCount(5);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"R$ 0.50", "R$ 1.00", "R$ 2.00", "R$ 5.00", "R$ 10.00"}));
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setBounds(10, 81, 100, 20);
		contentPane.add(comboBox_1);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("Quantidade");
		textField_3.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_3.setColumns(10);
		textField_3.setBounds(120, 81, 50, 20);
		contentPane.add(textField_3);
		
		JButton button_1 = new JButton("Inserir Troco");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int quantidade = Integer.parseInt(textField_3.getText());
					String valorStr = comboBox_1.getSelectedItem().toString();
					double valor = Double.parseDouble(valorStr.substring(3));
					TrocoMBeam.addTroco(quantidade, valor);
					
					textField_3.setText("");
				}
				catch(NumberFormatException err){
					// Not an Integer
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1.setBounds(180, 80, 114, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Gerar Relat\u00F3rio");
		button_2.setBounds(10, 127, 284, 23);
		contentPane.add(button_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 114, 284, 2);
		contentPane.add(separator);
	}

}
