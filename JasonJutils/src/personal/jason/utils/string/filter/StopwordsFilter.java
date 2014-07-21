package personal.jason.utils.string.filter;

import java.io.IOException;
import java.util.List;

import personal.jason.utils.io.reader.LineReader;
import personal.jason.utils.io.writer.LineWriter;

import com.google.common.collect.Lists;

public class StopwordsFilter implements IFilter {

	private List<String> stopwords;
	private String encode;
	
	public StopwordsFilter(String filepath, String encode) throws IOException{
		stopwords = Lists.newLinkedList();
		LineReader reader = new LineReader(filepath, encode);
		String tmp;
		while( ( tmp = reader.getNextLine() ) != null ){
			stopwords.add(tmp.trim());
		}
		this.encode = encode;
	}
	
	@Override
	public void fileFilter(LineReader reader, String outputFilename, int flushLineNum) throws IOException {
		String tmp = null;
		LineWriter writer = new LineWriter(outputFilename, encode, flushLineNum);
		while ((tmp = reader.getNextLine()) != null) {
			writer.writeLine(this.stringFilter(tmp.trim()));
		}
		writer.writeLine(null);
	}

	@Override
	public String stringFilter(String input) {
		for(String stopword : stopwords){
			input = input.replace(stopword, "");
		}
		return input;
	}
}
