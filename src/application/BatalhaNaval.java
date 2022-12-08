package application;

import entities.*;

public class BatalhaNaval {

	public static void main(String[] args) {
				
		Tabuleiro tabuleiro = new Tabuleiro();
		
		tabuleiro.criaTabuleiro();
		
		Barco corveta = new Corveta();
		Barco submarino = new Submarino();
		Barco fragata = new Fragata();
		Barco destroyer = new Destroyer();
		
		int[][] teste = destroyer.criarBarco(tabuleiro.getTabuleiro());
		
		teste = corveta.criarBarco(teste);
		teste = submarino.criarBarco(teste);
		teste = fragata.criarBarco(teste);
		
		for(int i[] : teste) {
			for(int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
			
	}

}
