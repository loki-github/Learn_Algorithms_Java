package com.learn.algorithms;

public class SelectionRankAlgorithm {

	public static int selectKth(int[] arr, int k) {
		if (arr == null || arr.length <= k)
			throw new Error();

		int from = 0, to = arr.length - 1;

		// if from == to we reached the kth element
		while (from < to) {
			int r = from, w = to;
			int mid = arr[(r + w) / 2];

			// stop if the reader and writer meets
			while (r < w) {

				if (arr[r] >= mid) { // put the large values at the end
					int tmp = arr[w];
					arr[w] = arr[r];
					arr[r] = tmp;
					w--;
				} else { // the value is smaller than the pivot, skip
					r++;
				}
			}

			// if we stepped up (r++) we need to step one down
			if (arr[r] > mid)
				r--;

			// the r pointer is on the end of the first k elements
			if (k <= r) {
				to = r;
			} else {
				from = r + 1;
			}
		}

		return arr[k];
	}

	public static void main(String... args) {
		int[] a = {0,1,2,3,4,5,6};
		int min = getKthSmallest(a, 0, a.length-1,4);
		System.out.println(min);
	}
	
	public static int getKthSmallest(int[] arr,int l,int r,int k){
		if(l>=arr.length-1){
			return -1;
		}
		
		int pivotIndex=partition(arr, l, r);
		
		int leftSize=pivotIndex-l;
		if(l<arr.length && leftSize==k-1){
			return max(arr,l,pivotIndex);
		}else if(l<arr.length && k<leftSize){
			return getKthSmallest(arr, l, pivotIndex, k);
		}else {
			return getKthSmallest(arr, pivotIndex+1, r, k-leftSize);
		}
	}
	
	public static int max(int[] a,int l,int p){
		int i=l;
		int max=a[l];
		while(i<=p){
			if(a[i]>max){
				max=a[i];
			}
			i++;
		}
		return max;
	}
	
	public static int partition(int[] arr,int l,int r){
		int pivot=arr[l];
		while(true){
			while(l<r && arr[l]<pivot){
				l++;
			}
			while(l<r && arr[r]>=pivot){
				r--;
			}
			if(l<r){
				swap(arr,l,r);
			}else{
				for(int i=0;i<arr.length;i++){
					System.out.print(arr[i]+",");
				}
				System.out.println();
				System.out.println("Pivot index="+l);
				return l;
			}
		}
		
	}
	
	public static void swap(int[] arr,int i, int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
