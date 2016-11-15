package com.test;


public class Test_03_Thread_Comp extends Thread implements Runnable{
	
	public int threadType = 0; //1이면 쓰레드 상속 2이면 Runnable 구현
	
	@Override
	public void run() {
		if(threadType==1){ //쓰레드 상속일때
			for(int inx=0;inx<=30;inx++){
				System.out.println(this.getName()+":"+inx);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}else if(threadType==2){//runnable 구현일때
			while(true){
				System.out.println("따따라따따 암욜맨~!");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Test_03_Thread_Comp t1 = new Test_03_Thread_Comp();
		Test_03_Thread_Comp t2 = new Test_03_Thread_Comp();
		
		t1.threadType = 1;
		t2.threadType = 2;
		
		Thread tt = new Thread(t2);
		tt.setDaemon(true);
		
		t1.start();
		tt.start();
	}
}
