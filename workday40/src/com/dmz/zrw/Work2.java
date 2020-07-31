package com.dmz.zrw;

import java.util.ArrayList;
import java.util.List;
/*  2. 反转二叉树*/
public class Work2<E  extends Comparable<? super E>> {
    private TreeNode root;
    private int size;


     public boolean add(E e) {


         // 递归实现
         if (e == null) {
             throw new IllegalArgumentException("Key cannot be null.");
         }
         int oldSize = size;
         root = add(root, e);
         return size > oldSize;
     }

    private TreeNode add(TreeNode node, E e) {
        // 边界条件
        if (node == null) {
            size++;
            return new TreeNode(e);
        }
        int cmp = e.compareTo(node.value);
        if (cmp < 0) node.left = add(node.left, e);
        else if (cmp > 0) node.right = add(node.right, e);
        return node;
    }

    /**
     * 清空所有元素
     */
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * 获取集合中元素的个数
     * @return 元素的个数
     */
    public int size() {
        return size;
    }

    /**
     * 判断BST是否为空树
     * @return 如果BST为空树返回true,否则返回false
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * 先序遍历
     * @return 先序遍历的序列
     */
    public List<E> preOrder() {
        List<E> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    private void preOrder(TreeNode node, List<E> list) {
        // 边界条件
        if (node == null) return ;
        // 遍历根节点
        list.add(node.value);
        // 遍历左子树
        preOrder(node.left, list);
        // 遍历右子树
        preOrder(node.right, list);
    }

    /**
     * 中序遍历
     * @return 中序遍历的序列
     */
    public List<E> inOrder() {
        List<E> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    private void inOrder(TreeNode node, List<E> list) {
        // 边界条件
        if (node == null) return ;
        // 遍历左子树
        inOrder(node.left, list);
        // 遍历根节点
        list.add(node.value);
        // 遍历右子树
        inOrder(node.right, list);
    }

    /**
     * 后序遍历
     * @return 后序遍历的序列
     */
    public List<E> postOrder() {
        List<E> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    private void postOrder(TreeNode node, List<E> list) {
        // 边界条件
        if (node == null) return ;
        // 遍历左子树
        postOrder(node.left, list);
        // 遍历右子树
        postOrder(node.right, list);
        // 遍历根节点
        list.add(node.value);
    }

    public   TreeNode reverseMyBinaryTree(TreeNode currentRoot){
/*        TreeNode node=currentRoot;

        if (currentRoot==null){return null;}

        TreeNode left=reverseMyBinaryTree(currentRoot.right);
        TreeNode right=reverseMyBinaryTree(currentRoot.left);


*//*      node.left=reverseMyBinaryTree(currentRoot.right);
        node.right=reverseMyBinaryTree(currentRoot.left);
        return node;*//*

        node.left=left;
        node.right=right;
        return node;*/

        //标准答案
        if(currentRoot==null){return null;}
        TreeNode left=reverseMyBinaryTree(currentRoot.left);
        TreeNode right=reverseMyBinaryTree(currentRoot.right);
        currentRoot.left=right;
        currentRoot.right=left;
        return currentRoot;
    }




    public static void main(String[] args) {
        Work2<Integer> tree = new Work2<>();
        tree.add(4);
        tree.add(2);
        tree.add(7);tree.add(1);tree.add(3);tree.add(6);tree.add(9);


        // List<E> preOrder()
        System.out.println(tree.preOrder()); //[[4, 2, 1, 3, 7, 6, 9]]

        tree.root=tree.reverseMyBinaryTree(tree.root);
        System.out.println(tree.preOrder()); //[C, A, B, D, E]


    }






    private class TreeNode {
        E value;
        TreeNode left;
        TreeNode right;

        public TreeNode(E value) {
            this.value = value;
        }
    }
}
