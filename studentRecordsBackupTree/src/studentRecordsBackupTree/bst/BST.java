//code for BST: https://www.softwaretestinghelp.com/binary-search-tree-in-java/
//code for Observer Pattern: https://javabypatel.blogspot.com/2016/06/observer-design-pattern-java.html

package studentRecordsBackupTree.bst;

import java.util.ArrayList;
import java.util.List;


public class BST implements Subject{
    
    // BST root node 
    Node root;

    List<Integer> inOrderArray = new ArrayList<Integer>();
    private int updateValue;
    private List<Observer> listOfObserver = new ArrayList<Observer>();

    // insert a node in BST 
    public void insert(int nodeValue)  { 
        root = insert_Recursive(root, nodeValue); 
    } 
    
    //recursive insert function
    Node insert_Recursive(Node root, int nodeValue) { 
        //check if tree is empty
        if(root == null) { 
            root = new Node(nodeValue); 
            return root; 
        } 
        //traverse the tree
        if(nodeValue < root.nodeValue){     
        //insert in the left subtree
            root.left = insert_Recursive(root.left, nodeValue);} 
        else if(nodeValue > root.nodeValue){    
        //insert in the right subtree
            root.right = insert_Recursive(root.right, nodeValue);} 

        return root; 
    } 
    
    public void update(int post)  {
    root = update_Recursive(root, post); 
    } 

    //recursive insert function
    Node update_Recursive(Node root, int post) { 
        //check if tree is empty
        if(root == null) {
            return root; 
        }else{
        update_Recursive(root.left,post); 
        root.nodeValue=root.nodeValue+post;
        update_Recursive(root.right,post);
        }
        return root; 
    } 
        

    public List<Integer> inorder() { 
    //System.out.println("\n");
    return(inorder_Recursive(root));
        //return inorder_Recursive(root); 
    } 

    // recursively traverse the BST  
    List<Integer> inorder_Recursive(Node root) {
        if (root != null) { 
            inorder_Recursive(root.left); 
            System.out.print(root.nodeValue + " ");
            inOrderArray.add(root.nodeValue);
            inorder_Recursive(root.right);
        }
        
        //System.out.println("Array: "+ inOrderArray);
    
        return inOrderArray;
    }

    public int findSum(){
        return(addBT(root));
    }
    int addBT(Node root)
    {
    if (root == null)
        return 0;
    return (root.nodeValue + addBT(root.left) + addBT(root.right));
    }
    
    public void addObserver(Observer observer) {
        listOfObserver.add(observer);
    }

    public void notifyObservers() {
        for (Observer observer : listOfObserver) {
            //System.out.println("Rasdfasf ");
            if(root==null){
                System.out.print("Root is still null in BST");
            }
            //System.out.println("in notify observer func" + root.nodeValue);
        observer.notify(updateValue, root);
        }
    }
    
    public void backup(int updateValue) {
            //System.out.println("backup func called");
        this.updateValue = updateValue;
        notifyObservers();
    }
}