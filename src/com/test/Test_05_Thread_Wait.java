package com.test;

public class Test_05_Thread_Wait extends Thread{
	public Account account;
	
	public Test_05_Thread_Wait(Account account){
		this.account = account;
	}
	
	public void run() {		
		for(int inx=0;inx<10;inx++){
			
			//입금출금 구분
			int withdrawDepositFlag = (int)(Math.random()*3); // 0또는 1 또는 2
			
			//입출금금액
			int withdrawAmt = (int)(Math.random()*3 + 1)*1000;
			
			if(withdrawDepositFlag==0 || withdrawDepositFlag==1){//입출금 구분이 0또는 1이면 출금
				this.account.withdraw(this.getName(),withdrawAmt);	
			}else if(withdrawDepositFlag==2){//입출금 구분이 2이면 입금
				this.account.deposit(this.getName(), withdrawAmt);
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		Account account = new Account();
		Test_05_Thread_Wait t1 = new Test_05_Thread_Wait(account);
		Test_05_Thread_Wait t2 = new Test_05_Thread_Wait(account);
		
		t1.start();
		t2.start();
	}
}
