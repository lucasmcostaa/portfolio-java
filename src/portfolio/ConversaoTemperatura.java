package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Atxy2k.CustomTextField.RestrictedTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Toolkit;

public class ConversaoTemperatura extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtF;
	private JTextField txtC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversaoTemperatura dialog = new ConversaoTemperatura();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public ConversaoTemperatura() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConversaoTemperatura.class.getResource("/img/2205209_bright_day_light_sun_icon.png")));
		setTitle("Convers\u00E3o de temperatura");
		setModal(true);
		setBounds(100, 100, 401, 205);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fahrenheit");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(23, 37, 88, 14);
		getContentPane().add(lblNewLabel);
		
		txtF = new JTextField();
		txtF.setBounds(124, 36, 86, 20);
		getContentPane().add(txtF);
		txtF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Celsius");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(28, 73, 72, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtC = new JTextField();
		txtC.setEditable(false);
		txtC.setBounds(134, 67, 221, 20);
		getContentPane().add(txtC);
		txtC.setColumns(10);
		
		JButton btnNewButton = new JButton("Converter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				converter();
			}
		});
		btnNewButton.setBounds(241, 35, 104, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Limpar();
			}
		});
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setIcon(new ImageIcon(ConversaoTemperatura.class.getResource("/img/borracha.png")));
		btnNewButton_1.setToolTipText("Limpar");
		btnNewButton_1.setBounds(164, 98, 64, 64);
		getContentPane().add(btnNewButton_1);
		
		RestrictedTextField validar = new RestrictedTextField(txtF, "0123456789.");
		validar.setLimit(6);

	} //fim do construtor
	void Limpar() {
		txtF.setText(null);
		txtC.setText(null);
	}
	
	void converter() {
		//validação
		if (txtF.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a temperatura em Fahrenheit");
			txtF.requestFocus();
		} else {
		//variáveis
		double c,f;
		//entrada
		f = Double.parseDouble(txtF.getText());
		//processamento
		c = (5 * (f - 32)) / 9;
		c = Math.round(c * 100.0) / 100.0;
		//saída
		// a linha abaixo exibe o conteúdo da variável c na caixa de texto (é necessário converter para String)
		txtC.setText(String.valueOf(c));
	}
	}
}
