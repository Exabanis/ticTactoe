import java.util.Scanner;

public class TicTacToe{

    static int row = 0;
    static int column = 0;
    static String p1 = "O";
    static String p2 = "X";
    static boolean play = true;
    static int i = 0;
    static Scanner input = new Scanner(System.in);

    static Sounds s = new Sounds();
	//Drawing the board
    static String[][] board = {
    {"-", "-", "-", "-","-", "-", "-", "-", "-", "-","-", "-", "-"},
    {"|", " ", " ", " ","|", " ", " ", " ", "|", " "," ", " ", "|"},
    {"-", "-", "-", "-","-", "-", "-", "-", "-", "-","-", "-", "-"},
    {"|", " ", " ", " ","|", " ", " ", " ", "|", " "," ", " ", "|"},
    {"-", "-", "-", "-","-", "-", "-", "-", "-", "-","-", "-", "-"},
    {"|", " ", " ", " ","|", " ", " ", " ", "|", " "," ", " ", "|"},
    {"-", "-", "-", "-","-", "-", "-", "-", "-", "-","-", "-", "-"}};

	//main method
    public static void main(String[] args){
        String p = p1;
        display_board(p);
        while (play){
            if (play){
                prompt(p);
            }
            p = change_player(p);
        }
    }

	//method that request the user to choose a move
    static void prompt(String player){
        
        System.out.print("\nPlayer " + player + ", please enter a row (0, 1 or 2): ");
        row = input.nextInt() + 1;
        
        System.out.print("Player " + player + ", please enter a column (0, 1 or 2): ");
        column = input.nextInt() + 1;
        if (row < 1 || row > 3){
            System.out.println("\nwrong row co-ordinate, please choose 0 - 2");
            prompt(player);
        }
        else if (column < 1 || column > 3){
            System.out.println("\nwrong column co-ordinate, please choose 0 - 2");
            prompt(player);
        }else{
            if (row != 1){
                row = row * 2 - 1;
            }
            column = (column * 3) + (column - 2);
            if ((board[row][column]).equals(" ")){
                board[row][column] = player;
                i++;
            }else{
                System.out.println("The spot is not empty, please choose a blank spot.");
                prompt(player);
            }
            display_board(player);
        }
    }

	//changes the player turns when called
    static String change_player(String player){
        if (player.equals(p1)){
            return (p2);
        }else{
            return (p1);
        }
    }

	//board displayer
    static void display_board(String player){
        System.out.println("");
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
        if (check_win()){
            System.out.println("\nGame over!!! Player " + player + " wins.");
            play = false;
            input.close();
            s.play("player" +player+ ".wav");
        }else if (i == 9){
            System.out.println("\nGame over!!! its a draw");
            play = false;
            input.close();
            s.play("draw.wav");
        }
    }

	//check if one of the players ha won
    static boolean check_win(){
        if ((board[1][2]).equals("X") || (board[1][2]).equals("O")){
            if ((board[1][2]).equals(board[1][6]) && (board[1][6]).equals(board[1][10])){
                return true;
            } else if ((board[1][2]).equals(board[3][2]) && (board[3][2]).equals(board[5][2])){
                return true;
            } else if ((board[1][2]).equals(board[3][6]) && (board[3][6]).equals(board[5][10])){
                return true;
            }
        }
        if ((board[3][6]).equals("X") || (board[3][6]).equals("O")){
            if ((board[1][6]).equals(board[3][6]) && (board[3][6]).equals(board[5][6])){
                return true;
            } else if ((board[1][10]).equals(board[3][6]) && (board[3][6]).equals(board[5][2])){
                return true;
            } else if ((board[3][2]).equals(board[3][6]) && (board[3][6]).equals(board[3][10])){
                return true;
            }
        }
        if ((board[5][10]).equals("X") || (board[5][10]).equals("O")){
            if ((board[1][10]).equals(board[3][10]) && (board[3][10]).equals(board[5][10])){
                return true;
            } else if ((board[5][2]).equals(board[5][6]) && (board[5][6]).equals(board[5][10])){
                return true;
            }
        }
        return false;
    }
}
