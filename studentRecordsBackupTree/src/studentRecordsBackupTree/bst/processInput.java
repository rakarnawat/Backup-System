package studentRecordsBackupTree.bst;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class processInput {
	public void fetchBstInput(String bstInputFilePath, String errorLogFilePath, int updateValue, String fileName){
        String logFilePath = errorLogFilePath;
         List<Integer> BSTArray =null;
         List<Integer> Backup1Array = null;
         List<Integer> Backup2Array = null;
         //(uncomment the following code to print the updated node)
         //List<Integer> BSTArray1 =null;
         //List<Integer> Backup1Array1 = null;
         //List<Integer> Backup2Array1 = null;
         FileWriter logWriter;
        try {
            logWriter = new FileWriter(logFilePath);
        
        try {
            //String fileName = "bstOutput.txt";
            FileWriter fw1;
            fw1 = new FileWriter(fileName);
            
           
            Backup1 b1 = new Backup1();
            Backup2 b2 = new Backup2();
            
            //create a BST object and instance of backup1,backup2 using BST class
            BST backup1 = new BST();
            BST backup2 = new BST();
            BST processInput = new BST();

            //user observer pattern to add backup1 and backup2 as observer
            backup1.addObserver(b1);
            backup2.addObserver(b2);

            //Read BST input file
            File bstInputFile = new File(bstInputFilePath);
            Scanner sc =new Scanner(bstInputFile);

            int bstValue;
            //Read values and insert it into the BST and Backup1,Backup2
            while(sc.hasNextLine()){
                    int bv = sc.nextInt();
                    //System.out.println(bv);
                    bstValue=Integer.valueOf(bv);
                    processInput.insert(bstValue);
                    backup1.insert(bstValue);
                    backup2.insert(bstValue);
            }
            sc.close();

            
            try {   
                FileWriter fw = new FileWriter(fileName,true);
                
            //----------------------------------------------------------------------------------
            //PRINT BST INORDER
            //----------------------------------------------------------------------------------
            
            System.out.println("// Inorder traversal");
            fw.write("// Inorder traversal");
            
            System.out.print("Bst: ");
            fw.write("\nBST: ");
            BSTArray=processInput.inorder();
            for(int i=0;i<BSTArray.size(); i++){
                fw.write(BSTArray.get(i) +" ");
             }
            //fw.write(BSTArray.toString());
            System.out.println("");

            System.out.print("Backup-1: ");
            fw.write("\nBackup-1: ");
            Backup1Array=backup1.inorder();
            for(int i=0;i<Backup1Array.size(); i++){
                fw.write(Backup1Array.get(i) +" ");
             }
            System.out.println("");
            
            System.out.print("Backup-2: ");
            fw.write("\nBackup-2: ");
            Backup2Array=backup2.inorder();
            for(int i=0;i<Backup2Array.size(); i++){
                fw.write(Backup2Array.get(i) +" ");
             }
            System.out.println("");

            //----------------------------------------------------------------------------------
            //PRINT BST SUM
            //----------------------------------------------------------------------------------
            System.out.println("\n// Sum of all the B-Numbers in each tree");
            fw.write("\n\n// Sum of all the B-Numbers in each tree");
            
            int bstSum = processInput.findSum();
            System.out.println("BST: " + bstSum);
            fw.write("\nBST: " + bstSum);
            //System.out.println("");
            
            int backup1Sum = backup1.findSum();
            System.out.println("Backup-1: " + backup1Sum);
            fw.write("\nBackup-1: " + backup1Sum);
            //System.out.println("");
            
            int backup2Sum = backup2.findSum();
            System.out.println("Backup-2: " + backup2Sum);
            fw.write("\nBackup-2: " + backup2Sum);
            System.out.println("");

            //-------------------------------------------------------------------------------------
            //UPDATE BST VALUE AND USE OBSERVER PATTERN TO UPDATE BACKUP 
            //(uncomment the following code to print the updated node)
            //-------------------------------------------------------------------------------------
            //System.out.println("//Inorder after increment");
            
            //System.out.print("BST: ");
            processInput.update(updateValue);
            //processInput.inorder();
            //System.out.println("");
            
            //System.out.print("Backup-1: ");;
            backup1.backup(updateValue);
            // backup1.inorder();
            //System.out.println("");
            
            //System.out.print("Backup-2: ");
            backup2.backup(updateValue);
            //backup2.inorder();
            //System.out.println("");

            //-------------------------------------------------------------------------------------
            //PRINT SUM AFTER UPDATE
            //-------------------------------------------------------------------------------------
            System.out.println("// Sum of all the B-Numbers after increment");
            fw.write("\n\n// Sum of all the B-Numbers after increment");
            
            int bstSum1 = processInput.findSum();
            System.out.println("BST: " + bstSum1);
            fw.write("\nBST: " + bstSum1);
            int backup1Sum1 = backup1.findSum();

            System.out.println("Backup-1: " + backup1Sum1);
            fw.write("\nBackup-1: "+ backup1Sum1);
            //System.out.println("");
            
            int backup2Sum2 = backup2.findSum();
            System.out.println("Backup-2: " + backup2Sum2);
            fw.write("\nBackup-2: " + backup2Sum2);
            
            fw.close();
        } catch (IOException e) {
            //e.printStackTrace();
            logWriter.write("IO excpetion occurred in processInput.java file");
            System.err.println("IO excpetion occurred in processInput.java file");
        }finally{}
            fw1.close();
        //sc.close();
        }catch(FileNotFoundException e){
            logWriter.write("\nFile Not Found Error from processInput.java ");
            System.err.println("\nFile Not Found Error from processInput.java");
        }catch(Exception e){
            logWriter.write("\nexception occurred in processInput.java file");
            System.err.println("\nexception occurred in processInput.java file");
        }finally{}
    } catch (IOException e1) {
        //e1.printStackTrace();
        System.err.println("Error in logWriter from processInput.java file");

    }finally{}
        
    }
}