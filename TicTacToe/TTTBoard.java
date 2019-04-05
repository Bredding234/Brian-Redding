public class TTTBoard
{
	private int board[][] = new int[3][3]; //This is the board. `0` means blank, `1` means X, `2` means O. -V
	
	public TTTBoard(){}
	private TTTBoard(int board[][])
	{import java.util.Scanner;

public class TTTBoard {
    private static int numBoxesLeft = 0;
        private int board[][] = new int [3][3]; //This is the board. `0` means blank, `1` means X, `2` means O.
    private int ID;
    private int opponentID;
    private static TTTBoard boards;
    private  int[][] myBoard = new int[3][3];
public TTTBoard(){} //Blank constructor, nothing else needed
    // this is TTT computer player, I renamed it to take away errors.
    public TTTBoard(int ID, int opponentID, TTTBoard board)
    {
        this.ID = ID;
        this.opponentID = opponentID;
        this.boards = boards;
    }

    private TTTBoard(int board[][])
        {
            this.board = board.clone();
        }

        public TTTBoard cloneBoard()
        {
            return new TTTBoard(board);
        }

        public int getSpace(int x, int y)
        {
            return board[x][y];
        }

        public void setSpace(int x, int y, int val)
        {
            board[x][y] = val;
        }
        public int checkWinner(){
    // check rows
        for(int x = 0; x < 3; ++x)
        {
            if(board[x][0] == 0) continue;
            if(board[x][1] != board[x][0]) continue;
            if(board[x][2] != board[x][0]) continue;
            return board[x][0];
        }
        // check columns
        for(int y = 0; y < 3; ++y)
        {
            if(board[0][y] == 0) continue;
            if(board[1][y] != board[0][y]) continue;
            if(board[2][y] != board[0][y]) continue;
            return board[0][y];
        }
        // check diagonals
        if(board[0][0] != 0 && board[0][0] == board[1][1] && board[0][0] == board[2][2]) return board[0][0];
        if(board[2][0] != 0 && board[2][0] == board[1][1] && board[2][0] == board[0][2]) return board[2][0];
        return board[0][0];
        }
    public void takeTurn()
    {
        Scanner scan = new Scanner(System.in);
        boolean HasMadeTurn = false; // The player has not made a turn yet, default set to false.
        int row = 0; // The row that in the board game
        int column = 0; // The column that in the board game.
        // So if the ID (player) is greater than or equal to 1(only) then they shall be able to take their turn.
        if(ID >= 1){
            System.out.println("Enter your move ID player: ");
            ID = scan.nextInt(); // they should enter 1 for 'X'
            System.out.println(ID); // Just to see whats going on.
            getSpace(0,1);
        }
        // So if the opponent(player) is less than or equal to 2(only) then they shall be able to take their turn.
        if(opponentID <= 2){
            System.out.println("Enter your move ID player: ");
           opponentID = scan.nextInt(); // they should enter 2 for '0'
            System.out.println(opponentID); // Just to see whats going on.
            getSpace(0,2);
        }
        /**
        if(board[row][column] == getSpace(ID,1)){
            takeTurn();
        }
         */
while(HasMadeTurn) {
    if (ID >= 1) {
        System.out.println("Enter you turns AI: ");
        ID = scan.nextInt();
        board[row][column] = ID;
        HasMadeTurn = true;
        getSpace(ID, 1);

    } else if (opponentID <= 2) {
        System.out.println("Enter you turns human player: ");
        opponentID = scan.nextInt();
        board[row][column] = opponentID;
        HasMadeTurn = true;
        getSpace(opponentID, 2);
    } else {
        getSpace(ID, 0);
        getSpace(opponentID, 0);
        HasMadeTurn = false;
    }


}
while(opponentID > 2 || ID < 1){
    System.out.println("Invalid number of moves or turns.");
    opponentID = scan.nextInt();
    System.out.println("Invalid number of moves or turns.");
        ID = scan.nextInt();
}
if(opponentID <= 2 || ID >=1){
    System.out.println("\n You took" + opponentID + "turns.");
    System.out.println("There are " + + (numBoxesLeft - opponentID) + " Boxes left.");
    System.out.println("\n You took" + ID + "turns.");
    System.out.println("There are " + + (numBoxesLeft - ID) + " Boxes left.");
}
    opponentID = scan.nextInt();
    ID = scan.nextInt();
/**
    if (board[row + 1][column + 1] == ID) {
        takeTurn();
        System.out.print("Enter your move- Player X");
        ID = scan.nextInt();
    }
    if (board[row + 2][column + 2] == 2) {
        takeTurn();
        System.out.print("Enter your move- Player Y");
        opponentID = scan.nextInt();

    }
*/
}






        //Take the AI's turn, using the `board` object.
        //If you need a copy of the board to modify for some reason, you can do:
        //TTTBoard tempBoard = board.cloneBoard();
        //This will give you a copy of the current state of the board.
        //`ID` is 1 or 2 (X or O); the one the AI is using
        //`opponentID` is 1 or 2 (X or O); the one the human is using
        //You can make whatever helper methods you need to accomplish this task. You can even make other classes, if you think it would help.
        //The only condition is that it all needs to run from THIS method, as though this were `main()`
        //-V


    public static void main(String[] args) {
        TTTBoard theboard = new TTTBoard();
        TTTBoard AI1 = new TTTBoard(1, 2, boards);
        TTTBoard AI2 = new TTTBoard(2, 1, boards);
        while(theboard.checkWinner() == 0)
        {
            AI1.takeTurn();
            if(theboard.checkWinner() == 0)
                AI2.takeTurn();
        }
        int win = theboard.checkWinner();
        if(win < 0)
            System.out.println("Tie! No one wins!");
        else
            System.out.println("The winner is: " + win);
    }
    }




		this.board = board.clone();
	}
	
	public TTTBoard cloneBoard()
	{
		return new TTTBoard(board);
	}
	
	public int getSpace(int x, int y)
	{
		return board[x][y];
	}
	
	public void setSpace(int x, int y, int val)
	{
		board[x][y] = val;
	}
	
	/*
		Returns -1 if tie, 1 if X, 2 if O, or 0 if game is not over -V
	*/
	public int checkWinner()
	{
		for(int x = 0; x < 3; ++x) //Check columns
		{
			if(board[x][0] == 0) continue;
			if(board[x][1] != board[x][0]) continue;
			if(board[x][2] != board[x][0]) continue;
			return board[x][0];
		}
		for(int y = 0; y < 3; ++y) //Check rows
		{
			if(board[0][y] == 0) continue;
			if(board[1][y] != board[0][y]) continue;
			if(board[2][y] != board[0][y]) continue;
			return board[0][y];
		}
		//Check diagonals
		if(board[0][0] != 0 && board[0][0] == board[1][1] && board[0][0] == board[2][2]) return board[0][0];
		if(board[2][0] != 0 && board[2][0] == board[1][1] && board[2][0] == board[0][2]) return board[2][0];
		
		return isFull() ? -1 : 0; //-1 if game is over in a tie, 0 if ongoing
	}
	
	public boolean isFull()
	{
		for(int x = 0; x < 3; ++x)
		{
			for(int y = 0; y < 3; ++y)
			{
				if(board[x][y] == 0) return false;
			}
		}
		return true;
	}
}
