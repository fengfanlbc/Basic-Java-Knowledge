package com.collection.treeset;

public class Teacher implements Comparable<Teacher>{
	private int num;
	private String name;
	
	Teacher(String name, int num) {
        this.num = num;
        this.name = name;
    }

    public String toString() {
        return "学号：" + num + "\t\t姓名：" + name;
    }

	@Override
	public int compareTo(Teacher o) {
		int result = num < o.num ? 1 : (num == o.num ? 0 : -1);//降序
        //int result = num > o.num ? 1 : (num == o.num ? 0 : -1);//升序
        if (result == 0) {
            result = name.compareTo(o.name);
        }
        return result;
	}
    
    
}
