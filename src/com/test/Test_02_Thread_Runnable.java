package com.test;

public class Test_02_Thread_Runnable implements Runnable{

	public String threadName;
	
	@Override
	public void run() {
		for(int inx=0;inx<=10;inx++){
			System.out.println(this.threadName+":"+inx);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Test_02_Thread_Runnable r1 = new Test_02_Thread_Runnable();
		Test_02_Thread_Runnable r2 = new Test_02_Thread_Runnable();
		Test_02_Thread_Runnable r3 = new Test_02_Thread_Runnable();
		r1.threadName = "Thread01";	
		r2.threadName = "Thread02";	
		r3.threadName = "Thread02";	
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r2);
		t1.start();
		t2.start();
		t3.start();
	}
}
