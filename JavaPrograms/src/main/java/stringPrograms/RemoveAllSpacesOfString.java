package stringPrograms;

public class RemoveAllSpacesOfString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = " Java Parogramming ";
		char[] charAry = str.toCharArray();
		
		String res = "";
		
		for(int i=0; i<charAry.length; i++) {
			if(charAry[i] != ' ') {
				res = res+charAry[i];
			}
		}
		
		System.out.println(res);
	}

}
