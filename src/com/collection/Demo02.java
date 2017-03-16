package com.collection;

import java.util.Iterator;

public class Demo02 {

	public static void main(String[] args) {
		for(String s: new IterableClass()){
			System.out.print(s+" ");
		}

	}
	
	

}
class IterableClass implements Iterable<String>{
	protected String[] words = ("hello world, hello life").split(" ");
	@Override
	public Iterator<String> iterator() {
		
		return new Iterator<String>(){
			private int index = 0;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return index < words.length ;
			}

			@Override
			public String next() {
				return words[index++];
				
			}
			
			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
			
		};
	}
	
}