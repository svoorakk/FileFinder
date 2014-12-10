package FileUtils;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class FileFinder {

	public FileFinder() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 *	args[0] : folder to search
	 *	args[1] : file name to search for
	 * @author Sridhar Voorakkara
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//args[0] : folder to search
		//args[1] : file name to search for
		if (args.length < 2) {
			System.out.print("At least two arguments needed - 1. Path of the folder to search, 2. Full name (with extension) of the file to be found");
			return;
		}
		String folderName = args[0];
		String fileName = args[1];
		File folder = new File(folderName);
		if (!folder.exists()) {
			System.out.print("Folder specified does not exist.");
			return;
		}
		FileFinder ff = new FileFinder();
		File fOut = ff.findFile(folderName, fileName);
		if (fOut == null) {
			System.out.print("File not found");
		} else {
			System.out.print("File found at : " + fOut.getCanonicalPath()); 
		}
	}

	//Look for the folder and return a match is found.
	private File findFile(String fileName, String folderPath) throws IOException {
		File f = new File(folderPath);
		File fOut = checkFolder(f, fileName);
		if (fOut != null) {
			return fOut;
		} else {
			return null;
		}
	}
	
	//Look into a folder for the file.
	private File checkFolder(File folder, String reqFileName) {
		String[] fileList = folder.list();
		for (int i = 0; i < fileList.length; i++) {
			String fName = fileList[i];
			String fullFileName = folder+File.separator+fName;
			File f = new File(fullFileName);
			if (f.isDirectory()) {
				File fOut = checkFolder(f, reqFileName);
				if (fOut != null) {
					return fOut;
				}
			} else {
				if (fName.equalsIgnoreCase(reqFileName)) {
					return f;
				}
			}
		}
		return null;
	}	
}