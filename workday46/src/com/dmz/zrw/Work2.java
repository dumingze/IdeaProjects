package com.dmz.zrw;

import java.util.Deque;
import java.util.LinkedList;

public class Work2 {
/*    2. 给定一棵二叉树，判断它是不是镜像对称的。
    比如：
            1
            / \
            2   2
            / \ / \
            3  4 4  3
    这是镜像对称的
    1
            / \
            2   2
            \   \
            3    3
    这不是镜像对称的*/

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

     public boolean judgeTreeIsMirror(TreeNode root){

         return isSame(root,root);

     }
    public boolean isSame(TreeNode t1,TreeNode t2){
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return t1.val == t2.val && isSame(t1.left,t2.right) && isSame(t1.right,t2.left);
    }

}
