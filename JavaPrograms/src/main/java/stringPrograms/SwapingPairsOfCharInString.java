package stringPrograms;

public class SwapingPairsOfCharInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "Progrmamming";		
		char[] ca = s.toCharArray();
		char temp;
		
		for(int i=0; i<ca.length; i=i+2) {
			
			temp = ca[i];
			ca[i] = ca[i+1];
			ca[i+1] = temp;
			
		}
		System.out.println(ca);
	}
	

}
