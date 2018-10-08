package ru.lanit.warehouse;

public class WarehouseQueue implements WhQueue {
	boolean info_in_q = false;
	private int ID;
	private int quantity;

	public synchronized void writeQ(int id, int qnt) {
		if (info_in_q) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		ID = id;
		quantity = qnt;
		info_in_q = true;

		notify();

	}

	public synchronized int[] readQ() {

		if (!info_in_q) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		info_in_q = false;
		notify();
		return new int[] { ID, quantity };

	}

}
