package sistemaFeira.view;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import sistemaFeira.model.Venda;
import sistemaFeira.repositorios.RepositorioVenda;
import sistemaFeira.util.Imagens;
import sistemaFeira.view.ouvintes.OuvinteTelaVendas;

public class TelaVendas extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JPanel painel;
	
	private JLabel lblVendasHoje;
	private JLabel lblEliminar;
	private JLabel lblSeta;
	
	private JTable tbVendas;

	public TelaVendas() {
		configurarTela();
		configurarPainel();
		configurarLabel();
		configurarTabela();
	}
	
	private void configurarTela() {
		setSize(830,400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
	}
	
	private void configurarPainel() {
		painel = new JPanel();
		painel.setLayout(null);
		painel.setBorder(BorderFactory.createLineBorder(new Color(112,128,144),2));
		painel.setBounds(10, 20, 300, 330);
		
		add(painel);
	}
	
	private void configurarLabel() {
		OuvinteTelaVendas ouvinte = new OuvinteTelaVendas(this);
		
		JLabel lblOpcoes = new JLabel("OPÇÕES");
		lblOpcoes.setBounds(10, 0, 100, 20);
		lblOpcoes.setFont(new Font("Arial",1, 16));

		lblVendasHoje = new JLabel();
		lblVendasHoje.setText("VENDAS DE HOJE");
		lblVendasHoje.setIcon(Imagens.dinheiroDePapel);
		lblVendasHoje.setBounds(50, 50, 200, 50);
		lblVendasHoje.setOpaque(true);
		lblVendasHoje.setBackground(new Color(70,130,180));
		lblVendasHoje.setFont(new Font("Arial",1, 16));
		lblVendasHoje.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		lblVendasHoje.addMouseListener(ouvinte);
		
		lblEliminar = new JLabel();
		lblEliminar.setText("LIMPAR TABELA");
		lblEliminar.setIcon(Imagens.lixeira);
		lblEliminar.setBounds(50, 130, 200, 50);
		lblEliminar.setOpaque(true);
		lblEliminar.setBackground(new Color(70,130,180));
		lblEliminar.setFont(new Font("Arial",1, 16));
		lblEliminar.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		lblEliminar.addMouseListener(ouvinte);
		
		lblSeta = new JLabel(Imagens.seta);
		lblSeta.setBounds(770, -10, 50, 50);
		lblSeta.addMouseListener(ouvinte);
		
		painel.add(lblEliminar);
		painel.add(lblVendasHoje);
		add(lblSeta);
		add(lblOpcoes);
	}
	
	private void configurarTabela() {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] {"CÓDIGO","TOTAL","DATA","HORA"});
		tbVendas = new JTable(modelo);
		tbVendas.setFont(new Font("Arial", 1, 14));
		
		JScrollPane scrol = new JScrollPane(tbVendas);
		scrol.setBounds(320, 20, 460, 332);
		
		add(scrol);
		
	}
	
	public void atualizarTabela() {
		RepositorioVenda repo = new RepositorioVenda();
		
		List<Venda> vendas = repo.todasVendas();
		
		for(Venda v : vendas) {
			DefaultTableModel modelo = (DefaultTableModel) tbVendas.getModel();
			String id = String.valueOf(v.getId());
			String total = String.valueOf(v.getTotal());
			modelo.addRow(new String[] {id, total, v.getData(), v.getHora()});
		}
	}

	public JTable getTbVendas() {
		return tbVendas;
	}
	
	public JLabel getLblVendasHoje() {
		return lblVendasHoje;
	}

	public JLabel getLblEliminar() {
		return lblEliminar;
	}

	public JLabel getLblSeta() {
		return lblSeta;
	}
}
