package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadPool {
	
	Thread[] threads;
	ConcurrentLinkedQueue<Task> taskQueue;
	
	public ThreadPool(int totalThreads) {
	threads = new Thread[totalThreads];
	
	taskQueue = new ConcurrentLinkedQueue<Task>();
		
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new Worker(taskQueue));
		}
	}

	void addTask(Task task) {
		taskQueue.add(task);
	}
	
	void start() {
		for (int i = 0; i < threads.length; i++) {
				threads[i].start();
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}