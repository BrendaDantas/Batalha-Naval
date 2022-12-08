package entities;

import java.util.Random;

public class Submarino extends Barco {
	
	private int pos_umX;
	private int pos_doisX;
	private int pos_umY;
	private int pos_doisY;
	
	public int getPos_umX() {
		return pos_umX;
	}

	public void setPos_umX(int pos_umX) {
		this.pos_umX = pos_umX;
	}

	public int getPos_doisX() {
		return pos_doisX;
	}

	public void setPos_doisX(int pos_doisX) {
		this.pos_doisX = pos_doisX;
	}

	public int getPos_umY() {
		return pos_umY;
	}

	public void setPos_umY(int pos_umY) {
		this.pos_umY = pos_umY;
	}

	public int getPos_doisY() {
		return pos_doisY;
	}

	public void setPos_doisY(int pos_doisY) {
		this.pos_doisY = pos_doisY;
	}

	@Override
	public int[][] criarBarco(int[][] tabuleiro) {		
		Random sorteio = new Random();		
		boolean var = true;
		
		while(var) {
			
			int linha = sorteio.nextInt(10);
			int coluna = sorteio.nextInt(10);
			int direcao = sorteio.nextInt(4);

			if(tabuleiro[linha][coluna] == 0) {
				//boolean teste = false;
				int cont = 0, aux = 1;
				switch(direcao) {	
				case 0:		
					System.out.println("Caso Cima");
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
						for(int i = 0; i < 3; i++) {							
							tabuleiro[linha-i][coluna] = 4;
						}
						var = false;
					} else {
						break;
					}
					break;
				case 1:
					System.out.println("Caso lado Direito");
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
						for(int i = 0; i < 3; i++) {							
							tabuleiro[linha][coluna+i] = 1;
						}						
						var = false;
					} else {
						break;
					}
					break;
					
				case 2:
					System.out.println("Caso Baixo");
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
						for(int i = 0; i < 3; i++) {							
							tabuleiro[linha+i][coluna] = 2;
						}
						var = false;
					} else {
						break;
					}
					break;
				case 3:
					System.out.println("Caso lado Esquerdo");
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
		// TODO Auto-generated method stub
		return false;
	}

}
