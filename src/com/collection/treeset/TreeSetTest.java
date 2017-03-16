package com.collection.treeset;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        Set ts = new TreeSet();
        ts.add("abc");
        ts.add("xyz");
        ts.add("rst");
        Iterator it = ts.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
