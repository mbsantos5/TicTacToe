import java.util.Scanner;
import java.util.InputMismatchException;
public class TicTacToe
{  
   private int size;
   Scanner kbd = new Scanner(System.in);
   String[] playerNames = new String[2];
   char[][] grid;
   int row = 0; // am I using this anymore
   int col = 0;  // am I using this anymore
   int turn = 0;  

   
   public TicTacToe(int size, String[] playerNames)
   {
      this.size = size;
      this.playerNames[0] = playerNames[0];
      this.playerNames[1] = playerNames[1];
      initializeGrid();
   }

   
   private void initializeGrid()
   {
	  grid = new char[size][size];
      for(int i = 0; i < this.size; i++){
         for( int k = 0; k < this.size; k++){
            grid[i][k] = '-'; 
         }  
      }         
      
   }

   public void setPlayer()
   {
         System.out.println( playerNames[turn % 2] + "'s turn");   
      
   }

   public void play()
   {
      boolean gameOver = true; 
      while(gameOver){ 
         setPlayer();
         getPosition();
         System.out.println(this.toString());
         if(winner()){
            System.out.println(playerNames[turn % 2] + " is a winner");
            gameOver = false;
         }
         if(isFull() && !winner()){
             System.out.println( "It's a tie");  
             gameOver = false;
         }
         this.turn++;
     } 
      
   }
   public void getPosition()
   {
      boolean isValid = true;
      do{
         System.out.println("Enter row and column: ");
            try
            {     
                  row = kbd.nextInt();
                  col = kbd.nextInt();
         
                  if(!isOccupied()){
                     isValid = false;
                     if( this.turn % 2 == 0)
                        grid[row - 1][col - 1] = 'X';
                     else
                        grid[row - 1][col - 1] = 'O';
                  }
                  else
                      System.out.println(" cell is occupied try another position");
               
            }
            catch(InputMismatchException ex)
            {
               System.out.println("Not a valid position, try again");
               kbd.nextLine();
            }
            catch(ArrayIndexOutOfBoundsException ex)
            {
               System.out.println("Not a valid position, try again");
               kbd.nextLine();
            }
         
      } while(isValid);
         
      
   }

   public boolean isFull()
   {  
      boolean full = true; 
      for(int i = 0; i < size; i++){
         for( int k = 0; k < size; k++){
            if(grid[i][k] == '-')
               full = false;
         }
      } 
      
      return full;
        
   }

   public boolean isOccupied()
   {
      boolean occupied = false; 
      
      if (grid[row - 1][col - 1] != '-')
         occupied = true;
      
      return occupied;   
      
   }

   public boolean winner()
   {
      boolean isWinner = false;
      int xCount = 0;
      int oCount = 0; 
      
     //diagonal check  
      for(int i = 0; i < size; i++){
         for (int k = 0; k < size; k++){
            if( i == k ){
               if( grid[i][k] == 'X')
                  xCount++;
               if( grid[i][k] == 'O')
                  oCount++;
            }
         }
      }
      
      if(oCount == size || xCount == size)
         isWinner = true; 
         
      xCount = 0;
      oCount = 0;
      for(int i = 0; i < size; i++){
         for (int k = 0; k < size; k++){
            if( i + k == size - 1){
               if( grid[i][k] == 'X')
                  xCount++;
               if( grid[i][k] == 'O')
                  oCount++;
            }
         }
      }
      
      if(oCount == size || xCount == size)
         isWinner = true; 
                
     //vertical check
      for(int i = 0; i < size; i++){
            xCount = 0;
            oCount = 0;
            for(int k = 0; k < size; k++){
               if(grid[k][i] == 'X')
                  xCount++;
               if( grid[k][i] == 'O')
                  oCount++;
            }
            if(oCount == size || xCount == size){
               isWinner = true;
               break;
            } 
         }
    
     //horizontal check
         for(int i = 0; i < size; i++){
            xCount = 0;
            oCount = 0;
            for(int k = 0; k < size; k++){
               if(grid[i][k] == 'X')
                  xCount++;
               if( grid[i][k] == 'O')
                  oCount++;
            }
            if(oCount == size || xCount == size){
               isWinner = true;
               break;
            } 
         }
      return isWinner;
   }
   @Override
    public String toString(){
        String gridString = ""; 
        for(int rowCounter = 0; rowCounter < size; rowCounter++){
            for(int columnCounter = 0; columnCounter < size ; columnCounter++){
            gridString += " " + grid[rowCounter][columnCounter] + " ";
            }
         // new line break after each row
        gridString += "\n";
      }
      return gridString; 
   }
}