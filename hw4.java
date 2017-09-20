/* ========================================================================== */
/*	PROGRAM: Slot Machine Simulation
    AUTHOR: Megan Camp, Mercedes Kent
    COURSE NUMBER: CIS 210
    COURSE SECTION NUMBER: 02
    INSTRUCTOR NAME: Dr.Tian
    PROJECT NUMBER: 4
    DUE DATE: 09/21/2017
SUMMARY
A slot machine is a gambling device that the user inserts money into and then pulls a lever or
push a button. The slot machine then displays a set of random images. If one image matches, the
user wins the amount of money he or she bets. If two or more of the images match, the user wins
an amount of money that the slot machine dispenses back to the user.
Create a program that simulates a slot machine. When the program runs, it should do the
following:
1. Read in the initial amount of money a user wants to enter into the slot.
2. Ask the user to enter the amount of money he or she wants to bet. The amount of money
must be a multiple of $10. The minimum is $10 and maximum is the amount of money
the user currently has.
3. Display a menu for the user to select a word from the following list:
	1. Cherry
	2. Orange
	3. Apple
	4. Peach
	5. Melon
	6. Pear
 		i. Ask the user to select one word by entering the number between 1 and 6
 		ii. Randomly select a word from the above list three times and display all three of the words
		iii. If none of the randomly selected words match, the program will inform the user that he or
she has won $0. If one of the words match, the program will inform the user that he or
she has won one time of the amount entered. If two of the words match, the program will
inform the user that he or she has won two times the amount entered. If three of the
words match, the program will inform the user that he or she has won three times the amount entered.
INPUT
This program requires that you read in the following data values:
	1. The amount of money a user owns initially. It is read from a input file named input.txt
	2. Whether or not a user wants to play
 	3. The amount of money he wants to bet each time
 	4. The word a user selects
OUTPUT
-The amount of money a customer will pay
- The amount of money a customer will save if he or she purchase Package B or C
- The amount of money must following a ‘$’ and have 2 decimal points, such as $2.00,
$34.56, etc.
ASSUMPTIONS
The user will enter an integer for the number of hours used 
/* MAIN FUNCTION */

import java.util.Scanner;
import java.io.*;
import java.util.Random;
import java.io.IOException;

public class hw4{
   public static void main(String [] args) throws IOException{ 
	   
	   int fruitGuess;
	   int bet;
	   int amountOfMoney;
	   int availableMoney;
	   String availableMoneyAmount;
	   int amountAvailable;
	   
	   //create an scanner object to read in values from the user
	   Scanner keyboard = new Scanner(System.in);
	   File userFile = new File("input.txt");
	   PrintWriter outputFile = new PrintWriter("output.txt");
	   Scanner input = new Scanner(userFile);
	   //for the random pick
	   Random random = new Random();
	   
	   //open the file
	   File file = new File("input.txt");
	   Scanner moneyAvailable = new Scanner(file);
	   //allows us to read in the first line
	   availableMoneyAmount= moneyAvailable.nextLine();
	   amountAvailable= Integer.parseInt(availableMoneyAmount);
	   
	   
	   //This is allowing us to write to the output file
	   System.out.println("Welcome to Guanyu Tian's Slot Machine");
	   
	   // read the first line of the file to determine the amount of money the user has
	   amountOfMoney = input.nextInt();
	   
	   //this prints the first line
	   System.out.printf("You inserted $%.2s into the slot machine!", amountOfMoney);
	   amountOfMoney=keyboard.nextInt();
	   
	   //this ask the user for their first bet
	   System.out.println("How much would you like to bet?");
	   bet=keyboard.nextInt();
	   //start of while
	   while(bet!=0) {
		   //show the list of options to pick
		   System.out.print("Please type the number corresponding with the word you choose:/n/t 1. Cherry/n/t 2. Orange" + 
		   "/n/t 3. Apple/n/t 4. Peach/n/t 5. Melon/n/t 6. Pear"); 
		   
		   //random pick 3
		   //Random(nextInt)
	   }
	   
	   

	   
	   
	   
	   
	   
	   
	   //close the file
	 //  inputFile.close();
	   outputFile.close();
	   input.close();
	   keyboard.close();
	   moneyAvailable.close();
	   
   }
}
