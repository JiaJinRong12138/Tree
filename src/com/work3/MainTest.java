package com.work3;

import com.work1.Node;

public class MainTest {

    public static void main(String[] args) throws Exception {
        CircleLinkQueue clq = new CircleLinkQueue();
        System.out.println(clq.isEmpty());
        clq.offer("Z");
        clq.offer("J");
        clq.offer("K");
        clq.offer("L");
        System.out.println(clq.isEmpty());
        System.out.println(clq.peek());
        clq.poll();
        System.out.println(clq.peek());
        System.out.println(clq.isEmpty());

    }

}
