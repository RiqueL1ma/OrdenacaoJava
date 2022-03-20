package control;

import java.util.Random;

public class controller {

	public static int[] criarVetor(int tamanhoVetor) {
		Random random = new Random();
		int vetor[] = new int[tamanhoVetor];
		for (int i = 0; i < tamanhoVetor; i++) {
			vetor[i] = random.nextInt(100);
		}
		return vetor;
	}

	@SuppressWarnings("rawtypes")
	public static Comparable[] convertToComparable(int[] vet) {
		Integer[] vetComp = new Integer[vet.length];
		int x = 0;
		for (int i : vet) {
			vetComp[x] = i;
			x++;
		}
		return vetComp;
	}

	// insertion

	public static void insertionSort(int[] vetor) {
		long inicial = System.nanoTime();
		int j;
		int key;
		int i;
		for (j = 1; j < vetor.length; j++) {
			key = vetor[j];
			for (i = j - 1; (i >= 0) && (vetor[i] > key); i--) {
				vetor[i + 1] = vetor[i];
			}
			vetor[i + 1] = key;
		}
		long tempoFinal = System.nanoTime();
		long total = tempoFinal - inicial;
		System.out.println("tempo insertion: " + total);

	}

	// bubble
	public static void bubbleSort(int[] vetor) {
		long inicial = System.nanoTime();
		boolean troca = true;
		int aux;
		while (troca) {
			troca = false;
			for (int i = 0; i < vetor.length - 1; i++) {
				if (vetor[i] > vetor[i + 1]) {
					aux = vetor[i];
					vetor[i] = vetor[i + 1];
					vetor[i + 1] = aux;
					troca = true;
				}
			}
		}
		long tempoFinal = System.nanoTime();
		long total = tempoFinal - inicial;
		System.out.println("tempo bubble sort: " + total);
		
	}

	// quick
	public static void quickSort(int[] vetor) {
		
		quickSort(vetor, 0, vetor.length - 1);
	}

	private static void quickSort(int[] vetor, int inicio, int fim) {
		if (inicio < fim) {
			int posicaoPivo = separar(vetor, inicio, fim);
			quickSort(vetor, inicio, posicaoPivo - 1);
			quickSort(vetor, posicaoPivo + 1, fim);
		}
	}

	private static int separar(int[] vetor, int inicio, int fim) {
		int pivo = vetor[inicio];
		int i = inicio + 1, f = fim;
		while (i <= f) {
			if (vetor[i] <= pivo)
				i++;
			else if (pivo < vetor[f])
				f--;
			else {
				int troca = vetor[i];
				vetor[i] = vetor[f];
				vetor[f] = troca;
				i++;
				f--;
			}

		}
		vetor[inicio] = vetor[f];
		vetor[f] = pivo;
		return f;
	}

	// merge
	public static void mergeSort(Comparable[] a) {
		Comparable[] tmpArry = new Comparable[a.length];
		mergeSort(a, tmpArry, 0, a.length - 1);
	}

	private static void mergeSort(Comparable[] a, Comparable[] tmpArry, int left, int right) {

		if (left < right) {

			int center = (left + right) / 2;
			mergeSort(a, tmpArry, left, center);
			mergeSort(a, tmpArry, center + 1, right);
			merge(a, tmpArry, left, center + 1, right);
		}
	}

	private static void merge(Comparable[] a, Comparable[] tmpArray, int leftPos, int rightPos, int rightEnd) {
		int leftEnd = rightPos - 1;
		int tmpPos = leftPos;
		int numElements = rightEnd - leftPos + 1;

		while (leftPos <= leftEnd && rightPos <= rightEnd) {
			if (a[leftPos].compareTo(a[rightPos]) <= 0) {
				tmpArray[tmpPos++] = a[leftPos++];
			} else {
				tmpArray[tmpPos++] = a[rightPos++];
			}

		}

		while (leftPos <= leftEnd) {
			tmpArray[tmpPos++] = a[leftPos++];
		}

		while (rightPos <= rightEnd) {
			tmpArray[tmpPos++] = a[rightPos++];
		}

		for (int i = 0; i < numElements; i++, rightEnd--) {
			a[rightEnd] = tmpArray[rightEnd];

		}

	}

}
