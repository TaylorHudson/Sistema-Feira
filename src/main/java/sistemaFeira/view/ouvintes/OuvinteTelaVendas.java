package sistemaFeira.view.ouvintes;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.table.DefaultTableModel;

import sistemaFeira.view.TelaInicial;
import sistemaFeira.view.TelaVendas;

public class OuvinteTelaVendas implements MouseListener{
	
	TelaVendas tela;

	public OuvinteTelaVendas(TelaVendas t) {
		this.tela = t;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
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
