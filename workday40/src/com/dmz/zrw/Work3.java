package com.dmz.zrw;


import java.util.ArrayList;
import java.util.List;

/*  2. 反转二叉树*/
/*仿照BST中递归添加，递归实现BST的boolean remove(E e)方法*/
public class Work3<E extends Comparable<? super E>> {
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
     *
     * @return 元素的个数
     */
    public int size() {
        return size;
    }

    /**
     * 判断BST是否为空树
     *
     * @return 如果BST为空树返回true, 否则返回false
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * 先序遍历
     *
     * @return 先序遍历的序列
     */
    public List<E> preOrder() {
        List<E> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    private void preOrder(TreeNode node, List<E> list) {
        // 边界条件
        if (node == null) return;
        // 遍历根节点
        list.add(node.value);
        // 遍历左子树
        preOrder(node.left, list);
        // 遍历右子树
        preOrder(node.right, list);
    }

    /**
     * 中序遍历
     *
     * @return 中序遍历的序列
     */
    public List<E> inOrder() {
        List<E> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    private void inOrder(TreeNode node, List<E> list) {
        // 边界条件
        if (node == null) return;
        // 遍历左子树
        inOrder(node.left, list);
        // 遍历根节点
        list.add(node.value);
        // 遍历右子树
        inOrder(node.right, list);
    }

    /**
     * 后序遍历
     *
     * @return 后序遍历的序列
     */
    public List<E> postOrder() {
        List<E> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    private void postOrder(TreeNode node, List<E> list) {
        // 边界条件
        if (node == null) return;
        // 遍历左子树
        postOrder(node.left, list);
        // 遍历右子树
        postOrder(node.right, list);
        // 遍历根节点
        list.add(node.value);
    }

    public TreeNode reverseMyBinaryTree(TreeNode currentRoot) {
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
        if (currentRoot == null) {
            return null;
        }
        TreeNode left = reverseMyBinaryTree(currentRoot.left);
        TreeNode right = reverseMyBinaryTree(currentRoot.right);
        currentRoot.left = right;
        currentRoot.right = left;
        return currentRoot;
    }

    public boolean remove(E e) {
        if (e == null) {
            throw new IllegalArgumentException("Key cannot be null.");
        }
        int oldSize = size;
        root= remove(root, e);
        return size > oldSize;
    }

    private TreeNode remove(TreeNode x, E e) {
        if (x == null) return null;
        int cmp = e.compareTo(x.value);
// cmp < 0, 在左子树中删除
        if (cmp < 0) x.left = remove(x.left, e);
// cmp > 0, 在右子树中删除
        else if (cmp > 0) x.right = remove(x.right, e);
        else {
            // 度为2的情况
            if (x.left != null && x.right != null) {
// 找到右子树的最小结点
                TreeNode minOfRight = x.right;
                while (minOfRight.left != null) {
                    minOfRight = minOfRight.left;
                }
                x.value = minOfRight.value;
// 在右子树中删除最小结点
                x.right = remove(x.right, minOfRight.value);
            } else {
// 度为0或者度为1的情况
                TreeNode child = x.left != null ? x.left : x.right;
                size--;
                return child;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        Work3<Integer> tree = new Work3<>();
        tree.add(4);
        tree.add(2);
        tree.add(7);
        tree.add(1);
        tree.add(3);
        tree.add(6);
        tree.add(9);


        // List<E> preOrder()
        System.out.println(tree.preOrder()); //[[4, 2, 1, 3, 7, 6, 9]]
        //reserves
        tree.root = tree.reverseMyBinaryTree(tree.root);
        System.out.println(tree.preOrder()); //[4, 7, 9, 6, 2, 3, 1]


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
