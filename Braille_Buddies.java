
//======================================================================
//
// Title:      Braille Buddies
// Course:     CSC 3020

//======================================================================



package Braille_Buddies;

// import package
import java.util.Scanner;

// ==========================
// Class Braille_buddies
//===========================
public class Braille_Buddies {
	
	
	// matrix for the braille grids
public static void main(String[] args) {
	
	//---------------------------------
	// 				main
	// ---------------------------------
		
	// matrix for braille grids
		final int[][][] BRAILLE_GRIDS = 
			{
			  {{ 1, 0}, { 0, 0}, { 0, 0}},  // 'a' - 0
			  {{ 1, 0}, { 1, 0}, { 0, 0}},  // 'b' - 1
			  {{ 1, 1}, { 0, 0}, { 0, 0}},  // 'c' - 2
			  {{ 1, 1}, { 0, 1}, { 0, 0}},  // 'd' - 3
			  {{ 1, 0}, { 0, 1}, { 0, 0}},  // 'e' - 4
			  {{ 1, 1}, { 1, 0}, { 0, 0}},  // 'f' - 5
			  {{ 1, 1}, { 1, 1}, { 0, 0}},  // 'g' - 6
			  {{ 1, 0}, { 1, 1}, { 0, 0}},  // 'h' - 7
			  {{ 0, 1}, { 1, 0}, { 0, 0}},  // 'i' - 8
			  {{ 0, 1}, { 1, 1}, { 0, 0}},  // 'j' - 9
			  {{ 1, 0}, { 0, 0}, { 1, 0}},  // 'k' - 10
			  {{ 1, 0}, { 1, 0}, { 1, 0}},  // 'l' - 11
			  {{ 1, 1}, { 0, 0}, { 1, 0}},  // 'm' - 12
			  {{ 1, 1}, { 0, 1}, { 1, 0}},  // 'n' - 13
			  {{ 1, 0}, { 0, 1}, { 1, 0}},  // 'o' - 14
			  {{ 1, 1}, { 1, 0}, { 1, 0}},  // 'p' - 15
			  {{ 1, 1}, { 1, 1}, { 1, 0}},  // 'q' - 16
			  {{ 1, 0}, { 1, 1}, { 1, 0}},  // 'r' - 17
			  {{ 0, 1}, { 1, 0}, { 1, 0}},  // 's' - 18
			  {{ 0, 1}, { 1, 1}, { 1, 0}},  // 't' - 19
			  {{ 1, 0}, { 0, 0}, { 1, 1}},  // 'u' - 20
			  {{ 1, 0}, { 1, 0}, { 1, 1}},  // 'v' - 21
			  {{ 0, 1}, { 1, 1}, { 0, 1}},  // 'w' - 22
			  {{ 1, 1}, { 0, 0}, { 1, 1}},  // 'x' - 23
			  {{ 1, 1}, { 0, 1}, { 1, 1}},  // 'y' - 24
			  {{ 1, 0}, { 0, 1}, { 1, 1}},  // 'z' - 25
			  {{ 0, 0}, { 0, 0}, { 0, 1}}   // upper case follows - 26
			};
		
		// creating keyboard
		Scanner keyboard = new Scanner(System.in);
		
		
		// application header
		System.out.println("Welcome o the Braille Buddies\n------------------------------");
		
		
		// asking user to continue or quit
		System.out.println("For quiting the program press q\nTo continue press any letter key: ");
		String a_char = keyboard.nextLine();
		
		
		
		// validating user Input
		while (a_char.charAt(0) != 'q')
		{
			System.out.print("\nEnter a string (letters and spaces only) to convert to Braille (q to exit ):");
			String sentence = keyboard.nextLine();
			
			
			// removing all spaces from the sentence
			String trim_space = sentence.replaceAll("\\s+","");
			
			//System.out.printf("trim_space%4s", trim_space);
			
			// if user enter q program exit
			if(sentence.charAt(0)== 'q')
			{
				// call app_footer function
				app_footer();
				
				// closing keyboard
				keyboard.close();
				
				// exit the program
				return;
			}
			
			
			// if user input other than word letter it will
			// ask user to enter the sentence again
			while(!(trim_space.matches("[a-zA-Z]*")))
			{
				System.out.print("Invalid Entry\nEnter a string (letters and spaces only) to convert to Braille (q to exit ):\n");
				sentence = keyboard.nextLine();
				if(sentence.charAt(0) == 'q')
				{
					
					//call app footer function
					app_footer();
					
					// closing keyboard
					keyboard.close();
					
					// exit the program
					return;
				}
			}
			

			
			
			// call the print method
			print(BRAILLE_GRIDS, sentence);
			System.out.println();
		   
			
		}// while closing bracket
		
		
	
		// closing keyboard
		keyboard.close();
		
		
		// application footer
		app_footer();
		
	} // close main
	
	
// function 1
	private static void app_footer()
	{
		//************************
		// printing application footer
		//
		//*****************************
		
		System.out.println("\n----------------------------------"
				+ "------------------------------------\n"
				+ "Thnak you for using the application");
	}
	
	
	
// function 2
	private static void print(int [][][] a, String s)
	{
		//********************************
		// print function
		//**********************************
		
		
		System.out.println();
		
		// declare String variable and store the lower case string
		String token;
		token = s.toLowerCase();
		
		
		System.out.print("Char: ");
		for (int i = 0; i<s.length();i++)	
		{
			if ('A' <=s.charAt(i) && s.charAt(i)<= 'Z')
			{
				System.out.printf("%6s"," UP");
				
				// after printing UP than printing
				//corresponding letter beside UP
				System.out.printf("%7s ",(token.charAt(i)));
			}
			
			
			// if is there any space in the sentence
			else if(s.charAt(i) == ' ')
				System.out.print("     ");
			
			
			else
				System.out.printf(" %6s ",s.charAt(i));
				//System.out.printf("%8s\t%d",(sentence.charAt(i)),(int)sentence.charAt(i));
		}
		System.out.println();
		
		
		
		//-------------------------------------------------------------------------
		
		
		
		// Now printing matrix
		
		// printing 1st row
		System.out.print("\nRow1:");
		for(int i=0; i<s.length(); i++)
		{
			// if the letter is UpperCase
			// Used directly code 26 that is provided by professor
			if ('A' <=s.charAt(i) && s.charAt(i)<= 'Z')
			{
				System.out.printf("%6s%s", a[26][0][0]," ");
				System.out.print(a[26][0][1]);
				
				
				// after printing upper case code
				// convert that upper character into lower character
				char c = Character.toLowerCase(s.charAt(i));
				
				
				// after that get the code for the lower case
				// and print the matrix
			    int c_acii = ((int)c - 97);
			    System.out.printf("%6s%s", a[c_acii][0][0]," ");
				System.out.print(a[c_acii][0][1]);
				
				
			}
			
			// if empty character printing space between code
			else if(s.charAt(i) == ' ')
			{
				System.out.print("   ");
			}
			
			// if there are no capital letters or 
			// spaces else statement will execute
			else
			{
				System.out.printf("%6s%s", a[(int)s.charAt(i)-97][0][0]," ");
				System.out.print(a[(int)s.charAt(i)-97][0][1]);
			}
			
		}
		
		
		// printing 2nd row
		System.out.print("\nRow2:");
		for(int i=0; i<s.length(); i++)
		{
			if ('A' <=s.charAt(i) && s.charAt(i)<= 'Z')
			{
				
				// if the letter is UpperCase
				// Used directly code 26 that is provided by professor
				System.out.printf("%6s%s", a[26][1][0]," ");
				System.out.print(a[26][1][1]);
				
				
				// after printing upper case code
				// convert that upper character into lower character
				char c = Character.toLowerCase(s.charAt(i));
				
				// after that get the code for the lower case
				// and print the matrix
			    int c_acii = ((int)c - 97);
			    System.out.printf("%6s%s", a[c_acii][1][0]," ");
				System.out.print(a[c_acii][1][1]);
			}
			
			// if empty character printing space between code
			else if(s.charAt(i) == ' ')
			{
				System.out.print("   ");
			}
			

			// if there are no capital letters or 
			// spaces else statement will execute
			else
			{	
				System.out.printf("%6s%s", a[(int)s.charAt(i)-97][1][0]," ");
				System.out.print(a[(int)s.charAt(i)-97][1][1]);
			}
			
			
		}
		
		
		// printing 3rd row
		System.out.print("\nRow3:");
		for(int i=0; i<s.length(); i++)
		{
			if ('A' <=s.charAt(i) && s.charAt(i)<= 'Z')
			{
				
				// if the letter is UpperCase
				// Used directly code 26 that is provided by professor
				System.out.printf("%6s%s", a[26][2][0]," ");
				System.out.print(a[26][2][1]);
				
				
				// after printing upper case code
				// convert that upper character into lower character
				char c = Character.toLowerCase(s.charAt(i));
				
				
				// after that get the code for the lower case
				// and print the matrix
			    int c_acii = ((int)c - 97);
			    System.out.printf("%6s%s", a[c_acii][2][0]," ");
				System.out.print(a[c_acii][2][1]);
			}
			
			// if empty character printing space between code
			else if(s.charAt(i) == ' ')
			{
				System.out.print("   ");
			}
			

			// if there are no capital letters or 
			// spaces else statement will execute
			else
			{
			
				System.out.printf("%6s%s", a[(int)s.charAt(i)-97][2][0]," ");
				System.out.print(a[(int)s.charAt(i)-97][2][1]);
			}
	
		}
		System.out.println();
	}


}
