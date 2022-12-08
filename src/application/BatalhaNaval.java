package application;

import entities.*;

public class BatalhaNaval {

	public static void main(String[] args) {
				
		Tabuleiro tabuleiro = new Tabuleiro();
		
		tabuleiro.criaTabuleiro();
		//tabuleiro.mostraTabuleiro();
		
		Barco destroyer = new Destroyer();
		//tabuleiro.setTabuleiro(corveta.criarBarco(tabuleiro.getTabuleiro()));
		//tabuleiro.mostraTabuleiro();
		
		int[][] teste = destroyer.criarBarco(tabuleiro.getTabuleiro());
		
		for(int i[] : teste) {
			for(int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
			
	}

}
