package _04_Thread_Pool;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import _04_Thread_Pool.ThreadPool;
//   A Thread Pool is a way of managing multiple threads with multiple workloads.
//   It works by collecting a list of tasks to be performed by a thread.
//   A pool of threads is then created, and each thread takes a task from the list and does that work.
//   This continues until all the tasks are done.
//   When all the tasks are complete, the thread pool has finished its job.
//   This test will use a Thread pool to convert a large amount of lower case characters to upper case

//1. Fill in the ThreadPool and Worker classes and the Task interface according to the Thread Pool UML Diagram.

public class ThreadPoolTest {

	@Test
	public void test() {
		int total = 16; //536870912;
		
		ThreadPool tp = new ThreadPool(4);
		char[] chars = new char[total];
		
		for(int i = 0; i < total; i++){
			chars[i] = (char)(new Random().nextInt(25) + 97);
		}
				
		int count = (int) Math.sqrt(total);
		
		
		
		for(int i = 0; i < count; i++){
			
			int x = i * count;
			tp.addTask(()->{
				for(int j = 0; j < count; j++){
					chars[x + j] = Character.toUpperCase(chars[x + j]);
				}
			});
		}

		long start = System.currentTimeMillis();
		
		tp.start();
		
		long end = System.currentTimeMillis() - start;
		System.out.println("Total time: " + end);
		
		for(char c : chars){
			assertTrue(Character.isUpperCase(c));
		}	
	}
}
