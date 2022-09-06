package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Cursor;

public class AppServico extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtRemuneracao;
	private JTextField txtCusto;
	private JTextField txtCargaHoraria;
	private JTextField txtHora;
	private JTextField txtTempoEstimado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppServico dialog = new AppServico();
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
	public AppServico() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AppServico.class.getResource("/img/app.png")));
		setTitle("C\u00E1lculo do valor da hora de servi\u00E7o");
		setModal(true);
		setBounds(100, 100, 345, 434);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Remunera\u00E7\u00E3o:");
		lblNewLabel.setBounds(30, 28, 89, 14);
		getContentPane().add(lblNewLabel);

		txtRemuneracao = new JTextField();
		txtRemuneracao.setBounds(142, 25, 124, 20);
		getContentPane().add(txtRemuneracao);
		txtRemuneracao.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Custo operacional:");
		lblNewLabel_1.setBounds(30, 63, 109, 14);
		getContentPane().add(lblNewLabel_1);

		txtCusto = new JTextField();
		txtCusto.setBounds(166, 60, 100, 20);
		getContentPane().add(txtCusto);
		txtCusto.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Carga hor\u00E1ria mensal:");
		lblNewLabel_2.setBounds(30, 98, 140, 14);
		getContentPane().add(lblNewLabel_2);

		txtCargaHoraria = new JTextField();
		txtCargaHoraria.setBounds(180, 95, 86, 20);
		getContentPane().add(txtCargaHoraria);
		txtCargaHoraria.setColumns(10);

		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularHora();
			}
		});
		btnNewButton.setBounds(30, 146, 89, 23);
		getContentPane().add(btnNewButton);

		JLabel lblNewLabel_3 = new JLabel("Valor da hora de servi\u00E7o:");
		lblNewLabel_3.setBounds(30, 202, 151, 14);
		getContentPane().add(lblNewLabel_3);

		txtHora = new JTextField();
		txtHora.setEditable(false);
		txtHora.setBounds(191, 199, 75, 20);
		getContentPane().add(txtHora);
		txtHora.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Estimativa de horas do servi\u00E7o:");
		lblNewLabel_4.setBounds(30, 276, 179, 14);
		getContentPane().add(lblNewLabel_4);

		txtTempoEstimado = new JTextField();
		txtTempoEstimado.setBounds(224, 273, 67, 20);
		getContentPane().add(txtTempoEstimado);
		txtTempoEstimado.setColumns(10);

		JButton btnNewButton_1 = new JButton("Calcular");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularServico();
			}
		});
		btnNewButton_1.setBounds(30, 316, 89, 23);
		getContentPane().add(btnNewButton_1);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 247, 309, 4);
		getContentPane().add(panel);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Limpar();
				
			}
		});
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setIcon(new ImageIcon(AppServico.class.getResource("/img/borracha.png")));
		btnNewButton_2.setToolTipText("Limpar");
		btnNewButton_2.setBounds(170, 316, 64, 64);
		getContentPane().add(btnNewButton_2);

	}// fim do construtor

	// varíaveis globais
	double hora;
	
	// método usado para calcular o valor da hora
	void Limpar() {
		txtRemuneracao.setText(null);
		txtCusto.setText(null);
		txtCargaHoraria.setText(null);
		txtHora.setText(null);
		txtTempoEstimado.setText(null);
	}
	void calcularHora() {
		// variáveis
		double remuneracao, custo, cargaHoraria;
		// entrada
		remuneracao = Double.parseDouble(txtRemuneracao.getText());
		custo = Double.parseDouble(txtCusto.getText());
		cargaHoraria = Double.parseDouble(txtCargaHoraria.getText());
		// processamento
		hora = (remuneracao + 0.3 * remuneracao + custo + 0.2 * remuneracao) / cargaHoraria;
		// saída
		txtHora.setText(String.valueOf(hora));
	}

	// Método usado para calcular o valor do serviço
	void calcularServico() {
		// variáveis
		double tempoEstimado, valor;
		// entrada
		tempoEstimado = Double.parseDouble(txtTempoEstimado.getText());
		// processamento
		valor = tempoEstimado * hora;
		// saída
		JOptionPane.showMessageDialog(null,"Valor do serviço: " + valor,"Relatório",JOptionPane.DEFAULT_OPTION);
	}
}// fim do código
