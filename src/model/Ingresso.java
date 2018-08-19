package model;

public abstract class Ingresso {

	protected final double precoNormal = 100;
	protected Cadeira cadeira;

	public Ingresso(Cadeira cadeira) {
		this.cadeira = cadeira;
	}

	public Cadeira getCadeira() {
		return cadeira;
	}

	public abstract double getValor();
}
