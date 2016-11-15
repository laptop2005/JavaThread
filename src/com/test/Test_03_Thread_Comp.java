package com.test;


public class Test_03_Thread_Comp extends Thread implements Runnable{
	
	public int threadType = 0; //1�̸� ������ ��� 2�̸� Runnable ����
	
	@Override
	public void run() {
		if(threadType==1){ //������ ����϶�
			for(int inx=0;inx<=30;inx++){
				System.out.println(this.getName()+":"+inx);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}else if(threadType==2){//runnable �����϶�
			while(true){
				System.out.println("��������� �Ͽ��~!");
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
