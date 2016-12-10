import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import mbean.BebidasMBeam;
import mbean.LatasMBeam;
import mbean.TrocoMBeam;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Color;

public class MaquinaInterface {

	private JFrame frmMaquinaInterface;
	private JTextField textField;
	private JLabel label_Bebida = new JLabel("");
	private JLabel label_Preco = new JLabel("");
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
				
				try {
					label_Preco.setText("R$ "+ String.valueOf(BebidasMBeam.getBebidaPreco(btn_CocaCola.getText())));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btn_CocaCola.setBounds(10, 131, 100, 23);
		frmMaquinaInterface.getContentPane().add(btn_CocaCola);
		
		JButton btn_Pepsi = new JButton("Pepsi");
		btn_Pepsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_Bebida.setText(btn_Pepsi.getText());
				try {
					label_Preco.setText("R$ "+ String.valueOf(BebidasMBeam.getBebidaPreco(btn_Pepsi.getText())));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btn_Pepsi.setBounds(124, 131, 100, 23);
		frmMaquinaInterface.getContentPane().add(btn_Pepsi);
		
		JButton btn_MtnDew = new JButton("Mtn. Dew");
		btn_MtnDew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_Bebida.setText(btn_MtnDew.getText());
				try {
					label_Preco.setText("R$ "+ String.valueOf(BebidasMBeam.getBebidaPreco(btn_MtnDew.getText())));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btn_MtnDew.setBounds(10, 165, 100, 23);
		frmMaquinaInterface.getContentPane().add(btn_MtnDew);
		
		JButton btn_SoylentGreen = new JButton("Soylent Green");
		btn_SoylentGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_Bebida.setText(btn_SoylentGreen.getText());
				try {
					label_Preco.setText("R$ "+ String.valueOf(BebidasMBeam.getBebidaPreco(btn_SoylentGreen.getText())));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btn_SoylentGreen.setBounds(124, 165, 100, 23);
		frmMaquinaInterface.getContentPane().add(btn_SoylentGreen);
		
		JButton btn_CrystalPepsi = new JButton("Crystal Pepsi");
		btn_CrystalPepsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_Bebida.setText(btn_CrystalPepsi.getText());
				try {
					label_Preco.setText("R$ "+ String.valueOf(BebidasMBeam.getBebidaPreco(btn_CrystalPepsi.getText())));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_CrystalPepsi.setBounds(10, 199, 100, 23);
		frmMaquinaInterface.getContentPane().add(btn_CrystalPepsi);
		
		JButton btn_DrPepper = new JButton("Dr. Pepper");
		btn_DrPepper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_Bebida.setText(btn_DrPepper.getText());
				try {
					label_Preco.setText("R$ "+ String.valueOf(BebidasMBeam.getBebidaPreco(btn_DrPepper.getText())));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_DrPepper.setBounds(124, 199, 100, 23);
		frmMaquinaInterface.getContentPane().add(btn_DrPepper);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 112, 214, 8);
		frmMaquinaInterface.getContentPane().add(separator);
		
		textField = new JTextField();
		textField.setBounds(114, 78, 40, 23);
		frmMaquinaInterface.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextArea txtrBebida = new JTextArea();
		txtrBebida.setEditable(false);
		txtrBebida.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		txtrBebida.setText("Bebida:");
		txtrBebida.setBounds(10, 11, 94, 22);
		frmMaquinaInterface.getContentPane().add(txtrBebida);
		
		JTextArea txtrValor = new JTextArea();
		txtrValor.setEditable(false);
		txtrValor.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		txtrValor.setText("Pre\u00E7o (R$):");
		txtrValor.setBounds(10, 44, 94, 22);
		frmMaquinaInterface.getContentPane().add(txtrValor);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Float valor = Float.parseFloat(textField.getText());
					// Realizar Compra, calcular troco and so on
					int[] troco = LatasMBeam.sellLata(label_Bebida.getText(), valor);					

					if(troco[0] == -1)
					{
						label_Preco.setText("But I refuse");
						label_Bebida.setText("Dinheiro Insuficiente");
					} 
					if(troco[0] == -2)
					{
						label_Preco.setText("Dinheiro retornado");
						label_Bebida.setText("Indisponivel");
					}
					if(troco[0] == -3)
					{
						label_Preco.setText("Impossivel ");
						label_Bebida.setText("montar troco");
					} else
					{
						label_Preco.setText("Troco: R$"+String.valueOf(troco));
						label_Bebida.setText("Vendido");
					}

					
					
					
				}
				catch(NumberFormatException err){
					// Not an Integer;

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnOk.setBounds(164, 78, 60, 23);
		frmMaquinaInterface.getContentPane().add(btnOk);
		
		JTextArea txtrValorIns = new JTextArea();
		txtrValorIns.setEditable(false);
		txtrValorIns.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		txtrValorIns.setText("Pago  (R$):");
		txtrValorIns.setBounds(10, 77, 94, 22);
		frmMaquinaInterface.getContentPane().add(txtrValorIns);

		label_Bebida.setBackground(Color.WHITE);
		label_Bebida.setForeground(Color.BLACK);
		label_Bebida.setBounds(114, 13, 110, 20);
		frmMaquinaInterface.getContentPane().add(label_Bebida);
		
		
		label_Preco.setBackground(Color.WHITE);
		label_Preco.setForeground(Color.BLACK);
		label_Preco.setBounds(114, 44, 110, 23);
		frmMaquinaInterface.getContentPane().add(label_Preco);
	}
}
