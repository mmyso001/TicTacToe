package tictactoetester;
import javax.swing.JOptionPane;
import java.util.Random;



/**
 *
 * @author Meekaeel Mysorewala
 */
public class TicTacToe {
    Random  r = new Random();
    
    boolean nextTurn = false;
    char[][] board = new char [3][3];
    boolean tieGame = true;    
    String name;
    String printedBoard = "  |  " + board[0][0] + "  |  " + board[0][1] + "  |  " + board[0][2] + "  |  " + '\n' +
                          "  |  " + board[1][0] + "  |  " + board[1][1] + "  |  " + board[1][2] + "  |  " + '\n' +
                          "  |  " + board[2][0] + "  |  " + board[2][1] + "  |  " + board[2][2] + "  |  ";
    public void intro()
    {
    name = JOptionPane.showInputDialog(null,"Hello welcome to TicTacToe! Your name is?");
    JOptionPane.showMessageDialog(null, "Hello " + name + "  You are 'X' Good Luck!");
    }


    public enum eStatus {
        IN_PROGRESS,
        TIE_GAME,
        COMPUTER_WINS,
        PLAYER_WINS,
    }
    public void createBoard() 
    {
        printedBoard = "  |  " + board[0][0] + "  |  " + board[0][1] + "  |  " + board[0][2] + "  |  " + '\n' +
                       "  |  " + board[1][0] + "  |  " + board[1][1] + "  |  " + board[1][2] + "  |  " + '\n' +
                       "  |  " + board[2][0] + "  |  " + board[2][1] + "  |  " + board[2][2] + "  |  ";
        for (int row = 0; row <= 2; ++row)
        {
            for (int col = 0; col <= 2; ++col) 
            {
                board[row][col] = '-';
                
            }
        }
        JOptionPane.showMessageDialog(null, printedBoard);
    }
    
      
    public void computer() 
    {
    printedBoard = "  |  " + board[0][0] + "  |  " + board[0][1] + "  |  " + board[0][2] + "  |  " + '\n' +
               "  |  " + board[1][0] + "  |  " + board[1][1] + "  |  " + board[1][2] + "  |  " + '\n' +
               "  |  " + board[2][0] + "  |  " + board[2][1] + "  |  " + board[2][2] + "  |  ";
        while (true) 
        {
        
            int row = (int) r.nextInt(3);
            int col = (int) r.nextInt(3);

            
            if (board[row][col] == '-') 
            {
               board[row][col] = 'O';
                
               break;
            }
            
        }
        JOptionPane.showMessageDialog(null, printedBoard);
    }
    public void player() 
    {
        printedBoard = "  |  " + board[0][0] + "  |  " + board[0][1] + "  |  " + board[0][2] + "  |  " + '\n' +
               "  |  " + board[1][0] + "  |  " + board[1][1] + "  |  " + board[1][2] + "  |  " + '\n' +
               "  |  " + board[2][0] + "  |  " + board[2][1] + "  |  " + board[2][2] + "  |  ";
        while (true) 
        {

            int row = Integer.parseInt(JOptionPane.showInputDialog("Row: "));
            
            int col = Integer.parseInt(JOptionPane.showInputDialog("Column: "));
            
            if ((row < 0) || (row > 2))
            {
                JOptionPane.showMessageDialog(null,"Row out of range, try again!");
            }
            else if ((col < 0) || (col > 2))
            {
                JOptionPane.showMessageDialog(null,"Column out of range, try again!");
            }

            
            else if (board[row][col] != '-')
            {
                JOptionPane.showMessageDialog(null,"Occupied square, try again!");
            }
            
            else 
            {
                board[row][col] =  'X';
                break;
            }
        }
        JOptionPane.showMessageDialog(null, printedBoard);
    }
     public eStatus status() 
     {
         for (int row = 0; row <= 2; ++row)
         {
            for (int col = 0; col <= 2; ++col)
            {
                if (board[row][col] == '-')
                {
                     tieGame = false;
                }
            }
         }
        if (tieGame)
        {
            return eStatus.TIE_GAME;
        }
        
        else if (threeinaROW('X'))
        {
            return eStatus.PLAYER_WINS;
        }
        
        else if (threeinaROW('O'))
        {
            return eStatus.COMPUTER_WINS;
        }
        return eStatus.IN_PROGRESS;
    }
     public void setStatus()
     {
        while (status() == eStatus.IN_PROGRESS) 
        {
            if (nextTurn)
            {
                player();
            }
            else
            {
                computer();
            }
            nextTurn = !nextTurn;
        } 
        
        // Print status
        eStatus status = status();
        if (status == eStatus.TIE_GAME)
        {
            System.out.println("Game is tied!");
        }
        else if (status == eStatus.COMPUTER_WINS)
        {
            System.out.println("Computer wins!");
        }
        else if (status == eStatus.PLAYER_WINS)
        {
            System.out.println("Player wins!");
        }
     }

     boolean threeinaROW(char c) 
     {

        // Check rows
        for (int row = 0; row <= 2; ++row)
        {
            if ((board[row][0] == c) &&
                (board[row][1] == c) &&
                (board[row][2] == c))
            {
                return true;
            }
        }
        
        // Check columns
        for (int col = 0; col <= 2; ++col) 
        {
            if ((board[0][col] == c) &&
                (board[1][col] == c) &&
                (board[2][col] == c))
            {
                return true;
            }
        }
        
        // Check diagonals
        if ((board[0][0] == c) && 
            (board[1][1] == c) &&
            (board[2][2] == c))
        {
            return true;
        }
        else if ((board[2][0] == c) && 
            (board[1][1] == c) &&
            (board[0][2] == c))
        {
            return true;
        }

        return false; 
     }
        public void printFinal()
        {
            JOptionPane.showMessageDialog(null, printedBoard);
        }

    
}
