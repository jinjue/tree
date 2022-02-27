package use;

import pojo.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class search {

    //创建二叉树
    public static TreeNode CreateBinaryTree(LinkedList<Integer> list){
        TreeNode node = null;
        if(list == null||list.isEmpty()){
            return null;
        }
        Integer data = list.removeFirst();
        if(data != null){
            node = new TreeNode(data);
            node.leftChild = CreateBinaryTree(list);
            node.rightChild  = CreateBinaryTree(list);
        }
        return node;
    }
    //二叉树前序遍历  （递归
    public static void preOrdersearch(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrdersearch(root.leftChild);
        preOrdersearch(root.rightChild);
    }

    //二叉树中序遍历  （递归
    public static void inOrdersearch(TreeNode root){
        if(root == null){
            return;
        }

        inOrdersearch(root.leftChild);
        System.out.print(root.data+" ");
        inOrdersearch(root.rightChild);
    }

    //二叉树后序遍历  （递归
    public static void postOrdersearch(TreeNode root){
        if(root == null){
            return;
        }

        postOrdersearch(root.leftChild);
        postOrdersearch(root.rightChild);
        System.out.print(root.data+" ");
    }


    //二叉树前序遍历  （非递归
    public static void preOrderTraveral(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;
        while(treeNode !=null||!stack.isEmpty()){
            while(treeNode!=null){

                System.out.print(treeNode.data+" ");
                stack.push(treeNode);
                treeNode = treeNode.leftChild;

            }
            if(!stack.isEmpty()){
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    //二叉树中序遍历  （非递归
    public static void inOrderTraveral(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;
        while(treeNode !=null||!stack.isEmpty()){
            while(treeNode!=null){

                stack.push(treeNode);
                treeNode = treeNode.leftChild;

            }
            if(!stack.isEmpty()){


                TreeNode top = stack.pop();
                System.out.print(top.data+" ");
                treeNode = top.rightChild;
            }
        }
    }
    //二叉树后序遍历  （非递归
    public static void postOrderTraveral(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> flag = new Stack<>();;
        while(root !=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                flag.push(1);
                root = root.leftChild;

            }
            while(!stack.isEmpty() && flag.peek() == 2){
                TreeNode top = stack.pop();
                System.out.print(top.data+" ");
                flag.pop();

            }
            if(!stack.isEmpty()){
                flag.pop();
                flag.push(2);
                root = stack.peek().rightChild;
            }
        }
    }

    public static void main(String[] args){
        LinkedList<Integer> inputlist = new LinkedList<Integer>(Arrays.asList(new Integer[]{1,null,2,3,null}));
//        CreateTree createTree = new CreateTree();
        TreeNode treeNode = CreateBinaryTree(inputlist);
        System.out.println("（递归）先序遍历：");
        preOrdersearch(treeNode);
        System.out.println();

        System.out.println("（非递归）先序遍历：");
        preOrderTraveral(treeNode);
        System.out.println();

        System.out.println("（递归）中序遍历：");
        inOrdersearch(treeNode);
        System.out.println();

        System.out.println("（非递归）中序遍历：");
        inOrderTraveral(treeNode);
        System.out.println();

        System.out.println("（递归）后序遍历：");
        postOrdersearch(treeNode);
        System.out.println();

        System.out.println("（非递归）后序遍历：");
        postOrderTraveral(treeNode);
        System.out.println();

    }
}
