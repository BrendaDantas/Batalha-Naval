package entities;

public abstract class Barco implements AnalisandoBarco {
	private int pos_inicialX;
	private int pos_inicialY;	
	private int direcao;
	
	public Barco() {
	}

	public int getPos_inicialX() {
		return pos_inicialX;
	}

	public void setPos_inicialX(int pos_inicialX) {
		this.pos_inicialX = pos_inicialX;
	}

	public int getPos_inicialY() {
		return pos_inicialY;
	}

	public void setPos_inicialY(int pos_inicialY) {
		this.pos_inicialY = pos_inicialY;
	}
	
	public int getDirecao() {
		return direcao;
	}

	public void setDirecao(int direcao) {
		this.direcao = direcao;
	}	

}
