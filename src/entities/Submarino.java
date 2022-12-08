package entities;

import java.util.Random;

public class Submarino extends Barco {

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
					for(int i = 0; i < 3; i++) {
						if(linha != 0 && tabuleiro[linha-i][coluna] == 0) {
							tabuleiro[linha][coluna] = 2;
							tabuleiro[linha-i][coluna] = 2;
							this.setPos_inicialX(linha);
							this.setPos_inicialY(coluna);
							this.setDirecao(direcao);
							var = false;
						} else {
							var = true;
							break;
						}
					}	
									
					break;
				case 2:
					for(int i = 0; i < 3; i++) {
						if(coluna != 9 && tabuleiro[linha][coluna+i] == 0) {
							tabuleiro[linha][coluna] = 2;
							tabuleiro[linha][coluna+i] = 2;
							this.setPos_inicialX(linha);
							this.setPos_inicialY(coluna);
							this.setDirecao(direcao);
							var = false;
						} else {
							var = true;
							break;
						}
					}	
							
					break;
				case 3:
					for(int i = 0; i < 3; i++) {
						if(linha != 9 && tabuleiro[linha+i][coluna] == 0) {
							tabuleiro[linha][coluna] = 2;
							tabuleiro[linha+i][coluna] = 2;
							this.setPos_inicialX(linha);
							this.setPos_inicialY(coluna);
							this.setDirecao(direcao);
							var = false;
						} else {
							var = true;
							break;
						}
					}								
					break;
				case 4:
					for(int i = 0; i < 3; i++) {
						if(coluna != 0 && tabuleiro[linha][coluna-i] == 0) {
							tabuleiro[linha][coluna] = 2;
							tabuleiro[linha][coluna-i] = 2;
							this.setPos_inicialX(linha);
							this.setPos_inicialY(coluna);
							this.setDirecao(direcao);
							var = false;
						} else {
							var = true;
							break;
						}
					}					
					break;
				}
			}	
		}
		return tabuleiro;
	}		

	@Override
	public boolean verificaSeAfundou(int[][] tabuleiro) {
		// TODO Auto-generated method stub
		return false;
	}

}
