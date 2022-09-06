package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Toolkit;

public class CalculoPorcentagem extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtValor;
	private JTextField txtCusto;
	private JTextField txtLucro;
	private JTextField txtVenda;
	private JTextField txtValortotal;
	private JTextField txtDesconto;
	private JTextField txtResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculoPorcentagem dialog = new CalculoPorcentagem();
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
	public CalculoPorcentagem() {
		setTitle("Calculadora ");
		setIconImage(Toolkit.getDefaultToolkit().getImage(CalculoPorcentagem.class.getResource("/img/porcentagem.png")));
		getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setBounds(100, 100, 569, 398);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Porcentagem");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(213, 11, 86, 16);
		getContentPane().add(lblNewLabel);
		
		txtX = new JTextField();
		txtX.setBounds(42, 38, 79, 20);
		getContentPane().add(txtX);
		txtX.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("% DE");
		lblNewLabel_1.setBounds(131, 41, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtY = new JTextField();
		txtY.setBounds(177, 38, 79, 20);
		getContentPane().add(txtY);
		txtY.setColumns(10);
		
		JButton btnNewButton = new JButton("=");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				calcular();
			}
		});
		btnNewButton.setBounds(293, 38, 53, 23);
		getContentPane().add(btnNewButton);
		
		txtValor = new JTextField();
		txtValor.setEditable(false);
		txtValor.setBounds(366, 38, 86, 20);
		getContentPane().add(txtValor);
		txtValor.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Custo de Venda");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(213, 94, 106, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Custo");
		lblNewLabel_3.setBounds(10, 122, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		txtCusto = new JTextField();
		txtCusto.setBounds(47, 119, 86, 20);
		getContentPane().add(txtCusto);
		txtCusto.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Lucro");
		lblNewLabel_4.setBounds(144, 122, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		txtLucro = new JTextField();
		txtLucro.setBounds(177, 119, 86, 20);
		getContentPane().add(txtLucro);
		txtLucro.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("%");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(273, 122, 46, 14);
		getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton_1 = new JButton("Venda");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularVenda();
			}
		});
		btnNewButton_1.setBounds(293, 118, 72, 23);
		getContentPane().add(btnNewButton_1);
		
		txtVenda = new JTextField();
		txtVenda.setEditable(false);
		txtVenda.setBounds(375, 119, 86, 20);
		getContentPane().add(txtVenda);
		txtVenda.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Calcular Desconto");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(213, 163, 124, 14);
		getContentPane().add(lblNewLabel_6);
		
		txtValortotal = new JTextField();
		txtValortotal.setBounds(42, 212, 86, 20);
		getContentPane().add(txtValortotal);
		txtValortotal.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Subtotal");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(61, 187, 60, 14);
		getContentPane().add(lblNewLabel_7);
		
		txtDesconto = new JTextField();
		txtDesconto.setBounds(170, 212, 86, 20);
		getContentPane().add(txtDesconto);
		txtDesconto.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Desconto");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(177, 187, 64, 14);
		getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("%");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_9.setBounds(266, 215, 46, 14);
		getContentPane().add(lblNewLabel_9);
		
		JButton btnNewButton_2 = new JButton("Total");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularDesconto();
			}
		});
		btnNewButton_2.setBounds(297, 211, 63, 23);
		getContentPane().add(btnNewButton_2);
		
		txtResultado = new JTextField();
		txtResultado.setEditable(false);
		txtResultado.setBounds(370, 212, 86, 20);
		getContentPane().add(txtResultado);
		txtResultado.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setIcon(new ImageIcon(CalculoPorcentagem.class.getResource("/img/borracha.png")));
		btnNewButton_3.setToolTipText("Limpar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Limpar();
			}
		});
		btnNewButton_3.setBounds(224, 265, 64, 64);
		getContentPane().add(btnNewButton_3);

	}// fim do construtor

	//Método regra de 3
	void Limpar() {
 	
	
	txtX.setText(null);
	txtY.setText(null);
	txtValor.setText(null);
	txtCusto.setText(null);
	txtLucro.setText(null);
	txtVenda.setText(null);
	txtValortotal.setText(null);
	txtDesconto.setText(null);
	txtResultado.setText(null);
	}
	
	
	
	
	
	void calcular(){
		
		

		// variáveis
		double x, y, valor;
		// entrada
		x = Double.parseDouble(txtX.getText());
		y = Double.parseDouble(txtY.getText());
		// processamento
		valor = (x * y) / 100;

		// saída
		txtValor.setText(String.valueOf(valor));
	}
	
	//Método lucro venda
	void calcularVenda(){
		//variáveis
		double custo, lucro, venda;
		//entrada
		custo = Double.parseDouble(txtCusto.getText());
		lucro = Double.parseDouble(txtLucro.getText());
		//processamento
		venda = custo + ((lucro * custo) / 100);
		//saída
		txtVenda.setText(String.valueOf(venda));
		
	}
	
	//Método desconto
	void calcularDesconto() {
		//variáveis
		double total, desconto, descontoTotal;
		//entrada
		total = Double.parseDouble(txtValortotal.getText());
		desconto = Double.parseDouble(txtDesconto.getText());
		//processamento
		descontoTotal = total - (desconto * total) / 100;
		//saída
		txtResultado.setText(String.valueOf(descontoTotal));
		
	}
}//fim
