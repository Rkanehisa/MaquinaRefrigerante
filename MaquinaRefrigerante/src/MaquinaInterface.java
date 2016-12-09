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
import java.awt.Color;

public class MaquinaInterface {

	private JFrame frmMaquinaInterface;
	private JTextField textField;
	JLabel label_Bebida = new JLabel("");
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
		
		JButton btn_CocaCola = new JButton("Coca Cola");
		btn_CocaCola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label_Bebida.setText(btn_CocaCola.getText());
			}
		});
		btn_CocaCola.setBounds(10, 131, 100, 23);
		frmMaquinaInterface.getContentPane().add(btn_CocaCola);
		
		JButton btn_Pepsi = new JButton("Pepsi");
		btn_Pepsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_Bebida.setText(btn_Pepsi.getText());
			}
		});
		btn_Pepsi.setBounds(124, 131, 100, 23);
		frmMaquinaInterface.getContentPane().add(btn_Pepsi);
		
		JButton btn_MtnDew = new JButton("Mtn Dew");
		btn_MtnDew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_Bebida.setText(btn_MtnDew.getText());
			}
		});
		btn_MtnDew.setBounds(10, 165, 100, 23);
		frmMaquinaInterface.getContentPane().add(btn_MtnDew);
		
		JButton btn_SoylentGreen = new JButton("Soylent Green");
		btn_SoylentGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_Bebida.setText(btn_SoylentGreen.getText());
			}
		});
		btn_SoylentGreen.setBounds(124, 165, 100, 23);
		frmMaquinaInterface.getContentPane().add(btn_SoylentGreen);
		
		JButton btn_CrystalPepsi = new JButton("Crystal Pepsi");
		btn_CrystalPepsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_Bebida.setText(btn_CrystalPepsi.getText());
			}
		});
		btn_CrystalPepsi.setBounds(10, 199, 100, 23);
		frmMaquinaInterface.getContentPane().add(btn_CrystalPepsi);
		
		JButton btn_DrPepper = new JButton("Dr. Pepper");
		btn_DrPepper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_Bebida.setText(btn_DrPepper.getText());
			}
		});
		btn_DrPepper.setBounds(124, 199, 100, 23);
		frmMaquinaInterface.getContentPane().add(btn_DrPepper);
		
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
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label_Bebida.setText("");
			}
		});
		btnOk.setBounds(174, 78, 50, 23);
		frmMaquinaInterface.getContentPane().add(btnOk);
		
		JTextArea txtrValorIns = new JTextArea();
		txtrValorIns.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		txtrValorIns.setText("Pago  (R$):");
		txtrValorIns.setBounds(10, 77, 94, 22);
		frmMaquinaInterface.getContentPane().add(txtrValorIns);

		label_Bebida.setBackground(Color.WHITE);
		label_Bebida.setForeground(Color.WHITE);
		label_Bebida.setBounds(114, 13, 110, 20);
		frmMaquinaInterface.getContentPane().add(label_Bebida);
		
		JLabel label_Preco = new JLabel("");
		label_Preco.setBackground(Color.WHITE);
		label_Preco.setForeground(Color.WHITE);
		label_Preco.setBounds(114, 44, 110, 23);
		frmMaquinaInterface.getContentPane().add(label_Preco);
	}
}
