package personal.jason.utils.io.writer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * 完成按照编码格式进行一行行的写回
 * 
 * @author Jasonwbw@yahoo.com
 */

public class LineWriter {
	
	private OutputStreamWriter osw;
	private int flushLineNum;
	private int currentLineNum;
	
	public LineWriter(String filename, String encode, int flushLineNum) throws UnsupportedEncodingException, FileNotFoundException{
		FileOutputStream fos = new FileOutputStream(filename); 
		this.osw = new OutputStreamWriter(fos, encode); 
		this.flushLineNum = flushLineNum;
		this.currentLineNum = 0;
	}
	
	/**
	 * 写回一行
	 * @param text 如果非null则写回，否则关闭写文件流
	 * @return
	 * @throws IOException
	 */
	public int writeLine(String text) throws IOException{
		if(text == null){
			osw.close();
			return -1;
		}
		osw.write(text + '\n'); 
		currentLineNum++;
		if (currentLineNum % flushLineNum == 0) {
			osw.flush();
		}
		return currentLineNum; 
	}
}
