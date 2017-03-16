package com.collection.hashset;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class EqualsTest {

	public static void main(String[] args) {
		LinkedList<Student> list = new LinkedList<Student>();
		Set<Student> set = new HashSet<Student>();
		
		Student s1 = new Student(3,"feng");
		Student s2 = new Student(3,"feng");
		
		System.out.println("s1==s2:"+(s1==s2));
		System.out.println("s1.equals(s2):"+(s1.equals(s2)));
		list.add(s1);
		list.add(s2);
		System.out.println("list size:"+ list.size());
		set.add(s1);
		set.add(s2);
		System.out.println("s1 hashcode:" + s1.hashCode());
		System.out.println("s2 hashcode:" + s2.hashCode());
		System.out.println("set.size:"+set.size());
		s1.setAge(13);
		System.out.println("s1 hashcode:" + s1.hashCode());
		System.out.println("set.size:"+set.size());
		System.out.println("remove:" + set.remove(s1));

	}

}
