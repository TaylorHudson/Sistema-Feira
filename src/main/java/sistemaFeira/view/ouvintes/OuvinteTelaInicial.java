package sistemaFeira.view.ouvintes;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import sistemaFeira.view.TelaCadastroProdutos;
import sistemaFeira.view.TelaInicial;

public class OuvinteTelaInicial implements MouseListener{

	TelaInicial tela;
	
	public OuvinteTelaInicial(TelaInicial t) {
		this.tela = t;
	}
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tela.getImgProduto()) {
			this.tela.dispose();
			new TelaCadastroProdutos().setVisible(true);;
		}
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
