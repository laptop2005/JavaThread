package com.test.exercise;

import java.util.ArrayList;

public class HorseRacing{
	
	private Horse[] horses;
	private ArrayList<Horse> finishLine = new ArrayList<>();
	
	public HorseRacing(){
		//�� 10������ �迭�� ������ ���´�.
		horses = new Horse[10];
		horses[0] = new Horse("������",finishLine);
		horses[1] = new Horse("������",finishLine);
		horses[2] = new Horse("�ǹ̼�",finishLine);
		horses[3] = new Horse("����",finishLine);
		horses[4] = new Horse("��±�",finishLine);
		horses[5] = new Horse("������",finishLine);
		horses[6] = new Horse("�ڽ¸�",finishLine);
		horses[7] = new Horse("�����",finishLine);
		horses[8] = new Horse("�տ���",finishLine);
		horses[9] = new Horse("�ۿ���",finishLine);
	}
	
	public void start(){
		//�� ������ �渶�� ���󾲷���� ���̸鼭 ���� �޸��� �����Ѵ�.
		//�̷��� �Ǹ� �渶�� ������ �Ǹ� ���� 100���͸� �� �޸��� �ʾҴ���
		//���� �����尡 ����ǰ� �ȴ�.
		for(Horse horse:horses){
			horse.setDaemon(true);
			horse.start();
		}
		
		//��¼��� 10������ �� ������ ����ǵ���
		while(finishLine.size()<horses.length){
			try {
				//1�ʿ� �ѹ��� ����� ����Ѵ�.
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//���м�
			System.out.println("------------------------------------------------------------------------------------------------------");
			//�� 10������ �޸� �Ÿ���ŭ�� .���� ǥ�����ֱ� ���� for��
			for(int i=0;i<horses.length;i++){
				//���� �޸� �Ÿ���ŭ .�� ����ش�.
				for(int j=0;j<horses[i].distance;j++){
					System.out.print(".");
				}
				//.�� ���� �������� ���� �̸��� ���� �ٹٲ�
				System.out.println(horses[i].name);
			}
			//���м�
			System.out.println("------------------------------------------------------------------------------------------------------");
		}
		
		//���� ������ ǥ��
		for(int i=0;i<finishLine.size();i++){
			Horse rankHorse = finishLine.get(i);
			System.out.println((i+1)+"���� "+rankHorse.name);
		}
	}
	
	public static void main(String[] args) {
		
		//�渶 �ν��Ͻ��� ����
		HorseRacing racing = new HorseRacing();
		
		//�渶 ����
		racing.start();
	}
}
