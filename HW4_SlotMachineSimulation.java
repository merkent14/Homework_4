/* ========================================================================== */
/* PROGRAM: Slot Machine Simulation
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

public class HW4_SlotMachineSimulation{
   public static void main(String [] args) throws IOException{ 
  
  int fruitGuess;
  double amountAvailable;
  String availableMoneyAmount;
  char repeatGame ='a';
  int bet_Amount=10;
  double current_Amount=0;
  int matchCount=0;
  double netGain=0;
  final int MINIMAL_AMOUNT=10;
  int SMALLEST_IMAGE_OPTION=1;
  int BIGGEST_IMAGE_OPTION=6;
  
  //create an scanner object to read in values from the user
  Scanner keyboard = new Scanner(System.in);
//open the file
  
  File userFile = new File("input.txt");
  Scanner input = new Scanner(userFile);
  
 
  //for the random pick 
  Random fruitGenerator = new Random();
  
  // read the first line of the file to determine the amount of money the user has
  availableMoneyAmount= input.nextLine();
  amountAvailable= Double.parseDouble(availableMoneyAmount);
  //close the file
  input.close();
  
  //This is allowing us to write to the output file
  PrintWriter outFile=new PrintWriter("output.txt");
 
  
 
  //start of the first while that checks to see if user wants to play
  
 //welcome into the game
 System.out.println("Welcome to Megan's and Mercedes' Slot Machine");
 outFile.println("Welcome to Megan's and Mercedes' Slot Machine");
 //this prints the initial amount the user has
 System.out.printf("You inserted $%.2f into the slot machine!\n", amountAvailable);
  outFile.printf("You inserted $%.2f into the slot machine!\n", amountAvailable);
  //this shows how much the user has and how much he/she can bet
  System.out.printf("You currently have $%.2f, you can bet the multiple of $10.\n",amountAvailable);
  outFile.printf("You currently have $%.2f, you can bet the multiple of $10.\n",amountAvailable);
 //asking them to play
  System.out.print("Do you want to continue playing (y/Y) or quit (n/N): ");
  repeatGame=keyboard.next().charAt(0);
  outFile.print("Do you want to continue playing (y/Y) or quit (n/N): ");

  while(bet_Amount<=1||bet_Amount*10<amountAvailable && (repeatGame=='Y' || repeatGame=='y') ) {
 System.out.println("If you enter 1, you will bet $10");
 outFile.println("If you enter 1, you will bet $10");
 System.out.println("If you enter 2, you will bet $20,etc.");
 outFile.println("If you enter 2, you will bet $20,etc.");
 //ask how much the user wants to bet
 System.out.print("Please enter how much do you want to bet this time: ");
 outFile.print("Please enter how much do you want to bet this time: ");
 bet_Amount=keyboard.nextInt();
 System.out.print("Do you want to continue playing (y/Y) or quit (n/N): ");
 repeatGame=keyboard.next().charAt(0);
 outFile.print("Do you want to continue playing (y/Y) or quit (n/N): ");
 
 if(bet_Amount<1) {
 
 System.out.println("The bet is less than 1.");
  
 outFile.println("The bet is less than 1.");
  
 }
 
 else if(bet_Amount*10 >amountAvailable) {
  
 System.out.println("The bet is greater than your current amount of money");
 
 outFile.println("The bet is greater than your current amount of money");   
 
 }
  
  
  bet_Amount*=MINIMAL_AMOUNT;
  // the amount the user is betting
  System.out.printf("Your current bet: $%d\n", bet_Amount);
  outFile.printf("Your current bet: $%d\n", bet_Amount);
  System.out.println("Please select one of the fruit by entering a number between 1 and 6:");
 
  //show the list of options to pick
  System.out.println("Please type the number corresponding with the word you choose:" + "\n1- Cherry" 
  +"\n2- Orange" + "\n3- Apple" + "\n4- Peach"+"\n5- Melon"+"\n6- Pear"); 
  outFile.println("Please type the number corresponding with the word you choose:" + "\n1- Cherry" 
  +"\n2- Orange" + "\n3- Apple" + "\n4- Peach"+"\n5- Melon"+"\n6- Pear");
  
  System.out.print("Please enter your selection: ");
  outFile.print("Please enter your selection: ");
  fruitGuess=keyboard.nextInt();
  while(fruitGuess<SMALLEST_IMAGE_OPTION || fruitGuess>BIGGEST_IMAGE_OPTION) {
  System.out.print("Invalid selection, you must enter a number between 1 and 6 inclusive.");
  outFile.print("Invalid selection, you must enter a number between 1 and 6 inclusive.");
  fruitGuess=keyboard.nextInt();
  }
  //assigns a number to each fruit
  int countCherry =0;
  int countOrange =0;
  int countApple=0;
  int countPeach=0;
  int countMelon=0;
  int countPear=0;
  String results = " ";
  
if(fruitGuess <=6 && fruitGuess >=1) {
  for(int i=0; i < 3; i++) {
 int rand_num=fruitGenerator.nextInt(6)+1;
  switch(rand_num) {
  case 1:
  countCherry++;
  results+= " Cherry ";
    break;
  case 2:
  countOrange++;
  results+= " Orange ";
  break;
  case 3:
  countApple++;
  results+= " Apple ";
  break;
  case 4:
  countPeach++;
  results+= " Peach ";
  break; 
  case 5:
  countMelon++;
  results+= " Melon ";
  break;
  case 6:
  countPear++;
  results+= " Pear ";
  break;
  
  }
  }
  System.out.println("Result: " + results);
} 
else {
System.out.print("Please enter a number between 1 and 6.");
}
int amountWon=0;
switch(fruitGuess) {
case 1:
if(countCherry ==3) {
amountWon=bet_Amount*3;
amountAvailable+=bet_Amount;
}
else if(countCherry==2) {
amountWon=bet_Amount*2;
amountAvailable+=bet_Amount;
}
else if(countCherry==1) {
amountWon=bet_Amount*1;
amountAvailable+=bet_Amount;
}
else {
amountWon=0;
amountAvailable-=bet_Amount;
System.out.println("None of the randomly selected words matched your selection.");
outFile.println("None of the randomly selected words matched your selection.");
}
break;
case 2:
if(countOrange ==3) {
amountWon=bet_Amount*3;
amountAvailable+=bet_Amount;
}
else if(countOrange==2) {
amountWon=bet_Amount*2;
amountAvailable+=bet_Amount;
}
else if(countOrange==1) {
amountWon=bet_Amount*1;
amountAvailable+=bet_Amount;
}
else {
amountWon=0;
amountAvailable-=bet_Amount;
System.out.println("None of the randomly selected words matched your selection.");
outFile.println("None of the randomly selected words matched your selection.");
}
break;
case 3:
if(countApple ==3) {
amountWon=bet_Amount*3;
amountAvailable+=bet_Amount;
}
else if(countApple==2) {
amountWon=bet_Amount*2;
amountAvailable+=bet_Amount;
}
else if(countApple==1) {
amountWon=bet_Amount*1;
amountAvailable+=bet_Amount;
}
else {
amountWon=0;
amountAvailable-=bet_Amount;
System.out.println("None of the randomly selected words matched your selection.");
outFile.println("None of the randomly selected words matched your selection.");
}
break;
case 4:
if(countPeach ==3) {
amountWon=bet_Amount*3;
amountAvailable+=bet_Amount;
}
else if(countPeach==2) {
amountWon=bet_Amount*2;
amountAvailable+=bet_Amount;
}
else if(countPeach==1) {
amountWon=bet_Amount*1;
amountAvailable+=bet_Amount;
}
else {
amountWon=0;
amountAvailable-=bet_Amount;
System.out.println("None of the randomly selected words matched your selection.");
outFile.println("None of the randomly selected words matched your selection.");
}
break;
case 5:
if(countMelon ==3) {
amountWon=bet_Amount*3;
amountAvailable+=bet_Amount;
}
else if(countMelon==2) {
amountWon=bet_Amount*2;
amountAvailable+=bet_Amount;
}
else if(countMelon==1) {
amountWon=bet_Amount*1;
amountAvailable+=bet_Amount;
}
else {
amountWon=0;
amountAvailable-=bet_Amount;
System.out.println("None of the randomly selected words matched your selection.");
outFile.println("None of the randomly selected words matched your selection.");
}
break;
case 6:
if(countPear ==3) {
amountWon=bet_Amount*3;
amountAvailable+=bet_Amount;
}
else if(countPear ==2) {
amountWon=bet_Amount*2;
amountAvailable+=bet_Amount;
}
else if(countPear==1) {
amountWon=bet_Amount*1;
amountAvailable+=bet_Amount;
}
else {
amountWon=0;
amountAvailable-=bet_Amount;
System.out.println("None of the randomly selected words matched your selection.");
outFile.println("None of the randomly selected words matched your selection.");
}
break;
}
if(current_Amount-amountAvailable <=0){
netGain=amountAvailable - current_Amount;
System.out.printf("Net gain if user quits: $%.2f. ", netGain);
outFile.printf("Net gain if user quits: $%.2f. ", netGain);
}
else if(current_Amount-amountAvailable >=0){
double netLoss= current_Amount - amountAvailable;
System.out.printf("Net loss if user quits: $%.2f",netLoss);
}
System.out.println("You won $"+amountWon);
outFile.println("You won $"+amountWon);

System.out.print("Do you want to continue playing (y/Y) or quit (n/N): ");
repeatGame=keyboard.next().charAt(0);
outFile.print("Do you want to continue playing (y/Y) or quit (n/N): ");


if(repeatGame!=('Y') && repeatGame!=('y') && repeatGame!=('N') && repeatGame!=('n')){
System.out.print("Invalid choice!! Please enter (y/Y) to play or (n/N): ");
repeatGame=keyboard.next().charAt(0);
outFile.print("Invalid choice!! Please enter (y/Y) to play or (n/N): ");
}
if(amountAvailable==0){
System.out.print("You are out of money");
outFile.print("You are out of money");
 }
 
 
  }
  while(repeatGame==('N') || repeatGame==('n')){
    
  System.out.println("\nThe end! Thank you for playing!");
  break;
  }
  
  
  
  
  

  
  
  
  
 
  outFile.close();
  keyboard.close();
  
  
   }
}
