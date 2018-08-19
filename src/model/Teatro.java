package model;

public class Teatro {
	private final int fileiras = 10;
	private final int cadeiras = 20;
	private Cadeira[] assentos;

	public Teatro() {
		int posicao;
		assentos = new Cadeira[tamanhoTeatro()];
		posicao = 0;
		for (int i = 1; i <= fileiras; i++) {
			for (int j = 1; j <= cadeiras; j++) {
				assentos[posicao] = new Cadeira(i, j);
				posicao += 1;
			}
		}
	}

	public boolean vender(int fila, int assento) {
		Cadeira cadeira;
		boolean deuCerto = false;
		if(fila <= fileiras && assento <= cadeiras && fila > 0 && assento > 0) {
			cadeira = buscaCadeira(fila, assento);
			if (cadeira.estaLivre()) {
				cadeira.ocupar();
				deuCerto = true;
			}
		}
	
		return deuCerto;
	}

	public Cadeira buscaCadeira(int fila, int assento) {
		Cadeira cadeira = null;
		int i = 0;
		while (cadeira == null && i < tamanhoTeatro()) {
			if (assentos[i].getFileira() == fila) {
				if (assentos[i].getAssento() == assento) {
					cadeira = assentos[i];
				}
			}
			i++;
		}
		return cadeira;
	}
	
	public int cadeirasDisponiveis() {
		int disponiveis = 0;
		for(int i = 0; i < assentos.length; i++) {
			if(assentos[i].estaLivre())
				disponiveis +=1;
		}
		return disponiveis;
	}
	
	public int tamanhoTeatro() {
		return fileiras*cadeiras;
	}
}
