package com.queue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayqueueEx
{
		static class DelayedElement implements Delayed
		{
			private String name;
			private long delayTime;

			DelayedElement(String name, long delayTime)
			{
				this.name = name;
				this.delayTime = System.currentTimeMillis() + delayTime;
			}

			public long getDelay(TimeUnit unit) 
			{
				long diff = delayTime - System.currentTimeMillis();
				return unit.convert(diff, TimeUnit.MILLISECONDS);
			}

			@Override
			public int compareTo(Delayed o)
			{
				long diff = this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS);
				return Long.compare(diff, 0);
			}

			@Override
			public String toString() 
			{
				return "DelayedElement{" + "name='" + name + '\'' + ", delayTime=" + delayTime + '}';
			}

			
		}

		public static void main(String[] args) throws InterruptedException
		{
			DelayQueue<DelayedElement> delayQueue = new DelayQueue<>();

			// Adding delayed elements to the queue
			delayQueue.put(new DelayedElement("Element first", 3000));
			delayQueue.put(new DelayedElement("Element second", 2000));
			delayQueue.put(new DelayedElement("Element third", 3000));

			// Retrieving elements from the queue after their delay time
			System.out.println("DelayQueue elements:");
			while (!delayQueue.isEmpty()) {
				DelayedElement element = delayQueue.take();
				System.out.println(element);
			}
		}

	}


