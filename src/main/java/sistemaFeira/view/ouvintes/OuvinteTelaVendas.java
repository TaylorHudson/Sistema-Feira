package sistemaFeira.view.ouvintes;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import sistemaFeira.model.Venda;
import sistemaFeira.repositorios.RepositorioVenda;
import sistemaFeira.view.TelaInicial;
import sistemaFeira.view.TelaVendas;

public class OuvinteTelaVendas implements MouseListener{
	
	TelaVendas tela;

	public OuvinteTelaVendas(TelaVendas t) {
		this.tela = t;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		SimpleDateFormat spdf = new SimpleDateFormat("dd/MM/yyyy");
		RepositorioVenda repo = new RepositorioVenda();
		
		if(e.getSource() == tela.getLblSeta()) {
			tela.dispose();
			new TelaInicial().setVisible(true);
		}
		else if(e.getSource() == tela.getLblVendasHoje()) {
			tela.atualizarTabela();
		}
		else if(e.getSource() == tela.getLblEliminar()) {
			DefaultTableModel model = (DefaultTableModel) tela.getTbVendas().getModel();
			model.setNumRows(0);
		}
		else if(e.getSource() == tela.getLblChooser()) {
			String data = spdf.format(tela.getChooser().getDate());
			DefaultTableModel model = (DefaultTableModel) tela.getTbVendas().getModel();
			
			List<Venda> vendas = repo.vendasPorDia(data);
			model.setNumRows(0);
			
			if(!vendas.isEmpty()) {
				for(Venda v : vendas) {
					model.addRow(new String[] {v.getId().toString(),v.getTotal().toString(),v.getData(),v.getHora()});
				}
			}
			else {
				JOptionPane.showMessageDialog(null,"Nenhum registro de vendas nessa data.", "Observação", 1, null);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
