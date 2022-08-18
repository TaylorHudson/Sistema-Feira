package sistemaFeira.aplicacao;

import sistemaFeira.view.TelaCadastroProdutos;
import sistemaFeira.view.TelaInicial;

public class Programa {

	public static void main(String[] args) {
		
		TelaCadastroProdutos t = new TelaCadastroProdutos();
		t.listarProdutosTabela();
		
		new TelaInicial();
		
	}
}
