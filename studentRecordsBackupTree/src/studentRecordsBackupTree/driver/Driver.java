package studentRecordsBackupTree.driver;


import studentRecordsBackupTree.bst.processInput;

/**
 * @author placeholder
 *
 */
public class Driver {
	public static void main(String[] args) {

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */

		//System.out.println("args length: "+ args.length + "\nargs[0]: "+args[0]+"\nargs[1]: "+ args[1] + "\nargs[2]: "+args[2] + "\nargs[3]: "+args[3] + "\nargs[4]: "+args[4]);

	    if (args.length != 5 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")
				|| args[3].equals("${arg3}") || args[4].equals("${arg4}")) {

			System.err.println("Error: Incorrect number of arguments. Program accepts 5 argumnets.");
			System.exit(0);
		}
		
		//System.out.println("Hello World! Lets get started with the assignment");

		String bstInputFilePath = args[0];
		String bstOutputFilePath = args[1];
		String errorLogFilePath = args[2];
		//int debugLevel = Integer.parseInt(args[3]);
		int updateValue = Integer.parseInt(args[4]);

		
		processInput FP = new processInput();
		FP.fetchBstInput(bstInputFilePath, errorLogFilePath, updateValue, bstOutputFilePath);
	}
}
