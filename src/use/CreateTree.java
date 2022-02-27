package use;


import pojo.TreeNode;

import java.util.LinkedList;

public class CreateTree {

    public static TreeNode CreateBinaryTree(LinkedList<Integer> inputList){
        TreeNode node = null;
        if(inputList == null||inputList.isEmpty()){
            return null;
        }
        Integer data = inputList.removeFirst();
        if(data != null){
            node = new TreeNode(data);
            node.leftChild = CreateBinaryTree(inputList);
            node.rightChild  = CreateBinaryTree(inputList);
        }
        return node;
    }


}
