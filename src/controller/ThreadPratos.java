package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadPratos extends Thread {
	private int id;
	private Semaphore semaforo;
	
	public ThreadPratos(int id, Semaphore semaforo) {
		
		this.id = id;
		this.semaforo = semaforo;
		
	}
	
	
	public void run() {
		
		cozinhando();
//		--- seção critica ---- 
		finalizado();
		try {
			semaforo.acquire();
			entregando();
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}finally{
			semaforo.release();
		}
		
	}


	private void finalizado() {
		System.out.println("O prato #"+ id + " está finalizado");
		
	}


	private void cozinhando() {
		double tempo =0;
		double aux=0;
		double p=0;
		
		
		if(id%2 ==0){//verificando se id é impar ou par 
			System.out.println("A Lasanha Bolonhesa #"+id +" iniciou");// nomeando o prato 
			tempo =(int) ((Math.random()*201)+500);// definindo o tempo 
			while(aux<=tempo){// enquanto o auxiliar for menor que o tempo total ira somar 100 a aux
				aux+=100;
				p = (aux/tempo)*100;// pegando a porcentagem 
				System.out.println("A Lasanha Bolonhesa #"+id +" está "+ p +"%");// printando a porcentagem 
				try {
					sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			//lasanha
		}else{
			//sopa
			System.out.println("A sopa de cebola #"+id +" iniciou");// nomeando o prato 
			tempo =(int) ((Math.random()*701)+600);// definindo o tempo 
			
			while(aux<=tempo){
				aux+= 100; 
				p = (aux/tempo)*100;// pegando a porcentagem 
				System.out.println("A sopa de cebola #"+id +" está "+ p +"%");// printando a porcentagem 
				try {
					sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		
	}





	private void entregando() {
		
		System.err.println("O prato #"+id +" está sendo entregue");//avisando que o prato está sendo entregue 
		try {
			sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
