package com.collection.treeset;

import java.util.Comparator;

public class TeacherCompare implements Comparator<Teacher2> {

	@Override
	public int compare(Teacher2 o1, Teacher2 o2) {
		
		
        int result = o1.num > o2.num ? 1 : (o1.num == o2.num ? 0 : -1);
        if (result == 0) {
            result = o1.name.compareTo(o2.name);
        }
        return result;
	}

}
