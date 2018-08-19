package model;

public class Meia extends Ingresso {
	
	public Meia(Cadeira cadeira) {
		super(cadeira);
	}

	@Override
	public double getValor() {
		return (this.precoNormal / 2);
	}
}
