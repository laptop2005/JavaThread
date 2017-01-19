package com.test.exercise;

import java.util.ArrayList;

public class Horse extends Thread{
	
	//���� �̸�
	public String name;
	
	//���� �޸� �Ÿ�
	public int distance = 0;
	
	private ArrayList<Horse> rankList;
	
	public Horse(String name, ArrayList<Horse> rankList){
		this.name = name;
		this.rankList = rankList;
	}
	
	public void run(){
		//���� �Ÿ� 100�� �����Ҷ����� �޸���.
		while(distance<100){
			//�ѹ��� �޸��� �Ÿ��� 1~5 ���� �����ϰ�
			int runDistance = (int)(Math.random()*3+1);
			//�ѹ��� �޸� �Ÿ��� �� �޸� �Ÿ��� ������Ų��.
			distance += runDistance;
			
			//���� ��¼��� �Ѿ�� ��¼������� �޸������� ����
			if(distance>100){
				distance = 100;
			}
			
			try {
				//0.5���� ������ �ΰ� �����Ѵ�.
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		synchronized (rankList) {
			this.rankList.add(this);
		}
	}
}
