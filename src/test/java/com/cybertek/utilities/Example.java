package com.cybertek.utilities;

public class Example {
    public static void main(String[] args) {
        String one = Singleton.get();
        System.out.println("one :" + one);
        String too = Singleton.get();
        System.out.println("too :" +too);
        String tree = Singleton.get();
        System.out.println("tree :"+tree);

    }
}
