package personal.jason.utils.string;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.collect.Lists;

public class Regex {

	/**
	 * 提取中英文括号中间的句子/词语
	 * @param str
	 * @return
	 */
	public static List<String> strInParenthesis(String str){
		List<String> res = Lists.newLinkedList();
	   	Pattern pattern = Pattern.compile("[\\(|（](.*?)[\\)|）]");
	   	Matcher m = pattern.matcher(str);
	   	while ( m.find() ) {
	   		String found = m.group();
	        res.add(found.replace("(", "").replace(")","").replace("（", "").replace("）", ""));
	   	}
	   	return res;
	}
}
