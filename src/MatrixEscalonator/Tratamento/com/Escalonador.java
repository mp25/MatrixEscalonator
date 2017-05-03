package MatrixEscalonator.Tratamento.com;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import MatrixEscalonator.LerArquivo.com.LerArquivo;

public class Escalonador {

	public static double[][] matriz;/* = {{1,1,1,7},{2,1,-1,9},{1,-2,2,2}}; */
	public static int[] vet;
	public static int linhas;
	public static int colunas;
	public static int cont = 0;

	public Escalonador() {
		// TODO Auto-generated constructor stub
	}

	public Escalonador(int linhas, int colunas) {
		this.linhas = linhas;
		this.colunas = colunas;
		matriz = new double[linhas][colunas];
		vet = new int[colunas * linhas];
	}

	public static double[][] ConverteArqXMatriz() {
		int cont = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {

				matriz[i][j] = vet[cont++];
			}
		}

		// EscalonarMatriz();
		
		return matriz;
	}

	public void EscalonarMatriz() {
		matriz = ordenaMatriz(matriz);
		double coef = 0.0;
		int col = -1;
		int linha = -1;
		
		//for que encontra a linha principal
		for (int i = 0; i < matriz.length; i++) {
			
			//for que encontra algarismo sem 0 (zero)
			for (int j = 0; j < matriz.length; j++) {
				
				if(matriz[i][j] != 0){
					col = j;
					//for que encontra linha secundária
					for (int k = 0; k < matriz.length; k++) {
						if(matriz[k][col] != 0 && i != k ){
							linha = k;
//							double a = Math.floor(matriz[linha][col]);
//							double b = Math.floor(matriz[i][col]);
							double a = arredondaNumbero(matriz[linha][col]);
							double b = arredondaNumbero(matriz[i][col]);
							coef = a/b;
							//for que percorre a linha secundária escalonando com a linha principal
							for (int l = 0; l < matriz[i].length; l++) {
//								double x = Math.floor(matriz[linha][l]);
//								double y = Math.floor(matriz[i][l]);
								double x  = arredondaNumbero(matriz[linha][l]);
								double y = arredondaNumbero(matriz[i][l]);
								matriz[linha][l] = x - y * coef;
							}
						}

					}
				}
			}
			try {
				LerArquivo.gravarArquivo(matriz);
				cont++;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	public static double arredondaNumbero(double num){
		
		BigDecimal bd = new BigDecimal(num).setScale(4, RoundingMode.HALF_EVEN);
		num = bd.doubleValue();
		return num;
		
	}

	public static double[][] ordenaMatriz(double[][] mat) {
		int valorAtual = 0;
		int linha = 0;
		int valorAnt = 0;
		int cont = 0;
		boolean flag = false;
		double[] vetAtual = new double[mat.length];
		double[] vetPost = new double[mat.length];
		
		for (int k = 0; k < mat.length -1; k++) {
			linha = k;
			for (int i = k; i < mat.length; i++) {
				
				for (int j = 0; j < mat.length; j++) {
					if (mat[i][j] == 0){
						valorAtual++;
					}
			
				}
				if(valorAnt < valorAtual){
					valorAnt = valorAtual;
					linha = i;
				}
				valorAtual = 0;
			}
			valorAnt = 0;
			vetAtual = mat[linha];
			mat[linha] = mat[k];
			mat[k] = vetAtual; 
		}
		
		return mat;

	}

}
