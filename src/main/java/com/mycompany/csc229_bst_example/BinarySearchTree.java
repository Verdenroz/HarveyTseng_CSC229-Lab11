package com.mycompany.csc229_bst_example;
/**
 *
 * @author MoaathAlrajab
 */
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private BstNode root;

    public boolean isEmpty() {
        return (this.root == null);
    }

    public void insert(Integer data) {

        System.out.print("[input: " + data + "]");
        if (root == null) {
            this.root = new BstNode(data);
            System.out.println(" -> inserted: " + data);
            return;
        }
        insertNode(this.root, data);
        System.out.print(" -> inserted: " + data);
        System.out.println();
    }

    private BstNode insertNode(BstNode root, Integer data) {
        
        BstNode tmpNode = null;
        System.out.print(" ->" + root.getData());
        if (root.getData() >= data) {
            System.out.print(" [L]");
            if (root.getLeft() == null) {
                root.setLeft(new BstNode(data));
                return root.getLeft();
            } else {
                tmpNode = root.getLeft();
            }
        } else {
            System.out.print(" [R]");
            if (root.getRight() == null) {
                root.setRight(new BstNode(data));
                return root.getRight();
            } else {
                tmpNode = root.getRight();
            }
        }
        return insertNode(tmpNode, data);
    }

    public void inOrderTraversal() {
        doInOrder(this.root);
    }

    private void doInOrder(BstNode root) {
        // ToDo 1: complete InOrder Traversal 
        if(root == null)
            return;
        
        doInOrder(root.getLeft());
        System.out.println(root.getData() + " Depth: " + this.getDepth(root));
        doInOrder(root.getRight());
    }
    
    public void preOrderTraversal() {
        doPreOrder(this.root);
        // ToDo 2: complete the pre-order travesal . 
    }
    
    private void doPreOrder(BstNode root){
        if(root == null)
            return;
        
        System.out.println(root.getData() + " Depth: " + this.getDepth(root));
        doPreOrder(root.getLeft());
        doPreOrder(root.getRight());
    }
            
    public Integer findHeight() {
        // ToDo 3: Find the height of a tree (largest depth of a node)
        LinkedList<BstNode> nodes = new LinkedList<BstNode>();
        
        if(this.root == null){
            return 0;
        }
        
        //start from the root
        nodes.add(this.root);
        int height = 0;
        int numNodes = nodes.size();
        while(true){
            numNodes = nodes.size();
            //break when the current level has no nodes
            if(numNodes == 0)
                break;
            height++;
            
            //add the nodes of the next level and remove current nodes
            for(int i = 0; i < numNodes; i++){
                BstNode newNode = nodes.peek();
                nodes.remove();
                if(newNode.getLeft() != null){
                    nodes.add(newNode.getLeft());
                }
                if(newNode.getRight() != null){
                    nodes.add(newNode.getRight());
                }
            }
        }
        //returns the height of the last level before 0 nodes
        return height - 1;
    }
    
   
    public int getDepth(BstNode node) {
        //ToDo 4: complete getDepth of a node
        LinkedList<BstNode> list = new LinkedList<BstNode>();
        
        if(this.root == null){
            return 0;
        }
        
        //start from the root
        list.add(this.root);
        int depth = 0;
        int numNodes = list.size();
        while(true){
            numNodes = list.size();
            
            //check each level if it contains the node
            if(list.contains(node))
                break;
            
            depth++;
            
            //add the nodes of the next level and remove current nodes
            for(int i = 0; i < numNodes; i++){
                BstNode newNode = list.peek();
                list.remove();
                if(newNode.getLeft() != null){
                    list.add(newNode.getLeft());
                }
                if(newNode.getRight() != null){
                    list.add(newNode.getRight());
                }
            }
        }
        return depth;
    }
    
   public void print() {
       System.out.println("\n==== BST Print ===== \n");
        //print("", root, false);
        // ToDo 5: complete the print of the BST
        
        LinkedList<BstNode> nodes = new LinkedList<BstNode>();
        
        if(this.root == null){
            return;
        }
        
        //start from the root
        nodes.add(this.root);
        int height = 0;
        int numNodes = nodes.size();
        while(true){
            numNodes = nodes.size();
            //break when the current level has no nodes
            if(numNodes == 0)
                break;
            height++;
            
            //add the nodes of the next level and remove current nodes
            for(int i = 0; i < numNodes; i++){
                BstNode newNode = nodes.peek();
                System.out.print(newNode.getData() + " ");
                nodes.remove();
                if(newNode.getLeft() != null){
                    nodes.add(newNode.getLeft());
                }
                if(newNode.getRight() != null){
                    nodes.add(newNode.getRight());
                }
            }
        }
        
        
    }

}
