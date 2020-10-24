import java.util.Scanner;
public class TicTacToeApp
{
   public static void main(String[] args)
   {
      Scanner kbd = new Scanner(System.in);
      System.out.print("Player 1, Enter your name: ");
      String name1 = kbd.nextLine();

      System.out.print("Player 2, Enter your name: ");
      String name2 = kbd.nextLine();

      System.out.print("Enter the size of the Tic-Tac-Toe game: ");
      int size = kbd.nextInt();

      String[] playerNames = {name1, name2};

      TicTacToe ttt1 = new TicTacToe(size, playerNames);
      
      while(!ttt1.isFull() && !ttt1.winner())
      {
         ttt1.play();
      }
   } 
}