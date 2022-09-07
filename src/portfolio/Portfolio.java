package portfolio;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Portfolio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Portfolio frame = new Portfolio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Portfolio() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				//evento "ativar janela"
				Date data = new Date();
				DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
				lblStatus.setText(formatador.format(data));
				
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(Portfolio.class.getResource("/img/pc.png")));
		setResizable(false);
		setTitle("Portf\u00F3lio de projetos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBorder(null);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setIcon(new ImageIcon(Portfolio.class.getResource("/img/9057184_gym_icon.png")));
		btnNewButton.setToolTipText("Calcular o IMC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// as linhas abaixo fazem o link com o formulário IMC
				IMC imc = new IMC();
				imc.setVisible(true);
			}
		});
		btnNewButton.setBounds(329, 131, 73, 48);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setIcon(new ImageIcon(Portfolio.class.getResource("/img/sobre.png")));
		btnNewButton_1.setToolTipText("Sobre");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//evento clicar no botão
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 113, 73, 73);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setToolTipText("Calculadora da m\u00E9dia");
		btnNewButton_2.setIcon(new ImageIcon(Portfolio.class.getResource("/img/calculadora.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Media media = new Media();
				media.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(173, 23, 64, 64);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_3.setToolTipText("Calculadora de F para C");
		btnNewButton_3.setIcon(new ImageIcon(Portfolio.class.getResource("/img/8680130_celsius_fill_icon.png")));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConversaoTemperatura conversao = new ConversaoTemperatura();
				conversao.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(439, 38, 116, 63);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setBorderPainted(false);
		btnNewButton_5.setContentAreaFilled(false);
		btnNewButton_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_5.setToolTipText("Calculadora de Etanol x Gasolina");
		btnNewButton_5.setIcon(new ImageIcon(Portfolio.class.getResource("/img/combustivel1.png")));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EtanolxGasolina combustivel = new EtanolxGasolina();
				combustivel.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(456, 131, 89, 55);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setContentAreaFilled(false);
		btnNewButton_6.setBorderPainted(false);
		btnNewButton_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_6.setToolTipText("Eleitor ");
		btnNewButton_6.setIcon(new ImageIcon(Portfolio.class.getResource("/img/Eleitor1.png")));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Eleitor eleitor = new Eleitor();
			eleitor.setVisible(true);
			}
		});
		btnNewButton_6.setBounds(313, 32, 89, 55);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dado dado = new Dado();
				dado.setVisible(true);
			}
		});
		btnNewButton_7.setToolTipText("Dado");
		btnNewButton_7.setContentAreaFilled(false);
		btnNewButton_7.setBorderPainted(false);
		btnNewButton_7.setIcon(new ImageIcon(Portfolio.class.getResource("/img/Dado.png")));
		btnNewButton_7.setBounds(154, 131, 89, 55);
		contentPane.add(btnNewButton_7);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(-10, 477, 555, 52);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblStatus = new JLabel("New label");
		lblStatus.setForeground(SystemColor.text);
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStatus.setBounds(151, 11, 394, 30);
		panel.add(lblStatus);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setToolTipText("Porcentagem");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculoPorcentagem porcentagem = new CalculoPorcentagem();
				porcentagem.setVisible(true);
			}
		});
		btnNewButton_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_4.setContentAreaFilled(false);
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setIcon(new ImageIcon(Portfolio.class.getResource("/img/porcentagem.png")));
		btnNewButton_4.setBounds(22, 38, 89, 48);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_8 = new JButton("");
		btnNewButton_8.setToolTipText("Cartas");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cartas carta = new Cartas ();
				carta.setVisible(true);
			}
		});
		btnNewButton_8.setIcon(new ImageIcon(Portfolio.class.getResource("/img/cartas baralho.png")));
		btnNewButton_8.setContentAreaFilled(false);
		btnNewButton_8.setBorderPainted(false);
		btnNewButton_8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_8.setBounds(10, 217, 89, 64);
		contentPane.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("");
		btnNewButton_9.setToolTipText("Tabuada");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tabuada tabuada = new Tabuada();
				tabuada.setVisible(true);
			}
		});
		btnNewButton_9.setIcon(new ImageIcon(Portfolio.class.getResource("/img/tabuada.png")));
		btnNewButton_9.setContentAreaFilled(false);
		btnNewButton_9.setBorderPainted(false);
		btnNewButton_9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_9.setBounds(154, 217, 89, 64);
		contentPane.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("");
		btnNewButton_10.setToolTipText("Bucar CEP");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CEP cep = new CEP();
				cep.setVisible(true);
			}
		});
		btnNewButton_10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_10.setContentAreaFilled(false);
		btnNewButton_10.setBorderPainted(false);
		btnNewButton_10.setIcon(new ImageIcon(Portfolio.class.getResource("/img/cep.png")));
		btnNewButton_10.setBounds(301, 217, 101, 64);
		contentPane.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("");
		btnNewButton_11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppServico servico = new AppServico();
				servico.setVisible(true);
			}
		});
		btnNewButton_11.setContentAreaFilled(false);
		btnNewButton_11.setBorderPainted(false);
		btnNewButton_11.setIcon(new ImageIcon(Portfolio.class.getResource("/img/app.png")));
		btnNewButton_11.setToolTipText("App Sevi\u00E7o");
		btnNewButton_11.setBounds(439, 217, 89, 73);
		contentPane.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jokenpo jokenpo = new Jokenpo();
				jokenpo.setVisible(true);
			}
		});
		btnNewButton_12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_12.setContentAreaFilled(false);
		btnNewButton_12.setBorderPainted(false);
		btnNewButton_12.setIcon(new ImageIcon(Portfolio.class.getResource("/img/5741143_cleaning_hand_rubbing_washing_corona_icon.png")));
		btnNewButton_12.setToolTipText("Jokenpo");
		btnNewButton_12.setBounds(22, 335, 64, 64);
		contentPane.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("");
		btnNewButton_13.setToolTipText("Calculadora de C para F");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Temperatura2 temperatura2 = new Temperatura2();
						temperatura2.setVisible(true);
			}
		});
		btnNewButton_13.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_13.setContentAreaFilled(false);
		btnNewButton_13.setBorderPainted(false);
		btnNewButton_13.setIcon(new ImageIcon(Portfolio.class.getResource("/img/9081486_temperature_fahrenheit_icon.png")));
		btnNewButton_13.setBounds(154, 335, 64, 64);
		contentPane.add(btnNewButton_13);
	}// fim do construtor
}
