package com.chahatg.day2;
//3. Create a simple program to print pyramid pattern 
//   using *  multi dimensional arrays and loops


public class Pyramid {
	
	public static void main(String[] args) {
		int rows = 5, cols = 9;
		int starCounter = 1;
		int spaceCounter = (cols - starCounter)/2;
		char[][] charArr = new char[rows][cols];
		int i, j, k, l;
		for(i = 0; i < charArr.length; i++) {
			for(j = 0; j < spaceCounter; j++) {
				charArr[i][j] = ' ';
			}
			for(k = j; k < (spaceCounter + starCounter); k++) {
				charArr[i][k] = '*';
			}
			/*for(l = k; l < charArr[i].length; l++) {
				charArr[i][l] = ' ';
			}*/
			starCounter = starCounter+2;
			spaceCounter = spaceCounter-1;
		}
		
		for(int a = 0; a < charArr.length; a++) {
			for(int b = 0; b < charArr[a].length; b++) {
				System.out.print(charArr[a][b]);
			}
			System.out.println();
		}
	}
}
