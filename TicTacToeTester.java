import java.util.Scanner;

public class TicTacToeTester
{
    public static void main(String[] args)
    {
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Initial Game Board:");
        game.printBoard();
        // The outer loop runs indefinitely until a return statement is encountered
        while(true) 
        {
            // This loop alternates between player 1 and player 2
            for (int player = 1; player <= 2; player++) 
            { 
                int row, col;
                // This inner loop keeps asking the current player for a valid row and column
                while (true)
                {
                    // Prompt the current player to input a row
                    System.out.println("Player " + player + ", give a row");
                    row = scanner.nextInt();
                    // Prompt the current player to input a column
                    System.out.println("Player " + player + ", give a col");
                    col = scanner.nextInt();
                    // If the picked location is valid, break the loop
                    if (game.pickLocation(row, col)) 
                    {
                        break;
                    } 
                    else 
                    {
                        // If the picked location is not valid, ask the player to input again
                        System.out.println("Not a valid space. Please input another index.");
                    }
                }
                // Take the turn with the valid row and column
                game.takeTurn(row, col);
                // Print the current state of the board
                game.printBoard();
                // If the current player wins, announce the winner and end the game
                if (game.checkWin()) 
                {
                    System.out.println("Player " + player + " won!");
                    return;
                }
                // If the board is full and no one wins, announce a tie and end the game
                if (game.isBoardFull()) 
                {
                    System.out.println("Tied");
                    return;
                }
            }
        }
    }
}
