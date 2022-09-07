package portfolio;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Atxy2k.CustomTextField.RestrictedTextField;
import javax.swing.SwingConstants;

public class Temperatura2 extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtCelsius;
	private JTextField txtFahrenheit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Temperatura2 dialog = new Temperatura2();
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
	public Temperatura2() {
		setBackground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Temperatura2.class.getResource("/img/fahrenheit-48.png")));
		setTitle("Calculadora de Celsius para Farenheit");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 303, 325);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblCelsius = new JLabel("Celsius");
		lblCelsius.setBounds(30, 22, 49, 15);
		getContentPane().add(lblCelsius);

		txtCelsius = new JTextField();
		txtCelsius.setHorizontalAlignment(SwingConstants.CENTER);
		txtCelsius.setBounds(101, 19, 114, 19);
		getContentPane().add(txtCelsius);
		txtCelsius.setColumns(10);

		JLabel lblFahrenheit = new JLabel("Fahrenheit");
		lblFahrenheit.setBounds(28, 52, 69, 15);
		getContentPane().add(lblFahrenheit);

		txtFahrenheit = new JTextField();
		txtFahrenheit.setHorizontalAlignment(SwingConstants.CENTER);
		txtFahrenheit.setEditable(false);
		txtFahrenheit.setBounds(101, 52, 114, 19);
		getContentPane().add(txtFahrenheit);
		txtFahrenheit.setColumns(10);

		JButton btnConverter = new JButton("");
		btnConverter.setIcon(new ImageIcon(Temperatura2.class.getResource("/img/fahrenheit.png")));
		btnConverter.setToolTipText("Converter");
		btnConverter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConverter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcular();
			}
		});
		btnConverter.setBounds(115, 99, 64, 64);
		getContentPane().add(btnConverter);
		
		JButton btnLimpar = new JButton("");
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		btnLimpar.setIcon(new ImageIcon(Temperatura2.class.getResource("/img/eraser.png")));
		btnLimpar.setToolTipText("Limpar");
		btnLimpar.setBounds(115, 192, 64, 64);
		getContentPane().add(btnLimpar);
		
		// Uso da Biblioteca Atxy2k
				RestrictedTextField validar = new RestrictedTextField(txtCelsius, "0123456789.");
				validar.setLimit(6);

	} // Fim do Construtor

	void calcular() {
		// Valida��o
		if (txtCelsius.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a temperatura em Celsius");
			txtCelsius.requestFocus();
		} else {
			// Declara��o de vari�veis
			double celsius, fahrenheit;

			// Entrada
			celsius = Double.parseDouble(txtCelsius.getText());

			// Processamento
			fahrenheit = 1.8 * celsius + 32;
			fahrenheit = Math.round(fahrenheit * 100.0) / 100.0;

			// Sa�da
			txtFahrenheit.setText(String.valueOf(fahrenheit));
		}
	}// Fim do m�todo calcular
	
	/** m�todo para Limpar **/
	void limpar() {
		txtFahrenheit.setText(null);
		txtCelsius.setText(null);
		txtCelsius.requestFocus();
	} // Fim do m�todo limpar

} //Fim do programa
