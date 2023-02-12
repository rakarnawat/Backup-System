package studentRecordsBackupTree.bst;

class Backup1 implements Observer{
    Node root;
      
    public void notify(int post, Node root)  {
        //System.out.println("Update value "+post);
        root = update_Recursive(root, post);
        inorder_Recursive(root);
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
     
    
    // recursively traverse the BST  
    void inorder_Recursive(Node root) { 
        if (root != null) { 
             inorder_Recursive(root.left); 
             //System.out.print(root.nodeValue + " ");
             inorder_Recursive(root.right);
        }
         
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
}