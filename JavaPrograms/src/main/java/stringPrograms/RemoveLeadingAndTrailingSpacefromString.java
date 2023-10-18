package stringPrograms;

public class RemoveLeadingAndTrailingSpacefromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "   This is java coding ";
		
		String resStr = "";
		
		int x = 0; int y = 0;
		
		for(int i=0; i<str.length(); i++) {
			char p = str.charAt(i);
			if(p != ' ') {
				x = i;
				break;	
			}
		}
		
		for(int j= str.length()-1; j>=0; j-- ) {
			char q = str.charAt(j);
			if(q != ' ') {
				y = j;
				break;
			}
		}
		
		for(int k=x; k<=y; k++) {
			resStr = resStr + str.charAt(k);
			
		}
		
		System.out.println(resStr);
	}
}
