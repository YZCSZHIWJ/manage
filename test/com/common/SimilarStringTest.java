package com.common;

import org.junit.Test;

public class SimilarStringTest {

	@Test
	public void testCalDistance() {
		String str1 = "helo";
		String str2 = "helloworld";
		System.out.println(SimilarString.calDistance(str1, str2));
	}
	
	@Test
	public void testCalSimilarVal() {
		String str1 = "heloll";
		String str2 = "helloworld";
		System.out.println(SimilarString.calSimilarVal(str1, str2));
	}

}
