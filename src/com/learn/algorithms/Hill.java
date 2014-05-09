package com.learn.algorithms;

public class Hill {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] l = new Integer[] {3,3,2};
		hill(l);
	}

	public static void hill(Integer[] v) {
		int max = 0;
		int result=0;
		for (int i = 0; i < v.length; i++) {
			if (max < v[i]) {
				max = v[i];
			}
			int min = 0;
			while (true) {
				int av = (max + min) / 2;
				if (min == max) {
					if (isHill(v, av)) {
						result=min;
					} 
					break;
				}
				if (isHill(v, av)) {
					max = av;
				} else {
					min = av + 1;
				}
			}
		}
		System.out.println(result);
	}

	public static Boolean isHill(Integer[] l, int i) {
		int prev = -1;
		for (int j = 0; j < l.length; j++) {
			int max = Math.max(prev + 1, l[j] - i);
			if (Math.abs(max - l[j]) > i) {
				return false;
			}
			prev = max;
		}
		return true;
	}
}
