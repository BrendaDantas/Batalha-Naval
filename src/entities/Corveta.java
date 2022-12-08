package entities;

import java.util.Random;

public class Corveta extends Barco {

	@Override
	public int[][] criarBarco(int[][] tabuleiro) {
		Random sorteio = new Random();
		
		boolean var = true;
		
		while(var) {
			
			int linha = sorteio.nextInt(10);
			int coluna = sorteio.nextInt(10);
			int direcao = sorteio.nextInt(4);

			if(tabuleiro[linha][coluna] == 0) {
				switch(direcao) {
				case 1:				
					if(linha != 0 && tabuleiro[linha-1][coluna] == 0) {
						tabuleiro[linha][coluna] = 1;
						tabuleiro[linha-1][coluna] = 1;
						this.setPos_inicialX(linha);
						this.setPos_inicialY(coluna);
						this.setDirecao(direcao);
						var = false;
					}				
					break;
				case 2:
					if(coluna != 9 && tabuleiro[linha][coluna+1] == 0) {
						tabuleiro[linha][coluna] = 1;
						tabuleiro[linha][coluna+1] = 1;
						this.setPos_inicialX(linha);
						this.setPos_inicialY(coluna);
						this.setDirecao(direcao);
						var = false;
					}		
					break;
				case 3:
					if(linha != 9 && tabuleiro[linha+1][coluna] == 0) {
						tabuleiro[linha][coluna] = 1;
						tabuleiro[linha+1][coluna] = 1;
						this.setPos_inicialX(linha);
						this.setPos_inicialY(coluna);
						this.setDirecao(direcao);
						var = false;
					}			
					break;
				case 4:
					if(coluna != 0 && tabuleiro[linha][coluna-1] == 0) {
						tabuleiro[linha][coluna] = 1;
						tabuleiro[linha][coluna-1] = 1;
						this.setPos_inicialX(linha);
						this.setPos_inicialY(coluna);
						this.setDirecao(direcao);
						var = false;
					}
					break;
				}
			}	
		}
		return tabuleiro;
	}		

	@Override
	public boolean verificaSeAfundou(int[][] tabuleiro) {
		
		return false;
	}

}
