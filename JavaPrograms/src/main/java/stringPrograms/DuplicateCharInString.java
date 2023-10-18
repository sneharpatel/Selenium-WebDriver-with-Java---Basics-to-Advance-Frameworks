package stringPrograms;

public class DuplicateCharInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "java programming";
		
		String s2 = s1.toLowerCase();
		char[] str = s2.toCharArray();
		
		System.out.print("Duplicate chars in string are: ");
		
		for(int i=0; i<str.length; i++) {
			for(int j=i+1; j<str.length; j++) {
				if(str[i]==str[j]) {
					System.out.print(str[j] + " ");
					break;
				}
			}
		}

	}

}
