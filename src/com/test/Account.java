package com.test;

//�������
public class Account{
	//�ѱݾ�
	static int balance = 10000;
	
	//���
//	public static synchronized void withdraw(String name,int amt){
	public static void withdraw(String name,int amt){
		String success = "";
		int prevBalance = balance;
		//���� �ܰ� ����� �ݾ׺��� ũ�ų� ������ ����Ѵ�
		if(balance - amt >= 0){
			balance -= amt;
			success = "��ݼ���";
			
		//���� �ܰ� ���ڶ�� ���� �ԱݵǾ� ��ݱݾ��� �� ������ ��ٸ��� ����
		//wait�� ����ߴ�.
//		}else{
//			try {
//				wait();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
		System.out.println("�����:"+name+", ����� �ݾ�:"+prevBalance+", ��ݾ�:"+amt+", �ܾ�:"+balance);
		
	}
	
	//�Ա�
	public synchronized void deposit(String name, int amt){
		System.out.print("�Ա���:"+name+", �Ա��� �ݾ�:"+balance);
		balance += amt;
		System.out.println(", �Աݾ�:"+amt+", �ܾ�:"+balance);
		
		//�Ա� �Ŀ��� ��� ��� ���� �����带 �ٽ� ó���� �ֱ� ����
		//notify ���ش�. ���� ������� �����尡 ���ٸ� ������ ó���Ǵ� ���� ���� ����ȴ�.
		notify();
	}
}
