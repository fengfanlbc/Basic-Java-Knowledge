package com.collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest02 {

	public static void main(String[] args) {
		Map<Integer,Integer> map = new HashMap();
		map.put(1, 1);
		System.out.println(map.containsKey(1));
		map.put(1, 2);
		System.out.println(map.get(1));

	}

}
