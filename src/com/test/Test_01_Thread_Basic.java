package com.test;

public class Test_01_Thread_Basic extends Thread{
	
	//�����尡 ������� ���� �޼ҵ�
	public void noThread(){
		for(int inx=0;inx<=10;inx++){
			System.out.println(getName()+":"+inx);
		}
	}
	
	//�����尡 ����Ǵ� �޼ҵ�
	public void run(){
		for(int inx=0;inx<=10;inx++){
			System.out.println(getName()+":"+inx);
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}
	
	public static void main(String[] args) {
		Test_01_Thread_Basic thread1 = new Test_01_Thread_Basic();
		Test_01_Thread_Basic thread2 = new Test_01_Thread_Basic();
		Test_01_Thread_Basic thread3 = new Test_01_Thread_Basic();	
		
//		thread1.noThread();
//		thread2.noThread();
//		thread3.noThread();
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		
	}
}
