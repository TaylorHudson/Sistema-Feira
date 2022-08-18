package sistemaFeira.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import sistemaFeira.util.Imagens;
import sistemaFeira.view.ouvintes.OuvinteTelaInicial;

public class TelaInicial extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JLabel lblMenu;
	private JLabel imgProduto;
	private JLabel imgCaixa;
	private JLabel imgVendas;

	public TelaInicial() {
		configurarTela();
		configurarImagens();
		configurarLabel();
		
		setVisible(true);
	}
	
	private void configurarTela() {
		JLabel bg = new JLabel(Imagens.backGround);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900,800);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setContentPane(bg);
	}
	
	private void configurarImagens() {
		lblMenu = new JLabel(Imagens.labelAzul);
		lblMenu.setBounds(0,0, 900, 100);
		
		OuvinteTelaInicial ouvinte = new OuvinteTelaInicial(this);
		
		imgProduto = new JLabel();
		imgProduto.setIcon(Imagens.produto);
		imgProduto.setBounds(250, 20, 40, 40);
		imgProduto.addMouseListener(ouvinte);
		
		imgCaixa = new JLabel();
		imgCaixa.setIcon(Imagens.caixa);
		imgCaixa.setBounds(400, 25, 40, 40);
		imgCaixa.addMouseListener(ouvinte);
		
		imgVendas = new JLabel();
		imgVendas.setIcon(Imagens.dinheiro);
		imgVendas.setBounds(550, 25, 40, 40);
		imgVendas.addMouseListener(ouvinte);
		
		add(imgVendas);
		add(imgProduto);
		add(imgCaixa);
		add(lblMenu);
		
	}
	
	private void configurarLabel() {
		JLabel lblProdutos = new JLabel("PRODUTOS");
		lblProdutos.setBounds(235, 62, 100, 30);
		lblProdutos.setForeground(Color.white);
		lblProdutos.setFont(new Font("Arial", 1, 13));
		
		JLabel lblCaixa = new JLabel("CAIXA");
		lblCaixa.setBounds(400, 60, 100, 30);
		lblCaixa.setForeground(Color.white);
		lblCaixa.setFont(new Font("Arial", 1, 15));
		
		JLabel lblVendas = new JLabel("VENDAS");
		lblVendas.setBounds(540, 58, 100, 30);
		lblVendas.setForeground(Color.white);
		lblVendas.setFont(new Font("Arial", 1, 15));
		
		lblMenu.add(lblVendas);
		lblMenu.add(lblCaixa);
		lblMenu.add(lblProdutos);
	}

	public JLabel getImgProduto() {
		return imgProduto;
	}

	public JLabel getImgVendas() {
		return imgVendas;
	}

	public JLabel getImgCaixa() {
		return imgCaixa;
	}
}
