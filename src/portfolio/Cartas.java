package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Cursor;

public class Cartas extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblFace;
	private JLabel lblNipe;
	private JLabel lblNipeCentro;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cartas dialog = new Cartas();
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
	public Cartas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cartas.class.getResource("/img/botaocarta.png")));
		getContentPane().setBackground(Color.RED);
		setTitle("Cartas");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 283, 507);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(SystemColor.text);
		panel.setBounds(23, 132, 220, 323);
		getContentPane().add(panel);
		panel.setLayout(null);

		lblFace = new JLabel("");
		lblFace.setHorizontalAlignment(SwingConstants.CENTER);
		lblFace.setFont(new Font("Arial", Font.BOLD, 22));
		lblFace.setBounds(11, 11, 28, 20);
		panel.add(lblFace);

		lblNipe = new JLabel("");
		lblNipe.setHorizontalAlignment(SwingConstants.CENTER);
		lblNipe.setFont(new Font("Arial", Font.BOLD, 32));
		lblNipe.setBounds(11, 38, 28, 27);
		panel.add(lblNipe);

		lblNipeCentro = new JLabel("");
		lblNipeCentro.setFont(new Font("Arial", Font.BOLD, 90));
		lblNipeCentro.setBounds(32, 62, 160, 250);
		panel.add(lblNipeCentro);

		JButton btnNewButton = new JButton("");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setToolTipText("Sortear Carta");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setIcon(new ImageIcon(Cartas.class.getResource("/img/botaocarta.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sortearCarta();
			}
		});
		btnNewButton.setBounds(23, 26, 64, 64);
		getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setToolTipText("Limpar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Limpar();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(Cartas.class.getResource("/img/borracha.png")));
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBounds(179, 26, 64, 64);
		getContentPane().add(btnNewButton_1);

	}// Fim do construtor
	
	void Limpar() {
		lblNipeCentro.setText(null);
		lblNipeCentro.setIcon(null);
		lblFace.setText(null);
		lblNipe.setText(null);
		
	}
	
	

	void sortearCarta() {
		String[] nipes = { "♥", "♦", "♣", "♠ " };
		String[] faces = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "C" };
		Random carta = new Random();

		int indiceFace = carta.nextInt(faces.length);
		int indiceNipe = carta.nextInt(nipes.length);
		// System.out.println(faces[13] + nipes[4]);
		// Exibir carta
		lblFace.setText(faces[indiceFace]);
		lblNipe.setText(nipes[indiceNipe]);
		lblNipeCentro.setText(nipes[indiceNipe]);

		// trocar a cor
		if (indiceNipe == 0 || indiceNipe == 1) {
			lblFace.setForeground(Color.RED);
			lblNipe.setForeground(Color.RED);
			lblNipeCentro.setForeground(Color.RED);
		} else {
			lblFace.setForeground(Color.BLACK);
			lblNipe.setForeground(Color.BLACK);
			lblNipeCentro.setForeground(Color.BLACK);

		}
		// exibir imagens - valete, dama e rei
		if (indiceFace == 10) {
			lblNipeCentro.setIcon(new ImageIcon(Cartas.class.getResource("/img/valete.png")));

		} else if (indiceFace == 11) {
			lblNipeCentro.setIcon(new ImageIcon(Cartas.class.getResource("/img/dama.png")));

		} else if (indiceFace == 12) {
			lblNipeCentro.setIcon(new ImageIcon(Cartas.class.getResource("/img/rei.png")));

		} else if (indiceFace == 13) {
			lblNipeCentro.setIcon(new ImageIcon(Cartas.class.getResource("/img/jocker.png")));
			lblNipe.setText(null);
			lblFace.setText(null);	
		} else {
			
			lblNipeCentro.setIcon(null);
			lblNipeCentro.setText("  " + nipes[indiceNipe]);

		}
	}
}// Fim do Codigo
