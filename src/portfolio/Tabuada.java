package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Toolkit;

public class Tabuada extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTabuada;
	private JTextArea txtArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tabuada dialog = new Tabuada();
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
	public Tabuada() {
		setTitle(" Tabuada");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tabuada.class.getResource("/img/tabuada22.png")));
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 345, 435);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tabuada");
		lblNewLabel.setBounds(35, 35, 46, 14);
		getContentPane().add(lblNewLabel);
		
		txtTabuada = new JTextField();
		txtTabuada.setBounds(106, 32, 86, 20);
		getContentPane().add(txtTabuada);
		txtTabuada.setColumns(10);
		
		JButton btnCalcular = new JButton("");
		btnCalcular.setContentAreaFilled(false);
		btnCalcular.setBorderPainted(false);
		btnCalcular.setIcon(new ImageIcon(Tabuada.class.getResource("/img/tabuada22.png")));
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		btnCalcular.setBounds(45, 67, 64, 64);
		getContentPane().add(btnCalcular);
		
		JButton btnLimpar = new JButton("");
		btnLimpar.setContentAreaFilled(false);
		btnLimpar.setBorderPainted(false);
		btnLimpar.setIcon(new ImageIcon(Tabuada.class.getResource("/img/borracha.png")));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(193, 63, 73, 64);
		getContentPane().add(btnLimpar);
		
		txtArea = new JTextArea();
		txtArea.setBounds(78, 135, 163, 263);
		getContentPane().add(txtArea);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setVerifyInputWhenFocusTarget(false);
		btnNewButton.setBounds(183, 87, 89, 23);
		getContentPane().add(btnNewButton);

	}//fim do construtor
	
	void calcular() {
		//validacao
		if (txtTabuada.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Qual a tabuada que você deseja saber ?");
			txtTabuada.requestFocus();
		} else {
			// variáveis + entrada
			int valor = Integer.parseInt(txtTabuada.getText());
			// processamento
			for (int i = 0; i < 11; i++) {
				txtArea.append(" " + String.valueOf(valor) + " x " + i + " = " + valor * i + "\n");
				
			}
		}
	}
	
	void limpar() {
		txtTabuada.setText(null);
		txtArea.setText(null);
	}
}//fim do código