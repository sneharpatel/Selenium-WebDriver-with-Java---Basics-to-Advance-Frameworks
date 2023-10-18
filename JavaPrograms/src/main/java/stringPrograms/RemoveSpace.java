// Remove white space from string

package stringPrograms;

public class RemoveSpace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		String s = " This is java program ";
//		String s1=s.trim();
//		
//		String[] ar = s1.split(" ");
//		
//		for(int i=0; i<ar.length; i++) {
//		System.out.print(ar[i]); }
		
		String s = " This is java program ";
		char[] ch = s.toCharArray();
		
		String s1 = "";
		
		for(int i=0; i<ch.length; i++) {
			if(ch[i]!= ' ') {
				s1 = s1+ch[i];
			}			
		}
		System.out.println(s1);
	}

}
