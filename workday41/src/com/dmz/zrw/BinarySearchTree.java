package com.dmz.zrw;

import java.util.*;

/*
API:
    增：
        // boolean add(E e)
    删：
        // boolean remove(E obj)
        // void clear()
    查：
        // boolean contains(E obj)
        // E min()
        // E max()
    遍历：
        // List<E> preOrder()
        // List<E> inOrder()
        // List<E> postOrder()
        // List<E> levelOrder()
    获取集合属性：
        // int size()
        // boolean isEmpty()
        int height()
    建树：
        // static BinarySearchTree buildTree(List preOrder, List inOrder)

问题：在Java中怎样的对象是可比较的？
    Comparable接口实现的子类
    E extends Comparable 代表：Comparable或者Comparable的子类
     E(定义泛型) extends Comparable<E（使用泛型）> 这样写已经写得很好了，E是什么元素，就比较什么元素
    <E extends Comparable<? super E>>：Comparable接口可以比较E及E的父类，这样更能比较E了（用父类的地方一定可以用子类）
问题：我们实现的BST中, 添加、删除和查找元素的时间复杂度分别是多少呢？
查找：O(h) h是树的高度
添加：O(h)
删除：O(h)
问题：每次删除度为2的结点，都是从右子树中删除。在动态的添加和删除元素的过程中，
会导致树往左倾斜。这样的树是不平衡的，最坏情况下会退化成链表。
    自平衡二叉树
自平衡二叉树
    a. AVL树 (对于任意一个结点，它的左子树和右子树的高度之差不超过1)
        h = O(logn)
    b. 红黑树
        利用红黑规则，保证树的高度 h = O(logn)
AVL树 VS 红黑树
查找：AVL > 红黑树
添加：红黑树 > AVL
删除：红黑树 > AVL
 */
public class BinarySearchTree<E extends Comparable<? super E>> {
    // 属性
    private TreeNode root;
    private int size;

    private class TreeNode {
        E value;
        TreeNode left;
        TreeNode right;

        public TreeNode(E value) {
            this.value = value;
        }
    }

    /**
     * 添加元素
     *
     * @param e 待添加的元素
     * @return 如果添加成功返回true, 否则返回false
     */
    public boolean add(E e) {
        // 循环实现
        /*if (e == null) {
            throw new IllegalArgumentException("Key cannot be null.");
        }
        // 判断树是否为空
        if (root == null) {
            root = new TreeNode(e);
            size++;
            return true;
        }
        // 不是空树
        TreeNode p = null;
        TreeNode x = root;
        int cmp;
        do{
            cmp = e.compareTo(x.value);
            p = x;
            if (cmp < 0) {
                // 往左走
                x = x.left;
            } else if (cmp > 0) {
                // 往右走
                x  = x.right;
            } else return false;
        } while (x != null);
        // x == null;
        if (cmp < 0) p.left = new TreeNode(e);
        else p.right = new TreeNode(e);
        size++;
        return true;*/

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
     * 删除与指定对象相等的元素
     *
     * @param obj 指定对象
     * @return 如果删除成功返回true, 否则返回false
     */
    public boolean remove(E obj) {
        // 循环删除
        /*if (obj == null) throw new IllegalArgumentException("Key cannot be null.");
        // 找到要删除的结点
        TreeNode p = null;
        TreeNode x = root;
        while (x != null) {
            int cmp = obj.compareTo(x.value);
            if (cmp < 0) {
                p = x;
                x = x.left;
            } else if (cmp > 0) {
                p = x;
                x = x.right;
            }
            else break;
        }
        // x==null, break
        // 不存在与指定对象相等的元素
        if (x == null) return false;
        // x != null, x就是要删除的结点
        // 删除x结点
        // 度为2
        if (x.left != null && x.right != null) {
            TreeNode minP = x;
            TreeNode minX = x.right;
            while (minX.left != null) {
                minP = minX;
                minX = minX.left;
            }
            // minX指向右子树的最小结点, minP指向右子树最小结点的父节点。
            // 交换值
            x.value = minX.value;
            // 退化成度为0或者度为1
            p = minP;
            x = minX;
        }
        // 删除x结点即可。x结点的度只能是0或者1。
        TreeNode child = x.left != null ? x.left : x.right;
        // x指向的是根结点
        if (p == null) root = child;
        else {
            if (p.left == x) p.left = child;
            else p.right = child;
        }
        size--;
        return true;*/

        // 递归实现
        if (obj == null) throw new IllegalArgumentException("Key cannot be null.");
        int oldSize = size;
        root = remove(root, obj);
        return oldSize > size;
    }

    private TreeNode remove(TreeNode node, E obj) {
        // 边界条件
        if (node == null) return null;
        int cmp = obj.compareTo(node.value);
        // 在左子树中删除
        if (cmp < 0) node.left = remove(node.left, obj);
            // 在右子树中删除
        else if (cmp > 0) node.right = remove(node.right, obj);
        else {
            // 度为2
            if (node.left != null && node.right != null) {
                // 找右子树的最小结点
                TreeNode minOfRight = node.right;
                while (minOfRight.left != null) {
                    minOfRight = minOfRight.left;
                }
                node.value = minOfRight.value;
                // 在右子树中删除最小结点
                node.right = remove(node.right, minOfRight.value);
            } else {
                // 度为0或者1
                TreeNode child = node.left != null ? node.left : node.right;
                size--;
                // 返回孩子结点相当于删除该结点
                return child;
            }
        }
        return node;
    }

    /**
     * 判断BST是否有与指定对象相等的元素
     *
     * @param obj 指定对象
     * @return 如果存在与指定对象相等的元素返回true, 否则返回false
     */
    public boolean contains(E obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Key cannot be null.");
        }
        TreeNode x = root;
        while (x != null) {
            int cmp = obj.compareTo(x.value);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return true;
        }
        // x == null
        return false;
    }

    /**
     * 获取BST的最小元素
     *
     * @return 最小元素
     */
    public E min() {
        if (isEmpty()) throw new NoSuchElementException("The tree is Empty.");
        TreeNode x = root;
        while (x.left != null) x = x.left;
        return x.value;
    }

    /**
     * 获取BST的最大元素
     *
     * @return 最大元素
     */
    public E max() {
        if (isEmpty()) throw new NoSuchElementException("The tree is Empty.");
        TreeNode x = root;
        while (x.right != null) x = x.right;
        return x.value;
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
     * 获取树的高度
     *
     * @return 树的高度
     */
    public int height() {
        return height(root);
    }

    private int height(TreeNode node) {
        // 边界条件
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
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
        /*List<E> list = new ArrayList<>();
        preOrder(root, list);
        return list;*/

        // 用栈实现先序遍历
        List<E> list = new ArrayList<>();
        if (isEmpty()) return list;
        Deque<TreeNode> stack = new LinkedList<>();
        // 将根节点入栈
        stack.push(root);
        // 判断栈是否为空
        while (!stack.isEmpty()) {
            // 出栈
            TreeNode x = stack.pop();
            list.add(x.value);
            // 判断是否有右孩子
            if (x.right != null) stack.push(x.right);
            // 判断是否有左孩子
            if (x.left != null) stack.push(x.left);
        }
        // 返回list
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
        /*List<E> list = new ArrayList<>();
        inOrder(root, list);
        return list;*/

        // 用栈实现中序遍历
        List<E> list = new ArrayList<>();
        if (isEmpty()) return list;
        Deque<TreeNode> stack = new LinkedList<>();
        // 把x指向根结点
        TreeNode x = root;
        // 判断x是否为null或者栈是否为空
        while (x != null || !stack.isEmpty()) {
            // 如果x不等于null, 就将x结点入栈，往左走,直到x等于null
            while (x != null) {
                stack.push(x);
                x = x.left;
            }
            // 出栈, 处理根节点
            x = stack.pop();
            list.add(x.value);
            // 往右走,遍历右子树
            x = x.right;
        }
        // 返回list
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
        /*List<E> list = new ArrayList<>();
        postOrder(root, list);
        return list;*/

        // 用栈实现
        List<E> list = new LinkedList<>();
        if (isEmpty()) return list;
        Deque<TreeNode> stack = new LinkedList<>();
        // 将根节点入栈
        stack.push(root);
        // 判断栈是否为空
        while (!stack.isEmpty()) {
            // 出栈
            TreeNode x = stack.pop();
            list.add(0, x.value);
            // 判断是否有左孩子
            if (x.left != null) stack.push(x.left);
            // 判断是否有右孩子
            if (x.right != null) stack.push(x.right);
        }
        // 返回list
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

    /**
     * 层级遍历
     *
     * @return 层级遍历的序列
     */
    public List<E> levelOrder() {
        List<E> list = new ArrayList<>();
        if (isEmpty()) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        // 将根节点入队列
        queue.offer(root);
        // 判断队列是否为空
        while (!queue.isEmpty()) {
            // 出队列，并将元素添加到list
            TreeNode x = queue.poll();
            list.add(x.value);
            // 判断是否有左孩子
            if (x.left != null) queue.offer(x.left);
            // 判断是否有右孩子
            if (x.right != null) queue.offer(x.right);
        }
        return list;
    }

    /**
     * 层级遍历
     *
     * @return 层级遍历的序列
     */
    public List<List<E>> levelOrder1() {
        List<List<E>> list = new ArrayList<>();
        if (isEmpty()) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        // 将根结点入队列
        queue.offer(root);
        // 判断队列是否为空
        while (!queue.isEmpty()) {
            // 求此时队列的长度，也就是这一层元素的个数
            int sz = queue.size();
            // 处理这一层
            List<E> temp = new ArrayList<>();
            for (int i = 0; i < sz; i++) {
                TreeNode x = queue.poll();
                temp.add(x.value);
                // 判断是否有左孩子
                if (x.left != null) queue.offer(x.left);
                // 判断是否有右孩子
                if (x.right != null) queue.offer(x.right);
            }
            // 这一层处理完毕
            list.add(temp);
        }
        return list;
    }

    //在 BinarySearchTree 中，添加一个方法，实现层级倒序遍历
    public List<List<E>> levelOrderReverse() {
        LinkedList<List<E>> list = new LinkedList<>();
        if (isEmpty()) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        // 将根结点入队列
        queue.offer(root);
        // 判断队列是否为空
        while (!queue.isEmpty()) {
            // 求此时队列的长度，也就是这一层元素的个数
            int sz = queue.size();
            // 处理这一层
            List<E> temp = new ArrayList<>();
            for (int i = 0; i < sz; i++) {
                TreeNode x = queue.poll();
                temp.add(x.value);
                // 判断是否有左孩子
                if (x.left != null) queue.offer(x.left);
                // 判断是否有右孩子
                if (x.right != null) queue.offer(x.right);
            }
            // 这一层处理完毕
            //list.add(temp);
            list.push(temp);
        }
        return list;
    }
/*
    *//**
     * 根据先序和中序构建BST
    /*
    //泛型方法，<T extends Comparable<? super T>> 定义T
    public static <T extends Comparable<? super T>> BinarySearchTree<T> buildTree(List<T> preOrder, List<T> inOrder) {
        BinarySearchTree<T> tree = new BinarySearchTree<>();
        // 给tree的属性进行赋值
        tree.size = preOrder.size();
        tree.root = tree.build(preOrder, inOrder);
        return tree;
    }

    private TreeNode build(List<E> preOrder, List<E> inOrder) {
        // 边界条件
        if (preOrder == null || preOrder.isEmpty()) return null;
        // 构建根结点
        E e = preOrder.get(0);
        TreeNode node = new TreeNode(e);
        int index = inOrder.indexOf(e);
        // 构建左子树
        List<E> leftPreOrder = preOrder.subList(1, index + 1);
        List<E> leftInOrder = inOrder.subList(0, index);
        node.left = build(leftPreOrder, leftInOrder);
        // 构建右子树
        List<E> rightPreOrder = preOrder.subList(index + 1, preOrder.size());
        List<E> rightInOrder = inOrder.subList(index + 1, inOrder.size());
        node.right = build(rightPreOrder, rightInOrder);
        // 返回根结点
        return node;
    }*/

    //根据后序和中序构建BST
    public static <T extends Comparable<? super T>> BinarySearchTree<T> buildTree(List<T> postOrder, List<T> inOrder) {
        BinarySearchTree<T> tree = new BinarySearchTree<>();
        // 给tree的属性进行赋值
        tree.size = postOrder.size();
        tree.root = tree.build(postOrder, inOrder);
        return tree;
    }

    private TreeNode build(List<E> postOrder, List<E> inOrder) {
        // 边界条件
        if (postOrder == null || postOrder.isEmpty()) return null;
        // 构建根结点
        E e = postOrder.get(postOrder.size()-1);
        TreeNode node = new TreeNode(e);
        int index = inOrder.indexOf(e);
        // 构建左子树
        List<E> leftPostOrder = postOrder.subList(0, index);
        List<E> leftInOrder = inOrder.subList(0, index);
        node.left = build(leftPostOrder, leftInOrder);
        // 构建右子树
        List<E> rightPostOrder = postOrder.subList(index, postOrder.size()-1);
        List<E> rightInOrder = inOrder.subList(index + 1, inOrder.size());
        node.right = build(rightPostOrder, rightInOrder);
        // 返回根结点
        return node;
    }
    public static void main(String[] args) {
        List<Character> inOrder = Arrays.asList('B', 'A', 'D', 'C', 'E');
        List<Character> postOrder = Arrays.asList('B', 'D', 'E', 'C', 'A');
        BinarySearchTree<Character> tree = BinarySearchTree.buildTree(postOrder, inOrder);
        System.out.println(tree.preOrder());
        System.out.println(tree.inOrder());
        System.out.println(tree.postOrder());
        System.out.println(tree.levelOrderReverse());

    }
}
