Following are the commands and the instructions to run ANT on the project.
#### Note: build.xml is present in studentCoursesBackup/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile studentRecordsBackupTree/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile studentRecordsBackupTree/src/build.xml all

Description: Compiles the code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile studentRecordsBackupTree/src/build.xml run -Darg0=bstInput.txt -Darg1=bstOutput.txt -Darg2=errorLog.txt -Darg3=1 -Darg4=1

Description:
1. Drag0 = bst input file name 
2. Drag1 = bst output file name
3. Drag2 = error log file name
4. Drag3 = debug level as integer
5. Drag4 = update value as integer

-----------------------------------------------------------------------
## Time Complexicity: O(n)
-----------------------------------------------------------------------
## Description:
1.  Created a Node to store B-number and Description.
2. Read the Input file line by line i.e bstInput.txt using the processInput.txt file.
3. Initalized the instance of BST, Backup1,Backup2 using BST class and observers are being added using the backup1, backup2 i.e instance of same BST class.
4. Inserted values in the BST while reading the input file. While inserting value it is checked if the tree is empty of not and inseted value at the correct position by calling the insert_Recursive function recusively. 
5. Printed the BST, Backup-1 and Backup-2 using the indorder function which prints in left-root-right fashion and then printed the sum.
6.Now updated the BST by adding the updateValue to it and passed the updateValue to the backups using the observer pattern. i.e :
    - pass update value to backup method and which will call notifyObservers method it uses for loop over a listofobserver array to notify all observers. 
7. Once the observers gets the value to be updated the using the upadte function the observers i.e Backup1 and Backup2 will update/increment the value in the BST.
8. Now the sum of updated tree and the backups can be printed using the respective instance of BST and Backups.
9. Also to write the inorder output in the output file, List of Integers is being created and method inorder will return the list consisting of BST values inorder and this list is used to write the output inbstOutput.txt file.
10. All the error and exceptions are being logged in the errorLog.txt file.

-----------------------------------------------------------------------
#### Citations
-----------------------------------------------------------------------

- ####code for BST: https://www.softwaretestinghelp.com/binary-search-tree-in-java/
- ####code for Observer Pattern: https://javabypatel.blogspot.com/2016/06/observer-design-pattern-java.html
