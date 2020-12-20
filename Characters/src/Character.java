
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
		
		
		public int findDuplicate(String [] wordArr, int dupCount, String str, int startIndex) {
			for (int i = startIndex; i < wordArr.length; i++ ) {
				boolean used;
				
				used = str.equals(wordArr[i]);
				
				if (used) {
					dupCount++;
				}
					
			}
			return dupCount;
			
		}
	
}
