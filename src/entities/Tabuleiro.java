package entities;

public class Tabuleiro {
	
	private int[][] tabuleiro = new int[10][10];
	Barco corveta;
	Barco submarino;
	Barco fragata;
	Barco destroyer;
	
	public Tabuleiro() {
		this.corveta = new Corveta();
		this.submarino = new Submarino();
		this.fragata = new Fragata();
		this.destroyer = new Destroyer();
	}

	public Barco getCorveta() {
		return corveta;
	}

	public void setCorveta(Barco corveta) {
		this.corveta = corveta;
	}

	public Barco getSubmarino() {
		return submarino;
	}

	public void setSubmarino(Barco submarino) {
		this.submarino = submarino;
	}

	public Barco getFragata() {
		return fragata;
	}

	public void setFragata(Barco fragata) {
		this.fragata = fragata;
	}

	public Barco getDestroyer() {
		return destroyer;
	}

	public void setDestroyer(Barco destroyer) {
		this.destroyer = destroyer;
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
	
	public void criarBarcoEmTabuleiro() {
		this.corveta.criarBarco(this.getTabuleiro());
		this.submarino.criarBarco(this.getTabuleiro());
		this.fragata.criarBarco(this.getTabuleiro());
		this.destroyer.criarBarco(this.getTabuleiro());
		
	}
	
	/*
	 *  Mostrando o tabuleiro com condições onde 
	 * ~ é agua e sem navio, * é um tiro onde não tem navio(errou)
	 *  e X é tiro onde tem navio(acertou)
	 */
	public void mostraTabuleiro() {
		for(int linha = 0; linha < 10; linha++) {
			for(int coluna = 0; coluna < 10; coluna++) {
				//Agua ou Navio
				/*CORVETA = 1;
				SUBMARINO = 2;
				FRAGATA = 3;
				DESTROYER = 4;*/
				if(tabuleiro[linha][coluna] >= 0 && tabuleiro[linha][coluna] <= 4) {
					System.out.print(" ~ ");
				//Tiro atingido na agua
				} else if(tabuleiro[linha][coluna] == -1) {
					System.out.print(" * ");
				//Tiro atingido em navio
				} else if(tabuleiro[linha][coluna] == -2) {
					System.out.print(" X ");
				}
				
			}			
			System.out.println();
		}		
	}
}
