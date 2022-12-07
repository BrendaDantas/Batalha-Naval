package entities;

public class Tabuleiro {
	
	private int[][] tabuleiro = new int[10][10];
	
	public void criaTabuleiro() {
		for(int linha = 0; linha < 10; linha++) {
			for(int coluna = 0; coluna < 10; coluna++) {
				tabuleiro[linha][coluna] = 2;
			}
		}
	}
	
	public void mostraTabuleiro() {
		for(int linha = 0; linha < 10; linha++) {
			for(int coluna = 0; coluna < 10; coluna++) {
				System.out.print(tabuleiro[linha][coluna] + " ");
			}			
			System.out.println();
		}
		
	}

}
