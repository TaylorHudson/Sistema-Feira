package sistemaFeira.view.ouvintes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.table.DefaultTableModel;

import sistemaFeira.model.Produto;
import sistemaFeira.util.RepositorioProduto;
import sistemaFeira.view.TelaCadastroProdutos;

public class OuvinteTelaCadastroProdutos implements MouseListener{

	private TelaCadastroProdutos tela;
	private RepositorioProduto repo = new RepositorioProduto();
	
	public OuvinteTelaCadastroProdutos(TelaCadastroProdutos t) {
		this.tela = t;
	}
	
	private void limparTabela() {
		DefaultTableModel model = (DefaultTableModel) tela.getTbPreco().getModel();
		model.setRowCount(0);
		//int tamanho = tela.getTbPreco().getRowCount();
		//System.out.println(tamanho);
		//for(int i = 0; i <= tamanho; i++) {
		//	model.removeRow(i);
		//}
	}
	
	private void limparTexto() {
		tela.getTxtNomeProduto().setText("");
		tela.getTxtPreco().setText("");
	}
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tela.getTxtNomeProduto()) {
				this.tela.getTxtNomeProduto().setText("");
				this.tela.getTxtNomeProduto().setEditable(true);
				this.tela.getTxtNomeProduto().setForeground(Color.white);
		}
		else if (e.getSource() == tela.getTxtPreco()) {
			this.tela.getTxtPreco().setText("");
			this.tela.getTxtPreco().setEditable(true);
			this.tela.getTxtPreco().setForeground(Color.white);
		}

		else if (e.getSource() == tela.getLblRegistrar()) {	
			Produto p = new Produto(tela.getTxtNomeProduto().getText().toUpperCase(),tela.getTxtPreco().getText().toUpperCase());
			repo.cadastrarProduto(p);
			
			limparTabela();
			tela.listarProdutosTabela();
			
			limparTexto();
		}
		
		else if(e.getSource() == tela.getLblExculir()) {
			DefaultTableModel model = (DefaultTableModel) tela.getTbPreco().getModel();

			Object id = tela.getTbPreco().getValueAt(tela.getTbPreco().getSelectedRow(), 0);
		
			Produto p = repo.buscarPorId(Integer.parseInt(id.toString()));
			repo.excluirProduto(p);
			
			model.removeRow(tela.getTbPreco().getSelectedRow());
			
			limparTexto();
		}
		
		else if(e.getSource() == tela.getLblAtualizar()) {
				Object id = tela.getTbPreco().getValueAt(tela.getTbPreco().getSelectedRow(), 0);
				Object nome = tela.getTxtNomeProduto().getText();
				Object preco = tela.getTxtPreco().getText();
				Produto p = new Produto(Integer.parseInt(id.toString()), nome.toString(), preco.toString());
		
				repo.atualizarProduto(p);
				limparTabela();
				tela.listarProdutosTabela();	
				
				limparTexto();
		}
		else if(e.getSource() == tela.getTbPreco()) {
			Object nome = tela.getTbPreco().getValueAt(tela.getTbPreco().getSelectedRow(), 1);
			Object preco = tela.getTbPreco().getValueAt(tela.getTbPreco().getSelectedRow(), 2);
			
			tela.setFont(new Font("Arial", 1, 14));
			tela.getTxtNomeProduto().setText(nome.toString());
			tela.getTxtPreco().setText(preco.toString());
		}
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
	
		
	}
	
	public void mouseExited(MouseEvent e) {
		
	}
}
