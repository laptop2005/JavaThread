package com.test.exercise;

import java.util.Comparator;

//���� ���� ����
public class HorseComparator implements Comparator<Horse>{

	@Override
	public int compare(Horse o1, Horse o2) {
		int result = 0;
		//�� o1�� o2�� ���ؼ� o1�� �� ���� ������ -1 o2�� �� ���� ������ 1�� ����
		//���� ���� �Ÿ��̸� 0�� �����ϹǷ� �������� ����
		if(o1.distance>o2.distance){
			result = -1;
		}else if(o1.distance<o2.distance){
			result = 1;
		}
		return result;
	}

}
