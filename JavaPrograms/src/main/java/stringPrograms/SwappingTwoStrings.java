package stringPrograms;


public class SwappingTwoStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1 = "Java";		
		String str2 = "Coding";		
		String temp = "";

		System.out.println("Before swapping s1 and s2 resp. are : "  + str1 + str2);
		
		temp = str1;
		
		str1 = str2;
		
		str2=temp;
		
		System.out.println("After swapping s1 and s2 resp. are : "  + str1 + ", " + str2);
		
		
	}

}
