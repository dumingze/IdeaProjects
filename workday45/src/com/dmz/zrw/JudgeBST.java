package com.dmz.zrw;

public class JudgeBST {


/*2. 给定一棵二叉树，验证它是不是二叉搜索树。
    二叉搜索树的定义如下：
    a.左子树结点的关键字都比根结点小。
    b.右子树结点的关键字都比根节点大。
    c.左子树和右子树都是二叉搜索树。
    结点定义如下：
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    实现这个方法：public boolean isValidBST(TreeNode x) {}*/


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode x) {
        if (x == null) return true;
        if (x.left != null) {
            int maxOfLeft = max(x.left);
            if (x.val <= maxOfLeft) return false;
        }
        if (x.right != null) {
            int minOfRight = min(x.right);
            if (x.val >= minOfRight) return false;
        }
        return isValidBST(x.left) && isValidBST(x.right);
    }

    private int max(TreeNode x) {
        while (x.right != null) x = x.right;
        return x.val;
    }

    private int min(TreeNode x) {
        while (x.left != null) x = x.left;
        return x.val;
    }

/*

    2.
    //获取二叉树的中序遍历序列
    public void inOrder(TreeNode node, List<Integer> list) {
        // 边界条件
        if (node == null) return;
        // 遍历左子树
        inOrder(node.left, list);
        // 遍历根节点
        list.add(node.val);
        // 遍历右子树
        inOrder(node.right, list);
    }

    //判断二叉树是否为BST（若中序序列有序则为BST）
    public boolean isValidBST(TreeNode x){
        if (x==null) return true;
        //创建集合存储中序遍历序列
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(x,list);
        //遍历中序序列判断是否有序，若无序返回false，否则返回true
        for (int i = 1;i < list.size();){
            if (list.get(i) > list.get(i-1)) i++;
            else return false;
        }
        return true;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
*/


/*    public boolean isValidBST() {
//        a.左子树结点的关键字都比根结点小。
//        b.右子树结点的关键字都比根节点大。
//        c.左子树和右子树都是二叉搜索树。
        return isValid(root);
    }
    private boolean isValid(TreeNode root) {
        if(root.left!=null){
            int cmp = root.value.compareTo(root.left.value);
            if(cmp<0){
                return false;
            }
            isValid(root.left);
        }
        if(root.right!=null){
            int cmp = root.value.compareTo(root.right.value);
            if(cmp>0){
                return false;
            }
            isValid(root.right);
        }
        return true;
    }*/

}
