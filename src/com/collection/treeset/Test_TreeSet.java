package com.collection.treeset;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Test_TreeSet {

	public static void main(String[] args) {
		Set ts = new TreeSet();
        ts.add(new Teacher("zhangsan", 1));
        ts.add(new Teacher("lisi", 2));
        ts.add(new Teacher("wangmazi", 3));
        ts.add(new Teacher("wangwu",4));
        ts.add(new Teacher("mazi", 3));
        
        
        Set ts2 = new TreeSet(new TeacherCompare());
        ts2.add(new Teacher2("zhangsan", 1));
        ts2.add(new Teacher2("lisi", 2));
        ts2.add(new Teacher2("wangmazi", 3));
        ts2.add(new Teacher2("wangwu",4));
        ts2.add(new Teacher2("mazi", 3));
        Iterator it = ts.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        
        System.out.println("=========================");
        Iterator it2 = ts2.iterator();
        while (it2.hasNext()) {
            System.out.println(it2.next());
        }

	}

}
