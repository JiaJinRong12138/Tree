package com.work2;

import com.work1.IQueue;

public class CIrclesqQueue implements IQueue {

    private Object[] queueElem;
    private int front;
    private int rear;

    public CIrclesqQueue(int maxSize){
        front = rear = 0;
        queueElem = new Object[maxSize];
    }


    @Override
    public void clear() {
        front = rear = 0;
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public int length() {
        return (rear - front + queueElem.length) % queueElem.length;
    }

    @Override
    public Object peek() {
        if(front == rear) {
            return null;
        }
        return queueElem[front];
    }

    @Override
    public void offer(Object x) throws Exception {

        if((rear + 1) % queueElem.length == front){
            throw new Exception("队列已满");
        }
        else{
            queueElem[rear] = x;
            rear = (rear +1) % queueElem.length;
        }


    }

    @Override
    public Object poll() {
        if(front == rear){
            return null;
        }
        else{
            Object t = queueElem[front];
            front = (front + 1) % queueElem.length;
            return t;
        }
    }

    public void disPlay(){
        if(!this.isEmpty()){
            for(int i = front; i!=rear; i=(i + 1)%queueElem.length){
                System.out.print(queueElem[i].toString() + "\t");
            }

        }else{
            System.out.println("NULL");
        }
        System.out.println();
    }
}
