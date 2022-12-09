package application;

import java.util.Scanner;

import controller.Jogador;
import entities.Tabuleiro;

public class BatalhaNaval {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		
		Tabuleiro tabuleiro = new Tabuleiro();
		Jogador jogador = new Jogador();
		
		jogador.iniciarPartida();
		jogador.pegaTiros();
		jogador.getTabuleiro().mostraTabuleiro();
		
		System.out.println("Você deseja parar de jogar? [S/N]");
		char resposta = sc.nextLine().toUpperCase().charAt(0);
		
		System.out.println("Char: " + resposta);	
		
		while(resposta == 'S') {
			
		}
	}

}
