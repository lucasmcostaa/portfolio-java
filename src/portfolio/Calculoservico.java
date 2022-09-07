package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextField;

import Atxy2k.CustomTextField.RestrictedTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Toolkit;

public class Calculoservico extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtRemuneracao;
	private JTextField txtCusto;
	private JTextField txtCargaHoraria;
	private JTextField txtHora;
	private JButton btnNewButton;
	private JLabel lblNewLabel_3;
	private JTextField txtTempoEstimado;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculoservico dialog = new Calculoservico();
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
	public Calculoservico() {
		setTitle("Calculadora de Servi\u00E7o");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Calculoservico.class.getResource("/img/app.png")));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		txtRemuneracao = new JTextField();
		txtRemuneracao.setBounds(138, 11, 86, 20);
		getContentPane().add(txtRemuneracao);
		txtRemuneracao.setColumns(10);
		
		txtCusto = new JTextField();
		txtCusto.setBounds(138, 42, 86, 20);
		getContentPane().add(txtCusto);
		txtCusto.setColumns(10);
		
		txtCargaHoraria = new JTextField();
		txtCargaHoraria.setBounds(138, 73, 86, 20);
		getContentPane().add(txtCargaHoraria);
		txtCargaHoraria.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Remunera\u00E7\u00E3o");
		lblNewLabel.setBounds(23, 14, 105, 14);
		getContentPane().add(lblNewLabel);
		
		txtHora = new JTextField();
		txtHora.setEditable(false);
		txtHora.setBounds(186, 129, 113, 20);
		getContentPane().add(txtHora);
		txtHora.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Custo Operacional");
		lblNewLabel_1.setBounds(23, 42, 122, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Carga Horaria");
		lblNewLabel_2.setBounds(23, 73, 122, 14);
		getContentPane().add(lblNewLabel_2);
		
		btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularHora();
			}
		});
		btnNewButton.setBounds(10, 98, 89, 23);
		getContentPane().add(btnNewButton);
		
		lblNewLabel_3 = new JLabel("Estimativa da Hora de Servi\u00E7o");
		lblNewLabel_3.setBounds(10, 202, 172, 14);
		getContentPane().add(lblNewLabel_3);
		
		txtTempoEstimado = new JTextField();
		txtTempoEstimado.setBounds(186, 199, 113, 20);
		getContentPane().add(txtTempoEstimado);
		txtTempoEstimado.setColumns(10);
		
		btnNewButton_1 = new JButton("Calcular");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularServico();
			}
		});
		btnNewButton_1.setBounds(10, 227, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		lblNewLabel_4 = new JLabel("Valor da Hora de Servi\u00E7o");
		lblNewLabel_4.setBounds(20, 132, 143, 14);
		getContentPane().add(lblNewLabel_4);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 163, 434, 1);
		getContentPane().add(panel);
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Limpar();
			}
		});
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setIcon(new ImageIcon(Calculoservico.class.getResource("/img/borracha.png")));
		btnNewButton_2.setToolTipText("Limpar");
		btnNewButton_2.setBounds(335, 175, 64, 64);
		getContentPane().add(btnNewButton_2);
		
		
		// Validação Remuneração
				RestrictedTextField remuneracao = new RestrictedTextField(txtRemuneracao, "0123456789.");
				remuneracao.setLimit(9);

				// Validação Custo Operacional
				RestrictedTextField custo = new RestrictedTextField(txtCusto, "0123456789.");
				custo.setLimit(9);

				// Validação Horas
				RestrictedTextField cargahoraria = new RestrictedTextField(txtCargaHoraria, "0123456789");
				cargahoraria.setLimit(4);

				// Validação Estimativa Horas
				RestrictedTextField tempoestimado = new RestrictedTextField(txtTempoEstimado, "0123456789");
				tempoestimado.setLimit(4);

	}//fim do construtor
	
	//variaveis globais
	double hora;
	private JButton btnNewButton_2;
	
	//método usado para calcular o valor da hora
	void Limpar () {
		txtRemuneracao.setText(null);
		txtCusto.setText(null);
		txtCargaHoraria.setText(null);
		txtHora.setText(null);
		txtTempoEstimado.setText(null);
	}
	void calcularHora() {
		
	

		//validaçao
		if (txtRemuneracao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a remuneracao mensal pretendida");
			txtRemuneracao.requestFocus();
		} else if (txtCusto.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o custo operacional mensal");
			txtCusto.requestFocus();
		} else if (txtCargaHoraria.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a quantidade de horas trabalhadas por mês");
			txtCargaHoraria.requestFocus();
		} else {
		
		
		//váriaveis
		double remuneracao, custo, cargaHoraria;
		//entrada
		remuneracao = Double.parseDouble(txtRemuneracao.getText());
		custo = Double.parseDouble(txtCusto.getText());
		cargaHoraria = Double.parseDouble(txtCargaHoraria.getText());
		//processamento
		hora = (remuneracao + 0.3 * remuneracao + custo + 0.2 * remuneracao) / cargaHoraria;
		//saída
		txtHora.setText(String.valueOf(hora));
	}
	}
	
	//Método usado para calcular o valor do serviço
	void calcularServico() {
		if (txtTempoEstimado.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a quantidade de horas para realizar o serviço");
			txtTempoEstimado.requestFocus();
		} else {
		//variáveis
		double tempoEstimado, valor;
		//entrada 
		tempoEstimado = Double.parseDouble(txtTempoEstimado.getText());
		// processamento

		valor = tempoEstimado * hora;
		//saída
		JOptionPane.showMessageDialog(null,"Valor do serviço: " + valor,"Relatório", JOptionPane.DEFAULT_OPTION);
	
	}
	}
}//fim do código