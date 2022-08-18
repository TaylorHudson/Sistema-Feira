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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import sistemaFeira.model.Produto;
import sistemaFeira.repositorios.RepositorioProduto;
import sistemaFeira.util.Imagens;
import sistemaFeira.view.ouvintes.OuvinteTelaCadastroProdutos;

public class TelaCadastroProdutos extends JFrame {
	private static final long serialVersionUID = 1L;

	private JTextField txtNomeProduto;
	private JTextField txtPreco;
	private JLabel lblRegistrar;
	private JLabel lblAtualizar;
	private JLabel lblExcluir;
	private JTable tbPreco;
	private JLabel lblSeta;
		
	public TelaCadastroProdutos() {
		configurarTela();
		configurarAreaRegistro();
		configurarAreaOpcao();
		configurarTabela();
		listarProdutosTabela();

	}

	private void configurarTela() {
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900, 750);
		setLocationRelativeTo(null);
		setResizable(false);

	}
	
	private void configurarAreaRegistro() {
		OuvinteTelaCadastroProdutos ouvinte = new OuvinteTelaCadastroProdutos(this);
		JLabel lblRegistro = new JLabel("REGISTRO");
		lblRegistro.setBounds(10, 5, 120, 25);
		lblRegistro.setFont(new Font("Arial", 1, 17));
		lblRegistro.setForeground(Color.BLACK);
		
		JPanel painel = new JPanel();
		painel.setBounds(10, 25, 865, 100);
		painel.setBorder(BorderFactory.createLineBorder(new Color(112,128,144),2));
		painel.setLayout(null);
		
		JLabel lblNomeProduto = new JLabel();
		txtNomeProduto = new JTextField("NOME DO PRODUTO");
		
		lblNomeProduto.setIcon(Imagens.produto);
		lblNomeProduto.setBorder(BorderFactory.createLineBorder(Color.black,2));
		lblNomeProduto.setBounds(100, 28, 250, 50);
		lblNomeProduto.setOpaque(true);
		lblNomeProduto.setBackground(new Color(70,130,180));
		lblNomeProduto.setLayout(null);
		
		txtNomeProduto.setBounds(45, 15, 200, 30);
		txtNomeProduto.setOpaque(true);
		txtNomeProduto.setBackground(new Color(70,130,180));
		txtNomeProduto.setBorder(BorderFactory.createLineBorder(new Color(70,130,180)));
		txtNomeProduto.setFont(new Font("Arial", 1, 15));
		txtNomeProduto.setForeground(new Color(176,196,222));
		txtNomeProduto.setEditable(false);
		txtNomeProduto.addMouseListener(ouvinte);
		
		JLabel lblPreco = new JLabel();
		txtPreco = new JTextField("PRE�O DO PRODUTO");
		
		lblPreco.setIcon(Imagens.moeda);
		lblPreco.setBorder(BorderFactory.createLineBorder(Color.black,2));
		lblPreco.setBounds(500, 28, 250, 50);
		lblPreco.setOpaque(true);
		lblPreco.setBackground(new Color(70,130,180));
		lblPreco.setLayout(null);
		
		txtPreco.setBounds(45, 12, 200, 30);
		txtPreco.setOpaque(true);
		txtPreco.setBackground(new Color(70,130,180));
		txtPreco.setBorder(BorderFactory.createLineBorder(new Color(70,130,180)));
		txtPreco.setFont(new Font("Arial", 1, 15));
		txtPreco.setForeground(new Color(176,196,222));
		txtPreco.setEditable(false);
		txtPreco.addMouseListener(ouvinte);
		
		lblPreco.add(txtPreco);
		lblNomeProduto.add(txtNomeProduto);
		painel.add(lblNomeProduto);
		painel.add(lblPreco);
		add(lblRegistro);
		add(painel);
	}
	
	private void configurarAreaOpcao() {
		OuvinteTelaCadastroProdutos ouvinte = new OuvinteTelaCadastroProdutos(this);
		
		JLabel lblOpcoes = new JLabel("OPÇÕES");
		lblOpcoes.setBounds(10, 130, 120, 25);
		lblOpcoes.setFont(new Font("Arial", 1, 17));
		lblOpcoes.setForeground(Color.BLACK);
		
		JPanel painel = new JPanel();
		painel.setLayout(null);
		painel.setBorder(BorderFactory.createLineBorder(new Color(112,128,144),2));
		painel.setBounds(10, 155, 865, 130);
		
		lblRegistrar = new JLabel(Imagens.registrarProduto);
		lblRegistrar.setBounds(105, 25, 250, 70);
		lblRegistrar.addMouseListener(ouvinte);
	
		lblAtualizar = new JLabel(Imagens.atualizarProduto);
		lblAtualizar.setBounds(305, 25, 250, 70);
		lblAtualizar.addMouseListener(ouvinte);
		
		lblExcluir = new JLabel(Imagens.excluirProduto);
		lblExcluir.setBounds(495, 25, 250, 70);
		lblExcluir.addMouseListener(ouvinte);
		
		JLabel lblTxtRegistrar = new JLabel("REGISTRAR");
		lblTxtRegistrar.setBounds(190, 80, 250, 70);
		lblTxtRegistrar.setFont(new Font("Arial", 1, 14));
		JLabel lblTxtAtualizar = new JLabel("ATUALIZAR");
		lblTxtAtualizar.setBounds(390, 80, 250, 70);	
		lblTxtAtualizar.setFont(new Font("Arial", 1, 14));
		JLabel lblTxtExcluir = new JLabel("EXCLUIR");
		lblTxtExcluir.setBounds(590, 80, 250, 70);	
		lblTxtExcluir.setFont(new Font("Arial", 1, 14));
		
		lblSeta = new JLabel(Imagens.seta);
		lblSeta.setBounds(830, -12,50,50);
		lblSeta.addMouseListener(ouvinte);
		
		painel.add(lblTxtRegistrar);
		painel.add(lblTxtAtualizar);
		painel.add(lblTxtExcluir);
		painel.add(lblAtualizar);
		painel.add(lblRegistrar);
		painel.add(lblExcluir);
		
		add(lblSeta);
		add(painel);
		add(lblOpcoes);
	}
	
	private void configurarTabela() {
		OuvinteTelaCadastroProdutos ouvinte = new OuvinteTelaCadastroProdutos(this);
		
		DefaultTableModel modelo = new DefaultTableModel(0, 3);
		modelo.setColumnIdentifiers(new String[] {"CÓDIGO DO PRODUTO" , "NOME DO PRODUTO", "PREÇO DO PRODUTO"});
		tbPreco = new JTable(modelo);
		tbPreco.addMouseListener(ouvinte);
		JScrollPane scrol = new JScrollPane(tbPreco);
		scrol.setBounds(10, 300, 865, 400);
		
		add(scrol);
	}
	
	public void listarProdutosTabela() {
		RepositorioProduto r = new RepositorioProduto();
		DefaultTableModel model = (DefaultTableModel) this.getTbPreco().getModel();
		
		List<Produto> produtos = r.todosProdutos();
		
		for(Produto p : produtos) {
			model.addRow(new String[] {String.valueOf(p.getId()),p.getNome(),p.getPreco()});
		}
	}
	
	public JTextField getTxtPreco() {
		return txtPreco;
	}
	public JTextField getTxtNomeProduto() {
		return txtNomeProduto;
	}
	public JLabel getLblRegistrar() {
		return lblRegistrar;
	}
	public JLabel getLblAtualizar() {
		return lblAtualizar;
	}
	public JLabel getLblExculir() {
		return lblExcluir;
	}
	public JTable getTbPreco() {
		return tbPreco;
	}
	public JLabel getLblSeta() {
		return lblSeta;
	}
}