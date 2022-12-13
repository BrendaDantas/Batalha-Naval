package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entities.Tabuleiro;

public class Jogador {
			
	List<Integer> listaDeRankings = new ArrayList<>();
	int contador = 0;
	Tabuleiro tabuleiro;	
	boolean teste = false;
	Scanner sc = new Scanner(System.in);
	
	public Jogador() {
		this.tabuleiro = new Tabuleiro();
	}	
	
	public List<Integer> getListaDeRankings() {
		return listaDeRankings;
	}

	public void setListaDeRankings(List<Integer> listaDeRankings) {
		this.listaDeRankings = listaDeRankings;
	}

	public int getContador() {
		return contador;
	}
	
	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public void iniciarPartida() {
		this.listaDeRankings.add(0);
		this.listaDeRankings.add(0);
		this.listaDeRankings.add(0);
		tabuleiro.criaTabuleiro();
		tabuleiro.criarBarcoEmTabuleiro();
		tabuleiro.mostraTabuleiro();
	}

	public boolean pegaTiros() {	
		boolean var = true;			
		while(var) {				
			try {				
				System.out.println("Digite a linha e coluna em que quer atacar[entre 0 e 9]. \nPara ENCERRAR o jogo a qualquer momento, basta digitar -3 "); 
				System.out.print("Linha: ");
				int linha = sc.nextInt();
				if(linha == -3) {
					sc.close();
					return false;
				}
				System.out.print("Coluna: ");
				int coluna = sc.nextInt();
				if(coluna == -3) {
					sc.close();
					return false;
				}								
				//Verifica se o tiro foi na agua, já teve ou navio				
				if(this.tabuleiro.getTabuleiro()[linha][coluna] == -1 || this.tabuleiro.getTabuleiro()[linha][coluna] == -2) {
					System.out.println("Posicao ja foi atirada anteriormente.");
					var = true;
				} else if (this.tabuleiro.getTabuleiro()[linha][coluna] > 0 && this.tabuleiro.getTabuleiro()[linha][coluna] <= 4) {
					this.tabuleiro.getTabuleiro()[linha][coluna] = -2;
					System.out.println("Navio atingido.");
					var = false;
				} else if(this.tabuleiro.getTabuleiro()[linha][coluna] == 0) {
					this.tabuleiro.getTabuleiro()[linha][coluna] = -1;
					System.out.println("Agua atingida");
					var = false;
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Tipo invalido. Adicione apenas numeros inteiros.");
				sc.nextLine();
				var = true;
			}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Posicao invalida. Tente novamente.");
				sc.nextLine();
				var = true;
			}			
		}
		contador++;		
		return true;		
	}	
	
	public boolean verificaSeAfundou() {
		int aux = 0;
		
		if(this.tabuleiro.getCorveta().verificaSeAfundou(this.tabuleiro.getTabuleiro())) {
			aux++;
			System.out.println("O corveta afundou.");
		}
		if(this.tabuleiro.getSubmarino().verificaSeAfundou(this.tabuleiro.getTabuleiro())) {
			aux++;
			System.out.println("O submarino afundou.");
		}
		if(this.tabuleiro.getFragata().verificaSeAfundou(this.tabuleiro.getTabuleiro())) {
			aux++;
			System.out.println("A fragata afundou.");
		}
		if(this.tabuleiro.getDestroyer().verificaSeAfundou(this.tabuleiro.getTabuleiro())) {
			aux++;
			System.out.println("O destroyer afundou.");
		}
		if(aux == 4) {	
			System.out.println("Todos os navios foram afundados.");	
			this.rankingDeResultado();			
			return true;
		}		
		return false;
	}
	
	public void rankingDeResultado() {
		this.listaDeRankings.add(contador);
		Collections.sort(listaDeRankings);
		this.listaDeRankings = new ArrayList<Integer>(listaDeRankings.subList(listaDeRankings.size()-3, listaDeRankings.size()));
	}

}
