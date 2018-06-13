package com.digitaladd.util;

import com.Ostermiller.util.RandPass;

public class RandomGenerator {
	public static final char[] CUSTOM_LETTERS_ALPHABET = {
			'A','B','C','D','E','F','G','H',
			'J','K','M','N','O','P',
			'Q','R','S','T','U','V','W','X',
			'Y','Z','a','b','c','d','e','f',
			'g','h','j','k','m','n',
			'o','p','q','r','s','t','u','v',
			'w','x','y','z',
		};
		
		public static final char[] CUSTOM_NUMERIC = {
			'1','2','3','4','5','6','7','8','9',
		};
		
		public RandomGenerator() {
			super();
		}

	    public static String generateAlphabetNumericRandom(int aPasswordLength) {
	       RandPass l_randPass = new RandPass();
	        l_randPass.setMaxRepetition(0);
	        l_randPass.setAlphabet(RandPass.NONCONFUSING_ALPHABET);
	        String l_szNewPass = l_randPass.getPass( aPasswordLength);
	        l_szNewPass = l_szNewPass.trim();
	        return l_szNewPass;
	    }

	    
	    public static String generateNumericRandom(int length)
	    {
	       RandPass l_randPass = new RandPass();
	        l_randPass.setMaxRepetition(0);
	        l_randPass.setAlphabet(CUSTOM_NUMERIC);
	        
	        String l_szNewPass = l_randPass.getPass( length);
	        l_szNewPass = l_szNewPass.trim();
	        
	        return l_szNewPass;
	    }
}
