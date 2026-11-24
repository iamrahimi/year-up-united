package com.iamsrahimi.recapexcercises.generic;

import com.iamsrahimi.recapexcercises.generic.interfac13.Err;
import com.iamsrahimi.recapexcercises.generic.interfac13.Ok;
import com.iamsrahimi.recapexcercises.generic.interfac13.Result;
import com.iamsrahimi.recapexcercises.generic.interfac13.Results;

public class Main {
    public static void main(String[] args) {
        Box<Integer> a = new Box<>(42);
        Box<String> b = new Box<>("hi");
        Box<Double> c = new Box<>(3434.213);
        System.out.println(a.get()); // 42
        System.out.println(b.get()); // hi
        System.out.println(c.get());


        Labelled<String> l1 = new Labelled<>("name", "Maaike");
        Labelled<Integer> l2 = new Labelled<>("age", 29);
        System.out.println(l1); // name=Maaike
        System.out.println(l2); // age=29


        Wrapper<String> w1 = new Wrapper<>("cat");
        Wrapper<String> w2 = new Wrapper<>("cat");
        System.out.println(w1.equalsByValue(w2)); // true
        Wrapper<Integer> w3 = new Wrapper<>(1);
        Wrapper<Integer> w4 = new Wrapper<>(2);
        System.out.println(w3.equalsByValue(w4)); // false


        Printer<String> ps = new Printer<>();
        Printer<Boolean> pb = new Printer<>();
        ps.print("Hi");
        pb.print(true);



        OptionalLite<String> o1 = OptionalLite.of("x");
        OptionalLite<String> o2 = OptionalLite.empty();
        System.out.println(o1.isPresent()); // true
        System.out.println(o2.isPresent()); // false


        PairStringify<Integer> p1 = new PairStringify<>();
        PairStringify<String>  p2 = new PairStringify<>();
        System.out.println(p1.stringify(1, 2));     // 1,2
        System.out.println(p2.stringify("a","b"));  // a,b



        StoreOnce<String> s1 = new StoreOnce<>();
        StoreOnce<Integer> s2 = new StoreOnce<>();
        s1.put("first"); s1.put("second");
        System.out.println(s1.get()); // first
        s2.put(10);
        System.out.println(s2.get()); // 10


        Pair<String,Integer> p3 = new Pair<>("age", 30);
        Pair<Integer,String> p4 = new Pair<>(1, "one");
        System.out.println(p3); // (age=30)
        System.out.println(p4); // (1=one)


        BiHolder<String,Boolean> bh = new BiHolder<>("ok", true);
        BiHolder<Boolean,String> swapped = bh.swap();
        System.out.println(swapped.getFirst()); // true
        System.out.println(swapped.getSecond()); // ok


        Result<Integer,String> r1 = Results.ok(200);
        Result<Integer,String> r2 = Results.err("Not found");
        System.out.println(r1 instanceof Ok);  // true
        System.out.println(r2 instanceof Err); // true
    }
}
