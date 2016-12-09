import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginInterface {

	private JFrame frmLogin;
	private JTextField text_Username;
	private final JPasswordField pass_Password = new JPasswordField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginInterface window = new LoginInterface();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 200, 180);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		text_Username = new JTextField();
		text_Username.setToolTipText("Username");
		text_Username.setHorizontalAlignment(SwingConstants.CENTER);
		text_Username.setBounds(10, 11, 164, 35);
		frmLogin.getContentPane().add(text_Username);
		text_Username.setColumns(10);
		
		JButton btn_Access = new JButton("OK");
		btn_Access.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(text_Username.getText().equals("a") && pass_Password.getText().equals("a")){
					System.out.println("Enter");
					frmLogin.dispose();
					MaintenanceInterface newInterface = new MaintenanceInterface();
					newInterface.setVisible(true);
				}else{
					System.out.println("Nah");
				}
			}
		});
		btn_Access.setBounds(40, 103, 110, 27);
		frmLogin.getContentPane().add(btn_Access);
		pass_Password.setToolTipText("Password");
		pass_Password.setHorizontalAlignment(SwingConstants.CENTER);
		pass_Password.setBounds(10, 57, 164, 35);
		frmLogin.getContentPane().add(pass_Password);
	}
}
