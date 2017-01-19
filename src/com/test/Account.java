package com.test;

//은행계좌
public class Account{
	//총금액
	static int balance = 10000;
	
	//출금
//	public static synchronized void withdraw(String name,int amt){
	public static void withdraw(String name,int amt){
		String success = "";
		int prevBalance = balance;
		//남은 잔고가 출금할 금액보다 크거나 같으면 출금한다
		if(balance - amt >= 0){
			balance -= amt;
			success = "출금성공";
			
		//은행 잔고가 모자라면 돈이 입금되어 출금금액이 될 때까지 기다리기 위해
		//wait을 사용했다.
//		}else{
//			try {
//				wait();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
		System.out.println("출금자:"+name+", 출금전 금액:"+prevBalance+", 출금액:"+amt+", 잔액:"+balance);
		
	}
	
	//입금
	public synchronized void deposit(String name, int amt){
		System.out.print("입금자:"+name+", 입금전 금액:"+balance);
		balance += amt;
		System.out.println(", 입금액:"+amt+", 잔액:"+balance);
		
		//입금 후에는 출금 대기 중인 쓰레드를 다시 처리해 주기 위해
		//notify 해준다. 만약 대기중인 쓰레드가 없다면 별도의 처리되는 것은 없이 진행된다.
		notify();
	}
}
