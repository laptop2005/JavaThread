package com.test;

//은행계좌
public class Account{
	//총금액
	int balance = 10000;
	
	//출금
	public synchronized void withdraw(String name,int amt){
		//남은 잔고가 출금할 금액보다 크거나 같으면 출금한다
		if(balance - amt >= 0){
			System.out.print("출금자:"+name+", 출금전 금액:"+balance);
			balance -= amt;
			System.out.println(", 출금액:"+amt+", 잔액:"+balance);
		}else{
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//입금
	public synchronized void deposit(String name, int amt){
		System.out.print("입금자:"+name+", 입금전 금액:"+balance);
		balance += amt;
		System.out.println(", 입금액:"+amt+", 잔액:"+balance);
		notify();
	}
}
