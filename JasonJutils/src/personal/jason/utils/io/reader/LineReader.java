package personal.jason.utils.io.reader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Read file by line
 * 
 * @author Jasonwbw@yahoo.com
 */

public class LineReader {

	private BufferedReader reader;
	
	public LineReader(String filename, String encode) throws UnsupportedEncodingException, FileNotFoundException{
		this.reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), encode));
	}
	
	/**
	 * get next line from file
	 * @return next line or null if read the file end
	 * @throws IOException
	 */
	public String getNextLine() throws IOException{
		String tmpString = this.reader.readLine();
		if (tmpString == null) {
			this.reader.close();
			return null;
		}
		return tmpString;
	}
}
