package org.example;

public class Picture {
    public static void main(String[]args){
        var x=1;
        var y=3;
        var s="Hello";

        sum(x,y);

        hello(s);
    }

    static void sum(long a,long b){
        System.out.println(a+b);
    }

    static void hello(String s) {
        System.out.println(s);

    }
}
