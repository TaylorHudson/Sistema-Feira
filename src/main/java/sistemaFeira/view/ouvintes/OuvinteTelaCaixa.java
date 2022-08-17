package sistemaFeira.view.ouvintes;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import sistemaFeira.model.Produto;
import sistemaFeira.util.RepositorioProduto;
import sistemaFeira.view.TelaCaixa;

public class OuvinteTelaCaixa implements MouseListener{

	private TelaCaixa tela;
	private RepositorioProduto repo = new RepositorioProduto();
	
	public OuvinteTelaCaixa(TelaCaixa tela) {
		this.tela = tela;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == tela.getBox()) {
			
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
