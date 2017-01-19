package com.test.exercise;

import java.util.ArrayList;

public class Horse extends Thread{
	
	//말의 이름
	public String name;
	
	//말이 달린 거리
	public int distance = 0;
	
	private ArrayList<Horse> rankList;
	
	public Horse(String name, ArrayList<Horse> rankList){
		this.name = name;
		this.rankList = rankList;
	}
	
	public void run(){
		//말이 거리 100에 도달할때까지 달린다.
		while(distance<100){
			//한번에 달리는 거리는 1~5 까지 랜덤하게
			int runDistance = (int)(Math.random()*3+1);
			//한번에 달린 거리를 총 달린 거리에 누적시킨다.
			distance += runDistance;
			
			//말이 결승선을 넘어가도 결승선까지만 달린것으로 설정
			if(distance>100){
				distance = 100;
			}
			
			try {
				//0.5초의 간격을 두고 실행한다.
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
