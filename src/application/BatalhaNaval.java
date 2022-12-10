package application;

import java.util.Scanner;

import controller.Jogador;

public class BatalhaNaval {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	
		Jogador jogador = new Jogador();
		char resposta;
				
		jogador.iniciarPartida();
		jogador.getTabuleiro().mostraTabuleiro();
		
		do {	
			
			jogador.pegaTiros();
			jogador.getTabuleiro().mostraTabuleiro();
			if(jogador.verificaSeAfundou()) {
				break;
			}			
			
			resposta = ' ';			
			while(resposta != 'N' && resposta != 'S') {
				System.out.println("Você deseja parar de jogar? [S/N]: ");
				try {				
					resposta = sc.nextLine().toUpperCase().charAt(0);
				}
				catch(StringIndexOutOfBoundsException e) {
					System.out.println("Digite uma resposta.");
				}
			}			
		}while(resposta == 'N');
		
		sc.close();		
		System.out.println("O jogo acabou.");
	}
}
