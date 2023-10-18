package stringPrograms;
import java.util.*;

public class CountVowelsAndConsonant {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "sadigevounbc";
		str = str.toLowerCase();
				
		List<Character> vowels = new ArrayList<Character>();
		List<Character> consonants = new ArrayList<Character>();
		
 		for(int i=0; i<str.length(); i++) {
 			if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' 
 					|| str.charAt(i) == 'o' || str.charAt(i) == 'u')
 					{ 
 						vowels.add(str.charAt(i));
 					}
 			else if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') 
 			{
 				consonants.add(str.charAt(i));
			}
		}
		
		for(int k = 0; k<vowels.size(); k++) {
			System.out.println(vowels.get(k));		
		}
		System.out.println("No of vowels in string are: " + vowels.size());
		
		for(int k = 0; k<consonants.size(); k++) {
			System.out.println(consonants.get(k));		
		}
		
		System.out.println("No of consonant in string are: " + consonants.size());
	}

}
