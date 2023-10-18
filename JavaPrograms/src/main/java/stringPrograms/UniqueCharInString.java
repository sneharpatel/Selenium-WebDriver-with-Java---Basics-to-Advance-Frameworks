package stringPrograms;
import java.util.*;

public class UniqueCharInString {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		
         String str = "thisisaaq";
		 findUniqueChars(str);			
	}
	
	public static void findUniqueChars(String str) {
		
		if(str.length()==0 || str=="") {
			System.out.println("Give valid input");
		}
			 
		
		Set<Character> st = new HashSet<Character>();
		
		for(int i=0; i<str.length(); i++) {
			st.add(str.charAt(i));
		}
		
		System.out.println(st);
		
	}

}
