package com.savioduarte.cadastroproduto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.savioduarte.cadastroprodutos.model.Produto;

public class TelaCadastro {
	 
	private List<Produto> produtos = new ArrayList<Produto>();
	
	private JFrame frame;
	private JTextField txtNome;
	private JTextField txtQuantidade;
	private JTextField txtPreco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro window = new TelaCadastro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(248, 248, 255));
		frame.setBounds(100, 100, 305, 173);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(26, 22, 91, 14);
		frame.getContentPane().add(lblNome);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQuantidade.setBounds(26, 47, 91, 14);
		frame.getContentPane().add(lblQuantidade);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o unit\u00E1rio:");
		lblPreco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPreco.setBounds(26, 72, 91, 14);
		frame.getContentPane().add(lblPreco);
		
		txtNome = new JTextField();
		txtNome.setBounds(127, 19, 127, 20);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
				String nome = txtNome.getText();
				int quantidade = Integer.parseInt(txtQuantidade.getText());
				double preco = Double.parseDouble(txtPreco.getText());
				double totalPreco = preco * quantidade;
				
				
				Produto prod = new Produto(nome, quantidade, preco, totalPreco);
				
				produtos.add(prod);
			
				txtNome.setText("");
				txtPreco.setText("");
				txtQuantidade.setText("");
				
			}
		});
		btnAdicionar.setBounds(26, 100, 108, 23);
		frame.getContentPane().add(btnAdicionar);
		

		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(127, 44, 127, 20);
		frame.getContentPane().add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		txtPreco = new JTextField();
		txtPreco.setBounds(127, 69, 127, 20);
		frame.getContentPane().add(txtPreco);
		txtPreco.setColumns(10);
		
		JButton btnRelatorio = new JButton("Relat\u00F3rio");
		btnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String nome = "Total";
				int quantidade = 0;
				String precoTotal = "-";
				double totalPreco = 0;
				
				for (int i = 0; i < produtos.size(); i++) {
					totalPreco = totalPreco + produtos.get(i).getTotalPreco();
					quantidade = quantidade + produtos.get(i).getQuantidade();
				}
				
				
				Object[] titulos = {"Nome","Quantidade", "Pre�o", "Total"};
				
				Object[][] linhas = new Object[produtos.size()+1][4];
				
				for (int i = 0; i < produtos.size(); i++) {
					Object[] linha = new Object[] {produtos.get(i).getNome(), produtos.get(i).getQuantidade(), produtos.get(i).getPreco(), produtos.get(i).getTotalPreco()};
					linhas[i] = linha;
					if(i == produtos.size() - 1) {
						Object[] linha1 = new Object[] {nome, quantidade, precoTotal, totalPreco};
						linhas[i+1] = linha1;
					}
					
				}
				
				
				
				JTable table = new JTable(linhas, titulos);
				JOptionPane.showMessageDialog(null, new JScrollPane(table));
				
			}
		});
		btnRelatorio.setBounds(157, 100, 108, 23);
		frame.getContentPane().add(btnRelatorio);
	}
}
