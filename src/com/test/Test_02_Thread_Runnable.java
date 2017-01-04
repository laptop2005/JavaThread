package com.test;

public class Test_02_Thread_Runnable implements Runnable{

	// 어떤 쓰레드인지 알기 위한 쓰레드 이름
	public String threadName;
	
	@Override
	public void run() {
		//0부터 10까지 출력한다.
		for(int inx=0;inx<=10;inx++){
			System.out.println(this.threadName+":"+inx);
			try {
				//Thread.sleep()은 쓰레드를 정해진 시간만큼 멈추는 기능이다.
				//매개변수는 long 타입의 숫자로 밀리세컨드를 말하며
				//1000을 입력하면 1초를 딜레이로 가지게 된다.
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
