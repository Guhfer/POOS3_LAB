package model;

public class Vendas {

	public static final int INTEIRA = 1;
	public static final int MEIA = 2;
	public static final int ISENTO = 3;
	private Teatro teatro;
	private Ingresso[] ingressos;
	private int ultimaVenda;

	public Vendas() {
		this.teatro = new Teatro();
		ultimaVenda = -1;
		ingressos = new Ingresso[teatro.tamanhoTeatro()];
	}

	public boolean novaVenda(int fila, int assento, int tipoIngresso) {
		boolean deuCerto = false;
		Ingresso ingresso = null;
		Cadeira cadeira;
		if (teatro.vender(fila, assento)) {
			cadeira = teatro.buscaCadeira(fila, assento);
			if(cadeira != null && tipoIngresso > 0 && tipoIngresso <= 3) {
				switch(tipoIngresso) {
					case 1: ingresso = new Normal(cadeira); break;
					case 2: ingresso = new Meia(cadeira); break;
					case 3: ingresso = new Isento(cadeira); break;
					default: deuCerto = false; break;
				}
				ultimaVenda += 1;
				ingressos[ultimaVenda] = ingresso;
				deuCerto = true;
			}
		}
		return deuCerto;
	}
	public int getCadeirasVazias() {
		return this.teatro.cadeirasDisponiveis();
	}
	
	public double valorArrecadado() {
		int i = 0;
		double soma = 0;
		for (i = 0; i <= ultimaVenda; i++) {
			soma += ingressos[i].getValor();
		}
		return soma;
	}

}
