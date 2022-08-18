package sistemaFeira.view.ouvintes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import sistemaFeira.model.Produto;
import sistemaFeira.model.Venda;
import sistemaFeira.repositorios.RepositorioProduto;
import sistemaFeira.repositorios.RepositorioVenda;
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
		else if(e.getSource() == tela.getLblExcluir()) {
			DefaultTableModel model = (DefaultTableModel) tela.getTbVendas().getModel();
			model.setNumRows(0);
			tela.getLblValorTotal().setText("0");
			
			tela.getTxtRecebido().setForeground(new Color(176,196,222));
			tela.getTxtRecebido().setText("RECEBIDO");
			tela.getTxtRecebido().setEditable(false);
			
			tela.getTxtTroco().setText("TROCO");
			tela.getTxtTroco().setEditable(false);
			tela.getTxtTroco().setForeground(new Color(176,196,222));
			
			tela.getBox().setSelectedIndex(0);
			
		}
		else if(e.getSource() == tela.getLblRecebido() || e.getSource() == tela.getTxtRecebido()) {
			tela.getTxtRecebido().setText("");
			tela.getTxtRecebido().setEditable(true);
			tela.getTxtRecebido().setForeground(Color.WHITE);
		}
		else if(e.getSource() == tela.getLblCalculadora()) {
			String recebido = tela.getTxtRecebido().getText();
			recebido = recebido.replaceAll(",", ".");
			String total = tela.getLblValorTotal().getText();
			
			if(Double.parseDouble(recebido) >= Double.parseDouble(total)) {
				double troco = Double.parseDouble(recebido) - Double.parseDouble(total);
				tela.getTxtTroco().setForeground(Color.white);
				tela.getTxtTroco().setText(String.valueOf(troco));
			}
			else {
				JOptionPane.showMessageDialog(null, "Valor recebido foi insuficiente.", "AtenÃ§Ã£o!", 2, null);
			}
		}
		else if(e.getSource() == tela.getLblRealizarVenda()) {
			SimpleDateFormat spdfDia = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat spdfHora = new SimpleDateFormat("HH:mm:ss");
			RepositorioVenda repo = new RepositorioVenda();
			
			Double total = Double.parseDouble(tela.getLblValorTotal().getText());
			Date date = new Date();
			Venda venda = new Venda(total,spdfDia.format(date),spdfHora.format(date));
			
			repo.cadastrarVenda(venda);
			JOptionPane.showMessageDialog(null, "Venda Cadastrada Com Sucesso.", "Informação da Venda", 1, null);
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
			if(produto != "PRODUTOS") {
			
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
}
