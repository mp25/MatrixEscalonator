package MatrixEscalonator.Principal.com;

import java.io.FileNotFoundException;
import java.util.Scanner;

import MatrixEscalonator.LerArquivo.com.LerArquivo;
import MatrixEscalonator.Tratamento.com.Escalonador;

public class Principal {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LerArquivo lerArquivo = new LerArquivo("Matriz.txt","MatrizOutput.txt");
		int linhas;
		int colunas;
		
		
		System.out.println("Define as dimensões da matriz a ser escalonada");
		System.out.println("Quantidade de Linhas: ");
		linhas = scan.nextInt();
		System.out.println("Quantidade de Colunas: ");
		colunas = scan.nextInt();
		
		Escalonador escalonador = new Escalonador(linhas,colunas);
		
		try {
			lerArquivo.LeArquivo();
			escalonador.EscalonarMatriz();
			escalonador.EscalonarMatriz();
			
			} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		
		
	}

}
