package entities;

public class Tabuleiro {
	
	private int[][] tabuleiro = new int[10][10];
	
	public Tabuleiro() {
	}
	
	public int[][] getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(int[][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public void criaTabuleiro() {
		for(int linha = 0; linha < 10; linha++) {
			for(int coluna = 0; coluna < 10; coluna++) {
				tabuleiro[linha][coluna] = 0;
			}
		}
	}
	
	/*
	 *  Mostrando o tabuleiro com condições onde 
	 * ~ é agua e sem navio, * é um tiro onde não tem navio(errou)
	 *  e X é tiro onde tem navio(acertou)
	 */
	public void mostraTabuleiro() {
		for(int linha = 0; linha < 10; linha++) {
			for(int coluna = 0; coluna < 10; coluna++) {
				if(tabuleiro[linha][coluna] == 0) {
					System.out.print(" ~ ");
				} else if(tabuleiro[linha][coluna] == -1) {
					System.out.print(" * ");
				} else if(tabuleiro[linha][coluna] == -2) {
					System.out.print(" X ");
				} else if(tabuleiro[linha][coluna] == 1) {
					System.out.print(" C ");
				} else if(tabuleiro[linha][coluna] == 2) {
					System.out.print(" S ");
				} else if(tabuleiro[linha][coluna] == 3) {
					System.out.print(" F ");
				} else if(tabuleiro[linha][coluna] == 4) {
					System.out.print(" D ");
				}
				
			}			
			System.out.println();
		}		
	}
}
