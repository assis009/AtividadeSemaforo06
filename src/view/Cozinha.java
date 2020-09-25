package view;

import java.util.concurrent.Semaphore;

import controller.ThreadPratos;

public class Cozinha {

	public static void main(String[] args) {
		int permissao =1;// permissão para o semaforo
		
		Semaphore semaforo = new Semaphore(permissao);
		
		for(int i =0; i<5; i++){
			Thread prato = new ThreadPratos(i, semaforo);
			prato.start();
		}
			

	}

}
