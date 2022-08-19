package sistemaFeira.view.ouvintes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import sistemaFeira.model.Produto;
import sistemaFeira.repositorios.RepositorioProduto;
import sistemaFeira.view.TelaCadastroProdutos;
import sistemaFeira.view.TelaInicial;

public class OuvinteTelaCadastroProdutos implements MouseListener{

	private TelaCadastroProdutos tela;
	private RepositorioProduto repo = new RepositorioProduto();
	
	public OuvinteTelaCadastroProdutos(TelaCadastroProdutos t) {
		this.tela = t;
	}
	
	private void limparTabela() {
		DefaultTableModel model = (DefaultTableModel) tela.getTbPreco().getModel();
		model.setRowCount(0);
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
			String nome = tela.getTxtNomeProduto().getText();
			String preco = tela.getTxtPreco().getText();
			
			if(!nome.equals("NOME DO PRODUTO") && !nome.isBlank()
					&& !preco.equals("PRE�O DO PRODUTO") && !preco.isBlank()) {
				
				String nomeProduto = tela.getTxtNomeProduto().getText();
				String precoProduto = tela.getTxtPreco().getText().replaceAll(",",".");
				
				Produto p = new Produto(nomeProduto.toUpperCase(),precoProduto);
				boolean cadastrado = repo.cadastrado(p);
				
				if(!cadastrado) {
					repo.cadastrarProduto(p);
					limparTabela();
					tela.listarProdutosTabela();
					limparTexto();
				}
				else{
					JOptionPane.showMessageDialog(null, "Produto j� cadastrado!", "Aten��o", 2, null);
				}		
			}
			else {
				JOptionPane.showMessageDialog(null, "Preencha todos os dados.", "Aten��o", 2, null);
			}
			
			
		}
		
		else if(e.getSource() == tela.getLblExculir()) {
			try {
				DefaultTableModel model = (DefaultTableModel) tela.getTbPreco().getModel();
	
				Object id = tela.getTbPreco().getValueAt(tela.getTbPreco().getSelectedRow(), 0);
			
				Produto p = repo.buscarPorId(Integer.parseInt(id.toString()));
				repo.excluirProduto(p);
				
				model.removeRow(tela.getTbPreco().getSelectedRow());
				
				limparTexto();
				
				JOptionPane.showMessageDialog(null, "Produto excluido.", "Informa��o", 1, null);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Selecione um produto para ser excluido.", "Aten��o!", 2, null);
			}
		}
		
		else if(e.getSource() == tela.getLblAtualizar()) {
			try {
					String nomeProduto = tela.getTxtNomeProduto().getText();
					String precoProduto = tela.getTxtPreco().getText();
					
					if(!nomeProduto.equals("NOME DO PRODUTO") && !nomeProduto.isBlank()
							&& !precoProduto.equals("PRE�O DO PRODUTO") && !precoProduto.isBlank()) {
						
						Object id = tela.getTbPreco().getValueAt(tela.getTbPreco().getSelectedRow(), 0);
						Object nome = tela.getTxtNomeProduto().getText();
						Object preco = tela.getTxtPreco().getText().replaceAll(",",".");
						Produto p = new Produto(Integer.parseInt(id.toString()), nome.toString(), preco.toString());
						
						repo.atualizarProduto(p);
						limparTabela();
						tela.listarProdutosTabela();
						limparTexto();
						
						JOptionPane.showMessageDialog(null, "Produto atualizado.", "Informa��o", 1, null);
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Dados inv�lidos.", "Aten��o", 2, null);
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Selecione um produto.", "Aten��o!", 2, null);
				}

		}
		else if(e.getSource() == tela.getTbPreco()) {
			Object nome = tela.getTbPreco().getValueAt(tela.getTbPreco().getSelectedRow(), 1);
			Object preco = tela.getTbPreco().getValueAt(tela.getTbPreco().getSelectedRow(), 2);
			
			tela.setFont(new Font("Arial", 1, 14));
			tela.getTxtNomeProduto().setText(nome.toString());
			tela.getTxtPreco().setText(preco.toString());
		}
		else if(e.getSource() == tela.getLblSeta()) {
			tela.dispose();
			new TelaInicial().setVisible(true);
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
