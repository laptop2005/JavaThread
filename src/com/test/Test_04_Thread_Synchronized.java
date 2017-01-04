package com.test;

public class Test_04_Thread_Synchronized extends Thread{
	
	public void run() {		
		for(int inx=0;inx<10;inx++){
			int withdrawAmt = (int)(Math.random()*3 + 1)*1000;	
			Account.withdraw(this.getName(),withdrawAmt);	
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		Test_04_Thread_Synchronized t1 = new Test_04_Thread_Synchronized();
		Test_04_Thread_Synchronized t2 = new Test_04_Thread_Synchronized();
		
		t1.start();
		t2.start();
	}

}
