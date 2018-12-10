package com.work5tree;

public class BiTreeNode {

    public Object data;
    public BiTreeNode lchid, rchid; //左 -- 右

    public BiTreeNode() {

    }

    public BiTreeNode(Object data) {
        this.data = data;
    }

    public BiTreeNode(Object data, BiTreeNode lchid, BiTreeNode rchid) {
        this.data = data;
        this.lchid = lchid;
        this.rchid = rchid;
    }
}
