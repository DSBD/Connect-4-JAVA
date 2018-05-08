import java.util.Scanner; //Import Scanner Class to Accept User Input
import java.util.Random; //Import Random Class to RAndomize who starts if they don't want to pick
//Title: Connect Four
//Project Description: This is a computer version of the popular board game Connect 4
//Name: Dragos Baciu-David
//Date: June, 12, 2015
public class ICS3U_Culminating_Connect4 //Class Header, the class will hold all the code
{//Open brace for the Class
	public static void main(String[] args) //Main method will be used to call the various methods that run the different parts of the game, it will also be responsible for starting the game
	{//Start of Main Method
		Scanner sc = new Scanner(System.in);//Create Scanner Object to Accept user input on who will start the game
		Random rand = new Random();//Random object to randomize who starts if the players wish
		String[][] board = createBoard();//Call the createBoard Method to create the board and store it in the 2D array named board
		String input;//Create String Variable that will be responsible for storing if the users want to play again
		String first;//Create String Variable to store who will play the first move
		boolean win =false;//Create a boolean to control if the code asks to play again
		boolean run = true;//Create a boolean to control the loop
		int count;//Create an variable to control which player goes when
		
		//The following 4 lines will introduce the game and give instructions on how to play
		
		System.out.println("Welcome to Virtual Connect 4. A Virtual Version of the Popular Game");
		System.out.println("    The Object of the game is to get Four of your chips in row.    ");
		System.out.println("    Horizontal, Vertical and Diagonal Lines all Count as a win.    ");
		System.out.println("  Coded by Dragos Baciu-David     Remember to tip Your Programmer  ");
		
		System.out.print("\n\nWhat Player wants to Start? (Y or B) Anything else and I will Randomize it: ");//Ask the users who will play first B for Blue, Y for Yellow, anything else is Random
		first  = sc.nextLine();//Store the input in the first variable
		first = first.toLowerCase();//Make the input all lower case
		if(first.charAt(0) == 'b')//Check if the first character of the input is "b"
		{//Start of Blue Conditional
			count = 0;//Set Count to Zero because blue goes on even number
		}//End of Blue Conditional
		else if(first.charAt(0) == 'y')//Check if the first character of the input is "y"
		{//Start of Yellow Conditional
			count = 1;//Set count to 1 since Yellow goes on odd numbers
		}//End of Yellow Conditional
		
		//These next lines of code are a special surprise for Mr.Petti, if the User inputs "startrek", the following will appear and then randomize the start
		//The following is ASCII art of the Startrek The Next Generation Logo and the USS Enterprise NCC 1701-E
		
		else if(first.equals("startrek"))
		{//Start of Easter Egg
			System.out.println("           ____ _____ ___     ____      _____ ____    _____ _ ___                         ");
  		System.out.println("          / __//____//__ \\   /__  \\    /____//__  \\  /____//_X__/                      ");
  		System.out.println("         ( (    __   __| |   ___) /     __   ___) / ____  ___                             ");
  		System.out.println("          \\ \\  / / ,/,/| |  /   _/     / /  /   _/ / __/ / _ \\                         ");
  		System.out.println("       ____) )/ /,/ /__| | / /\\ \\     / /  / /\\ \\ / /__ / / \\ \\                     ");
  		System.out.println("      /_____//_//________|/_/ /_/    /_/  /_/ /_//____//_/   \\_\\                        ");
			System.out.println("                                                                                          ");
			System.out.println("      ___      _          _    ___     __   _       _  _  __  ___    __                   ");
			System.out.println("       |  |_| |_    |\\ | |_ \\/  |     | _  |_ |\\ | |_ |_)   |  |  | |  | |\\ |         ");
			System.out.println("       |  | | |_    | \\| |_ /\\  |     |__| |_ | \\| |_ | \\ /_|  |  | |__| | \\|         ");			
			System.out.println("                                               __,----.____________________________       ");
			System.out.println("              ____.------------.____          /___\\ |>=============================|     ");
			System.out.println("        __.--'----------------------`--.__     `--.___.---,-----,-----------------'       ");
			System.out.println("      ======================================            .'   _.'                          ");
			System.out.println("           `---------------.--------'     `----._____.'___.'____                          ");
			System.out.println("                            `.========       >-----___________|_\\                        ");
			System.out.println("                              `.               .-'                                        ");
			System.out.println("                                '--.______.----'                                          ");
			
			
			//End of Fun Surprise for Mr.Petti
			
			count = rand.nextInt(2)+1;//Randomize the start between 1 and 2
		}//End of Easter Egg
		else//Anything but the above choices will randomize who starts
		{//Start of Random Conditional
			count = rand.nextInt(2)+1;//Randomize the start between 1 and 2
		}//End of Random Conditional
		
		printBoard(board);//Call the printBoard Method to print the original board on the screen
		
		while(run)//Main Game loop, is controlled by the loop control variable run, which starts as true and can be changed after the initial run of the game
		{//Start of main Loop
			if(count % 2 == 0)//If count is even, it's the blue player turn, so we call the dropBlueChip method and send it the board
			{//Start of blue turn conditional
				dropBlueChip(board);//Call the dropBlueChip method and give it access to the board array
			}//End of blue turn conditional
			else//otherwise it is yellow's turn
			{//Start of Yellow Turn Conditional
				dropYellowChip(board);//Call the dropYellowChip method and give it access to the board array
			}//End of blue turn conditional
			printBoard(board);//After each turn we re-print the board, so we call the method and send it the board
			count++;//Then we add one to count
			
			if(checkWinner(board) != null)//We call the check winner method and see if it returned a value, if it didn't return a value we skip all this and go on to the next turn
			{//Start of checkWinner Main Conditional
				if(checkWinner(board) == "B")//if the method returned a value check if it is "B", meaning a blue win
				{//Start of Blue Win Conditional
					System.out.println("The Blue Player has Won!");//Print out that the blue player has won
					run = false;//End the loop
					win = true;//Let the play again code run
				}//End of Blue Win Conditional
				else if(checkWinner(board) == "Y")//if the method returned a value check if it is "Y", meaning a Yellow win
				{//Start of Yellow Win Conditional
					System.out.println("The Yellow Player has Won!");//Print out that the yeellow player has won
					run = false;//End the loop
					win = true;//Let the play again code run
				}//End of Yellow Win Conditional
			}//End of checkWinner Main Conditional
			
			if(win == true)//If someone has won then we want to ask if they want to go again
			{//Start of Play Again Main Conditional
				System.out.print("Would You Like to go Again? (Y or N): ");//Ask the user if they wish to play again
				input = sc.nextLine();//Store the input in input
				input = input.toLowerCase();//Make it lower case
				
				if(input.charAt(0) == 'y')//If they inputed 'y', let the game run again
				{//Start if Run Again Conditional
					run = true;//Let the game run again
					board = createBoard();//Clear the board
					win = false;//Set the win variable to false
				}//End of Run Again Conditional
				else//IF they didn't input y, then they dont wanna play again
				{//Start of Don't Run again Conditional
					System.out.println("\nThanks for Playing!");//Thank the User for playing
					System.out.println("This game was coded for Mr.Petti's ICS 3U Culminating");//End Credits
					System.out.println("© DSBD 2015, All Rights Reserved");//Copyright the Code
					run = false;//End the loop and therefore the game
				}//End of Don't Run again Conditional
			}	//End of Play Again Main Conditional
		}//End of Main Game Loop
	}//End of Main Method
	
	public static String[][] createBoard()//Method to Create the Game Board
	{
		String[][] board = new String[7][15];//Creates an Array that is 7 Rows and 15 Columns that is a 6 * 7 game board with every other column being "|", and the bottom row being "-"
		
		for (int row = 0; row < 7; row++)//For Loop to iterate through each row
		{
			for (int column = 0; column < 15; column++)//For loop to iterate throught columns
			{
				if(column % 2 == 0)// for each even column add a "|"
				{
					board[row][column] = "|";//Put a "|" in each even row
				}
				else//In each odd row add a " "
				{
					board[row][column] = " ";//Put a " " in each odd row
				}
			}
			if (row == 6)//If it is row 6 fill it with "-"
			{
				for (int index = 0; index < 15; index++)//iterate through each column
				{
					board[row][index] = "-";//Put a "-" in each column
				}
			}
		}
		return board;//return the board to the main method
	}//End of createBoard Method
	
	public static void printBoard(String[][] board)//Method to print board
	{
		System.out.println(" 0 1 2 3 4 5 6 ");//Print the numbers above the column so that the user knows what number to enter.
		
		for (int rows = 0; rows < 7; rows++)//iterate through each row
		{
			for (int columns = 0; columns < 15; columns++)//iterate through each column
			{
				System.out.print(board[rows][columns]);//Print whatever is at those coordinates
			}
			System.out.println();//When the row is done advance to the next one.
		}
	}//End of printBoard Method
	
	public static void dropBlueChip(String[][] board)//Method that will be called to drop the blue player's chip in the slot
	{
		Scanner sc = new Scanner(System.in);//Create a Scanner Object to Accept User Input
		int blueSlot;//Create an variable to hold the slot
		
		System.out.print("\nBlue Player, Select a column 0-6: ");//Prompt the user to enter the column they want to put a piece in
		blueSlot = sc.nextInt();//Store their choice in the variable we created
		
		while(blueSlot < 0 || blueSlot > 6)//If it is not between 0 and 6 ask them to choose again
		{
			System.out.print("Please Choose a valid Column: ");//Ask for new input
			blueSlot = sc.nextInt();//Store it in blueSlot
		}
		
		blueSlot = 2 * blueSlot + 1;//We have to convert it to odd slot because it is 15 long not 7
		
		for (int rows = 5; rows >= 0; rows--)//Go through the rows from the bottom
		{
			if(board[rows][blueSlot] == " ")//if the slot in that column is empty place it there
			{
				board[rows][blueSlot] = "B";//Set that slot to "B"
				break;//If we placed the piece break the loop
			}
		}
	}//End of dropBlue Method
	
	public static void dropYellowChip(String[][] board)//Method that will be called to drop the yellow player's chip in the slot
	{
		Scanner sc = new Scanner(System.in);//Create a Scanner Object to Accept User Input
		int YellowSlot;//Create an variable to hold the slot
		
		System.out.print("\nYellow Player, Select a column 0-6: ");//Prompt the user to enter the column they want to put a piece in
		YellowSlot = sc.nextInt();//Store it in yellowSlot
		
		while(YellowSlot < 0 || YellowSlot > 6)//If it is not between 0 and 6 ask them to choose again
		{
			System.out.print("Please Choose a valid Column: ");//Ask for new input
			YellowSlot = sc.nextInt();//Store it in yellowSlot
		}
		
		YellowSlot = 2 * YellowSlot + 1;//We have to convert it to odd slot because it is 15 long not 7
		
		for (int rows = 5; rows >= 0; rows--)//Go through the rows from the bottom
		{
			if(board[rows][YellowSlot] == " ")//if the slot in that column is empty place it there
			{
				board[rows][YellowSlot] = "Y";//Set that slot to "B"
				break;//If we placed the piece break the loop
			}
		}
	}//End of dropYellow Method
	
	public static String checkWinner(String[][] board)//This is the final method. It runs after each turn to check the winner
	{	
		
		//Check for a Horizontal Line
		
		for (int i = 0; i < 6; i++)//go through each row
		{
			for (int j = 0; j < 7; j+= 2)//go through each column for the next four columns
			{
				//These next lines check if each slot is not empty and if they arn't then it checks if they are the same
				if((board[i][j+1] != " ") && (board[i][j+3] != " ") && (board[i][j+5] != " ") && (board[i][j+7] != " ") 
						&& ((board[i][j+1] == board[i][j+3]) && (board[i][j+3] == board[i][j+5]) && (board[i][j+5] == board[i][j+7])))
				{
					return (board[i][j+1]);//if they are the same it returns the letter
				}
			}
		}
		
		//Check for a Vertical Line
		
		for (int i = 1; i < 15; i+= 2)//Go through each column checking for 
    {
      for (int j = 0; j < 3; j++)//Go through each row for the next 4 rows
      {
      			//These lines check to see if each box on the vertical are not blank and if they are the same
      			if((board[j][i] != " ") && (board[j+1][i] != " ") && (board[j+2][i] != " ") && (board[j+3][i] != " ") && 
            		((board[j][i] == board[j+1][i])  && (board[j+1][i] == board[j+2][i]) && (board[j+2][i] == board[j+3][i])))
            {
            	return board[j][i];//If it is true it returns the letter  
            }
      }  
    }
		
		//Check for Diagonal to the right
		
		for (int i = 0; i < 3; i++)//go through four rows
		{
			for (int j = 1; j < 9; j+= 2)//go through four columns
			{
				//Check if they are not blanks and then if they are the same
				if((board[i][j] != " ") && (board[i+1][j+2] != " ") && (board[i+2][j+4] != " ") && (board[i+3][j+6] != " ")
						&& ((board[i][j] == board[i+1][j+2]) && (board[i+1][j+2] == board[i+2][j+4]) && (board[i+2][j+4] == board[i+3][j+6])))
				{
					return board[i][j];//If true return the letter
				}
	     }  
	   }
		
		//Check for diagonal to the left
		
		for (int o = 0; o < 3; o++)//Go through 4 rows
		{
			for (int p = 7; p < 15; p+=2)//Go through four columns
			{
				//This checks if they are not blanks and if they are the same
				if((board[o][p] != " ") && (board[o+1][p-2] != " ") && (board[o+2][p-4] != " ") && (board[o+3][p-6] != " ") 
						&& ((board[o][p] == board[o+1][p-2]) && (board[o+1][p-2] == board[o+2][p-4]) && (board[o+2][p-4] == board[o+3][p-6])))
				{
					return (board[o][p]);//If true return the letter
				}
			}
		}
		return null;//If none of the conditionals are met then return null which tells the code there is no win.
	}//End of Check winner method
}//End of Class Body

//End of Code