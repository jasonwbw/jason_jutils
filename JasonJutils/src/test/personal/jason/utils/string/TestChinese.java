package test.personal.jason.utils.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import personal.jason.utils.string.Chinese;

public class TestChinese {

	@Test
	public void testGetLenOfChinese() {
		assertEquals(8, Chinese.getLenOfChinese("我爱北京天安门吗"));
		assertEquals(8, Chinese.getLenOfChinese("我aaaa爱北京天安门吗"));
		assertEquals(8, Chinese.getLenOfChinese("我,爱 北;‘京天安门吗"));
	}
	
	@Test
	public void testFilterNotChinese(){
		assertEquals("我爱北京天安门吗", Chinese.filterNotChinese("我aaaa爱北京天安门吗"));
		assertEquals("我爱北京天安门吗", Chinese.filterNotChinese("我,爱北京。天安:门：吗"));
	}

}
