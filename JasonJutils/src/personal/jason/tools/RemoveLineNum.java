package personal.jason.tools;

import java.io.*;

/**
 * Remove line number in the head of each line for copy code from some website.
 * 
 * @author Jasonwbw@yahoo.com
 */

public class RemoveLineNum {
	
	private String strSourceCode="";
	private BufferedReader br;
	
	public RemoveLineNum(String strFilePath) throws Exception{
		File fileRead = new File(strFilePath);
		br = new BufferedReader(new FileReader(fileRead));
	}
	
	/**
	 * get correct source code
	 * @return
	 * @throws Exception
	 */
	public String getSourceCode() throws Exception{
		String s = br.readLine();
		while ( s != null) {
			if(s.matches("^[0-9]+")==false){
				strSourceCode += s + "\n";
			}
			s = br.readLine();
		}
		br.close();
		return strSourceCode;
	}

}