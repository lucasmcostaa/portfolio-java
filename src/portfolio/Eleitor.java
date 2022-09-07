package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Atxy2k.CustomTextField.RestrictedTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Toolkit;

public class Eleitor extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtIdade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eleitor dialog = new Eleitor();
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
	public Eleitor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Eleitor.class.getResource("/img/Eleitor1.png")));
		setTitle("Eleitor");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Idade");
		lblNewLabel.setBounds(24, 22, 46, 14);
		getContentPane().add(lblNewLabel);
		
		txtIdade = new JTextField();
		txtIdade.setBounds(80, 19, 86, 20);
		getContentPane().add(txtIdade);
		txtIdade.setColumns(10);
		
		JButton btnNewButton = new JButton("Verificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verificar();
			}
		});
		btnNewButton.setBounds(24, 69, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Limpar();
			}
		});
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setIcon(new ImageIcon(Eleitor.class.getResource("/img/borracha.png")));
		btnNewButton_1.setToolTipText("Limpar");
		btnNewButton_1.setBounds(24, 141, 64, 64);
		getContentPane().add(btnNewButton_1);
		
		RestrictedTextField validar = new RestrictedTextField(txtIdade, "0123456789");
		validar.setLimit(2);
		
	}//fim do construtor
	
	
	
	void Limpar() { 
		txtIdade.setText(null);
		
	}
	
	void verificar(){ 
		
		//validação
		
		if (txtIdade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a idade");
			txtIdade.requestFocus();
		} else {

	

			int idade = 18;
			
			idade = Integer.parseInt(txtIdade.getText());
			
			if (idade < 16) {
               JOptionPane.showMessageDialog(null,"Proibido votar"); 
			    
			} else if (idade == 16 || idade == 17 || idade > 70) {
				JOptionPane.showMessageDialog(null,"Voto facultativo");
				
			} else {
				JOptionPane.showMessageDialog(null,"Voto obrigatório");
			}

		}

	}
}//fim
