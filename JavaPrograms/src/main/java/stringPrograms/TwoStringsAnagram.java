package stringPrograms;

import java.util.Arrays;

public class TwoStringsAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// secure == rescue
		String s1 = "care";
		String s2 = "race";
		
		char[] s1Ary = s1.toCharArray();
		char[] s2Ary = s2.toCharArray();
	
	
		if(s1.length() != s2.length()) {
			System.out.println("Strings length is not same");
		}
		
		Arrays.sort(s1Ary);
		Arrays.sort(s2Ary);
		
		boolean result = Arrays.equals(s1Ary, s2Ary);
		
		
				
		if (result == true) {
			System.out.println("Two strings are anagram");
		}else {
			System.out.println("Two strings are not anagram");
		}
			
	}
	
//	public static char[] sortArray(String s) {
//		
//		char[] ary = s.toCharArray();
//		char temp = ' ';
//		
//		for(int i=0; i<ary.length; i++) {
//			
//			for(int j=0; j<ary.length; j++) {
//				
//				if(ary[j] > ary[i]) {
//					
//					temp = ary[i];
//					
//					ary[i] = ary[j];
//					
//					ary[j] = temp;
//				}
//			}
//						
//			
//		}
//		return ary;		
//		
		
	

}
