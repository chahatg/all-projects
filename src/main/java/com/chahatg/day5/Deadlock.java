package com.chahatg.day5;

public class Deadlock {
	public static Object ob1 = new Object();
	public static Object ob2 = new Object();
	
	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		Thread t2 = new Thread2();
		
		t1.start();
		t2.start();
		
	}
	
	private static class Thread1 extends Thread{
		
		/************deadlock implementation********
		public void run() {
			synchronized (ob1) {
				System.out.println("Thread 1: Acquiring lock for ob1");
				try {
					Thread.sleep(100);
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread 1: Waiting for lock for ob2");
				synchronized (ob2) {
					System.out.println(("Thread1: Aqcuirin lock for ob1 and ob2")); //will never reach hear because ob1 is 
																					//waiting for ob2 and ob2 is waiting for ob1
				}
			}
		}
		*/
		/************deadlock situation solution**********/
		public void run() {
			synchronized (ob1) {
				System.out.println("Thread 1: Acquiring lock for ob1");
				try {
					Thread.sleep(100);
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread 1: Waiting for lock for ob2");
				synchronized (ob2) {
					System.out.println(("Thread 1: Aqcuirin lock for ob1 and ob2"));
				}
			}
		}

	}

	private static class Thread2 extends Thread{
		/************deadlock implementation*********
		public void run() {
			synchronized (ob2) {
				System.out.println("Thread 2: Acquiring lock for ob2");
				try {
					Thread.sleep(100);
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread 2: Waiting for lock for ob1");
				synchronized (ob1) {
					System.out.println("Thread 2: Acquiring lock for ob1 and ob2");//will never reach hear because ob1 is 
																					//waiting for ob2 and ob2 is waiting for ob1
				}
			}
			
		}*/
		
		
		/************deadlock situation solution**********/
		public void run() {
			synchronized (ob1) {
				System.out.println("Thread 2: Acquiring lock for ob1");
				try {
					Thread.sleep(100);
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread 2: Waiting for lock for ob2");
				synchronized (ob2) {
					System.out.println(("Thread 2: Aqcuirin lock for ob1 and ob2"));
				}
			}
		}
				
	}
}



