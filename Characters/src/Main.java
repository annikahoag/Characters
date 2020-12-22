import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner (System.in);
		Character chara = new Character();
		String myStr, str2, str;
		boolean hasPunc=false, hasSpace=false, hasMultSpace=false, hasEndPunc=false;
		int strLength;
		int arrIndex=0;
		String wordStringTemp = " ", wordString = " ";
		boolean beenUsed=false;
		int charCount=0;
		int usedCount=0;
		int count=0;
		int sentCount=1;
	
		System.out.println("Please enter a sentence.\n"
				+ "You can input anything, numbers, punctuation etc.");
		myStr = scn.nextLine();
		
		
		//delete all leading and trailing white spaces 
		str2 = myStr.trim();
		str = str2.toLowerCase();
		
	
		
		
		//set arrays and variables
		chara.setString(str);
		strLength = str.length();
		String [] wordArr = new String [strLength];
		int [] countArr = new int [strLength];
		
		
		for (int i = 0; i < str.length(); i++) {
			int k;
			
			for (k = i; k < str.length(); k++) {

				
				hasPunc = chara.hasPunctuation(k);
				hasSpace = chara.hasSpace(k);
				
				
				//checks for multiple spaces
				if (hasSpace) {
					try {
						hasMultSpace = chara.hasSpace(k-1);

					}catch (StringIndexOutOfBoundsException e) {
						//do nothing beginning of sentence
					}
					
					if (hasMultSpace == true) {
						continue;
					}
				}
			
				
				//break and go to set substring
				if ((hasPunc == true && hasSpace == true) || hasSpace == true) {
					break;
				}
				
				
				//tests for punctuation and space after
				//EXTRA CREDIT count sentences 
				try {
					if (hasPunc == true) {
						if (chara.hasSpace(k+1) == true) {
							hasEndPunc = chara.hasEndPunc(k);
							if(hasEndPunc) {
								if (sentCount > 1) {
									charCount++;
								}
								wordStringTemp = str.substring(i, k);
								wordString = wordStringTemp.trim();
								i = k;	
								hasSpace = true;
								sentCount++;
								
							}else {
								wordStringTemp = str.substring(i, k);
								wordString = wordStringTemp.trim();
								i = k;	
								hasSpace = true;
								charCount++;
							}
							break;
						}else {
							
							continue;
						}
					}
				}catch(StringIndexOutOfBoundsException e) {
					//special case end of sentence
					if (sentCount > 1) {
						charCount++;
					}
					hasSpace = false;
					wordString = str.substring(i, k);
					usedCount = 0; 
					
					//test for if it's a duplicate 
					for (int j = 0; j < arrIndex; j++) {
						
						
						beenUsed = wordString.equals(wordArr[j]);
						if (beenUsed) {
							countArr[j] ++;
							countArr[arrIndex] = 0;
							wordArr[arrIndex] = null;
							usedCount ++;
						}
					}//end of for loop
					
					if (usedCount == 0) {
						wordArr[arrIndex] = wordString;
						countArr[arrIndex] = 1;
					}
					i=k;
				}//end of catch	
				
			
				
				//add to character count unless it's a space
				if (hasSpace == false) {
					charCount++;
				}
				
				
			}//end of k for loop 
			
			
			//trim extra spaces if it has multiple 
			if (hasPunc == false && hasMultSpace == false) {
				wordStringTemp = str.substring(i, k);
				wordString = wordStringTemp.trim();
				i = k;	
				if (wordString.equals("")) {
//					wordArr[arrIndex] = null;
					i = k;
					continue;
				}
			}
			
			
			
			//check for punctuation and space after
			if ((hasPunc == true && hasSpace == true) || hasSpace == true) {
				
				
				//check if word has been used already
				if (arrIndex != 0) {
					usedCount = 0;
		
					for (int j = 0; j < arrIndex; j++) {

						beenUsed = wordString.equals(wordArr[j]);
						if (beenUsed) {

							countArr[j] ++;
							countArr[arrIndex] = 0;
							wordArr[arrIndex] = null;
							usedCount ++;
						}
						
					}//end of for loop
					
			
				}//end of arrIndex !=0 if 
				
				
				//check if it's been used, add to array
				if (usedCount == 0) {
					
						wordArr[arrIndex] = wordString;
						countArr[arrIndex] = 1;
						arrIndex++;
					
					
				}
				
			//empty wordString	
			wordString = " ";
			
		}//end of hasPunc if 
		}//end of big for loop
		
		

	
		for (int i = 0; i<=arrIndex; i++) {
			if (wordArr [i]  != null) {
				System.out.println("");
				System.out.printf("%-10s%d", wordArr[i].trim(), countArr[i]);
			
				count = count + countArr[i];
			}
			
		}//end of for
		System.out.println("");
		System.out.println("");
		

		System.out.println("Characters: " + charCount);
		System.out.println("Words: " + count);
		System.out.println("Sentences: " + sentCount);
		
		scn.close();
		
	}

}
