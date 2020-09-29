package main;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
    	for(int i = 1; i <= 10; i++) {
    		long inicio = System.currentTimeMillis();
    		principal();
    		long fim = System.currentTimeMillis();
    		
    		System.out.println(String.format("Iteração: %s\n"
    				+ "Tempo de execução: %sms\n"
    				+ "-=-=-=-=-\n\n", i, (fim-inicio)));
    	}
    }
    
    public static void principal() {
    	Random r = new Random();
    	int indice = r.nextInt(400);
    	
    	int[] vetor = new int[400];
    	for(int i = 0; i < 400; i++) {
    		vetor[i] = r.nextInt();
    	}
    	
    	insertionSort(vetor);
    	
    	int output = pesquisaBinaria(vetor, vetor[indice], vetor.length);
    	System.out.println(String.format("Número encontrado no índice: %s\n"
    			+ "Índice gerado: %s\n"
    			+ "Número encontrado no índice: %s\n", output, indice, vetor[indice]));
    }
    
    public static int pesquisaBinaria(int vet[], int chave, int Tam) {
    	int inf = 0;
    	int sup = Tam-1;
    	int indice;
    	int qtdLoop = 0;
    	
    	while(inf <= sup) {
    		qtdLoop++;
    		indice = (inf + sup) / 2;
    		
    		if (chave == vet[indice]) {
    			System.out.println("Quantidade de buscas: " + qtdLoop);
    			return indice;
    		}
    		if (chave < vet[indice]) sup = indice-1;
    		else inf = indice + 1;
    	}
    	return -1;
    }
    
    public static void insertionSort(int[] vetor) {
        int j;
        int key;
        int i;

        for (j = 1; j < vetor.length; j++)
        {
          key = vetor[j];
          for (i = j - 1; (i >= 0) && (vetor[i] > key); i--)
          {
             vetor[i + 1] = vetor[i];
           }
            vetor[i + 1] = key;
        }
    }
}