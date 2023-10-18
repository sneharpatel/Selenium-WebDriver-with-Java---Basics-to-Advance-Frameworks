package stringPrograms;

public class RemoveNumbersFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "Java23 Programming";
		
		String resStr = "";
		
		for(int i=0; i<str.length(); i++) {
			if(!Character.isDigit(str.charAt(i))) {
				resStr = resStr+str.charAt(i);
			}
		}
		
		System.out.println(resStr);

	}

}
