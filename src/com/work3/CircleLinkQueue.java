package com.work3;

import com.work1.IQueue;
import com.work1.Node;

public class CircleLinkQueue implements IQueue {

    private Node head; // 头节点
    private Node rear; // 尾部指针

    public CircleLinkQueue(){
        rear = new Node();
        rear.next = rear;
    }

    @Override
    public void clear() {
        rear = rear.next;
    }

    @Override
    public boolean isEmpty() {
        return rear == rear.next;
    }

    @Override
    public int length() {
        int length = 0;
        while(rear != rear.next){
            length ++;
        }
        return length;
    }

    @Override
    public Object peek() {
        //判空
        if(this.isEmpty()){
            return null;
        }
        return rear.next.data;
    }

    @Override
    public void offer(Object x) throws Exception {

        Node p = new Node(x);
        p.next = rear.next;
        rear.next = p;

    }

    @Override
    public Object poll() {
        //当队列元素为空的时候
        if(this.isEmpty()){
            return null;
        }
        //当队列元素为一个的时候
        else if(rear.next.next == rear){

            Object x = rear.next.next.data;
            rear.next = rear;
            return x;

        }
        else{

            Object x = rear.next.next.data;
            rear.next = rear.next.next.next;
            return x;

        }
    }

    public void disPlay(){



    }
}
