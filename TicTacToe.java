public class TicTacToe
{
   //copy over code from Tic Tac Toe Methods!
    //copy over your constructor from the Tic Tac Toe Board activity in the previous lesson!
   private int turn;
   
   private String[][] ticBoard = new String[3][3];
    public TicTacToe() 
    {
        for (int row = 0; row < ticBoard.length; row++) 
        {
            for (int col = 0; col < ticBoard[row].length; col++) 
            {
                ticBoard[row][col] = "-";
             }
        }
    }
   
   //this method returns the current turn
   public int getTurn()
   {
       return turn;
   }
   
   /*This method prints out the board array on to the console
   */
   public void printBoard()
   {
        System.out.print("  ");
      for (int i = 0; i < ticBoard[0].length; i++) 
      {
        
        System.out.print(i);
          if (i < ticBoard[0].length - 1) 
          {
            System.out.print(" "); // Only print space before the last element
          }
      }
      
      System.out.println();

  // Print the board with row and column numbers
        for (int i = 0; i < ticBoard.length; i++) 
        {
            System.out.print(i + " ");
            for (int j = 0; j < ticBoard[i].length; j++) 
            {
              System.out.print(ticBoard[i][j] + " ");
            }
            System.out.println();
        }
   }
   
   //This method returns true if space row, col is a valid space
   public boolean pickLocation(int row, int col)
   {
       if (row < 0 || row >= ticBoard.length || col < 0 || col >= ticBoard[0].length) 
       {
        return false;
      }
    
      // Check if the chosen location is empty
      if (ticBoard[row][col].equals("-")) 
      {
          return true;
      }
      return false;
      
   }
   
   //This method places an X or O at location row,col based on the int turn
   public void takeTurn(int row, int col)
   {
        String symbol = "";
       // Determine the symbol based on turn parity
       if (turn % 2 == 0) 
       {
           symbol = "X";
       } else 
       {
           symbol = "O";
       }
    
      // Update the board if the location is valid
      if (pickLocation(row, col)) 
      {
        ticBoard[row][col] = symbol;
        turn++;
      } 
   }
   
   //This method returns a boolean that returns true if a row has three X or O's in a row
  public boolean checkRow() 
  {
  
    for (int row = 0; row < ticBoard.length; row++) {
        String firstSymbol = ticBoard[row][0]; // Assuming all elements in a row have the same player
        String secondSymbol = ticBoard[row][1];
        String thirdSymbol = ticBoard[row][2];
        // Check if the first element is empty or different from the next two elements
        if (firstSymbol.equals(secondSymbol) && firstSymbol.equals(thirdSymbol) && !firstSymbol.equals("-")) 
        {
            return true;
        }
    }

      return false; // If no row has different symbols in the first three columns, return true
    }


 
   
   
    //This method returns a boolean that returns true if a col has three X or O's
   public boolean checkCol()
   {
         for (int col = 0; col < ticBoard[0].length; col++) 
    {
        String firstSymbol = ticBoard[0][col];
        String secondSymbol = ticBoard[1][col];
        String thirdSymbol = ticBoard[2][col];

        // Check if all symbols in the column are the same and are not "-"
        if (firstSymbol.equals(secondSymbol) && firstSymbol.equals(thirdSymbol) && !firstSymbol.equals("-")) 
        {
            return true;
        }
    }

    // If no column has three of the same symbols, return false
    return false;
   }
   
    //This method returns a boolean that returns true if either diagonal has three X or O's
   public boolean checkDiag()
   {
             // Check the top-left to bottom-right diagonal
        String firstSymbol = ticBoard[0][0];
        String secondSymbol = ticBoard[1][1];
        String thirdSymbol = ticBoard[2][2];
        if (firstSymbol.equals(secondSymbol) && firstSymbol.equals(thirdSymbol) && !firstSymbol.equals("-")) 
        {
            return true;
        }
    
        // Check the top-right to bottom-left diagonal
        firstSymbol = ticBoard[0][2];
        secondSymbol = ticBoard[1][1];
        thirdSymbol = ticBoard[2][0];
        if (firstSymbol.equals(secondSymbol) && firstSymbol.equals(thirdSymbol) && !firstSymbol.equals("-")) 
        {
            return true;
        }
    
        // If no diagonal has three of the same symbols, return false
        return false;

   }
   public boolean isBoardFull() 
    {
    for (int row = 0; row < ticBoard.length; row++)
    {
        for (int col = 0; col < ticBoard[row].length; col++) 
        {
            if (ticBoard[row][col].equals("-")) {
                return false; // If any space is "-", the board is not full
            }
        }
    }
        return true; // If no spaces are "-", the board is full
    }
   
   //This method returns a boolean that checks if someone has won the game
   public boolean checkWin()
   {
        if (checkRow() || checkCol() || checkDiag()) 
        {
            return true;
        }
        return false;

   }
}
