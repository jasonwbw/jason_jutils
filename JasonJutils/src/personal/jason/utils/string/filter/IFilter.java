package personal.jason.utils.string.filter;

import java.io.IOException;

import personal.jason.utils.io.reader.LineReader;

public interface IFilter {

	public void fileFilter(LineReader reader, String outputFilename, int flushLineNum) throws IOException;
	
	public String stringFilter(String input);
}
