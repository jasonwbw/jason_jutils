package test.personal.jason.utils.string;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import personal.jason.utils.string.Regex;

public class TestRegex {

	@Test
	public void testStrInParenthesis() {
		List<String> ss = Regex.strInParenthesis("安河桥北(地铁站）(公交站)有没有");
		assertEquals(ss.size(), 2);
		assertEquals(ss.get(0), "地铁站");
		assertEquals(ss.get(1), "公交站");
		
		ss = Regex.strInParenthesis("安河桥北(地铁站）（公交站)有没有");
		assertEquals(ss.size(), 2);
		assertEquals(ss.get(0), "地铁站");
		assertEquals(ss.get(1), "公交站");
		
		ss = Regex.strInParenthesis("(地铁站）（公交站)有没有");
		assertEquals(ss.size(), 2);
		assertEquals(ss.get(0), "地铁站");
		assertEquals(ss.get(1), "公交站");
		
		ss = Regex.strInParenthesis("(地铁站）（公交站)");
		assertEquals(ss.size(), 2);
		assertEquals(ss.get(0), "地铁站");
		assertEquals(ss.get(1), "公交站");
	}

}
