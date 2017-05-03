package MatrixEscalonator.LerArquivo.com;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Scanner;

import MatrixEscalonator.Tratamento.com.Escalonador;

import static MatrixEscalonator.Tratamento.com.Escalonador.*;

public class LerArquivo {

	private String caminho;
	private static String caminhoGravar;
	public LerArquivo(String caminho, String caminhoGravar) {
		this.caminho = caminho;
		LerArquivo.caminhoGravar = caminhoGravar;
	}

	public void LeArquivo() throws FileNotFoundException {
		Scanner scanner = new Scanner(new FileReader(caminho)).useDelimiter("\\;");
		int i = 0;
		while (scanner.hasNext()) {
			String linha = scanner.next();
			linha = linha.replaceAll("\r", ""); 
			linha = linha.replaceAll("\t", "");
			linha = linha.replaceAll("\n", "");
			
			if(linha.contains("-")){
				vet[i] = (int) Float.parseFloat(linha);
			}
			vet[i] = Integer.parseInt(linha);
			
			i++;
//			System.out.println(linha);
		}
		ConverteArqXMatriz();

	}
	
	public static void gravarArquivo(double[][] matriz) throws IOException{
		FileWriter arq = new FileWriter(caminhoGravar,true);
		PrintWriter gravarArq = new PrintWriter(arq);
		gravarArq.println("Passo: " + cont);
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				double a = matriz[i][j];
				gravarArq.print(a + " ");
			}
			gravarArq.println("");
		}
		gravarArq.println("");
		arq.close();
		
	}
	
	
	private void imprimeMatriz(double[][] matriz) {
		
		

	}
	
	


}
