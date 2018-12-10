package com.work5tree;

public class MainTest {

    public static BiTree createBiiTree(){

        BiTreeNode d = new BiTreeNode('D');
        BiTreeNode g = new BiTreeNode('G');
        BiTreeNode h = new BiTreeNode('H');
        BiTreeNode e = new BiTreeNode('E', g, null);
        BiTreeNode b = new BiTreeNode('B', d, e);
        BiTreeNode f = new BiTreeNode('F', null, h);
        BiTreeNode c = new BiTreeNode('C', f, null);
        BiTreeNode a = new BiTreeNode('A', b, c);
        return new BiTree(a);       //创建根节点a的二叉树
    }

    public static void main(String[] args) {

        BiTree biTree = createBiiTree();
        BiTreeNode root = biTree.getRoot();

        biTree.preRootTraverse(root);
        System.out.println();
        biTree.inRootTraverse(root);
        System.out.println();
        biTree.postRootTraverse(root);
        System.out.println();


        System.out.println(new BiTree().isEmpty());
        System.out.println(biTree.isEmpty());

        biTree.levelTraverse();

    }

}
