import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.Font;

public class MaquinaInterface {

	private JFrame frmMaquinaInterface;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MaquinaInterface window = new MaquinaInterface();
					window.frmMaquinaInterface.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MaquinaInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMaquinaInterface = new JFrame();
		frmMaquinaInterface.setTitle("M\u00E1quina Refrigerante ");
		frmMaquinaInterface.setBounds(100, 100, 250, 270);
		frmMaquinaInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMaquinaInterface.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Coca Cola");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(10, 131, 100, 23);
		frmMaquinaInterface.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Pepsi");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(124, 131, 100, 23);
		frmMaquinaInterface.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Mtn Dew");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(10, 165, 100, 23);
		frmMaquinaInterface.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Soylent Green");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(124, 165, 100, 23);
		frmMaquinaInterface.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Crystal Pepsi");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(10, 199, 100, 23);
		frmMaquinaInterface.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Dr. Pepper");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_5.setBounds(124, 199, 100, 23);
		frmMaquinaInterface.getContentPane().add(btnNewButton_5);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 112, 214, 8);
		frmMaquinaInterface.getContentPane().add(separator);
		
		textField = new JTextField();
		textField.setBounds(114, 78, 50, 23);
		frmMaquinaInterface.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextArea txtrBebida = new JTextArea();
		txtrBebida.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		txtrBebida.setText("Bebida:");
		txtrBebida.setBounds(10, 11, 94, 22);
		frmMaquinaInterface.getContentPane().add(txtrBebida);
		
		JTextArea txtrValor = new JTextArea();
		txtrValor.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		txtrValor.setText("Pre\u00E7o (R$):");
		txtrValor.setBounds(10, 44, 94, 22);
		frmMaquinaInterface.getContentPane().add(txtrValor);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(174, 78, 50, 23);
		frmMaquinaInterface.getContentPane().add(btnOk);
		
		JTextArea txtrValorIns = new JTextArea();
		txtrValorIns.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		txtrValorIns.setText("Pago  (R$):");
		txtrValorIns.setBounds(10, 77, 94, 22);
		frmMaquinaInterface.getContentPane().add(txtrValorIns);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(114, 11, 110, 22);
		frmMaquinaInterface.getContentPane().add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(114, 44, 110, 22);
		frmMaquinaInterface.getContentPane().add(textArea_1);
	}
}
