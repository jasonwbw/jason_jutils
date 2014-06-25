package personal.jason.utils.string;

public class Chinese {

	/**
	 * 统计字符串中汉字个数
	 * @param nickname
	 * @return
	 */
    public static int getLenOfChinese(String nickname) {
        int chCnt = 0;  
        String regEx = "[\\u4e00-\\u9fa5]";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(regEx);  
        java.util.regex.Matcher m = p.matcher(nickname);  
        while (m.find()) {  
        	chCnt++;  
        }  
        return chCnt;
    }
    
    /**
     * 过滤非中文的字符
     * @param s
     * @return
     */
    public static String filterNotChinese(String s){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if((""+s.charAt(i)).matches("[\u4e00-\u9fa5]+")){
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}
}
