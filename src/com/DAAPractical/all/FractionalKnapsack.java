package com.DAAPractical.all;
import java.util.*;

class item{
	float wt;
	float profit;
	
	public item(int p, int w) {
		this.wt = w;
		this.profit = p;
	} 
}

// class Comparative

class MyComparator4 implements Comparator<item>{
	
	public int Compare(item x, item y) {
		float a = (x.profit/x.wt);
		float b = (y.profit/y.wt);
		
		if(a>b) {
			return -1;
		}
		
		else {
			return 1;
		}
		
	}

	@Override
	public int compare(item o1, item o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}

public class FractionalKnapsack {

	static void fracKnapsack(item[] items, float bagsize) {
		float maxprofit = 0;
		
		Arrays.sort(items, new MyComparator4());
		
		for(int i=0; i< items.length; i++) {
			if(bagsize >= items[i].wt) {
				maxprofit = maxprofit + items[i].profit;
				bagsize = bagsize - items[i].wt;
			}
			else
			{
				float x = (items[i].profit/ items[i].wt)*bagsize;
				maxprofit = maxprofit + x;
				bagsize = 0;
				break;
			}
		}
		System.out.println(maxprofit);
	}
	
	public static void main(String[] args) {
		item[] arr = {new item(60,10), new item(100, 20), new item(120, 30)};
		
		int bagsize = 50;
		
		System.out.println("The maxprofit is: ");
		fracKnapsack(arr, bagsize);

	}

}





