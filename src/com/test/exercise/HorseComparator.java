package com.test.exercise;

import java.util.Comparator;

//말의 정렬 기준
public class HorseComparator implements Comparator<Horse>{

	@Override
	public int compare(Horse o1, Horse o2) {
		int result = 0;
		//말 o1과 o2를 비교해서 o1이 더 많이 갔으면 -1 o2가 더 많이 갔으면 1을 리턴
		//서로 같은 거리이면 0을 리턴하므로 정렬하지 않음
		if(o1.distance>o2.distance){
			result = -1;
		}else if(o1.distance<o2.distance){
			result = 1;
		}
		return result;
	}

}
