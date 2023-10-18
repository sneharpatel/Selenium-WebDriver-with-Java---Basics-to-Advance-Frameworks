package stringPrograms;

public class ReverseOfEachWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "Java coding prog";
		
		String[] words = str.split(" ");
		String resString = "";

				
		for(int i=0; i<words.length; i++) {
			
			String word = words[i];
			String resWord = "";
			
			for(int j = word.length()-1; j>=0; j--) {
				resWord = resWord+word.charAt(j);
			}
			resString += resWord + " ";
		}
				
		System.out.println(resString);		

	}

}
