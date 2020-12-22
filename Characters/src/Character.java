
public class Character {
	
		//instance variables
		String s;
		
		//constructor
		public Character() {
			s = " ";
		}
		
		//set string
		public void setString (String str) {
			s = str;
		}
		
		//check for punctuation
		public boolean hasPunctuation(int i) {
			if (s.charAt(i) == '.' || s.charAt(i) == '?' || s.charAt(i) == '!'
					|| s.charAt(i) == ',' || s.charAt(i) == ';' || s.charAt(i) == ':') {
				return true;
			}else {
				return false;
			}
		}
		
		
		//check for white space 
		public boolean hasSpace(int i) {
			if (s.charAt(i) == ' ') {
				return true;
			}else {
				return false;
			}
		}
		
		
		//check for sentence ending punctuation
		public boolean hasEndPunc(int i) {
			if (s.charAt(i) == '.' || s.charAt(i) == '!' || s.charAt(i) == '?') {
				return true;
			}else {
				return false;
			}
		}
		
		

	
}
