package controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import entities.Tabuleiro;

public class Jogador {
	
	int linha, coluna;		
	Tabuleiro tabuleiro;
	Scanner sc = new Scanner(System.in);
	
	public Jogador() {
		this.tabuleiro = new Tabuleiro();
	}
	
	public void iniciarPartida() {
		tabuleiro.criaTabuleiro();
		tabuleiro.criarBarcoEmTabuleiro();
		tabuleiro.mostraTabuleiro();
	}
	/*public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}*/

	public void pegaTiros() {
		boolean var = true;		
		while(var) {	
			try {				
				System.out.println("Digite a linha e coluna em que quer atacar[entre 0 e 9], respectivamente:"); 
				System.out.print("Linha: ");
				linha = sc.nextInt();
				System.out.print("Coluna: ");
				coluna = sc.nextInt();
				var = false;
			}
			catch(InputMismatchException e) {
				System.out.println("Tipo invalido. Adicione apenas numeros inteiros.");
				sc.nextLine();
				var = true;
			}
		}
		System.out.println("Linha " + linha + " e " + coluna );
		System.out.println("ACABOU.");
	}	

}
