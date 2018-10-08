package ru.lanit.client;

import ru.lanit.warehouse.WhQueue;

public class Customer extends Thread {
	
	private WhQueue q;
	private int fin_id;
	
	public Customer(WhQueue q, int fin_id){
		this.q = q;
		this.fin_id = fin_id;
	}
	
	public void run(){
		for(int id =1; id<=fin_id;id++){
			int qnt = (int)Math.round(Math.random()*20);
			q.writeQ(id,qnt);
			System.out.println("Put: ID "+id+", Quantity "+qnt);
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		
		//Это сигнал завершения
		q.writeQ(-1, -1);
	}
	
}
