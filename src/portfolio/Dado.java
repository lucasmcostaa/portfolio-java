package portfolio;

import java.awt.BorderLayout;
import java.util.Random;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Cursor;

public class Dado extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblFace;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dado dialog = new Dado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Dado() {
		setTitle("Dado");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Dado.class.getResource("/img/icons8-dado-30.png")));
		setBounds(100, 100, 229, 336);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JButton btnNewButton = new JButton("Lan\u00E7ar");
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dado();
			}
		});
		btnNewButton.setBounds(0, 45, 115, 23);
		contentPanel.add(btnNewButton);

		lblFace = new JLabel("");
		lblFace.setHorizontalAlignment(SwingConstants.CENTER);
		lblFace.setIcon(new ImageIcon(Dado.class.getResource("/img/dadocapa.png")));
		lblFace.setBounds(51, 124, 115, 119);
		contentPanel.add(lblFace);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Limpar();
			}
		});
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setIcon(new ImageIcon(Dado.class.getResource("/img/borracha.png")));
		btnNewButton_1.setToolTipText("Limpar");
		btnNewButton_1.setBounds(139, 26, 64, 64);
		contentPanel.add(btnNewButton_1);
	}// Fim do Construtor
	
	void Limpar() { 
		lblFace.setIcon(new ImageIcon(Dado.class.getResource("/img/Dado.png")));
		
		
	
	}

	void dado() {

		Random random = new Random();
		int face = random.nextInt(6) + 1;

		switch (face) {
		case 1:
			lblFace.setIcon(new ImageIcon(Dado.class.getResource("/img/face1.png")));
			break;
		case 2:
			lblFace.setIcon(new ImageIcon(Dado.class.getResource("/img/face2.png")));
			break;
		case 3:
			lblFace.setIcon(new ImageIcon(Dado.class.getResource("/img/face3.png")));
			break;
		case 4:
			lblFace.setIcon(new ImageIcon(Dado.class.getResource("/img/face4.png")));
			break;
		case 5:
			lblFace.setIcon(new ImageIcon(Dado.class.getResource("/img/face5.png")));
			break;
		case 6:
			lblFace.setIcon(new ImageIcon(Dado.class.getResource("/img/face6.png")));
			break;
	
		}
	}
}
