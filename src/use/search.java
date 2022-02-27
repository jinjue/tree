package use;

import pojo.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class search {

    public static void inOrderTraveral(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;
        while(treeNode !=null||!stack.isEmpty()){
            while(treeNode!=null){

                stack.push(treeNode);
                treeNode = treeNode.leftChild;

            }
            System.out.println();
            if(!stack.isEmpty()){

                treeNode = stack.peek();
                stack.pop();
                System.out.print(treeNode.data+" ");
                treeNode = treeNode.rightChild;
            }
        }


    }
    public static void postOrderTraveral(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;
        while(treeNode !=null||!stack.isEmpty()){
            while(treeNode!=null){
                stack.push(treeNode);
                treeNode = treeNode.leftChild;

            }

            if(!stack.isEmpty()){
                treeNode = stack.pop();
                System.out.println(treeNode.data);
                treeNode = treeNode.rightChild;
            }
        }
    }

    public static void main(String[] args){
        LinkedList<Integer> inputlist = new LinkedList<Integer>(Arrays.asList(new Integer[]{1,2,3,4,5,6,null}));
        CreateTree createTree = new CreateTree();
        TreeNode treeNode = createTree.CreateBinaryTree(inputlist);
        System.out.println("中序遍历：");
        inOrderTraveral(treeNode);

    }
}
