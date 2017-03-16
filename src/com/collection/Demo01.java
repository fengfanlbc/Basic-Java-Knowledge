package com.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class Demo01 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
//		for(int a:list ){
//			System.out.println(a);
//			list.remove(a);
//		}
		Iterator it = list.iterator();
		while(it.hasNext()){
			//System.out.println(it.next());
			it.remove();
		}
		System.out.println("size:"+list.size());
		

	}

}
