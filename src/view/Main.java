package view;

import javax.swing.JOptionPane;

import model.Vendas;

public class Main {

	public static void main(String[] args) {
		Vendas vendas;
		int fileira;
		int assento;
		int ingresso;
		boolean vendeu;
		
		vendas = new Vendas();
		
		do {
			JOptionPane.showMessageDialog(null, "Venda de ingressos", "Ingressos do Teatro POO",
					JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(null, vendas.getCadeirasVazias()+" Cadeiras disponíveis", "Assentos Livres",
					JOptionPane.INFORMATION_MESSAGE);
			fileira = Integer.parseInt(JOptionPane.showInputDialog("Fileira:"));
			assento = Integer.parseInt(JOptionPane.showInputDialog("Cadeira:"));
			
			/*
			 * 1o Considerar a endentação.
			 * 2o Poderia ter utilizado apenas um JOptionPane para apresentar os tipos de impresso
			 * e ler qual o tipo desejado. 
			 */
				JOptionPane.showMessageDialog(null, "Qual tipo de ingresso?\n 1 - Inteira \n 2 - Meia\n 3 - Isento",
					"Ingressos do Teatro POO", JOptionPane.QUESTION_MESSAGE);
			ingresso = Integer.parseInt(JOptionPane.showInputDialog("Ingresso tipo:"));
			
			switch(ingresso) {
				case 1: vendeu = vendas.novaVenda(fileira, assento, Vendas.INTEIRA); break;
				case 2: vendeu = vendas.novaVenda(fileira, assento, Vendas.MEIA); break;
				case 3: vendeu = vendas.novaVenda(fileira, assento, Vendas.ISENTO); break;
				default: vendeu = false; break;
			}
			
			if (!vendeu) {
				JOptionPane.showMessageDialog(null, "Cadeira ou ingresso indisponivil!", "Ingresso do Teatro POO",
						JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Bom espetaculo", "Ingresso do Teatro POO",
						JOptionPane.WARNING_MESSAGE);
			}
		} while (JOptionPane.showConfirmDialog(null, "Deseja encerrar o sistema?", "Ingressos do Teatro POO",
				JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION);
		JOptionPane.showMessageDialog(null, "Total de vendas: R$" + vendas.valorArrecadado(), "Teatro POO",
				JOptionPane.INFORMATION_MESSAGE);
	}

}
