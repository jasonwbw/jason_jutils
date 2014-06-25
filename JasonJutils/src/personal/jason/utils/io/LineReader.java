package personal.jason.utils.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * 完成按照编码格式进行一行行的读取
 * 
 * @author Jasonwbw@yahoo.com
 */

public class LineReader {

	private BufferedReader reader;
	
	public LineReader(String filename, String encode) throws UnsupportedEncodingException, FileNotFoundException{
		this.reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), encode));
	}
	
	public String getNextLine() throws IOException{
		String tmpString = this.reader.readLine();
		if (tmpString == null) {
			this.reader.close();
			return null;
		}
		return tmpString;
	}
}
