package application;

import java.util.Scanner;

import controller.Jogador;

public class BatalhaNaval {

	public static void main(String[] args) {
			
		Jogador jogador = new Jogador();
		Scanner sc = new Scanner(System.in);
		boolean var = true;
		char resposta;
		
		
		while(var) {
			jogador.iniciarPartida();		
			do {			
				if(!jogador.pegaTiros()) {
					System.out.println(jogador.getContador() + " tiros.");
					System.out.println("O jogo foi encerrado.");
					return;
				}
				jogador.getTabuleiro().mostraTabuleiro();			
						
			}while(!jogador.verificaSeAfundou());
			System.out.println("A partida acabou.");
			
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
			if(resposta == 'S') {
				var = false;
			}
		}
		
		System.out.println(jogador.getContador() + " tiros.");
		System.out.println("O jogo foi encerrado.");
	}
}
