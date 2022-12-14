package application;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
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
					System.out.println("O jogo foi encerrado.");
					sc.close();
					return;
				}
				jogador.getTabuleiro().mostraTabuleiro();			
						
			}while(!jogador.verificaSeAfundou());			
			System.out.println("A partida acabou.");
			
			resposta = ' ';
			while(resposta != 'N' && resposta != 'S') {
				System.out.println("Voce deseja parar de jogar? [S/N]: ");
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
		
		try {
			PrintStream arquivo = new PrintStream(new FileOutputStream("ranking.txt"));
			int cont = 1;
			arquivo.append("RANKING DE PONTUACAO:\n");
			for(int i = 0; i <= 2; i++) {
				String valorDeRanking = jogador.getListaDeRankings().get(i).toString();
				arquivo.append(cont + ": " + valorDeRanking + "\n");
				cont++;
			}
			arquivo.close();
		}		
		catch(FileNotFoundException e) {
			System.out.println("Erro de arquivo.");
		}
		
		sc.close();
		System.out.println("O jogo foi encerrado.");
	}
}
