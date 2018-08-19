package model;

public class Normal extends Ingresso {
	
	public Normal(Cadeira cadeira) {
		super(cadeira);
	}

	@Override
	public double getValor() {
		return this.precoNormal;
	}
}
