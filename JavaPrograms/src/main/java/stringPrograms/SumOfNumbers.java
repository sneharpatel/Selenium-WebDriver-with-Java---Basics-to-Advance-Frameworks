package stringPrograms;

public class SumOfNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "as12er30";
		int sum = 0;
		String temp = "0";
		
		for(int i=0; i<str.length(); i++) {
			
			char ch = str.charAt(i);
			if(Character.isDigit(ch)) {
				temp = temp+ch;				
			}
			else {
				sum = sum+Integer.parseInt(temp);
				temp= "0";				
			}
			
		}
		sum = sum+Integer.parseInt(temp);	
		System.out.println(sum);
	}

	
}
