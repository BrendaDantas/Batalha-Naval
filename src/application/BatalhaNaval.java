package application;

import java.util.Scanner;

import controller.Jogador;
import entities.Tabuleiro;

public class BatalhaNaval {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	
		Jogador jogador = new Jogador();
		char resposta;
		
		jogador.iniciarPartida();
		//jogador.pegaTiros();
		jogador.getTabuleiro().mostraTabuleiro();
		
		
		do {		
			jogador.pegaTiros();
			jogador.getTabuleiro().mostraTabuleiro();
			jogador.verificaSeAfundou();
			
			System.out.println("Você deseja parar de jogar? [S/N]");
			resposta = sc.nextLine().toUpperCase().charAt(0);
		}while(resposta == 'N');
		
		System.out.println("O jogo acabou.");
	}

}
