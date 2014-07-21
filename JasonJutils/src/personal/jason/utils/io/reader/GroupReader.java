package personal.jason.utils.io.reader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

/**
 * Read group lines that split by a give li separator
 * 
 * @author Jasonwbw@yahoo.com
 */

public class GroupReader {

	private BufferedReader reader;
	private String lineSeparator;
	
	public GroupReader(String filename, String encode, String lineSeparator) throws UnsupportedEncodingException, FileNotFoundException{
		this.reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), encode));
		this.lineSeparator = lineSeparator;
	}
	
	/**
	 * read next group
	 * @return group text list by line, or null if file end
	 * @throws IOException
	 */
	public List<String> readGroupLines() throws IOException{
		String tempString = this.reader.readLine();
		List<String> text = new LinkedList<String>();
		while (tempString != null && !tempString.trim().equals(this.lineSeparator)) {
			text.add(tempString.trim());
			tempString = this.reader.readLine();
        }	
		if (text.size() == 0) {
			this.reader.close();
		}
		return text;
	}
}
