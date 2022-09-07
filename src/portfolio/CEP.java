package portfolio;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import Atxy2k.CustomTextField.RestrictedTextField;

public class CEP extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCep;
	private JTextField txtEndereço;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JComboBox cboUF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CEP frame = new CEP();
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
	public CEP() {
		setTitle("Buscar CEP");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CEP.class.getResource("/img/Home.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CEP");
		lblNewLabel.setBounds(30, 68, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtCep = new JTextField();
		txtCep.setBounds(76, 65, 96, 20);
		contentPane.add(txtCep);
		txtCep.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Endere\u00E7o");
		lblNewLabel_1.setBounds(30, 96, 57, 14);
		contentPane.add(lblNewLabel_1);
		
		txtEndereço = new JTextField();
		txtEndereço.setBounds(86, 96, 294, 20);
		contentPane.add(txtEndereço);
		txtEndereço.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Bairro");
		lblNewLabel_2.setBounds(33, 127, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(79, 124, 314, 20);
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Cidade");
		lblNewLabel_3.setBounds(31, 152, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(79, 149, 174, 20);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("UF");
		lblNewLabel_4.setBounds(288, 152, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		cboUF = new JComboBox();
		cboUF.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE\t ", "TO"}));
		cboUF.setBounds(336, 148, 57, 22);
		contentPane.add(cboUF);
		
		JButton btnLimpar = new JButton("");
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.setContentAreaFilled(false);
		btnLimpar.setBorderPainted(false);
		btnLimpar.setIcon(new ImageIcon(CEP.class.getResource("/img/borracha.png")));
		btnLimpar.setToolTipText("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(10, 197, 64, 64);
		contentPane.add(btnLimpar);
		
		JButton btnCep = new JButton("Buscar");
		btnCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtCep.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Informe o CEP");
					txtCep.requestFocus();
				}else{
					buscarCep();
					
				}
			}
		});
		btnCep.setBounds(195, 64, 89, 23);
		contentPane.add(btnCep);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre	= new Sobre();
				sobre.setVisible(true);
			}
		});
		btnNewButton_2.setToolTipText("Sobre");
		btnNewButton_2.setIcon(new ImageIcon(CEP.class.getResource("/img/3017955_examination_inquiry_interrogation_investigation_poll_icon.png")));
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBackground(SystemColor.control);
		btnNewButton_2.setBounds(309, 21, 64, 64);
		contentPane.add(btnNewButton_2);
		
		/*uso da biblioteca Atxy2k.jar para validação do camp txtCep */
		RestrictedTextField validar = new RestrictedTextField(txtCep);
		validar.setOnlyNums(true);
		validar.setLimit(8);
	}//fim do construtor
	void limpar() {
		txtCep.setText(null);
		txtEndereço.setText(null);
		txtBairro.setText(null);
		txtCidade.setText(null);
	}
	private void buscarCep() {
		String Bairro = "";
		String logradouro = "";
		String tipologradouro = "";
		String resultado = null;
		String cep = txtCep.getText();
		try {
			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
			SAXReader xml = new SAXReader();
			Document documento = xml.read(url);
			Element root = documento.getRootElement();
			 for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
			        Element element = it.next();
			        if (element.getQualifiedName().equals("cidade")) {
			        	txtCidade.setText(element.getText());
			        }
			        if (element.getQualifiedName().equals("bairro")) {
						txtBairro.setText(element.getText());
					}
			        if (element.getQualifiedName().equals("uf")) {
			        	cboUF.setSelectedItem(element.getText());
			        }
			        if (element.getQualifiedName().equals("tipo_logradouro")) {
			        	tipologradouro = element.getText();
			        }
			        if (element.getQualifiedName().equals("logradouro")) {
			        	logradouro = element.getText();
			        }
			 }
			 //setar o campo Endereço
			 txtEndereço.setText(tipologradouro + "" + logradouro);
			 
		}catch (Exception e ) {
			System.out.println(e);
		}
	}
	
}//fim do código


	


