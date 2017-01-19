package com.test.exercise;

import java.util.ArrayList;

public class HorseRacing{
	
	private Horse[] horses;
	private ArrayList<Horse> finishLine = new ArrayList<>();
	
	public HorseRacing(){
		//말 10마리를 배열로 선언해 놓는다.
		horses = new Horse[10];
		horses[0] = new Horse("강성진",finishLine);
		horses[1] = new Horse("곽수남",finishLine);
		horses[2] = new Horse("권미소",finishLine);
		horses[3] = new Horse("김기욱",finishLine);
		horses[4] = new Horse("김승기",finishLine);
		horses[5] = new Horse("노진권",finishLine);
		horses[6] = new Horse("박승리",finishLine);
		horses[7] = new Horse("서기원",finishLine);
		horses[8] = new Horse("손용휘",finishLine);
		horses[9] = new Horse("송예닮",finishLine);
	}
	
	public void start(){
		//각 말들을 경마에 데몬쓰레드로 붙이면서 말을 달리기 시작한다.
		//이렇게 되면 경마가 끝나게 되면 말이 100미터를 다 달리지 않았더라도
		//말의 쓰레드가 종료되게 된다.
		for(Horse horse:horses){
			horse.setDaemon(true);
			horse.start();
		}
		
		//결승선에 10마리가 다 들어오면 종료되도록
		while(finishLine.size()<horses.length){
			try {
				//1초에 한번씩 결과를 출력한다.
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//구분선
			System.out.println("------------------------------------------------------------------------------------------------------");
			//말 10마리의 달린 거리만큼을 .으로 표시해주기 위한 for문
			for(int i=0;i<horses.length;i++){
				//말이 달린 거리만큼 .을 찍어준다.
				for(int j=0;j<horses[i].distance;j++){
					System.out.print(".");
				}
				//.을 찍은 마지막에 말의 이름을 쓰고 줄바꿈
				System.out.println(horses[i].name);
			}
			//구분선
			System.out.println("------------------------------------------------------------------------------------------------------");
		}
		
		//말의 순위를 표시
		for(int i=0;i<finishLine.size();i++){
			Horse rankHorse = finishLine.get(i);
			System.out.println((i+1)+"등은 "+rankHorse.name);
		}
	}
	
	public static void main(String[] args) {
		
		//경마 인스턴스를 생성
		HorseRacing racing = new HorseRacing();
		
		//경마 시작
		racing.start();
	}
}
