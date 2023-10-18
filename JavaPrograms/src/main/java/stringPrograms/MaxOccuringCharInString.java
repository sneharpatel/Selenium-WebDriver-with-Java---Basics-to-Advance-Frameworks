package stringPrograms;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class MaxOccuringCharInString {

	public static void main(String[] args) {
		
		String s = "Java Programming";
		
		int maxCount = 0;
		char maxCh = 0;
		
		// logic to get occurrence of each character in string
		
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(hm.containsKey(ch)) {
				hm.put(ch, hm.get(ch)+ 1);	
			}else {
				hm.put(ch, 1);
			}
		}
		
		// logic to get max occurrence of character in string
		
		Set<Entry<Character, Integer>> entrySet = hm.entrySet();
		
		for (Entry<Character, Integer> entry : entrySet ) {
			if(entry.getValue()> maxCount) {
				maxCount = entry.getValue();
				maxCh = entry.getKey();
			}
				
		}
		
		System.out.println("Print occurance of max chara == " + maxCh + ":" + maxCount);
		
		System.out.println("**********");
		
		// print occurrence of each character in string
		
		for(Character key : hm.keySet()){
			System.out.println("Print occurance of each chara in string == " + key + ":" + hm.get(key));
			
		}
		

	}

}
