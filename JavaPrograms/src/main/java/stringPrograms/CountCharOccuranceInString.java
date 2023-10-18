package stringPrograms;

public class CountCharOccuranceInString {

	public static void main(String[] args) {
		
		String s = "Java Programming";
	
		
		char[] charArray = s.toCharArray();
		
		int count = 0;
		
		char c = 'm';
	
		for(int i=0; i<charArray.length; i++) {
			if(charArray[i] == c) {
				count += 1;
			}
		}
		
		System.out.println(count);

	}

}
