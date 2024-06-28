package com.queue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueEx
{
	public static void main(String[] args)
	{
		ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

		// Adding elements to the queue
		queue.offer("Pizza");
		queue.offer("Burger");
		queue.offer("choclate");

		// Removing elements from the queue
		String str1 = queue.poll(); // Removes and returns the head of the queue
		String str2 = queue.peek(); // Retrieves but does not remove the head of the queue

		System.out.println("Removed element: " + str1);
		System.out.println("Peeked element: " + str2);
	}
}
