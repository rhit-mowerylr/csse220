package fileIO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Class: LevelIO
 * @author CSSE 220 Student
 * <br>Purpose: Demonstration of how to read and write files containing arcade game levels 
 * <br>Restrictions: restricted to reading and writing .txt files
 * <br>For example: 
 * <pre>
 *    LevelIO app = new LevelIO();
 * </pre>
 */
public class LevelIO {
	
	
	/***************************************************************************
		For the writeFile method
		
		Use the java.io class PrintWriter to write out the following
		arcade game board (below) to the file supplied by the filename parameter
		
Title: Sample arcade game level: a 20 x 20 field of play not counting boundaries
|--------------------|
|....................|
|..------............|
|.............----...|
|....................|
|....................|
|....................|
|............A.......|
|......---------.....|
|....................|
|....................|
|.......A............|
|.-------............|
|....................|
|....................|
|.-------............|
|....................|
|....................|
|.........------.....|
|....................|
|...H.............A..|
|--------------------|

	 ***************************************************************************/
	public void writeFile(String filename){
		boolean foundFile=false;
		String fileToRead=filename;

		while (!foundFile) {
			try {
				PrintWriter out = new PrintWriter(fileToRead);
				foundFile=true;
				out.println("|--------------------|");
				out.println("|....................|");
				out.println("|..------............|");
				out.println("|.............----...|");

				out.close();
			} catch (FileNotFoundException e) {
				System.err.println(e.getMessage());

				//Option 1: User gives correct filename in console
				Scanner in = new Scanner(System.in);
				System.out.print("Enter corrected filename:");
				fileToRead = in.nextLine().trim();
				System.out.println(fileToRead);

				//Option 2: User gives correct filename via JFileChooser
			}
		}
	}

	/*************************************************************************** 
		For the readFile method
		
		Use the java.io File class and the java.util Scanner class to read in the 
		file supplied by the filename parameter.
		For each line read in, use System.out to write the line to the console window
	 
	 ***************************************************************************/


	private void readFile(String filename){
		File file = new File(filename);
		try {
			Scanner in = new Scanner(file);  //Not new Scanner(System.in);
			while (in.hasNextLine()){
				String currentLine= in.nextLine();
				System.out.println(currentLine);
			}

			in.close();

		} catch (FileNotFoundException e){
			throw new RuntimeException(e);
		}
	}
	//-----------------------------------------------------------------------------------
	
	/**
	 * ensures: 1st writes a text file, then reads it back in
	 */
	public void runApp() {
		String filename = "levels/level1.txt";
		

		// TODO #1 Uncomment the calls to the writeFile and readFile methods (below)
		// TODO #2 Have Eclipse generate the stubs for these two methods
		// TODO #3 Implement both writeFile and readFile methods - read instructions above
		
		 writeFile(filename);
		 readFile(filename);
	} // runApp

	//-----------------------------------------------------------------------------------

	/**
	 * ensures: runs the app
	 * @param args parameter ignored
	 */
	public static void main(String[] args) {
		LevelIO app = new LevelIO();
		app.runApp();
	} // main
}

	
