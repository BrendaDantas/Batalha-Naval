package entities;

import java.util.Random;

public class Fragata extends Barco {

	@Override
	public int[][] criarBarco(int[][] tabuleiro) {		
		Random sorteio = new Random();		
		boolean var = true;
		
		while(var) {
			
			int linha = sorteio.nextInt(10);
			int coluna = sorteio.nextInt(10);
			int direcao = sorteio.nextInt(4);

			if(tabuleiro[linha][coluna] == 0) {
				int cont = 0, aux = 1;
				switch(direcao) {	
				case 0:		
					while(cont < 4) {
						if(tabuleiro[linha-cont][coluna] == 0 && linha-cont > 0) {											
							aux++;
							cont++;
						} else {
							aux = 0;
							break;
						}									
					}
					if(aux == 5) {
						this.setPos_inicialX(linha);
						this.setPos_inicialY(coluna);
						this.setDirecao(direcao);
						for(int i = 0; i < 4; i++) {							
							tabuleiro[linha-i][coluna] = 3;
						}
						var = false;
					} else {
						break;
					}
					break;
					
				case 1:
					while(cont < 4) {
						if(tabuleiro[linha][coluna+cont] == 0 && coluna+cont < 9) {
							aux++;
							cont++;
						} else {
							aux = 0;
							break;
						}						
					}
					if(aux == 5) {
						this.setPos_inicialX(linha);						
						this.setPos_inicialY(coluna);
						this.setDirecao(direcao);
						for(int i = 0; i < 4; i++) {							
							tabuleiro[linha][coluna+i] = 3;
						}						
						var = false;
					} else {
						break;
					}
					break;
					
				case 2:
					while(cont < 4) {
						if(tabuleiro[linha+cont][coluna] == 0 && linha+cont < 9) {							
							aux++;
							cont++;
						} else {
							aux = 0;
							break;
						}						
					}
					if(aux == 5) {
						this.setPos_inicialX(linha);						
						this.setPos_inicialY(coluna);
						this.setDirecao(direcao);
						for(int i = 0; i < 4; i++) {							
							tabuleiro[linha+i][coluna] = 3;
						}
						var = false;
					} else {
						break;
					}
					break;
				case 3:
					while(cont < 4) {
						if(tabuleiro[linha][coluna-cont] == 0 && coluna-cont > 0) {							
							aux++;
							cont++;
						} else {
							aux = 0;
							break;
						}						
					}
					if(aux == 5) {
						this.setPos_inicialX(linha);						
						this.setPos_inicialY(coluna);
						this.setDirecao(direcao);
						for(int i = 0; i < 4; i++) {							
							tabuleiro[linha][coluna-i] = 3;
						}
						var = false;
					} else {
						break;
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
