package com.copy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.Serializable;

public class CopyDemo01 {

	public static void main(String[] args) throws OptionalDataException, ClassNotFoundException, IOException {
        Professor0 p = new Professor0("wangwu", 50);
        Student0 s1 = new Student0("zhangsan", 18, p);
        Student0 s2 = (Student0) s1.clone();
        s2.p.name = "lisi";
        s2.p.age = 30;
        s2.name = "z";
        s2.age = 45;
        System.out.println("浅拷贝：");

        System.out.println("学生s1的姓名：" + s1.name + "\n学生s1教授的姓名：" + s1.p.name + "," + "\n学生s1教授的年纪" + s1.p.age);// 学生1的教授
        System.out.println("深拷贝：");
        long t1 = System.currentTimeMillis();
        Professor p1 = new Professor("wangwu", 50);
        Student s3 = new Student("zhangsan", 18, p1);
        Student s4 = (Student) s3.clone();
        s4.p.name = "lisi";
        s4.p.age = 30;
        System.out.println("name=" + s3.p.name + "," + "age=" + s3.p.age);// 学生1的教授不改变。
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
        
        System.out.println("串行化深拷贝：");
        long t3 = System.currentTimeMillis();
        Professor2 p2 = new Professor2("wangwu", 50);
        Student2 s5 = new Student2("zhangsan", 18, p2);
        Student2 s6 = (Student2) s5.deepClone();
        s6.p.name = "lisi";
        s6.p.age = 30;
        System.out.println("name=" + s5.p.name + "," + "age=" + s5.p.age); // 学生1的教授不改变。
        long t4 = System.currentTimeMillis();
        //可以看出串行化明显费时间
        System.out.println(t4-t3);
	}

}
class Professor0 implements Cloneable {
    String name;
    int age;
 
    Professor0(String name, int age) {
        this.name = name;
        this.age = age;
    }
 
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
 
class Student0 implements Cloneable {
    String name;// 常量对象。
    int age;
    Professor0 p;// 学生1和学生2的引用值都是一样的。
 
    Student0(String name, int age, Professor0 p) {
        this.name = name;
        this.age = age;
        this.p = p;
    }
 
    public Object clone() {
        Student0 o = null;
        try {
            o = (Student0) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
        }
 
        return o;
    }
}


class Professor implements Cloneable {
    String name;
    int age;
 
    Professor(String name, int age) {
        this.name = name;
        this.age = age;
    }
 
    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
        }
        return o;
    }
}
 
//继承Cloneable，改写clone()方法深拷贝
class Student implements Cloneable {
    String name;
    int age;
    Professor p;
 
    Student(String name, int age, Professor p) {
        this.name = name;
        this.age = age;
        this.p = p;
    }
 
    public Object clone() {
        Student o = null;
        try {
            o = (Student) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
        }
        o.p = (Professor) p.clone();
        return o;
    }
}


//串行化实现深拷贝
class Professor2 implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    String name;
    int age;
 
    Professor2(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
 
class Student2 implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    String name;// 常量对象。
    int age;
    Professor2 p;// 学生1和学生2的引用值都是一样的。
 
    Student2(String name, int age, Professor2 p) {
        this.name = name;
        this.age = age;
        this.p = p;
    }
 
    public Object deepClone() throws IOException, OptionalDataException,
            ClassNotFoundException {
        // 将对象写到流里
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(this);
        // 从流里读出来
        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);
        return (oi.readObject());
    }
 
}