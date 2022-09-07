package portfolio;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Cursor;
import java.awt.Toolkit;

public class EtanolxGasolina extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtEtanol;
	private JTextField txtGasolina;
	private JLabel lblStatus;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EtanolxGasolina dialog = new EtanolxGasolina();
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
	public EtanolxGasolina() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EtanolxGasolina.class.getResource("/img/combustivel1.png")));
		setFont(new Font("Dialog", Font.BOLD, 14));
		setTitle("Etanol x Gasolina");
		setBounds(100, 100, 329, 326);
		getContentPane().setLayout(null);
		
		JButton txtCalcular = new JButton("Calcular");
		txtCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		txtCalcular.setBounds(10, 72, 89, 23);
		getContentPane().add(txtCalcular);
		
		txtEtanol = new JTextField();
		txtEtanol.setBounds(57, 20, 61, 20);
		getContentPane().add(txtEtanol);
		txtEtanol.setColumns(10);
		
		txtGasolina = new JTextField();
		txtGasolina.setBounds(226, 20, 66, 20);
		getContentPane().add(txtGasolina);
		txtGasolina.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Etanol");
		lblNewLabel.setBounds(10, 23, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Gasolina");
		lblNewLabel_1.setBounds(155, 23, 61, 14);
		getContentPane().add(lblNewLabel_1);
		
		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(EtanolxGasolina.class.getResource("/img/neutro.png")));
		lblStatus.setBounds(0, 127, 318, 160);
		getContentPane().add(lblStatus);
		
		btnNewButton = new JButton("");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Limpar();
			}
		});
		btnNewButton.setIcon(new ImageIcon(EtanolxGasolina.class.getResource("/img/borracha.png")));
		btnNewButton.setToolTipText("Limpar");
		btnNewButton.setBounds(228, 51, 64, 64);
		getContentPane().add(btnNewButton);
		
	}//fim do construtor 
	
	void Limpar() {
		lblStatus.setIcon(new ImageIcon(EtanolxGasolina.class.getResource("/img/neutro.png")));
		txtEtanol.setText(null);
    	txtGasolina.setText(null);
	}
	
	void calcular() {
		if(txtEtanol.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o valor do Etanol");
		}else if (txtGasolina.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o valor da Gasolina");
			txtGasolina.requestFocus();
		}else { 
			
		
		//variaveis
		double etanol, gasolina;
		
		//entrada
		
	gasolina = Double.parseDouble(txtGasolina.getText());
				
	etanol = Double.parseDouble(txtEtanol.getText());
				
		
		//processamento/saída
		if (etanol < 0.7*gasolina) {
			//JOptionPane.showMessageDialog(null, "Abastecer com Etanol");
			lblStatus.setIcon(new ImageIcon(EtanolxGasolina.class.getResource("/img/etanol.png")));
			
			//abastecer com etanol
		}else {
			//JOptionPane.showMessageDialog(null, "Abastecer com Gasolina");
			lblStatus.setIcon(new ImageIcon(EtanolxGasolina.class.getResource("/img/gasolina.png")));
			
			//abastercer com gasolina
		}
		
	

	}
}
}
