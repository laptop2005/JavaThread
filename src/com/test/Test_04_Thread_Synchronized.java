package com.test;

public class Test_04_Thread_Synchronized extends Thread{

	public Account account;
	
	public Test_04_Thread_Synchronized(Account account){
		this.account = account;
	}
	
	public void run() {		
		for(int inx=0;inx<10;inx++){
			int withdrawAmt = (int)(Math.random()*3 + 1)*1000;	
			this.account.withdraw(this.getName(),withdrawAmt);	
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		Account account = new Account();
		Test_04_Thread_Synchronized t1 = new Test_04_Thread_Synchronized(account);
		Test_04_Thread_Synchronized t2 = new Test_04_Thread_Synchronized(account);
		
		t1.start();
		t2.start();
	}

}
