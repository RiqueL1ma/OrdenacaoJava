package view;

import control.controller;
import control.mergeEx;

public class Principal {

	public static void main(String[] args) {
		
		controller m = new controller();
		mergeEx m1 = new mergeEx();
		
		int[] vetor = controller.criarVetor(200000);
		
		m.insertionSort(vetor);
		
		m.bubbleSort(vetor);
		
		long tempoInicialMerge = System.nanoTime();
		m1.mergeSort(m.convertToComparable(vetor));
		long tempoFinal = System.nanoTime();
		long tempoTotal = tempoFinal - tempoInicialMerge;
		System.out.println("Tempo Merge: " + tempoTotal);
		
		long tempoInicialQuick = System.nanoTime();
		m.quickSort(vetor);
		long tempoFinalQuick = System.nanoTime();
		long tempoTotalQuick = tempoFinalQuick - tempoInicialQuick;
		System.out.println("Tempo Quick: " + tempoTotalQuick);
		
	}

}
