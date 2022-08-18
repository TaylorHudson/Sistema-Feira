package sistemaFeira.view;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import sistemaFeira.model.Produto;
import sistemaFeira.repositorios.RepositorioProduto;
import sistemaFeira.util.Imagens;
import sistemaFeira.view.ouvintes.OuvinteTelaCaixa;

public class TelaCaixa extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JPanel painelProdutos;
	private JPanel painelVenda;
	private JPanel painelTabela;
	private JPanel painelOpcoes;
	
	private JLabel lblProdutos;
	private JLabel lblData;
	private JLabel lblRecebido;
	private JLabel lblTroco;
	private JLabel lblCalculadora;
	private JLabel lblRealizarVenda;
	private JLabel lblExcluir;
	private JLabel lblSeta;
	private JLabel lblValorTotal;
	
	private JTextField txtRecebido;
	private JTextField txtTroco;
	
	private JTable tbVendas;
	private JComboBox<String> box;
	
	public TelaCaixa() {
		configurarTela();
		configurarPanel();
		configurarLabel();
		configurarTabela();
		carregarProdutos();
	}
	
	private void configurarTela() {
		setTitle("Vendas");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900, 580);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	private void configurarLabel() {
		OuvinteTelaCaixa ouvinte = new OuvinteTelaCaixa(this);
		
		SimpleDateFormat spdf = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date();
		
		lblProdutos = new JLabel();
		box = new JComboBox<String>(new String[] {"PRODUTOS"});
		box.setBounds(22,12, 112, 25);
		box.setOpaque(true);
		box.setFont(new Font("Arial", 1, 9));
		box.setForeground(Color.white);
		box.setBackground(new Color(70,130,180));
		box.addActionListener(ouvinte);
		
		lblProdutos.setIcon(Imagens.lupa);
		lblProdutos.setFont(new Font("Arial",1,14));
		lblProdutos.setLayout(null);
		lblProdutos.setBounds(10, 15, 130, 50);
		lblProdutos.setOpaque(true);
		lblProdutos.setBackground(new Color(70,130,180));
		lblProdutos.setBorder(BorderFactory.createLineBorder(new Color(70,130,180)));
		
		lblData = new JLabel(Imagens.calendario);
		lblData.setText(spdf.format(data));
		lblData.setFont(new Font("Arial",1,15));
		lblData.setBounds(145, 15, 130, 50);
		lblData.setOpaque(true);
		lblData.setBackground(new Color(70,130,180));
		lblData.setBorder(BorderFactory.createLineBorder(new Color(70,130,180)));
		
		lblTroco = new JLabel();
		txtTroco = new JTextField();
		lblTroco.setLayout(null);
		lblTroco.setBounds(415, 15, 130, 50);
		txtTroco.setBounds(40, 10, 108, 30);
		txtTroco.setOpaque(true);
		txtTroco.setBackground(new Color(70,130,180));
		txtTroco.setForeground(Color.white);
		txtTroco.setText("TROCO");
		txtTroco.setEditable(false);
		txtTroco.setBorder(BorderFactory.createLineBorder(new Color(70,130,180)));
		txtTroco.setFont(new Font("Arial",1,16));
		txtTroco.setForeground(new Color(176,196,222));
		lblTroco.setIcon(Imagens.troco);
		lblTroco.setOpaque(true);
		lblTroco.setBackground(new Color(70,130,180));
		lblTroco.setBorder(BorderFactory.createLineBorder(new Color(70,130,180)));
		
		lblRecebido = new JLabel();
		txtRecebido = new JTextField();
		lblRecebido.setLayout(null);
		lblRecebido.setBounds(280, 15, 130, 50);
		txtRecebido.setBounds(40, 10, 108, 30);
		txtRecebido.setOpaque(true);
		txtRecebido.setBackground(new Color(70,130,180));
		txtRecebido.setForeground(new Color(176,196,222));
		txtRecebido.setText("RECEBIDO");
		txtRecebido.setEditable(false);
		txtRecebido.setBorder(BorderFactory.createLineBorder(new Color(70,130,180)));
		txtRecebido.setFont(new Font("Arial",1,16));
		txtRecebido.addMouseListener(ouvinte);
		lblRecebido.setIcon(Imagens.moeda);
		lblRecebido.setOpaque(true);
		lblRecebido.setBackground(new Color(70,130,180));
		lblRecebido.setBorder(BorderFactory.createLineBorder(new Color(70,130,180)));
		lblRecebido.addMouseListener(ouvinte);
		
		JLabel lblNumeroVendas = new JLabel();
		lblNumeroVendas.setForeground(Color.white);
		lblNumeroVendas.setText("  N°");
		lblNumeroVendas.setFont(new Font("Arial",1,16));
		lblNumeroVendas.setOpaque(true);
		lblNumeroVendas.setBackground(new Color(70,130,180));
		lblNumeroVendas.setBounds(10, 10, 280, 45);
		
		lblCalculadora = new JLabel();
		lblCalculadora.setLayout(null);
		lblCalculadora.setBounds(10, 15, 280, 50);
		lblCalculadora.setIcon(Imagens.calculdora);
		lblCalculadora.setText("     REALIZAR CÁLCULO");
		lblCalculadora.setFont(new Font("Arial",1,16));
		lblCalculadora.setForeground(Color.white);
		lblCalculadora.setOpaque(true);
		lblCalculadora.setBackground(new Color(70,130,180));
		lblCalculadora.setBorder(BorderFactory.createLineBorder(new Color(70,130,180)));
		lblCalculadora.addMouseListener(ouvinte);
		
		lblRealizarVenda = new JLabel();
		lblRealizarVenda.setLayout(null);
		lblRealizarVenda.setBounds(10, 75, 280, 50);
		lblRealizarVenda.setIcon(Imagens.carrinho);
		lblRealizarVenda.setText("     REALIZAR VENDA");
		lblRealizarVenda.setFont(new Font("Arial",1,16));
		lblRealizarVenda.setForeground(Color.white);
		lblRealizarVenda.setOpaque(true);
		lblRealizarVenda.setBackground(new Color(70,130,180));
		lblRealizarVenda.setBorder(BorderFactory.createLineBorder(new Color(70,130,180)));
		
		lblExcluir = new JLabel();
		lblExcluir.setLayout(null);
		lblExcluir.setBounds(10, 135, 280, 50);
		lblExcluir.setIcon(Imagens.lixeira);
		lblExcluir.setText("     EXCLUIR TUDO");
		lblExcluir.setFont(new Font("Arial",1,16));
		lblExcluir.setForeground(Color.white);
		lblExcluir.setOpaque(true);
		lblExcluir.setBackground(new Color(70,130,180));
		lblExcluir.setBorder(BorderFactory.createLineBorder(new Color(70,130,180)));
		lblExcluir.addMouseListener(ouvinte);
		
		lblProdutos.add(box);
		lblRecebido.add(txtRecebido);
		lblTroco.add(txtTroco);
		
		lblSeta = new JLabel(Imagens.seta);
		lblSeta.setBounds(832, -12, 50, 50);
		lblSeta.addMouseListener(ouvinte);
		
		JLabel lblTotal = new JLabel("TOTAL: ");
		lblTotal.setFont(new Font("Arial", 0, 23));
		lblTotal.setBounds(10, 380, 300, 50);
		
		lblValorTotal = new JLabel("0");
		lblValorTotal.setFont(new Font("Arial", 0, 21));
		lblValorTotal.setBounds(100, 380, 300, 50);
		
		painelOpcoes.add(lblValorTotal);
		painelOpcoes.add(lblTotal);
		painelVenda.add(lblNumeroVendas);
		
		painelOpcoes.add(lblCalculadora);
		painelOpcoes.add(lblRealizarVenda);
		painelOpcoes.add(lblExcluir);
		painelProdutos.add(lblTroco);
		painelProdutos.add(lblRecebido);
		painelProdutos.add(lblData);
		painelProdutos.add(lblProdutos);
		
		add(lblSeta);
	}
	
	private void configurarTabela() {
		DefaultTableModel model = new DefaultTableModel(0,4);
		model.setColumnIdentifiers(new String[] {"CÓDIGO", "PRODUTO", "PREÇO", "QUANTIDADE", "TOTAL"});
		
		tbVendas = new JTable(model);
		tbVendas.setEnabled(false);
		JScrollPane scrol = new JScrollPane(tbVendas);
		
		scrol.setBounds(10, 10, 535, 410);
		
		painelTabela.add(scrol);
		
		add(painelTabela);
	}
	
	private void configurarPanel() {
		painelProdutos = new JPanel();
		painelProdutos.setLayout(null);
		painelProdutos.setBorder(BorderFactory.createLineBorder(new Color(112,128,144),2));
		painelProdutos.setBounds(10,10, 555, 80);
		
		painelVenda = new JPanel();
		painelVenda.setLayout(null);
		painelVenda.setBorder(BorderFactory.createLineBorder(new Color(112,128,144),2));
		painelVenda.setBounds(575,25, 300, 65);
		
		painelOpcoes = new JPanel();
		painelOpcoes.setLayout(null);
		painelOpcoes.setBorder(BorderFactory.createLineBorder(new Color(112,128,144),2));
		painelOpcoes.setBounds(575,100, 300, 430);
		
		painelTabela = new JPanel();
		painelTabela.setLayout(null);
		painelTabela.setBorder(BorderFactory.createLineBorder(new Color(112,128,144),2));
		painelTabela.setBounds(10,100, 555, 430);
		
		add(painelTabela);
		add(painelOpcoes);
		add(painelProdutos);
		add(painelVenda);
	}
	
	private void carregarProdutos() {
		RepositorioProduto repo = new RepositorioProduto();
		
		List<Produto> produtos = repo.todosProdutos();
		
		for(Produto p : produtos) {
			getBox().addItem(p.getNome());
		}
	}
	
	public JLabel getLblProdutos() {
		return lblProdutos;
	}
	public JLabel getLblRecebido() {
		return lblRecebido;
	}
	public JLabel getLblTroco() {
		return lblTroco;
	}	
	public JComboBox<String> getBox() {
		return box;
	}
	public JLabel getLblSeta() {
		return lblSeta;
	}
	public JTable getTbVendas() {
		return tbVendas;
	}
	public JLabel getLblValorTotal() {
		return lblValorTotal;
	}
	public JLabel getLblExcluir() {
		return lblExcluir;
	}
	public JLabel getLblCalculadora() {
		return lblCalculadora;
	}
	public JTextField getTxtRecebido() {
		return txtRecebido;
	}
	public JTextField getTxtTroco() {
		return txtTroco;
	}
}
