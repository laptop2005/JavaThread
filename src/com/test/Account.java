package com.test;

//�������
public class Account{
	//�ѱݾ�
	int balance = 10000;
	
	//���
	public synchronized void withdraw(String name,int amt){
		//���� �ܰ� ����� �ݾ׺��� ũ�ų� ������ ����Ѵ�
		if(balance - amt >= 0){
			System.out.print("�����:"+name+", ����� �ݾ�:"+balance);
			balance -= amt;
			System.out.println(", ��ݾ�:"+amt+", �ܾ�:"+balance);
		}else{
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//�Ա�
	public synchronized void deposit(String name, int amt){
		System.out.print("�Ա���:"+name+", �Ա��� �ݾ�:"+balance);
		balance += amt;
		System.out.println(", �Աݾ�:"+amt+", �ܾ�:"+balance);
		notify();
	}
}
