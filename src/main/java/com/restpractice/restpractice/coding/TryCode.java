package com.restpractice.restpractice.coding;

import java.io.IOException;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class TryCode {
    public static void main(String[] args) {
        Person person1 = new Person(30, "One");
        Person person2 = new Person(5, "Two");
        Person person3 = new Person(70, "Three");
        Predicate<Person>p = (person -> person.age > 10);
        Predicate<Person>q = (person -> person.age < 60);
        boolean value1 = p.test(person1);
        boolean value2 = p.test(person2);
        System.out.println(value1 + " " + value2);
        Predicate<Person>t1 = p.and(q);
        Predicate<Person>t2 = p.or(q);
        boolean value3 = t1.negate().negate().test(person1);
        boolean value4 = t2.test(person2);
        Predicate<String>t3 = Predicate.isEqual("One");
        boolean value5 = t3.test("One");
        BiPredicate<Person, Integer>t4 = (p1, q1) -> p1.age > q1;
        boolean value6 = t4.test(person1, 20);
        boolean value7 = t4.test(person1, 70);
        System.out.println(value3 + " " +  value6 + " " + value7) ;

    }

}

class Person {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

class MyFace {
    TreeNode f;
    int s;
    public MyFace(TreeNode f, int s) {
        this.f = f;
        this.s = s;
    }

    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        MyFace obj1 = (MyFace) o;
        return (s == obj1.s && Objects.equals(f, obj1.f));
    }

    public int hashCode() {
        return Objects.hash(f,  s);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
