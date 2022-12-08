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
				int cont = 0, aux = 1;
				switch(direcao) {	
				case 0:		
					while(cont < 3) {
						if(tabuleiro[linha-cont][coluna] == 0 && linha-cont > 0) {											
							aux++;
							cont++;
						} else {
							aux = 0;
							break;
						}									
					}
					if(aux == 4) {
						this.setPos_inicialX(linha);
						this.setPos_inicialY(coluna);
						this.setDirecao(direcao);
						for(int i = 0; i < 3; i++) {							
							tabuleiro[linha-i][coluna] = 2;
						}
						var = false;
					} else {
						break;
					}
					break;
					
				case 1:
					while(cont < 3) {
						if(tabuleiro[linha][coluna+cont] == 0 && coluna+cont < 9) {
							aux++;
							cont++;
						} else {
							aux = 0;
							break;
						}						
					}
					if(aux == 4) {
						this.setPos_inicialX(linha);						
						this.setPos_inicialY(coluna);
						this.setDirecao(direcao);
						for(int i = 0; i < 3; i++) {							
							tabuleiro[linha][coluna+i] = 2;
						}						
						var = false;
					} else {
						break;
					}
					break;
					
				case 2:
					while(cont < 3) {
						if(tabuleiro[linha+cont][coluna] == 0 && linha+cont < 9) {							
							aux++;
							cont++;
						} else {
							aux = 0;
							break;
						}						
					}
					if(aux == 4) {
						this.setPos_inicialX(linha);						
						this.setPos_inicialY(coluna);
						this.setDirecao(direcao);
						for(int i = 0; i < 3; i++) {							
							tabuleiro[linha+i][coluna] = 2;
						}
						var = false;
					} else {
						break;
					}
					break;
				case 3:
					while(cont < 3) {
						if(tabuleiro[linha][coluna-cont] == 0 && coluna-cont > 0) {							
							aux++;
							cont++;
						} else {
							aux = 0;
							break;
						}						
					}
					if(aux == 4) {
						this.setPos_inicialX(linha);						
						this.setPos_inicialY(coluna);
						this.setDirecao(direcao);
						for(int i = 0; i < 3; i++) {							
							tabuleiro[linha][coluna-i] = 2;
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
		switch(this.getDirecao()) {
		//Para cima
		case 0:
			for(int i = 0; i < 3; i++) {
				if(tabuleiro[this.getPos_inicialX()-i][this.getPos_inicialY()] == 2) {
					return false;
				}
			}
			return true;
		//Para direita	
		case 1:
			for(int i = 0; i < 3; i++) {
				if(tabuleiro[this.getPos_inicialX()][this.getPos_inicialY()+i] == 2) {
					return false;
				}
			}
			return true;
		//Para baixo
		case 2:
			for(int i = 0; i < 3; i++) {
				if(tabuleiro[this.getPos_inicialX()+i][this.getPos_inicialY()] == 2) {
					return false;
				}
			}
			return true;
		//Para esquerda
		case 3:
			for(int i = 0; i < 3; i++) {
				if(tabuleiro[this.getPos_inicialX()][this.getPos_inicialY()-i] == 2) {
					return false;
				}
			}
			return true;			
		}
		return false;
	}
}
