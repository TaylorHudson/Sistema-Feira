package sistemaFeira.view.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import sistemaFeira.model.Produto;
import sistemaFeira.util.RepositorioProduto;
import sistemaFeira.view.TelaCaixa;
import sistemaFeira.view.TelaInicial;

public class OuvinteTelaCaixa implements MouseListener, ActionListener{

	private TelaCaixa tela;
	private RepositorioProduto repo = new RepositorioProduto();
	
	public OuvinteTelaCaixa(TelaCaixa tela) {
		this.tela = tela;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == tela.getLblSeta()) {
			tela.dispose();
			new TelaInicial().setVisible(true);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == tela.getBox()) {
			String produto = tela.getBox().getSelectedItem().toString();
			String quantidade = JOptionPane.showInputDialog(null, "QUANTIDADE: ", "QUANTIDADE DO PRODUTO", 2);
			
			if(quantidade != null || quantidade != "") {
				DefaultTableModel modelo = (DefaultTableModel) tela.getTbVendas().getModel();
				
				double valorTotal = 0;
				
				List<Produto> produtos = repo.todosProdutos();
				for(Produto p : produtos) {
					if(p.getNome().equals(produto)) {
						double preco = Double.parseDouble(p.getPreco().replaceAll(",", "."));
						double quant = Double.parseDouble(quantidade);
						double total = preco * quant;
						modelo.addRow(new String[] {p.getId().toString(),p.getNome(),p.getPreco().toString(),quantidade,String.valueOf(total)});
						
						tela.getLblValorTotal().setText(String.valueOf((Double.parseDouble(tela.getLblValorTotal().getText())) + (valorTotal + total)));
					}
				}
			}
		}
	}
}
