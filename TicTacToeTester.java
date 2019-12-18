package tictactoetester;



/**
 *
 * @author Meekaeel Mysorewala
 */
public class TicTacToeTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TicTacToe tictactoe = new TicTacToe();
        tictactoe.intro();
        tictactoe.createBoard();
        tictactoe.player();
        tictactoe.computer();
        tictactoe.setStatus();
        tictactoe.status();
        tictactoe.printFinal();
        

        // TODO code application logic here
    }
    
}
