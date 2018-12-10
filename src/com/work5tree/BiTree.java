package com.work5tree;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class BiTree {

    private BiTreeNode root;
    private static int index = 0;

    public BiTree(String preOrder, String inOrder, int i, int inIndex) {
        this.root = null;
    }

    public BiTree() {
    }

    public BiTree(BiTreeNode root) {
        this.root = root;
    }

    //右先跟遍历和中。。。创建一颗二叉树的算法
    public BiTree(String preOrder, String inOrder, int preIndex, int inIndex, int count) {
        if(count > 0){
            char r = preOrder.charAt(preIndex);
            for(int i = 0; i<count; i++){
                if (r == inOrder.charAt(i + inIndex)) {
                    break;
                }
                root = new BiTreeNode(r);
                root.lchid = new BiTree(preOrder, inOrder, preIndex+1, inIndex).root;
                root.rchid = new BiTree(preOrder, inOrder, preIndex+1, inIndex+i+1, count-i-1).root;
            }
        }
    }

    //由标明空子树的先跟遍历序列创建一颗二叉树的算法
    public BiTree(String preStr) {
        char c = preStr.charAt(index ++);
        if(c!= '#'){
            root = new BiTreeNode(c);
            root.lchid = new BiTree(preStr).root;
            root.rchid = new BiTree(preStr).root;
        }else{
            root = null;
        }
    }


    //判断是否为空二叉树
    public boolean isEmpty(){
        return root == null;
    }


    //先跟遍历递归算法
    public void preRootTraverse(BiTreeNode T) {
        if(T != null){
            System.out.print(T.data+ "\t");
            preRootTraverse(T.lchid);
            preRootTraverse(T.rchid);
        }
    }

    //先跟遍历非递归算法
    public void preRootTraverse() {
        BiTreeNode T = root;
        if(T != null){
            Stack S = new Stack();
            S.push(T);
            while (!S.isEmpty()){
                T = (BiTreeNode)S.pop();
                while (T != null){
                    if(T.lchid != null){
                        System.out.print(T.lchid.data + "\t");
                    }
                    if(T.rchid != null){
                        S.push(T.rchid);
                    }
                    T = T.rchid;
                }
            }
        }
    }

    //中跟遍历递归算法
    public void inRootTraverse(BiTreeNode T) {
        if(T != null){
            inRootTraverse(T.lchid);
            System.out.print(T.data+ "\t");
            inRootTraverse(T.rchid);
        }
    }

    //中跟遍历非递归算法
    public void inRootTraverse() {

        BiTreeNode T = root;
        if(T != null){
            Stack S = new Stack();
            S.push(T);
            while (!S.isEmpty()){
                while (S.peek()!= null){
                    S.push(((BiTreeNode)S.peek()).lchid);
                }
                S.pop();
                if(!S.isEmpty()){
                    T = (BiTreeNode)S.pop();
                    System.out.print(T.data+ "\t");
                    S.push(T.rchid);
                }
            }
        }

    }

    public BiTreeNode searchNode(BiTreeNode T,Object x){

        if(T != null){
            if(T.data.equals(x)){
                return T;
            }else{
                BiTreeNode l = searchNode(T.lchid, x);
                return l != null?l:searchNode(T.rchid, x);
            }
        }
        return null;
    }

    //后跟遍历递归算法
    public void postRootTraverse(BiTreeNode T) {
        if(T != null){
            postRootTraverse(T.lchid);
            postRootTraverse(T.rchid);
            System.out.print(T.data+ "\t");
        }
    }

    //后跟遍历非递归算法
    public void postRootTraverse() {

        BiTreeNode T = root;
        if(T != null){
            Stack S = new Stack();
            S.push(T);
            Boolean flag;
            BiTreeNode p = null;
            while (!S.isEmpty()){
                while (S.peek() != null){
                    S.push(((BiTreeNode)S.peek()).lchid);
                }
                S.pop();
                while (!S.isEmpty()){
                    T = (BiTreeNode)S.peek();
                    if(T.rchid == null || T.rchid == p){
                        System.out.print(T.data+ "\t");
                        S.pop();
                        p = T;
                        flag = true;

                    }else {
                        S.push(T.rchid);
                        flag = false;
                    }
                    if( !flag ){
                        break;
                    }
                }
            }
        }

    }

    //层次遍历（自右向左）
    public void levelTraverse() {

        BiTreeNode T = root;
        if(T != null){
//            Queue<Object> L = new LinkedList<Object>();
            Queue L = new LinkedBlockingQueue();
            L.offer(T);
            while (!L.isEmpty()){
                T = (BiTreeNode)L.poll();
                System.out.print(T.data+ "\t");
                if(T.lchid != null){
                    L.offer(T.lchid);
                }
                if(T.rchid != null){
                    L.offer(T.rchid);
                }
            }

        }

    }


    public int countNode1(BiTreeNode T){
        if(T == null){
            return 0;
        }else{
            return countNode1(T.lchid) + countNode1(T.rchid) + 1;
        }
    }

    public static int getDepth(BiTreeNode T) {
        if(T == null){
            return 0;
        }else if(T.lchid == null && T.rchid == null){
            return 1;
        }else{
            return 1+(getDepth(T.lchid) > getDepth(T.rchid)?getDepth(T.lchid):getDepth(T.rchid));
        }
    }

    public BiTreeNode getRoot() {
        return root;
    }

    public void setRoot(BiTreeNode root) {
        this.root = root;
    }

}
