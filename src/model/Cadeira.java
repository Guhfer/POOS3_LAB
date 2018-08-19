package model;

public class Cadeira {

	private int fileira;
	private int assento;
	private boolean ocupada;

	public Cadeira(int fileira, int assento) {
		this.fileira = fileira;
		this.assento = assento;
		this.ocupada = false;
	}

	public void ocupar() {
		this.ocupada = true;
	}

	public boolean estaLivre() {
		return this.ocupada == false ? true : false;
	}
	
	public int getAssento() {
		return assento;
	}

	public int getFileira() {
		return fileira;
	}

}
