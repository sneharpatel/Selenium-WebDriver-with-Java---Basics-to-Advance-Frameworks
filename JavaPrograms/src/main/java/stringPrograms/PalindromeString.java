package stringPrograms;

public class PalindromeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "Madam";
		
		String result = "";
		
		for(int i = str.length()-1; i>=0; i--) {
			result = result+str.charAt(i);	
			
		}
	
		
		if(str.equalsIgnoreCase(result)) {
			System.out.println("Given string is palindrome");
		}else {
			System.out.println("Given string is not palindrome");
		}
	}

}
