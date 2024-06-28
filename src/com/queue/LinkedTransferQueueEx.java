package com.queue;

import java.util.concurrent.LinkedTransferQueue;

public class LinkedTransferQueueEx {

	
		public static void main(String[] args) throws InterruptedException
		{
			LinkedTransferQueue<String> transferQueue = new LinkedTransferQueue<>();

			// Adding elements to the transfer queue
			transferQueue.put("Pizza");
			transferQueue.put("Burger");
			transferQueue.put("Choclate");

			// Transferring elements between threads
			new Thread(() -> {
				try {
					String str = transferQueue.take();
					System.out.println("Consumed item in Thread 1: " + str);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}).start();

			transferQueue.transfer("Ice-Cream");

			new Thread(() -> {
				try {
					String str = transferQueue.take();
					System.out.println("Consumed item in Thread 2: " + str);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}).start();
		}
	}


